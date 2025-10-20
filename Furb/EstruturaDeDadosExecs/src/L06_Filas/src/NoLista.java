public class NoLista<T> {
  private T info;
  private NoLista<T> proximo;

  public NoLista(T info) {
    this.info = info;
    this.proximo = null;
  };

  public T getInfo() {
    return info;
  };

  public void setInfo(T info) {
    this.info = info;
  };

  public void setProximo(NoLista<T> proximo) {
    this.proximo = proximo;
  };

  public NoLista<T> getProximo() {
    return proximo;
  };
}
