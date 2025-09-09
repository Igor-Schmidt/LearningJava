public class Veterinario {
    private String nome;
    private String crmv;
    private String especialidade;
    private Veterinario supervisor;

    public Veterinario(String nome, String crmv, String especialidade) {
        this.nome = nome;
        this.crmv = crmv;
        this.especialidade = especialidade;
        this.supervisor = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Veterinario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Veterinario supervisor) {
        this.supervisor = supervisor;
    }

    public String retornarDados() {
        String mensagem = "Nome: " + this.nome + ", CRMV: " + this.crmv + ", Especialidade: " + this.especialidade;
        if (this.supervisor != null) {
            mensagem += ", Supervisor:" +
        }
        return ();
    }
}
