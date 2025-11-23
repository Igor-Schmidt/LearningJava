package src;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public NoLista<T> getUltimo() {
        return ultimo;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<>(valor);
        if (estaVazia()) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            novo.setProximo(this.primeiro);
            this.primeiro = novo;
        }
    }

    public void inserirNoFinal(T valor) {
        NoLista<T> novo = new NoLista<>(valor);
        if (estaVazia()) {
            this.primeiro = novo;
            this.ultimo = novo;
        } else {
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
        }
    }

    public T retirarDoInicio() {
        if (estaVazia()) {
            return null; // Ou lançar exceção
        }
        T valor = this.primeiro.getInfo();
        this.primeiro = this.primeiro.getProximo();
        if (this.primeiro == null) {
            this.ultimo = null;
        }
        return valor;
    }

    public void exibir() {
        NoLista<T> p = primeiro;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> buscar(T valor) {
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public int obterComprimento() {
        int comprimento = 0;
        NoLista<T> p = primeiro;
        while (p != null) {
            comprimento++;
            p = p.getProximo();
        }
        return comprimento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoLista<T> p = primeiro;
        while (p != null) {
            sb.append(p.getInfo());
            if (p.getProximo() != null) {
                sb.append(",");
            }
            p = p.getProximo();
        }
        return sb.toString();
    }
}
