// Aluno: Igor Zafriel Schmidt
public class Profissional {
    private String id;
    private String cpf;
    private String nome;

    public Profissional(String id, String cpf, String nome) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do profissional não pode ser nulo ou vazio.");
        } 
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF do profissional não pode ser nulo ou vazio.");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do profissional não pode ser nulo ou vazio.");
        }
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Profissional(" +
                "ID: '" + id + "'" +
                ", Nome: '" + nome + "'" +
                ", CPF: '" + cpf + "'" +
                ')';
    }
}
