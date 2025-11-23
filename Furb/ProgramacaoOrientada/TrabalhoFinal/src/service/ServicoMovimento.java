package service;

import model.Entrada;
import model.Movimento;
import model.Saida;
import persistence.Persistencia;
import persistence.MovimentoPersistenciaCSV;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pela lógica de negócio relacionada aos movimentos de estoque.
 */
public class ServicoMovimento {

    private List<Movimento> movimentos;
    private final Persistencia<Movimento> persistencia;
    private final ServicoEstoque servicoEstoque;

    public ServicoMovimento(ServicoEstoque servicoEstoque) {
        this.servicoEstoque = servicoEstoque;
        this.persistencia = new MovimentoPersistenciaCSV();
        this.movimentos = new ArrayList<>(persistencia.carregar());
    }

    /**
     * Registra uma nova entrada de produto no estoque.
     *
     * @param e A entrada a ser registrada.
     */
    public void registrarEntrada(Entrada e) {
        this.movimentos.add(e);
        this.servicoEstoque.atualizarEstoque(e);

        // Atualiza o preço unitário do produto com base na última entrada
        e.getProduto().setPrecoUnitario(e.getValorUnitario());
        this.persistencia.salvar(this.movimentos);
    }

    /**
     * Registra uma nova saída de produto do estoque.
     *
     * @param s A saída a ser registrada.
     */
    public void registrarSaida(Saida s) {
        this.movimentos.add(s);
        this.servicoEstoque.atualizarEstoque(s);
        this.persistencia.salvar(this.movimentos);
    }

    /**
     * Lista todas as entradas registradas.
     *
     * @return Uma lista de entradas.
     */
    public List<Entrada> listarEntradas() {
        return this.movimentos.stream()
                .filter(m -> m instanceof Entrada)
                .map(m -> (Entrada) m)
                .collect(Collectors.toList());
    }

    /**
     * Lista todas as saídas registradas.
     *
     * @return Uma lista de saídas.
     */
    public List<Saida> listarSaidas() {
        return this.movimentos.stream()
                .filter(m -> m instanceof Saida)
                .map(m -> (Saida) m)
                .collect(Collectors.toList());
    }

    /**
     * Lista todos os movimentos de estoque, ordenados por data.
     *
     * @return Uma lista de movimentos ordenados.
     */
    public List<Movimento> listarMovimentosOrdenados() {
        return this.movimentos.stream()
                .sorted(Comparator.comparing(Movimento::getData))
                .collect(Collectors.toList());
    }

    /**
     * Calcula o saldo total do estoque em um período específico.
     * (Este método calcula o valor total de movimentações, não o saldo em valor monetário)
     *
     * @param inicio A data de início do período.
     * @param fim    A data de fim do período.
     * @return O valor total das movimentações no período.
     */
    public double getSaldoNoPeriodo(LocalDate inicio, LocalDate fim) {
        return this.movimentos.stream()
                .filter(m -> !m.getData().isBefore(inicio) && !m.getData().isAfter(fim))
                .mapToDouble(m -> {
                    
                    if (m instanceof Entrada) {
                        return ((Entrada) m).getValorUnitario() * m.getQuantidade();
                    
                    } else if (m instanceof Saida) {
                        // Para saídas, o valor é negativo
                        return -m.getProduto().getPrecoUnitario() * m.getQuantidade();
                    }
                    return 0.0;
                })
                .sum();
    }
}
