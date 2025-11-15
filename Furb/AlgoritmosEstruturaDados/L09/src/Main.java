import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Início dos Testes ---");

        // Caso de Teste 1: Inserir e localizar um objeto
        System.out.println("\n--- Caso de Teste 1: Inserir e localizar um objeto ---");
        MapaDispersao<Aluno> mapa1 = new MapaDispersao<>(53);
        Aluno aluno1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa1.inserir(aluno1.getMatricula(), aluno1);

        Aluno alunoEncontrado1 = mapa1.buscar(12000);
        System.out.println("Aluno encontrado: " + alunoEncontrado1);
        System.out.println("Teste 1 passou? " + (aluno1 == alunoEncontrado1));

        // Caso de Teste 2: Inserir e localizar diversos objetos
        System.out.println("\n--- Caso de Teste 2: Inserir e localizar diversos objetos ---");
        MapaDispersao<Aluno> mapa2 = new MapaDispersao<>(53);
        Aluno[] alunos2 = {
                new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1)),
                new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20)),
                new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18)),
                new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25))
        };

        for (Aluno aluno : alunos2) {
            mapa2.inserir(aluno.getMatricula(), aluno);
        }

        boolean teste2_passou = true;
        for (Aluno aluno : alunos2) {
            Aluno encontrado = mapa2.buscar(aluno.getMatricula());
            System.out.println("Buscando por " + aluno.getMatricula() + ": " + encontrado);
            if (encontrado != aluno) {
                teste2_passou = false;
                System.out.println("ERRO: Aluno não corresponde ao original.");
            }
        }
        System.out.println("Teste 2 passou? " + teste2_passou);


        // Caso de Teste 3: Inserção e busca com colisão
        System.out.println("\n--- Caso de Teste 3: Inserção e busca com colisão ---");
        MapaDispersao<Aluno> mapa3 = new MapaDispersao<>(53);
        // 12000 % 53 = 25
        // 14226 % 53 = 25 (colisão com 12000)
        // 14000 % 53 = 21
        // 17180 % 53 = 21 (colisão com 14000)
        Aluno[] alunos3 = {
                new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1)),
                new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20)),
                new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18)),
                new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25))
        };

        for (Aluno aluno : alunos3) {
            mapa3.inserir(aluno.getMatricula(), aluno);
        }

        System.out.println("\nMapa após inserções (com colisões):\n");
        mapa3.exibir();

        boolean teste3_passou = true;
        for (Aluno aluno : alunos3) {
            Aluno encontrado = mapa3.buscar(aluno.getMatricula());
            System.out.println("Buscando por " + aluno.getMatricula() + ": " + encontrado);
            if (encontrado != aluno) {
                teste3_passou = false;
                System.out.println("ERRO: Aluno não corresponde ao original.");
            }
        }
        System.out.println("Teste 3 passou? " + teste3_passou);

        // Teste de remoção
        System.out.println("\n--- Teste de Remoção ---");
        System.out.println("Removendo aluno com matrícula 14226 (com colisão)...");
        mapa3.remover(14226);
        Aluno removido = mapa3.buscar(14226);
        System.out.println("Busca por 14226 após remoção: " + removido);
        System.out.println("Aluno 12000 (mesmo índice) ainda existe? " + mapa3.buscar(12000));
        System.out.println("Teste de remoção passou? " + (removido == null && mapa3.buscar(12000) != null));


        System.out.println("\n--- Fim dos Testes ---");
    }
}