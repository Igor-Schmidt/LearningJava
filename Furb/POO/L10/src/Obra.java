import java.util.Date;

public class Obra {
    private int id;
    private Date dataCriacao;
    private String descricaoObra;
    private Profissional[] profissionals;

    public Obra(int id, Date dataCriacao, String descricaoObra, Profissional[] profissionals) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.descricaoObra = descricaoObra;
        this.profissionals = profissionals;
    }

    public int getId() {
        return id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricaoObra() {
        return descricaoObra;
    }

    public void setDescricaoObra(String descricaoObra) {
        this.descricaoObra = descricaoObra;
    }
}

