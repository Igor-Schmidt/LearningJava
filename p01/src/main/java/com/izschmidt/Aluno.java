package com.izschmidt;

public class Aluno extends Pessoa {
    // Novos atributos apenas do Aluno

    private String matricula;
    private int periodo;

    public Aluno(
            String nome,
            int idade,
            String matricula,
            int periodo
    ) {
        super(nome, idade);
    }

    // public boolean verificarPeriodo(int periodo) {
    // }
}
