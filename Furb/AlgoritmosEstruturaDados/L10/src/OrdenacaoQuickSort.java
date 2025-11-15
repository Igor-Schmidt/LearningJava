package src;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public OrdenacaoQuickSort(T[] info) {
        setInfo(info);
    }

    @Override
    public void ordenar() {
        quickSort(0, getInfo().length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(inicio, fim);
            quickSort(inicio, indicePivo - 1);
            quickSort(indicePivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        T[] info = getInfo();
        T pivo = info[fim];
        int i = (inicio - 1);

        for (int j = inicio; j < fim; j++) {
            if (info[j].compareTo(pivo) <= 0) {
                i++;
                trocar(i, j);
            }
        }
        trocar(i + 1, fim);
        return i + 1;
    }
}
