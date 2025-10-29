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
        for (Profissional p : this.responsaveis) {
            if (profissional.equals(p)) {
                throw new IllegalArgumentException(String.format("Esse profissional já um responsável do projeto: %s", this.getId()));
            }
        }

        if (profissional != null) {
            this.responsaveis.add(profissional);
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setResponsaveis(Set<Profissional> responsaveis) {
        this.responsaveis = responsaveis;
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
