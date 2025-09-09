// Aluno: Igor Zafriel Schmidt

package L04_ListaDuplamenteEncadeada;

public class App {
    public static void main(String[] args) {
        System.out.println();

        // CASO 01
        ListaDupla<Integer> lista = new ListaDupla<Integer>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        System.out.println(lista.toString());
        lista.exibirOrdemInversa();

        // CASO 02
        System.out.println(lista.buscar(20).getInfo());

        // CASO 03
        System.out.println(lista.buscar(10).getInfo());

        // CASO 04
        lista.retirar(20);
        System.out.println(lista.toString());

        // CASO 05
        ListaDupla<Integer> lista2 = new ListaDupla<Integer>();
        lista2.inserir(5);
        lista2.inserir(10);
        lista2.inserir(15);
        lista2.inserir(20);

        lista2.retirar(10);
        System.out.println(lista2.toString());

        // CASO 06
        ListaDupla<Integer> lista3 = new ListaDupla<Integer>();
        lista3.inserir(5);
        lista3.inserir(10);
        lista3.inserir(15);
        lista3.inserir(20);

        lista3.retirar(5);
        System.out.println(lista3.toString());

        // CASO 07
        lista.liberar();
        System.out.println(lista.toString());
    }
}
