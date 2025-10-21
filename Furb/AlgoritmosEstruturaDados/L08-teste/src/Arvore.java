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
    public String toString(){
        return obterRepresentacaoTextual(raiz);
    }

    private String obterRepresentacaoTextual(NoArvore<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + obterRepresentacaoTextual(no.getProximo()) + ">";
    }

    public boolean pertence(T info) {
        return pertence(raiz, info);
    }
    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null) {
            return false;
        }
        return pertence(no.getProximo(), info);
    }

    public int contarNos() {
        return contarNos(raiz);
    }
    private int contarNos(NoArvore<T> no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getProximo());
    }
}
