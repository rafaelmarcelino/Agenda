package br.com.ram_automation.agenda.Model;

import androidx.annotation.NonNull;

public class Aluno {
    private final String nomeAluno;
    private final String telefoneAluno;
    private final String emailAluno;

    public Aluno(String nomeAluno, String telefoneAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.telefoneAluno = telefoneAluno;
        this.emailAluno = emailAluno;
    }

    @NonNull
    @Override
    public String toString() {
        return this.nomeAluno;
    }
}
