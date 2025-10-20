public class Profissional {
    private int id;
    private String numeroDocumento;
    private String nome;

    public Profissional(int id, String numeroDocumento, String nome) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
