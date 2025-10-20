public class FilaLista<T> implements Fila<T> {

    private ListaEncadeada<T> lista;

    public FilaLista() {
        this.lista = new ListaEncadeada<>();
    }

    @Override
    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public T peek() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public T retirar() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        return lista.retirarDoInicio();
    }

    @Override
    public void liberar() {
        this.lista = new ListaEncadeada<>();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
