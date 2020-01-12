package br.com.ram_automation.agenda.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import br.com.ram_automation.agenda.DAO.AlunoDAO;
import br.com.ram_automation.agenda.Model.Aluno;
import br.com.ram_automation.agenda.R;

public class CadastroNovoAluno extends AppCompatActivity {
    EditText etNomeAluno;
    EditText etTelefoneAluno;
    EditText etEmailAluno;

    RadioGroup radioGroup;
    Button btnSalvarAluno;

    AlunoDAO alunoDAO = new AlunoDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_novo_aluno);
        initializeVariables();

        btnSalvarAluno.setOnClickListener(new View.OnClickListener() {
            String _nomeAluno = etNomeAluno.getText().toString();
            String _telefoneAluno = etTelefoneAluno.getText().toString();
            String _emailAluno = etEmailAluno.getText().toString();
            Boolean _sexoAluno = false;

            @Override
            public void onClick(View v) {
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (group.getCheckedRadioButtonId()){
                            case R.id.activity_cadastrar_aluno_gen_masc:
                                _sexoAluno = true;
                                break;
                        }
                    }
                });

                Aluno aluno = new Aluno(_nomeAluno, _telefoneAluno, _emailAluno, _sexoAluno);

                alunoDAO.salva(aluno);

                startActivity(new Intent(CadastroNovoAluno.this,ListaAlunosCadastrados.class));

            }
        });
    }

    private void initializeVariables() {
        etNomeAluno = findViewById(R.id.activity_cadastrar_aluno_nome);
        etTelefoneAluno = findViewById(R.id.activity_cadastrar_aluno_telefone);
        etEmailAluno = findViewById(R.id.activity_cadastrar_aluno_email);

        radioGroup = findViewById(R.id.activity_cadastrar_aluno_radioGroup);
        btnSalvarAluno = findViewById(R.id.activity_cadastrar_aluno_btn_salvar);
    }
}
