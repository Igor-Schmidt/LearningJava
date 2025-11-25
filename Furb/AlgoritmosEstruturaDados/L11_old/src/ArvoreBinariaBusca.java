public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(info);
        if (estaVazia()) {
            setRaiz(novo);
        } else {
            inserir(getRaiz(), novo);
        }
    }

    private void inserir(NoArvoreBinaria<T> no, NoArvoreBinaria<T> novo) {
        int comparacao = novo.getInfo().compareTo(no.getInfo());

        if (comparacao < 0) {
            if (no.getEsquerda() == null) {
                no.setEsquerda(novo);
            } else {
                inserir(no.getEsquerda(), novo);
            }
        } else {
            if (no.getDireita() == null) {
                no.setDireita(novo);
            } else {
                inserir(no.getDireita(), novo);
            }
        }
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscar(getRaiz(), info);
    }

    private NoArvoreBinaria<T> buscar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        int comparacao = info.compareTo(no.getInfo());

        if (comparacao == 0) {
            return no;
        } else if (comparacao < 0) {
            return buscar(no.getEsquerda(), info);
        } else {
            return buscar(no.getDireita(), info);
        }
    }

    public void retirar(T info) {
        setRaiz(retirar(getRaiz(), info));
    }

    private NoArvoreBinaria<T> retirar(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        int comparacao = info.compareTo(no.getInfo());

        if (comparacao < 0) {
            no.setEsquerda(retirar(no.getEsquerda(), info));
        } else if (comparacao > 0) {
            no.setDireita(retirar(no.getDireita(), info));
        } else {
            if (no.getEsquerda() == null && no.getDireita() == null) {
                return null;
            }
            if (no.getEsquerda() == null) {
                return no.getDireita();
            }
            if (no.getDireita() == null) {
                return no.getEsquerda();
            }
            NoArvoreBinaria<T> sucessor = encontrarMenor(no.getDireita());
            no.setInfo(sucessor.getInfo());
            no.setDireita(retirar(no.getDireita(), sucessor.getInfo()));
        }

        return no;
    }

    private NoArvoreBinaria<T> encontrarMenor(NoArvoreBinaria<T> no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }
}
