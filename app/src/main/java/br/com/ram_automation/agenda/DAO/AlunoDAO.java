package br.com.ram_automation.agenda.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.ram_automation.agenda.Model.Aluno;

public class AlunoDAO {
    private static final List<Aluno> alunos = new ArrayList<>();
    private static Long idIncrement = Long.valueOf(0);

    public void salva(Aluno aluno) {
        aluno.setId(idIncrement);
        idIncrement++;
        aluno.setPosition(alunos.size());
        alunos.add(aluno);

    }

    public List<Aluno> getAll() {
        return new ArrayList<>(alunos);
    }

    public void atualiza(Aluno alunoColetado) {
        for (Aluno alunoRequisitado : alunos) {
            if (alunoColetado.getId().longValue() ==  alunoRequisitado.getId().longValue()) {
                alunos.set(alunoRequisitado.getPosition(),alunoColetado);
            }
        }
    }
}
