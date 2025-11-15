package src;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public OrdenacaoBolha(T[] info) {
        setInfo(info);
    }

    @Override
    public void ordenar() {
        T[] info = getInfo();
        int n = info.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}
