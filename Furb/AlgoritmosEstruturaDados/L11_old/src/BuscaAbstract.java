public abstract class BuscaAbstract<T> {
    private T[] info;

    public T[] getInfo() {
        return info;
    }
    public void setInfo(T[] info) {
        this.info = info;
    }

    public abstract int buscar(T valor);
}
