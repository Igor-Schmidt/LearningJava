// Aluno: Igor Zafriel Schmidt
public class Main {
    public static void main(String[] args) {
        System.out.println("Plano de testes PL01 - Validar funcionamento dos algoritmos de busca");
        testesBuscas();

        System.out.println("\nPlano de testes PL01 - Validar funcionamento da implementação de árvore binária de busca");
        testeArvoreBinariaBusca_Insercao();
        testeArvoreBinariaBusca_RetirarFolha();
        testeArvoreBinariaBusca_RetirarNoComUmFilho();
    }

    public static void testesBuscas() {
        Integer[] dados = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        BuscaLinear<Integer> buscaLinear = new BuscaLinear<>();
        buscaLinear.setInfo(dados);
        System.out.println("Caso 1: Busca Linear(20) - Resultado: " + buscaLinear.buscar(20) + " - Esperado: 2");

        BuscaLinearVetorOrdenado<Integer> buscaLinearOrdenado = new BuscaLinearVetorOrdenado<>();
        buscaLinearOrdenado.setInfo(dados);
        System.out.println("Caso 2: Busca Linear Vetor Ordenado(40) - Resultado: " + buscaLinearOrdenado.buscar(40) + " - Esperado: 4");

        BuscaBinaria<Integer> buscaBinaria = new BuscaBinaria<>();
        buscaBinaria.setInfo(dados);
        System.out.println("Caso 3: Busca Binária(70) - Resultado: " + buscaBinaria.buscar(70) + " - Esperado: 7");
        System.out.println("Caso 4: Busca Binária(75) - Resultado: " + buscaBinaria.buscar(75) + " - Esperado: -1");
    }

    public static void testeArvoreBinariaBusca_Insercao() {
        System.out.println("\n--- Teste de Inserção ---");
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(40);
        arvore.inserir(25);
        arvore.inserir(75);
        arvore.inserir(65);
        arvore.inserir(35);
        arvore.inserir(60);

        String esperado = "<50<30<25<><>><40<35<><>><>>><70<65<60<><>><>><75<><>>>>";
        String resultado = arvore.toString();
        System.out.println("Caso 1: Inserção - Resultado: " + resultado);
        System.out.println("Caso 1: Inserção - Esperado:  " + esperado);
        System.out.println("Caso 1: Inserção - Teste passou: " + esperado.equals(resultado));
    }

    public static void testeArvoreBinariaBusca_RetirarFolha() {
        System.out.println("\n--- Teste de retirar nó folha ---");
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(25);
        arvore.inserir(40);
        arvore.retirar(40);

        String esperado = "<50<30<25<><>><>><>>";
        String resultado = arvore.toString();
        System.out.println("Caso 2: retirar nó folha (40) - Resultado: " + resultado);
        System.out.println("Caso 2: retirar nó folha (40) - Esperado:  " + esperado);
        System.out.println("Caso 2: retirar nó folha (40) - Teste passou: " + esperado.equals(resultado));
    }

    public static void testeArvoreBinariaBusca_RetirarNoComUmFilho() {
        System.out.println("\n--- Teste de Retirar Nó com Um Filho ---");
        ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<>();
        arvore.inserir(80);
        arvore.inserir(52);
        arvore.inserir(90);
        arvore.inserir(48);
        arvore.inserir(71);
        arvore.inserir(63);
        arvore.inserir(67);
        arvore.retirar(71);

        String esperado = "<80<52<48<><>><63<><67<><>>>><90<><>>>";
        String resultado = arvore.toString();
        System.out.println("Caso 3: Retirar nó com um filho (71) - Resultado: " + resultado);
        System.out.println("Caso 3: Retirar nó com um filho (71) - Esperado:  " + esperado);
        System.out.println("Caso 3: Retirar nó com um filho (71) - Teste passou: " + esperado.equals(resultado));
    }
}
