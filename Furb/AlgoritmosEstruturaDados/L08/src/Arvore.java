public class Arvore<T> {
    private NoArvore<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "";
        }
        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        String s = "<" + no.getInfo();
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            s += obterRepresentacaoTextual(filho);
            filho = filho.getProximo();
        }
        s += ">";
        return s;
    }

    public boolean pertence(T info) {
        if (raiz == null) {
            return false;
        }
        return pertence(raiz, info);
    }

    private boolean pertence(NoArvore<T> no, T info) {
        if (no.getInfo().equals(info)) {
            return true;
        }
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            if (pertence(filho, info)) {
                return true;
            }
            filho = filho.getProximo();
        }
        return false;
    }

    public int contarNos() {
        if (raiz == null) {
            return 0;
        }
        return contarNos(raiz);
    }

    private int contarNos(NoArvore<T> no) {
        int qtde = 1;
        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            qtde += contarNos(filho);
            filho = filho.getProximo();
        }
        return qtde;
    }
}
