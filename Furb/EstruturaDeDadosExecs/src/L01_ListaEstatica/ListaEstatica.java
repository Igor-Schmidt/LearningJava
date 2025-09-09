// Aluno: Igor Zafriel Schmidt

package L01_ListaEstatica;

public class ListaEstatica {
    private int[] info;
    private int tamanho;

    public ListaEstatica() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    private void redimensionar() {
        int[] novoArray = new int[this.info.length + 10];
        for (int i = 0; i < this.info.length; i++) {
            novoArray[i] = this.info[i];
        }
        this.info = novoArray;
    }

    public void inserir(int valor) {
        if (this.tamanho == this.info.length) {
            redimensionar();
        }
        this.info[this.tamanho] = valor;
        this.tamanho++;
    }

    public void exibir() {
        System.out.println(" ");
        for (int count = 0; count < this.tamanho; count++) {
            System.out.print(this.info[count] + ",");
        }
        System.out.print(" |");
    }

    public int buscar(int valor) {
        for (int count = 0; count < this.tamanho; count++) {
            if (this.info[count] == valor) {
                return count;
            }
        }
        return -1;
    }

    public void reirar(int valor) {
        for (int count = 0; count < this.tamanho; count++) {
            if (this.info[count] == valor) {
                for (int j = count; j < this.tamanho - 1; j++) {
                    this.info[j] = this.info[j + 1];
                }
                this.tamanho--;
                return;
            }
        }
    }

    public void liberar() {
        this.info = new int[10];
        this.tamanho = 0;
    }

    public int obterElemento(int posicao) {
        if (posicao >= 0 && posicao < this.tamanho) {
            return this.info[posicao];
        } else {
            throw new IndexOutOfBoundsException("Posição inválida: " + posicao);
        }
    }

    public boolean estaVazio() {
        return this.tamanho == 0;
    }
    
    public int getTamanho() {
        return this.tamanho;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.tamanho; i++) {
            sb.append(this.info[i]);
            if (i < this.tamanho - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
