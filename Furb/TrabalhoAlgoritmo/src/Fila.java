package src;

public interface Fila<T> {

    void inserir(T valor) throws FilaCheiaException;
    boolean estaVazia();
    T peek() throws FilaVaziaException;
    T retirar() throws FilaVaziaException;
    void liberar() throws FilaVaziaException;

}