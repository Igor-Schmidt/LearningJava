package src;

public class OrdenacaoBolhaOtimizada<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    public OrdenacaoBolhaOtimizada(T[] info) {
        setInfo(info);
    }

    @Override
    public void ordenar() {
        T[] info = getInfo();
        int n = info.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }
}
