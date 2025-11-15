package src;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public OrdenacaoMergeSort(T[] info) {
        setInfo(info);
    }

    @Override
    public void ordenar() {
        mergeSort(0, getInfo().length - 1);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(int inicio, int fim, int meio) {
        T[] info = getInfo();
        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        T[] esquerda = (T[]) new Comparable[tamanhoEsquerda];
        T[] direita = (T[]) new Comparable[tamanhoDireita];

        for (int i = 0; i < tamanhoEsquerda; i++) {
            esquerda[i] = info[inicio + i];
        }
        for (int j = 0; j < tamanhoDireita; j++) {
            direita[j] = info[meio + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = inicio;

        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            if (esquerda[i].compareTo(direita[j]) <= 0) {
                info[k] = esquerda[i];
                i++;
            } else {
                info[k] = direita[j];
                j++;
            }
            k++;
        }

        while (i < tamanhoEsquerda) {
            info[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < tamanhoDireita) {
            info[k] = direita[j];
            j++;
            k++;
        }
    }
}