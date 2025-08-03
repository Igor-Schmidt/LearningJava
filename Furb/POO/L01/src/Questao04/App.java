// Aluno: Igor Zafriel Schmidt

package Questao04;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pessoa[] pessoas = new Pessoa[3];

        for (int countPessoas = 0; countPessoas <= 2; countPessoas++) {
            pessoas[countPessoas] = new Pessoa();

            System.out.println("Olá pessoa " + (countPessoas+1) + " digite seu nome: ");
            pessoas[countPessoas].nome = scanner.next();

            System.out.println("Digite seu peso em KG (Ex. 75.0)");
            pessoas[countPessoas].peso = scanner.nextDouble();

            System.out.println("Digite sua altura em metros (Ex. 1.95)");
            pessoas[countPessoas].altura = scanner.nextDouble();
        }

        for (int countPessoas = 2; countPessoas >= 0; countPessoas--) {
            System.out.println("Nome: " + pessoas[countPessoas].nome);
            System.out.println("Seu IMC: " + pessoas[countPessoas].calcularImc());
            System.out.println();
        }
    }
}
