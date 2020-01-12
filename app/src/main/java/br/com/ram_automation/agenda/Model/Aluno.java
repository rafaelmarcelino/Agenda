package br.com.ram_automation.agenda.Model;

import androidx.annotation.NonNull;

public class Aluno {
    private final String nomeAluno;
    private final String telefoneAluno;
    private final String emailAluno;
    private final Boolean sexoAluno;

    public Aluno(String nomeAluno, String telefoneAluno, String emailAluno, Boolean sexoAluno) {
        this.nomeAluno = nomeAluno;
        this.telefoneAluno = telefoneAluno;
        this.emailAluno = emailAluno;
        this.sexoAluno = sexoAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getTelefoneAluno() {
        return telefoneAluno;
    }

    public String getEmailAluno() {
        return emailAluno;
    }

    public Boolean getSexoAluno() {
        return sexoAluno;
    }

    @NonNull
    @Override
    public String toString() {
        return this.nomeAluno;
    }
}
