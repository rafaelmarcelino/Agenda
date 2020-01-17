package br.com.ram_automation.agenda.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {
    private Long id;
    private Integer position;
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

    public Long getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @NonNull
    @Override
    public String toString() {
        return this.nomeAluno;
    }
}
