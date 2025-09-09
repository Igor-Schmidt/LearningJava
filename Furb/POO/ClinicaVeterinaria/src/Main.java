// Aluno: Igor Zafriel Schmidt
public class Main {
    public static void main(String[] args) {
        Tutor tutor1 = new Tutor("João", "123456789", "Blumenau - SC");
        Tutor tutor2 = new Tutor("Maria", "123456780", "Indaial - SC");

        Animal animal1 = new Animal("Pé de pano", "Cavalo", 2);
        animal1.adicionarHistorico("Teve pneumonia");

        Animal animal2 = new Animal("Donatello", "Tartaruga", 1);
        animal2.adicionarHistorico("Machucou a nadadeira direita frontal");

        Animal animal3 = new Animal("Gato à Jato", "Gato", 3);
        animal3.adicionarHistorico("Ele não para queito");

        Animal animal4 = new Animal("ERRO", "TESTE", -10);
        Tutor tutor3 = new Tutor("ERRO", " ", "ERRO");
    }
}