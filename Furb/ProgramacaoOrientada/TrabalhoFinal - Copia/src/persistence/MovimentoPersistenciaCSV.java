package persistence;

import model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementação da persistência de movimentos em arquivo CSV.
 */
public class MovimentoPersistenciaCSV implements Persistencia<Movimento> {

    private static final String FILE_PATH = "movimentos.csv";
    private static final String CSV_DELIMITER = ",";

    @Override
    public void salvar(List<Movimento> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Movimento m : lista) {
                List<String> dados = new ArrayList<>();
                dados.add(String.valueOf(m.getId()));
                dados.add(m.getTipo().name());
                dados.add(m.getProduto().getCodigo());
                dados.add(m.getData().toString());
                dados.add(String.valueOf(m.getQuantidade()));

                if (m instanceof Entrada) {
                    Entrada e = (Entrada) m;
                    dados.add(String.valueOf(e.getValorUnitario()));
                    dados.add("");
                } else if (m instanceof Saida) {
                    Saida s = (Saida) m;
                    dados.add("");
                    dados.add(s.getTipoSaida().name());
                }
                bw.write(String.join(CSV_DELIMITER, dados));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar movimentos: " + e.getMessage());
        }
    }

    @Override
    public List<Movimento> carregar() {
        List<Movimento> movimentos = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return movimentos;
        }

        ProdutoPersistenciaCSV produtoPersistencia = new ProdutoPersistenciaCSV();
        List<Produto> produtos = produtoPersistencia.carregar();

        int maxId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(CSV_DELIMITER, -1);
                if (dados.length >= 5) {
                    int id = Integer.parseInt(dados[0]);
                    TipoMovimento tipoMovimento = TipoMovimento.valueOf(dados[1]);
                    String produtoCodigo = dados[2];
                    LocalDate data = LocalDate.parse(dados[3]);
                    int quantidade = Integer.parseInt(dados[4]);

                    Optional<Produto> produtoOpt = produtos.stream()
                            .filter(p -> p.getCodigo().equals(produtoCodigo))
                            .findFirst();

                    if (produtoOpt.isPresent()) {
                        Produto produto = produtoOpt.get();
                        Movimento movimento = null;
                        
                        if (tipoMovimento == TipoMovimento.ENTRADA && dados.length >= 6) {
                            double valorUnitario = Double.parseDouble(dados[5]);
                            movimento = new Entrada(produto, data, quantidade, valorUnitario);

                        } else if (tipoMovimento == TipoMovimento.SAIDA && dados.length >= 7) {
                            TipoSaida tipoSaida = TipoSaida.valueOf(dados[6]);
                            movimento = new Saida(produto, data, quantidade, tipoSaida);
                        }

                        if (movimento != null) {
                            java.lang.reflect.Field idField = Movimento.class.getDeclaredField("id");
                            
                            idField.setAccessible(true);
                            idField.set(movimento, id);

                            movimentos.add(movimento);
                            if (id > maxId) {
                                maxId = id;
                            }
                        }
                    }
                }
            }
        } catch (IOException | NumberFormatException | ReflectiveOperationException e) {
            System.err.println("Erro ao carregar movimentos: " + e.getMessage());
            e.printStackTrace();
        }

        Movimento.setProximoId(maxId + 1);
        return movimentos;
    }
}
