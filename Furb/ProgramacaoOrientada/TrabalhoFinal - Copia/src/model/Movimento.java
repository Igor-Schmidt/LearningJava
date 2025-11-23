package model;

import java.time.LocalDate;

/**
 * Classe abstrata que representa um registro de entrada ou saída de estoque.
 */
public abstract class Movimento {

    private static int proximoId = 1;

    private int id;
    private Produto produto;
    private LocalDate data;
    private int quantidade;

    public Movimento(Produto produto, LocalDate data, int quantidade) {
        this.id = proximoId++;
        this.produto = produto;
        this.data = data;
        this.quantidade = quantidade;
    }
    
    /**
     * Retorna o tipo do movimento (ENTRADA ou SAIDA).
     * @return O tipo do movimento.
     */
    public abstract TipoMovimento getTipo();

    /**
     * Calcula o impacto na quantidade de estoque.
     * @return Retorna a quantidade positiva (entrada) ou negativa (saída).
     */
    public int calcularImpacto() {
        return getTipo() == TipoMovimento.ENTRADA ? quantidade : -quantidade;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public LocalDate getData() {
        return data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public static void setProximoId(int proximoId) {
        Movimento.proximoId = proximoId;
    }
}
