package L04_ListaDuplamenteEncadeada;

public class NoListaDupla<T> {
    private T info;
    private NoListaDupla<T> proximo;
    private NoListaDupla<T> anterior;

    public NoListaDupla(T info) {
        this.info = info;
        this.proximo = null;
    };

    public void setInfo (T info){
        this.info = info;
    };

    public T getInfo() {
      return this.info;
    };

    public void setProximo (NoListaDupla<T> proximo) {
        this.proximo = proximo;
    };

    public NoListaDupla<T> getProximo () {
        return this.proximo;
    };

    public void setAnterior (NoListaDupla<T> anterior) {
        this.anterior = anterior;
    };

    public NoListaDupla<T> getAnterior () {
        return this.anterior;
    };
}
