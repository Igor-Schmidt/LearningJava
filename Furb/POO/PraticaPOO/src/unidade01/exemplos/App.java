package unidade01.exemplos;

public class App {
    public static void main(String[] args) {
        Cachorro dog01 = new Cachorro();

    // Atribuindo valores para dog01
        dog01.nome = "Pingo";
        dog01.racaCanina = "Labrador";
        dog01.cor = "Branca";
        dog01.peso = 12.0;

        dog01.pegarCoisa("TESTE");

        Cachorro dog02 = new Cachorro();
    }
}
