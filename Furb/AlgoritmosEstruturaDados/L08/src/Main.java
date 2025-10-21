public class Main {
    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>();

        // Criar a estrutura da árvore do exercício
        NoArvore<Integer> no1 = new NoArvore<>(1);
        NoArvore<Integer> no2 = new NoArvore<>(2);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        NoArvore<Integer> no4 = new NoArvore<>(4);
        NoArvore<Integer> no5 = new NoArvore<>(5);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no7 = new NoArvore<>(7);
        NoArvore<Integer> no8 = new NoArvore<>(8);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        NoArvore<Integer> no10 = new NoArvore<>(10);

        // Montar a árvore
        arvore.setRaiz(no1);
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);

        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);

        no3.inserirFilho(no8);

        no4.inserirFilho(no10);
        no4.inserirFilho(no9);

        // Teste 1: Representação textual
        System.out.println("Representação textual: " + arvore.toString());
        System.out.println("Esperado: <1<2<5><6><7>><3<8>><4<9><10>>>");

        // Teste 2: Pertence (sucesso)
        System.out.println("\nBuscando pelo valor 7...");
        System.out.println("Resultado: " + arvore.pertence(7));
        System.out.println("Esperado: true");

        // Teste 3: Pertence (falha)
        System.out.println("\nBuscando pelo valor 55...");
        System.out.println("Resultado: " + arvore.pertence(55));
        System.out.println("Esperado: false");

        // Teste 4: Contar nós
        System.out.println("\nContando o número de nós...");
        System.out.println("Resultado: " + arvore.contarNos());
        System.out.println("Esperado: 10");
    }
}