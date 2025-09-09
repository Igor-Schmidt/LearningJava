// Aluno: Igor Zafriel Schmidt

package L01_ListaEstatica;

public class App {
    public static void main(String[] args) {
        // CASO 01
        ListaEstatica listaCASO01 = new ListaEstatica();
        listaCASO01.inserir(5);
        listaCASO01.inserir(10);
        listaCASO01.inserir(15);
        listaCASO01.inserir(20);
        System.out.println("Lista: " + listaCASO01.toString());

        // CASO 02
        System.out.println("Tamanho da lista: " + listaCASO01.getTamanho());

        // CASO 03
        System.out.println("Buscar 15 na lista: " + listaCASO01.buscar(15));

        // CASO 04
        System.out.println("Buscar 30 na lista: " + listaCASO01.buscar(30));

        // CASO 05
        listaCASO01.reirar(10);
        System.out.println("Lista após remoção de 10: " + listaCASO01.toString());

        // CASO 06
        ListaEstatica listaCASO06 = new ListaEstatica();
        for (int i = 1; i <= 15; i++) {
            listaCASO06.inserir(i);
        }
        System.out.println("Lista após inserção de 15 elementos: " + listaCASO06.toString() + " (Tamanho: "
                + listaCASO06.getTamanho() + ")");

        // CASO 07
        ListaEstatica listaCASO07 = new ListaEstatica();
        listaCASO07.inserir(5);
        listaCASO07.inserir(10);
        listaCASO07.inserir(15);
        listaCASO07.inserir(20);
        System.out.println("Obter elemento posição 3: " + listaCASO07.obterElemento(3));

        // CASO 08
        try {
            System.out.println("Obter elemento posição 5: " + listaCASO07.obterElemento(5));
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Ocorreu um erro: " + error);
        }

        // CASO 09
        listaCASO07.liberar();
        System.out.println("Está vazia: " + listaCASO07.estaVazio());
    }
}
