package L03_ListaEncadeada;

public class NoLista {
  private int info;
  private NoLista proximo;

  public NoLista(int info) {
    this.info = info;
    this.proximo = null;
  };

  public int getInfo() {
    return info;
  };

  public void setInfo(int info) {
    this.info = info;
  };

  public void setProximo(NoLista proximo) {
    this.proximo = proximo;
  };

  public NoLista getProximo() {
    return proximo;
  };
}
