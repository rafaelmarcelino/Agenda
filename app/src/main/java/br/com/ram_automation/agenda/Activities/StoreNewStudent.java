package br.com.ram_automation.agenda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import br.com.ram_automation.agenda.DAO.StudentDAO;
import br.com.ram_automation.agenda.Model.Student;
import br.com.ram_automation.agenda.R;

public class StoreNewStudent extends AppCompatActivity {
    private static final String TITLE_APPBAR_NEW_STUDENT = "Novo Student";
    private static final String TITLE_APPBAR_EDIT_STUDENT = "Edita Student";
    private EditText etNameStudent;
    private EditText etTelephoneStudent;
    private EditText etEmaiStudent;

    private RadioGroup radioGroup;
    private RadioButton radioButtonMasc;
    private RadioButton radioButtonFem;
    private Button btnStoreStudent;

    public static final String TAG_INTENT_DATA = "DadosAluno";
    public static final String POSITION_TO_UPDATE = "position";
    private final StudentDAO studentDAO = new StudentDAO();

    private Student studentCollected;
    private int positionToUpdate;
    private String _nameStudent;
    private String _telephoneStudent;
    private String _emailStudent;
    private Boolean _genderStudent;
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
        etNameStudent = findViewById(R.id.activity_cadastrar_aluno_nome);
        etTelephoneStudent = findViewById(R.id.activity_cadastrar_aluno_telefone);
        etEmaiStudent = findViewById(R.id.activity_cadastrar_aluno_email);

        radioGroup = findViewById(R.id.activity_cadastrar_aluno_radioGroup);
        radioButtonMasc = findViewById(R.id.activity_cadastrar_aluno_gen_masc);
        radioButtonFem = findViewById(R.id.activity_cadastrar_aluno_gen_fem);
        btnStoreStudent = findViewById(R.id.activity_cadastrar_aluno_btn_salvar);

        _genderStudent = true;
    }

    private void behaviorActivity() {

        if (!_intent.hasExtra(TAG_INTENT_DATA)){
            setTitle(TITLE_APPBAR_NEW_STUDENT);
        }else{
            setTitle(TITLE_APPBAR_EDIT_STUDENT);
            studentCollected = (Student) _intent.getSerializableExtra(TAG_INTENT_DATA);
            positionToUpdate = _intent.getIntExtra(POSITION_TO_UPDATE,-1);
            retrieveDataFromCollectedStudent();
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                defineGender(radioGroup);
            }
        });

        btnStoreStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (studentCollected == null) {
                    Student student = createNewStudent();
                    storeStudent(student);
                }else {
                    updateDataOfColectedStudent();
                    updateStudent(studentCollected);
                }
            }
        });


    }

    private void updateDataOfColectedStudent() {
        _nameStudent = etNameStudent.getText().toString();
        _telephoneStudent = etTelephoneStudent.getText().toString();
        _emailStudent = etEmaiStudent.getText().toString();

        studentCollected.setNameStudent(_nameStudent);
        studentCollected.setTelephoneStudent(_telephoneStudent);
        studentCollected.setEmailStudent(_emailStudent);
        studentCollected.setGenderStudent(_genderStudent);

    }

    private void retrieveDataFromCollectedStudent() {
        etNameStudent.setText(studentCollected.getNameStudent());
        etTelephoneStudent.setText(studentCollected.getTelephoneStudent());
        etEmaiStudent.setText(studentCollected.getEmailStudent());

        if (studentCollected.getGenderStudent()) {
            radioButtonMasc.setChecked(true);
        } else {
            radioButtonFem.setChecked(true);
            _genderStudent = false;
        }
    }

    private void updateStudent(Student studentCollected) {
        studentDAO.updateStudent(studentCollected,positionToUpdate);
        finish();
    }

    private void storeStudent(Student student) {
        studentDAO.saveStudent(student);
        finish();
    }

    private Student createNewStudent() {
        _nameStudent = etNameStudent.getText().toString();
        _telephoneStudent = etTelephoneStudent.getText().toString();
        _emailStudent = etEmaiStudent.getText().toString();

        return new Student(_nameStudent, _telephoneStudent, _emailStudent, _genderStudent);
    }

    private void defineGender(RadioGroup radioGroup) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.activity_cadastrar_aluno_gen_masc:
                _genderStudent = true;
                break;
            case R.id.activity_cadastrar_aluno_gen_fem:
                _genderStudent = false;
                break;
        }
    }


}



