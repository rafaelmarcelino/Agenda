package br.com.ram_automation.agenda.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.ram_automation.agenda.Model.Aluno;

public class AlunoDAO {
    private static final List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAll() {
        return new ArrayList<>(alunos);
    }
}
