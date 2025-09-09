public class Animal {
    private String nome;
    private String especie;
    private int idade;
    private String historico;

    /**
     * 
     * @param nome
     * @param especie
     * @param idade
     * @throws IllegalArgumentException quando idade for um valor negativo
     */
    public Animal(String nome, String especie, int idade) {
        this.nome = nome;
        this.especie = especie;

        if (idade < 0) {
            throw new IllegalArgumentException("A idade do animal não pode ser negativa!");
        }
        this.idade = idade;
    }

    /**
     * @param descricao
     */
    public void adicionarHistorico(String descricao) {
        this.historico = descricao;
        System.out.println("Historico adionado com sucesso!");
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
    public String getEspecie() {
        return especie;
    }

    /**
     * 
     * @param especie
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * 
     * @return int
     */
    public int getIdade() {
        return idade;
    }

    /**
     * 
     * @param idade
     * @throws IllegalArgumentException quando idade for um valor negativo
     */
    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade do animal não pode ser negativa!");
        }
        this.idade = idade;
    }

    /**
     * 
     * @return
     */
    public String getHistorico() {
        return historico;
    }
}
