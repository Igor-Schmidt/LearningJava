import java.util.Objects;

public class NoMapa<T> {
    private int chave;
    private T valor;

    public NoMapa(int chave, T valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoMapa<?> noMapa = (NoMapa<?>) o;
        return chave == noMapa.chave;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chave);
    }

    @Override
    public String toString() {
        return "NoMapa{" +
                "chave=" + chave +
                ", valor=" + valor +
                '}';
    }
}