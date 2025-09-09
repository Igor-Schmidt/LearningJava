// Aluno: Igor Zafriel Schmidt

package L02_ListaEstaticaGenerica;

public class App {
    public static void main(String[] args) {

        // CASO 10
        ListaEstatica listaCASO10 = new ListaEstatica();
        listaCASO10.inserir(5);
        listaCASO10.inserir(10);
        listaCASO10.inserir(15);
        listaCASO10.inserir(20);
        
        listaCASO10.inverter();
        
        // CASO 11
        ListaEstatica listaCASO11 = new ListaEstatica();
        listaCASO11.inserir(5);
        listaCASO11.inserir(10);
        listaCASO11.inserir(15);
        listaCASO11.inserir(20);
        listaCASO11.inserir(25);
        listaCASO11.inverter();
    }
}
