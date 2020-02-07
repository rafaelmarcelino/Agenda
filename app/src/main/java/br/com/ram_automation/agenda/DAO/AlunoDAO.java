package br.com.ram_automation.agenda.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.ram_automation.agenda.Model.Aluno;

public class AlunoDAO {
    private static final  List<Aluno> alunos = new ArrayList<>();
    private static Long idIncrement = Long.valueOf(0);

    public void salvaAluno(Aluno aluno) {
        aluno.setId(idIncrement);
        idIncrement++;
        aluno.setPosition(alunos.size());
        alunos.add(aluno);

    }

    public List<Aluno> buscaTodosAlunos() {
        return new ArrayList<>(alunos);
    }

    public void atualizaAluno(Aluno alunoColetado) {
        for (Aluno alunoRequisitado : alunos) {
            if (alunoColetado.getId() ==  alunoRequisitado.getId()) {
                alunos.set(alunoRequisitado.getPosition(),alunoColetado);
            }
        }
    }

    public void removeAluno(Aluno alunoColetado){
        int position = -1;
        for (Aluno alunoAlvo:alunos) {
            if (alunoAlvo.getId()== alunoColetado.getId()){
                position = alunoAlvo.getPosition();
            }
        }
        if(position >= 0) {
            alunos.remove(position);
        }
    }
}
