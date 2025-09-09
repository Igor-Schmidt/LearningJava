public class Tutor {
    private String nome;
    private String telefone;
    private String endereco;

    /**
     * 
     * @param nome
     * @param telefone
     * @param endereco
     * @throws IllegalArgumentException quando o telefone for vazio.
     */
    public Tutor(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;

        if (telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("É obrigatório informar o telefone do tutor!");
        }
    }

    /**
     * 
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @return String
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * 
     * @param telefone
     * @throws IllegalArgumentException quando o telefone for vazio.
     */
    public void setTelefone(String telefone) {
        if (telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("É obrigatório informar o telefone do tutor!");
        }
        this.telefone = telefone;
    }

    /**
     * 
     * @return String
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * 
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
