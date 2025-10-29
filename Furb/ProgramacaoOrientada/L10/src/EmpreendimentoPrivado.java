// Aluno: Igor Zafriel Schmidt
import java.time.LocalDate;

public class EmpreendimentoPrivado extends Projeto {
    private TipoArea tipoArea;
    private double metragem;

    public EmpreendimentoPrivado(String id, String descricao, LocalDate dataEntrada, TipoArea tipoArea, double metragem) {
        super(id, descricao, dataEntrada);
        this.tipoArea = tipoArea;
        this.metragem = metragem;
    }

    public void setTipoArea(TipoArea tipoArea) {
        this.tipoArea = tipoArea;
    }

    public void setMetragem(double metragem) {
        this.metragem = metragem;
    }

    public TipoArea getTipoArea() {
        return tipoArea;
    }

    public double getMetragem() {
        return metragem;
    }

    @Override
    public String getResumo() {
        return String.format("Empreendimento Privado: Localização: %s, Tamanho: %.2f m²", tipoArea, metragem);
    }
}
