// Aluno: Igor Zafriel Schmidt
import java.time.LocalDate;

public class ProjetoPublico extends Projeto {
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public ProjetoPublico(String id, String descricao, LocalDate dataEntrada, LocalDate dataInicio, LocalDate dataFim) {
        super(id, descricao, dataEntrada);
        if (dataInicio == null || dataFim == null) {
            throw new IllegalArgumentException("Datas de início e fim são obrigatórias.");
        }
        if (dataFim.isBefore(dataInicio)) {
            throw new IllegalArgumentException("Data final não pode ser anterior à data inicial.");
        }
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public long getDuracaoEmDias() {
        long diasInicio = dataInicio.toEpochDay();
        long diasFim = dataFim.toEpochDay();
        return diasFim - diasInicio;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String getResumo() {
        return String.format("Projeto Público %s: %s (Duração: %d dias)", getId(), getDescricao(), getDuracaoEmDias());
    }
}
