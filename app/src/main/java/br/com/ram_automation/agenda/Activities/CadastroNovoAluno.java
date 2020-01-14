package br.com.ram_automation.agenda.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import br.com.ram_automation.agenda.DAO.AlunoDAO;
import br.com.ram_automation.agenda.Model.Aluno;
import br.com.ram_automation.agenda.R;

public class CadastroNovoAluno extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Novo Aluno";
    private EditText etNomeAluno;
    private EditText etTelefoneAluno;
    private EditText etEmailAluno;

    private RadioGroup radioGroup;
    private Button btnSalvarAluno;

    private final AlunoDAO alunoDAO = new AlunoDAO();

    private String _nomeAluno;
    private String _telefoneAluno;
    private String _emailAluno;
    private Boolean _sexoAluno = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_novo_aluno);
        setTitle(TITULO_APPBAR);
        initializeVariables();
    }

    @Override
    protected void onResume() {
        super.onResume();
        behaviorActivity();
    }

    private void initializeVariables() {
        etNomeAluno = findViewById(R.id.activity_cadastrar_aluno_nome);
        etTelefoneAluno = findViewById(R.id.activity_cadastrar_aluno_telefone);
        etEmailAluno = findViewById(R.id.activity_cadastrar_aluno_email);

        radioGroup = findViewById(R.id.activity_cadastrar_aluno_radioGroup);
        btnSalvarAluno = findViewById(R.id.activity_cadastrar_aluno_btn_salvar);
    }

    private void behaviorActivity() {

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                defineSexo(radioGroup);
            }
        });

        btnSalvarAluno.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Aluno aluno = criaAluno();
                salvaAluno(aluno);

            }
        });


    }

    private void salvaAluno(Aluno aluno) {
        alunoDAO.salva(aluno);
        finish();
    }

    private Aluno criaAluno() {
        _nomeAluno = etNomeAluno.getText().toString();
        _telefoneAluno = etTelefoneAluno.getText().toString();
        _emailAluno = etEmailAluno.getText().toString();

        return new Aluno(_nomeAluno, _telefoneAluno, _emailAluno, _sexoAluno);
    }

    private void defineSexo(RadioGroup radioGroup) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.activity_cadastrar_aluno_gen_masc:
                _sexoAluno = true;
                break;
            case R.id.activity_cadastrar_aluno_gen_fem:
                _sexoAluno = false;
                break;
        }
    }


}



