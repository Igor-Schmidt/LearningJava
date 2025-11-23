package src;

public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista;

    public PilhaLista() {
        this.lista = new ListaEncadeada<>();
    }

    @Override
    public void push(T info) {
        lista.inserir(info); // Inserts at the beginning, which is the top of the stack
    }

    @Override
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }
        return lista.retirarDoInicio();
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException("A pilha está vazia.");
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        // Re-instantiate to clear all elements, letting GC handle the old list
        this.lista = new ListaEncadeada<>();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
