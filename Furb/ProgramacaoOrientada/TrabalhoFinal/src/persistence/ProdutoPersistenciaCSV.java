package persistence;

import model.CategoriaProduto;
import model.Produto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da persistência de produtos em arquivo CSV.
 */
public class ProdutoPersistenciaCSV implements Persistencia<Produto> {

    private static final String FILE_PATH = "produtos.csv";
    private static final String CSV_DELIMITER = ",";

    @Override
    public void salvar(List<Produto> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Produto p : lista) {
                
                String linha = String.join(CSV_DELIMITER,
                        p.getCodigo(),
                        p.getNome(),
                        String.valueOf(p.getPrecoUnitario()),
                        String.valueOf(p.getQuantidadeEstoque()),
                        p.getCategoria().name()
                );

                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    @Override
    public List<Produto> carregar() {
        List<Produto> produtos = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return produtos;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(CSV_DELIMITER);

                if (dados.length == 5) {
                    String codigo = dados[0];
                    String nome = dados[1];

                    double precoUnitario = Double.parseDouble(dados[2]);
                    int quantidadeEstoque = Integer.parseInt(dados[3]);
                    
                    CategoriaProduto categoria = CategoriaProduto.valueOf(dados[4]);
                    produtos.add(new Produto(codigo, nome, precoUnitario, quantidadeEstoque, categoria));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao carregar produtos: " + e.getMessage());
        }
        return produtos;
    }
}
