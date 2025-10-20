public class App {

    public static void main(String[] args) {
        System.out.println("Plano de testes PL02 – Validar funcionamento da implementação dinâmica de fila");

        // Caso 1
        System.out.println("\nCASO 1: Conferir se o método estaVazia() reconhece fila vazia.");
        FilaLista<Integer> fila1 = new FilaLista<>();
        System.out.println("Saída esperada: true");
        System.out.println("Saída real: " + fila1.estaVazia());

        // Caso 2
        System.out.println("\nCASO 2: Conferir se o método estaVazia() reconhece fila não vazia.");
        FilaLista<Integer> fila2 = new FilaLista<>();
        fila2.inserir(10);
        System.out.println("Saída esperada: false");
        System.out.println("Saída real: " + fila2.estaVazia());

        // Caso 3 e 4
        System.out.println("\nCASO 3 e 4: Conferir se os dados são enfileirados e desenfileirados corretamente.");
        FilaLista<Integer> fila3 = new FilaLista<>();
        fila3.inserir(10);
        fila3.inserir(20);
        fila3.inserir(30);
        System.out.println("toString(): " + fila3.toString()); // Esperado: 10,20,30
        System.out.println("Retirado: " + fila3.retirar()); // Esperado: 10
        System.out.println("Retirado: " + fila3.retirar()); // Esperado: 20
        System.out.println("Retirado: " + fila3.retirar()); // Esperado: 30
        System.out.println("Fila vazia? " + fila3.estaVazia()); // Esperado: true

        // Caso 5 (no PDF é o 4, mas a descrição é do 5)
        System.out.println("\nCASO 5: Conferir se o método peek() retorna o início da fila.");
        FilaLista<Integer> fila5 = new FilaLista<>();
        fila5.inserir(10);
        fila5.inserir(20);
        fila5.inserir(30);
        System.out.println("Peek: " + fila5.peek()); // Esperado: 10
        System.out.println("Retirado: " + fila5.retirar()); // Esperado: 10
        System.out.println("Peek após retirar: " + fila5.peek()); // Esperado: 20

        // Caso 6 (no PDF é o 5)
        System.out.println("\nCASO 6: Conferir se o método liberar() remove os elementos da fila.");
        FilaLista<Integer> fila6 = new FilaLista<>();
        fila6.inserir(10);
        fila6.inserir(20);
        fila6.inserir(30);
        fila6.liberar();
        System.out.println("Fila vazia após liberar? " + fila6.estaVazia()); // Esperado: true

        // Teste extra para FilaVaziaException em retirar()
        System.out.println("\nTeste extra: FilaVaziaException em retirar().");
        try {
            fila6.retirar();
        } catch (FilaVaziaException e) {
            System.out.println("Exceção lançada como esperado: " + e.getMessage());
        }

        // Teste extra para FilaVaziaException em peek()
        System.out.println("\nTeste extra: FilaVaziaException em peek().");
        try {
            fila6.peek();
        } catch (FilaVaziaException e) {
            System.out.println("Exceção lançada como esperado: " + e.getMessage());
        }
    }
}
