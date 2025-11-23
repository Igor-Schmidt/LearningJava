package model;

import java.time.LocalDate;

/**
 * Representa um movimento de saída de produto do estoque.
 */
public class Saida extends Movimento {

    private TipoSaida tipoSaida;

    public Saida(Produto produto, LocalDate data, int quantidade, TipoSaida tipoSaida) {
        super(produto, data, quantidade);
        this.tipoSaida = tipoSaida;
    }

    /**
     * Retorna o tipo do movimento, que é sempre SAIDA.
     *
     * @return {@link TipoMovimento#SAIDA}
     */
    @Override
    public TipoMovimento getTipo() {
        return TipoMovimento.SAIDA;
    }

    // Getter
    public TipoSaida getTipoSaida() {
        return tipoSaida;
    }
}
