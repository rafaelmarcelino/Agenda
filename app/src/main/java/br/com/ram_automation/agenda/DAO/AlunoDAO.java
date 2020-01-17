package br.com.ram_automation.agenda.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.ram_automation.agenda.Model.Aluno;

public class AlunoDAO {
    private static final List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        int size = alunos.size();
        if (size <=0){
            aluno.setId(Long.valueOf(0));
        }else {
            aluno.setId(Long.valueOf(size));
        }

        aluno.setPosition(size + 1);
        alunos.add(aluno);
    }

    public List<Aluno> getAll() {
        return new ArrayList<>(alunos);
    }
}
