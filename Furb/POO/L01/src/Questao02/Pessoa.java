package Questao02;

public class Pessoa {
    Double altura;
    Double peso;

    double calcularImc() {
        return this.peso / (this.altura * this.altura);
    }
}
