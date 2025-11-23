public class MapaDispersao<T> {
    private ListaEncadeada<NoMapa<T>>[] info;

    public MapaDispersao(int tamanho) {
        info = new ListaEncadeada[tamanho];

        for (int i = 0; i < tamanho; i++) {
            info[i] = new ListaEncadeada<>();
        }
    }

    private int calcularHash(int chave) {
        return chave % info.length;
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);
        ListaEncadeada<NoMapa<T>> lista = info[indice];

        NoMapa<T> noMapa = new NoMapa<>(chave, dado);
        if (lista.buscar(noMapa) != null) {
            throw new IllegalArgumentException("Essa infomação ja foi adionada!");
        }
        lista.inserir(noMapa);
    }

    public void remover(int chave) {
        int indice = calcularHash(chave);
        ListaEncadeada<NoMapa<T>> lista = info[indice];
        NoMapa<T> noBusca = new NoMapa<>(chave, null);
        lista.retirar(noBusca);
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);
        ListaEncadeada<NoMapa<T>> lista = info[indice];
        NoMapa<T> noBusca = new NoMapa<>(chave, null);

        NoLista<NoMapa<T>> noEncontrado = lista.buscar(noBusca);

        if (noEncontrado != null) {
            return noEncontrado.getInfo().getValor();
        }

        return null;
    }

    public double calcularFatorCarga() {
        int totalElementos = 0;
        for (ListaEncadeada<NoMapa<T>> lista : info) {
            totalElementos += lista.obterComprimento();
        }
        return (double) totalElementos / info.length;
    }

    public void exibir() {
        for (int i = 0; i < info.length; i++) {
            System.out.println("Índice " + i + ": " + info[i].toString());
        }
    }
}