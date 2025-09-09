package L04_ListaDuplamenteEncadeada;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        this.primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<T>(valor);
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        this.primeiro = novo;

        if (novo.getProximo() != null) {
            novo.getProximo().setAnterior(novo);
        }
    }

    public NoListaDupla<T> buscar(T valor) {
        for (NoListaDupla<T> no = primeiro; no != null; no = no.getProximo()) {
            if (no.getInfo().equals(valor)) {
                return no;
            }
        }
        return null;
    }

    public void retirar(T valor) {
        for (NoListaDupla<T> no = primeiro; no != null; no = no.getProximo()) {
            if (no.getInfo().equals(valor)) {
                if (no.getInfo().equals(primeiro.getInfo())) {
                    this.primeiro = no.getProximo();
                    no.getProximo().setAnterior(null);
                }
                else if (no.getProximo() == null) {
                    no.getAnterior().setProximo(null);
                }
                else {
                    no.getAnterior().setProximo(no.getProximo());
                    no.getProximo().setAnterior(no.getAnterior());
                    break;
                }
            }
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> ultimoNo = null;

        for (NoListaDupla<T> no = primeiro; no != null; no = no.getProximo()) {
            ultimoNo = no;
        }

        for (NoListaDupla<T> no = ultimoNo; no != null; no = no.getAnterior()) {
            System.out.println("Info: " + no.getInfo());
        }
    }

    public void liberar() {
        for (NoListaDupla<T> no = primeiro; no != null; no = no.getProximo()) {
            no.setAnterior(null);
        }
        this.primeiro = null;
    }

    @Override
    public String toString() {
        String valoresNos = "";
        
        if (primeiro == null) {
            return valoresNos;
        }

        for (NoListaDupla<T> no = primeiro; no != null; no = no.getProximo()) {
            if (no.getProximo() != null) {
                valoresNos += no.getInfo() + ", ";
            } else {
                valoresNos += no.getInfo();
            }
        }
        return valoresNos;
    }
}
