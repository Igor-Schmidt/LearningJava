public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract<T> {

    @Override
    public int buscar(T valor) {
        T[] info = getInfo();
        int inicio = 0;
        int fim = info.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = valor.compareTo(info[meio]);

            if (comparacao == 0) {
                return meio;
            }

            if (comparacao < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return -1;
    }
}