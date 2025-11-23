package model;

import java.time.LocalDate;

/**
 * Representa um movimento de entrada de produto no estoque.
 */
public class Entrada extends Movimento {

    private double valorUnitario;

    public Entrada(Produto produto, LocalDate data, int quantidade, double valorUnitario) {
        super(produto, data, quantidade);
        this.valorUnitario = valorUnitario;
    }

    /**
     * Retorna o tipo do movimento, que é sempre ENTRADA.
     *
     * @return {@link TipoMovimento#ENTRADA}
     */
    @Override
    public TipoMovimento getTipo() {
        return TipoMovimento.ENTRADA;
    }

    // Getter
    public double getValorUnitario() {
        return valorUnitario;
    }
}
