public class Main {
    public static void main(String[] args) {
        // Test Case 1
        ArvoreBinaria<Integer> arvoreVazia = new ArvoreBinaria<>();
        System.out.println("Caso 1: Arvore vazia? " + arvoreVazia.estaVazia()); // Expected: true

        // Test Case 2
        ArvoreBinaria<Integer> arvoreNaoVazia = new ArvoreBinaria<>();
        arvoreNaoVazia.setRaiz(new NoArvoreBinaria<>(5));
        System.out.println("Caso 2: estaVazia() em arvore nao vazia? " + arvoreNaoVazia.estaVazia()); // Expected: false

        // Test cases 3 to 8 use this tree:
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);

        // Test Case 3
        System.out.println("Caso 3: Representacao textual: " + arvore.toString());
        // Expected: <1<2<><4<><>>><3<5<><>><6<><>>>>

        // Test Case 4
        System.out.println("Caso 4: Pertence 1? " + arvore.pertence(1)); // Expected: true

        // Test Case 5
        System.out.println("Caso 5: Pertence 3? " + arvore.pertence(3)); // Expected: true

        // Test Case 6
        System.out.println("Caso 6: Pertence 6? " + arvore.pertence(6)); // Expected: true

        // Test Case 7
        System.out.println("Caso 7: Pertence 10? " + arvore.pertence(10)); // Expected: false

        // Test Case 8
        System.out.println("Caso 8: Contar nos: " + arvore.contarNos()); // Expected: 6
    }
}
