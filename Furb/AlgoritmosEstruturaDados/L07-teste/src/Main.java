//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvoreVazia = new ArvoreBinaria<>();
        System.out.println("Caso 1: Arvore vazia? " + arvoreVazia.estaVazia()); // true

        ArvoreBinaria<Integer> arvoreNaoVazia = new ArvoreBinaria<>();
        arvoreNaoVazia.setRaiz(new NoArvoreBinaria<>(5));
        System.out.println("Caso 2: estaVazia() em arvore nao vazia? " + arvoreNaoVazia.estaVazia()); // false

        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(no1);

        System.out.println("Caso 3: Representacao textual: " + arvore.toString());
        // <1<2<><4<><>>><3<5<><>><6<><>>>>

        System.out.println("Caso 4: Pertence 1? " + arvore.pertence(1)); // true

        System.out.println("Caso 5: Pertence 3? " + arvore.pertence(3)); // true

        System.out.println("Caso 6: Pertence 6? " + arvore.pertence(6)); // true

        System.out.println("Caso 7: Pertence 10? " + arvore.pertence(10)); // false

        System.out.println("Caso 8: Contar nos: " + arvore.contarNos()); // 6
    }
}