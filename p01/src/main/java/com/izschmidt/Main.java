package com.izschmidt;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, WORLD!!!");

        Pessoa pessoa01 = new Pessoa("TEST", 20);
        pessoa01.mostrarInfosPessoa(pessoa01);

        System.out.println("Atualizando informações da pessoa.");

        pessoa01.setNome("Igor Z. Schmidt");
        pessoa01.setIdade(21);

        pessoa01.mostrarInfosPessoa(pessoa01);
    }
}

