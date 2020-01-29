package br.com.ram_automation.agenda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import br.com.ram_automation.agenda.DAO.AlunoDAO;
import br.com.ram_automation.agenda.Model.Aluno;
import br.com.ram_automation.agenda.R;

public class CadastroNovoAluno extends AppCompatActivity {
    private static final String TITULO_APPBAR_NOVO_ALUNO = "Novo Aluno";
    private static final String TITULO_APPBAR_EDITA_ALUNO = "Edita Aluno";
    private EditText etNomeAluno;
    private EditText etTelefoneAluno;
    private EditText etEmailAluno;

    private RadioGroup radioGroup;
    private RadioButton radioButtonMasc;
    private RadioButton radioButtonFem;
    private Button btnSalvarAluno;

    public static final String TAG_INTENT_DADOS = "DadosAluno";
    private final AlunoDAO alunoDAO = new AlunoDAO();

    private Aluno alunoColetado;
    private String _nomeAluno;
    private String _telefoneAluno;
    private String _emailAluno;
    private Boolean _sexoAluno = true;
    private Intent _intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_novo_aluno);
        initializeVariables();
    }

    @Override
    protected void onResume() {
        super.onResume();
        behaviorActivity();
    }

    private void initializeVariables() {
        _intent = getIntent();
        etNomeAluno = findViewById(R.id.activity_cadastrar_aluno_nome);
        etTelefoneAluno = findViewById(R.id.activity_cadastrar_aluno_telefone);
        etEmailAluno = findViewById(R.id.activity_cadastrar_aluno_email);

        radioGroup = findViewById(R.id.activity_cadastrar_aluno_radioGroup);
        radioButtonMasc = findViewById(R.id.activity_cadastrar_aluno_gen_masc);
        radioButtonFem = findViewById(R.id.activity_cadastrar_aluno_gen_fem);
        btnSalvarAluno = findViewById(R.id.activity_cadastrar_aluno_btn_salvar);
    }

    private void behaviorActivity() {

        if (!_intent.hasExtra(TAG_INTENT_DADOS)){
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
        }else{
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
            alunoColetado = (Aluno) _intent.getSerializableExtra(TAG_INTENT_DADOS);
            recuperaDadosAlunoColetado();
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                defineSexo(radioGroup);
            }
        });

        btnSalvarAluno.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (alunoColetado == null) {
                    Aluno aluno = criaNovoAluno();
                    salvaAluno(aluno);
                }else {
                    atualizaDadosAlunoColetado();
                    atualizaAluno(alunoColetado);
                }
            }
        });


    }

    private void atualizaDadosAlunoColetado() {
        _nomeAluno = etNomeAluno.getText().toString();
        _telefoneAluno = etTelefoneAluno.getText().toString();
        _emailAluno = etEmailAluno.getText().toString();

        alunoColetado.setNomeAluno(_nomeAluno);
        alunoColetado.setTelefoneAluno(_telefoneAluno);
        alunoColetado.setEmailAluno(_emailAluno);
        alunoColetado.setSexoAluno(_sexoAluno);

    }

    private void recuperaDadosAlunoColetado() {
        etNomeAluno.setText(alunoColetado.getNomeAluno());
        etTelefoneAluno.setText(alunoColetado.getTelefoneAluno());
        etEmailAluno.setText(alunoColetado.getEmailAluno());

        if (alunoColetado.getSexoAluno()) {
            radioButtonMasc.setChecked(true);
        } else {
            radioButtonFem.setChecked(true);
        }
    }

    private void atualizaAluno(Aluno alunoColetado) {
        alunoDAO.atualizaAluno(alunoColetado);
        finish();
    }

    private void salvaAluno(Aluno aluno) {
        alunoDAO.salvaAluno(aluno);
        finish();
    }

    private Aluno criaNovoAluno() {
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



