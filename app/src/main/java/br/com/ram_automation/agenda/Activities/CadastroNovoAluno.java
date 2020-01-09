package br.com.ram_automation.agenda.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.ram_automation.agenda.Model.Aluno;
import br.com.ram_automation.agenda.R;

public class CadastroNovoAluno extends AppCompatActivity {
    EditText etNomeAluno;
    EditText etTelefoneAluno;
    EditText etEmailAluno;

    Button btnSalvarAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_novo_aluno);

        initializeVariables();

        btnSalvarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _nomeAluno = etNomeAluno.getText().toString();
                String _telefoneAluno = etTelefoneAluno.getText().toString();
                String _emailAluno = etEmailAluno.getText().toString();

                Aluno aluno = new Aluno(_nomeAluno, _telefoneAluno, _emailAluno);

                Toast.makeText(CadastroNovoAluno.this, aluno.getNomeAluno()+" - "+
                        aluno.getTelefoneAluno()+" - "+
                        aluno.getEmailAluno(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeVariables() {
        etNomeAluno = findViewById(R.id.activity_cadastrar_aluno_nome);
        etTelefoneAluno = findViewById(R.id.activity_cadastrar_aluno_telefone);
        etEmailAluno = findViewById(R.id.activity_cadastrar_aluno_email);

        btnSalvarAluno = findViewById(R.id.activity_cadastrar_aluno_btn_salvar);
    }
}
