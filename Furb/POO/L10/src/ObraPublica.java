import java.util.Date;

public class ObraPublica extends Obra {
    private Date dataInicioObra;
    private Date dataFimObra;
    private int duracaoObra;

    public ObraPublica(int id, Date dataCriacao, String descricaoObra, Profissional[] profissionals, Date dataInicioObra, Date dataFimObra, int duracaoObra) {
        super(id, dataCriacao, descricaoObra, profissionals);
        this.dataInicioObra = dataInicioObra;
        this.dataFimObra = dataFimObra;
        this.duracaoObra = duracaoObra;
    }

    public Date getDataInicioObra() {
        return dataInicioObra;
    }

    public void setDataInicioObra(Date dataInicioObra) {
        this.dataInicioObra = dataInicioObra;
    }

    public Date getDataFimObra() {
        return dataFimObra;
    }

    public void setDataFimObra(Date dataFimObra) {
        this.dataFimObra = dataFimObra;
    }

    public int getDuracaoObra() {
        return duracaoObra;
    }

    public void setDuracaoObra(int duracaoObra) {
        this.duracaoObra = duracaoObra;
    }
}
