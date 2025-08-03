package Questao04;

public class Pessoa {
    String nome;
    Double altura;
    Double peso;

    double calcularImc() {
        return this.peso / (this.altura * this.altura);
    }
}
