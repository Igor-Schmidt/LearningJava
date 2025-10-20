public class FilaVetor<T> implements Fila<T> {

    private T[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
        this.inicio = 0;
    }

    @Override
    public void inserir(T valor) throws FilaCheiaException {
        if (tamanho == limite) {
            throw new FilaCheiaException("A fila está cheia.");
        }
        int fim = (inicio + tamanho) % limite;
        info[fim] = valor;
        tamanho++;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public T peek() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        return info[inicio];
    }

    @Override
    public T retirar() throws FilaVaziaException {
        if (estaVazia()) {
            throw new FilaVaziaException("A fila está vazia.");
        }
        T valor = info[inicio];
        info[inicio] = null; // Limpa a referência
        inicio = (inicio + 1) % limite;
        tamanho--;
        return valor;
    }

    @Override
    public void liberar() {
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
        this.inicio = 0;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        int novoLimite = this.limite + f2.limite;
        FilaVetor<T> novaFila = new FilaVetor<>(novoLimite);

        // Copia elementos da primeira fila (this)
        for (int i = 0; i < this.tamanho; i++) {
            int index = (this.inicio + i) % this.limite;
            novaFila.inserir(this.info[index]);
        }

        // Copia elementos da segunda fila (f2)
        for (int i = 0; i < f2.tamanho; i++) {
            int index = (f2.inicio + i) % f2.limite;
            novaFila.inserir(f2.info[index]);
        }

        return novaFila;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            int index = (inicio + i) % limite;
            sb.append(info[index]);
            if (i < tamanho - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public int getLimite() {
        return limite;
    }
}
