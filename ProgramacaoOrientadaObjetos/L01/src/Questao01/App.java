// Aluno: Igor Zafriel Schmidt

package Questao01;

public class App {
    public static void main(String[] args) {
        Pessoa pessoa01 = new Pessoa();

        pessoa01.peso = 75.0; // Em KG
        pessoa01.altura = 1.95; // Em metros

        System.out.println("Seu peso é: " + pessoa01.peso);
        System.out.println("Sua altura é: " + pessoa01.altura);
        System.out.println("Seu IMC é: " + pessoa01.calcularImc());
    }
}
