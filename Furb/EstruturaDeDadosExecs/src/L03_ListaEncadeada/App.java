// Aluno: Igor Zafriel Schmidt

package L03_ListaEncadeada;

public class App {
    public static void main(String[] args) {
        System.out.println();

        // CASO 01 - Lista vazia
        ListaEncadeada listaCASO01 = new ListaEncadeada();
        System.out.println("CASO 01 - Lista vazia: " + listaCASO01.estaVazia());

        // CASO 02 - Verificar se a lista não está mais vazia
        ListaEncadeada listaCASO02 = new ListaEncadeada();
        listaCASO02.inserir(5);
        System.out.println("CASO 02 - Lista vazia: " + listaCASO02.estaVazia());

        // CASO 03 - Validar inclusão de um número
        ListaEncadeada listaCASO03 = new ListaEncadeada();
        listaCASO03.inserir(5);
        System.out.println("CASO 03 - Primeiro item da lista: " + listaCASO03.getPrimeiro().getInfo());

        // CASO 04 - Validar inclusão de 3 números
        ListaEncadeada listaCASO04 = new ListaEncadeada();
        listaCASO04.inserir(5);
        listaCASO04.inserir(10);
        listaCASO04.inserir(15);
        System.out.println("CASO 04 - Tamanho da lista: " + listaCASO04.obterComprimento());

        // CASO 05 - Validar busca de dados na lista na primeira posição
        ListaEncadeada listaCASO05 = new ListaEncadeada();
        listaCASO05.inserir(5);
        listaCASO05.inserir(10);
        listaCASO05.inserir(15);
        listaCASO05.inserir(20);
        NoLista encontrado = listaCASO05.buscar(20);
        if (encontrado != null) {
            System.out.println("CASO 05 - Valor encontrado: " + encontrado.getInfo());
        } else {
            System.out.println("CASO 05 - Valor não encontrado.");
        }

        // CASO 06 - Validar busca de dados no meio da lista
        ListaEncadeada listaCASO06 = new ListaEncadeada();
        listaCASO06.inserir(5);
        listaCASO06.inserir(10);
        listaCASO06.inserir(15);
        listaCASO06.inserir(20);
        NoLista encontrado2 = listaCASO06.buscar(15);
        if (encontrado2 != null) {
            System.out.println("CASO 06 - Valor encontrado: " + encontrado2.getInfo());
        } else {
            System.out.println("CASO 06 - Valor não encontrado.");
        }

        // CASO 07 - Validar busca de dado inexistente
        ListaEncadeada listaCASO07 = new ListaEncadeada();
        listaCASO07.inserir(5);
        listaCASO07.inserir(10);
        listaCASO07.inserir(15);
        listaCASO07.inserir(20);
        NoLista encontrado3 = listaCASO07.buscar(25);
        if (encontrado3 != null) {
            System.out.println("CASO 07 - Valor encontrado: " + encontrado3.getInfo());
        } else {
            System.out.println("CASO 07 - Valor não encontrado.");
        }

        // CASO 08 - Validar exclusão de primeiro elemento da lista
        ListaEncadeada listaCASO08 = new ListaEncadeada();
        listaCASO08.inserir(5);
        listaCASO08.inserir(10);
        listaCASO08.inserir(15);
        listaCASO08.inserir(20);

        listaCASO08.reitrar(20);
        System.out.println("CASO 08 - Lista após exclusão de um elemento:");
        listaCASO08.exibir();

        // CASO 09 - Após o algoritmo de remoção, navegar na lista e certificar-se que a
        // lista contenha exclusivamente os números 5, 10 e 20.
        ListaEncadeada listaCASO09 = new ListaEncadeada();
        listaCASO09.inserir(5);
        listaCASO09.inserir(10);
        listaCASO09.inserir(15);
        listaCASO09.inserir(20);

        listaCASO09.reitrar(15);
        System.out.println("CASO 09 - Lista após exclusão de um elemento:");
        listaCASO09.exibir();

        // CASO 10 - Validar que obterNo() retorna nó da posição 0
        ListaEncadeada listaCASO10 = new ListaEncadeada();
        listaCASO10.inserir(5);
        listaCASO10.inserir(10);
        listaCASO10.inserir(15);
        listaCASO10.inserir(20);

        NoLista encontrado4 = listaCASO10.obterNo(0);
        System.out.println("CASO 10 - Valor encontrado: " + encontrado4.getInfo());

        // CASO 11 - Validar que obterNo() retorna nó da última posição
        ListaEncadeada listaCASO11 = new ListaEncadeada();
        listaCASO11.inserir(5);
        listaCASO11.inserir(10);
        listaCASO11.inserir(15);
        listaCASO11.inserir(20);

        NoLista encontrado5 = listaCASO11.obterNo(3);
        System.out.println("CASO 11 - Valor encontrado: " + encontrado5.getInfo());

        // CASO 12 - Validar que obterNo() recusa tentativa de ler posição invalidade nó
        try {
            ListaEncadeada listaCASO12 = new ListaEncadeada();
            listaCASO12.inserir(5);
            listaCASO12.inserir(10);
            listaCASO12.inserir(15);
            listaCASO12.inserir(20);

            NoLista encontrado6 = listaCASO12.obterNo(10);
            System.out.println("CASO 12 - Valor encontrado: " + encontrado6.getInfo());
        } catch (IllegalArgumentException e) {
            System.out.println("CASO 12 - Erro: " + e.getMessage());
        }

        // CASO 13 - Validar método obterComprimento() para lista vazia
        ListaEncadeada listaCASO13 = new ListaEncadeada();
        System.out.println("CASO 13 - Comprimento da lista: " + listaCASO13.obterComprimento());

        // CASO 14 - Validar método obterComprimento() para lista vazia
        ListaEncadeada listaCASO14 = new ListaEncadeada();
        listaCASO14.inserir(5);
        listaCASO14.inserir(10);
        listaCASO14.inserir(15);
        listaCASO14.inserir(20);
        System.out.println("CASO 14 - Comprimento da lista: " + listaCASO13.obterComprimento());
    }
}
