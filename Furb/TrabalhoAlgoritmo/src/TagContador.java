package src;

public class TagContador implements Comparable<TagContador> {
    private String nome;
    private int contagem;

    public TagContador(String nome) {
        this.nome = nome;
        this.contagem = 1;
    }

    public String getNome() {
        return nome;
    }

    public int getContagem() {
        return contagem;
    }

    public void incrementar() {
        this.contagem++;
    }

    @Override
    public int compareTo(TagContador outro) {
        return this.nome.compareTo(outro.getNome());
    }

    @Override
    public String toString() {
        return "Tag: " + nome + ", Ocorrências: " + contagem;
    }
}
