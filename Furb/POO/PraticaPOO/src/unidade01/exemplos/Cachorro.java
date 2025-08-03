package unidade01.exemplos;

public class Cachorro {
    String nome;
    String racaCanina;
    String cor;
    Double peso;

    void latir() {
        System.out.println("AU AU!");
    }

    void abanarRabo() {
        System.out.println("Abanando o rabo");
    }

    void pegarCoisa(String coisa) {
        System.out.println("Pegando: " + coisa);
    }
}
