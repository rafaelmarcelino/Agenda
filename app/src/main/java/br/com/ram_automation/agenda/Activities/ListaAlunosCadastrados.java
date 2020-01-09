package br.com.ram_automation.agenda.Activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.ram_automation.agenda.R;

public class ListaAlunosCadastrados extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos_cadastrados);
        setTitle("Lista de Alunos");
        List<String> alunos = new ArrayList<>();
        alunos.add("Rafael");
        alunos.add("Carmem");
        alunos.add("Barbara");
        alunos.add("Vera");
        alunos.add("Domingos");
        alunos.add("Aline");
        alunos.add("Rochele");

        ListView lv_alunos = findViewById(R.id.activity_lista_alunos_cadastrados_lv);

        lv_alunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alunos));
    }
}
