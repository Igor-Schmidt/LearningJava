public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract<T> {

    @Override
    public int buscar(T valor) {
        T[] info = getInfo();
        for (int i = 0; i < info.length; i++) {
            int comparacao = valor.compareTo(info[i]);
            if (comparacao == 0) {
                return i;
            }
            if (comparacao < 0) {
                return -1;
            }
        }
        return -1;
    }
}