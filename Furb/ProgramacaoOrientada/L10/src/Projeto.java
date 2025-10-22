// Aluno: Igor Zafriel Schmidt
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public abstract class Projeto {
    private String id;
    private String descricao;
    private LocalDate dataEntrada;
    private Set<Profissional> responsaveis;

    public Projeto(String id, String descricao, LocalDate dataEntrada) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do projeto não pode ser nulo ou vazio.");
        }
        this.id = id;
        this.descricao = descricao;
        this.dataEntrada = dataEntrada;
        this.responsaveis = new HashSet<>();
    }

    public void adicionarResponsavel(Profissional profissional) {
        if (profissional != null) {
            this.responsaveis.add(profissional);
        }
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public Set<Profissional> getResponsaveis() {
        return responsaveis;
    }

    public abstract String getResumo();
}
