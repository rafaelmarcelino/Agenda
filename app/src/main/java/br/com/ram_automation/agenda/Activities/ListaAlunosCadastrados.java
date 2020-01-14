package br.com.ram_automation.agenda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.security.PrivateKey;
import java.util.List;

import br.com.ram_automation.agenda.Adapters.CustomBaseAdapter;
import br.com.ram_automation.agenda.DAO.AlunoDAO;
import br.com.ram_automation.agenda.Model.Aluno;
import br.com.ram_automation.agenda.R;

public class ListaAlunosCadastrados extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Lista de Alunos";
    private AlunoDAO alunoDAO = new AlunoDAO();
    private ListView lv_alunos;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos_cadastrados);
        setTitle(TITULO_APPBAR);
        initializeVariables();
    }

    @Override
    protected void onResume() {
        super.onResume();
        behaviorActivity();
    }

    private void initializeVariables() {
        lv_alunos = findViewById(R.id.activity_lista_alunos_cadastrados_lv);
        floatingActionButton = findViewById(R.id.activity_lista_alunos_cadastrados_fab_cadastro);
    }

    private void behaviorActivity() {
        configuraFABCadastraNovoAluno();
        defineListaAlunos();

    }

    private void configuraFABCadastraNovoAluno() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunosCadastrados.this, CadastroNovoAluno.class));
            }
        });
    }

    private void defineListaAlunos() {
        List<Aluno> alunos = alunoDAO.getAll();

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(alunos,this);

        lv_alunos.setAdapter(customBaseAdapter);
    }

}
