package br.com.ram_automation.agenda.Activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.ram_automation.agenda.Adapters.CustomBaseAdapter;
import br.com.ram_automation.agenda.DAO.AlunoDAO;
import br.com.ram_automation.agenda.Model.Aluno;
import br.com.ram_automation.agenda.R;

public class ListaAlunosCadastrados extends AppCompatActivity {
    AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos_cadastrados);
        setTitle("Lista de Alunos");

        ListView lv_alunos = findViewById(R.id.activity_lista_alunos_cadastrados_lv);

        List<Aluno> alunos = alunoDAO.getAll();

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(alunos,this);

        lv_alunos.setAdapter(customBaseAdapter);
    }
}
