// Aluno: Igor Zafriel Schmidt

package Questao02;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa01 = new Pessoa();

        System.out.println("Digite seu peso em KG (Ex. 75.0)");
        pessoa01.peso = scanner.nextDouble();

        System.out.println("Digite sua altura em metros (Ex. 1.95)");
        pessoa01.altura = scanner.nextDouble();

        System.out.println("Seu peso é: " + pessoa01.peso);
        System.out.println("Sua altura é: " + pessoa01.altura);
        System.out.println("Seu IMC é: " + pessoa01.calcularImc());
    }
}
