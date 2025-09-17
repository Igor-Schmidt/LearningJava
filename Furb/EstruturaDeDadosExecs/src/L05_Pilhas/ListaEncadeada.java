package L05_Pilhas;

public class ListaEncadeada {
  private NoLista primeiro;

  public ListaEncadeada() {
    this.primeiro = null;
  };

  public NoLista getPrimeiro() {
    return primeiro;
  };

  public void inserir(int valor) {
    NoLista novo = new NoLista(valor);
    novo.setInfo(valor);
    novo.setProximo(primeiro);
    this.primeiro = novo;
  };

  public void exibir() {
    NoLista p = primeiro;
    while (p != null) {
      System.out.println(p.getInfo());
      p = p.getProximo();
    }
  };

  public boolean estaVazia() {
    if (primeiro == null) {
      return true;
    } else {
      return false;
    }
  };

  public NoLista buscar(int valor) {
    NoLista p = primeiro;

    while (p != null) {
      if (p.getInfo() == valor) {
        return p;
      }
      p = p.getProximo();
    }

    return null;
  };

  public void reitrar(int valor) {
    NoLista anterior = null;
    NoLista p = primeiro;

    while (p != null && p.getInfo() != valor) {
      anterior = p;
      p = p.getProximo();
    }

    if (p != null) {
      if (anterior == null) {
        primeiro = p.getProximo();
      } else {
        anterior.setProximo(p.getProximo());
      }
    } else {
      System.out.println("Valor não encontrado na lista.");
    }
  };

  public int obterComprimento(){
    int comprimento = 0;
    NoLista p = primeiro;

    while (p != null) {
      comprimento++;
      p = p.getProximo();
    }

    return comprimento;
  };

  public NoLista obterNo(int idx){
    int i = 0;
    NoLista p = primeiro;

    if (idx < 0 || idx >= obterComprimento()) {
      throw new IllegalArgumentException("Índice fora dos limites da lista.");
    }

    while (p != null && i < idx) {
      p = p.getProximo();
      i++;
    }

    return p;
  };

  public String toString(){
    String str = "";
    NoLista p = primeiro;
    
    while (p != null) {
      str += p.getInfo() + " ";
      p = p.getProximo();
    }

    return str;
  };
}
