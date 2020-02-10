package br.com.ram_automation.agenda.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.com.ram_automation.agenda.Adapters.CustomBaseAdapter;
import br.com.ram_automation.agenda.DAO.StudentDAO;
import br.com.ram_automation.agenda.Model.Student;
import br.com.ram_automation.agenda.R;

public class ListAllStudentsStored extends AppCompatActivity {
    private static final String TITLE_APPBAR = "Lista de Alunos";
    private static final String TAG_INTENT_DATA = "DadosAluno";
    private static final String POSITION_TO_UPDATE = "position";

    private FloatingActionButton floatingActionButton;
    private ListView lvStudents;

    private StudentDAO studentDAO;

    private List<Student> listStudents;
    private CustomBaseAdapter customBaseAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos_cadastrados);
        setTitle(TITLE_APPBAR);
        initializeVariables();
        Toast.makeText(this, "ONCREATE", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        behaviorActivity();
    }

    private void initializeVariables() {
        lvStudents = findViewById(R.id.activity_lista_alunos_cadastrados_lv);
        floatingActionButton = findViewById(R.id.activity_lista_alunos_cadastrados_fab_cadastro);

        studentDAO = new StudentDAO();
        generateDefaultStudents();
        listStudents = studentDAO.getAllStudents();
        configureAdapter();
    }

    private void behaviorActivity() {
        configureFABRegisterNewStudent();
        defineListOfStudents();
        configureAdapter();
    }

    private void generateDefaultStudents() {
        studentDAO.saveStudent(new Student("Rafael Alves Marcelino",
                "(11)985264091",
                "rafael.alvesmarcelino@gmail.com",
                true));
        studentDAO.saveStudent(new Student("Carmelina Alves Marcelino",
                "(11)991764568",
                "alves.carmelina@gmail.com",
                false));
        studentDAO.saveStudent(new Student("Helio Santiago Marcelino",
                "(11)39695321",
                "helio.santiagomarcelino@gmail.com",
                true));
        studentDAO.saveStudent(new Student(" Micaelle Marcelino",
                "(11)44536135",
                "carmem.micaelle@gmail.com",
                false));
    }

    private void configureAdapter() {
        customBaseAdapter = new CustomBaseAdapter(listStudents, this);
        lvStudents.setAdapter(customBaseAdapter);
    }

    private void configureFABRegisterNewStudent() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListAllStudentsStored.this, StoreNewStudent.class));
            }
        });
    }

    private void defineListOfStudents() {
        updateAllStudents();
        setupClickListener();
        setupLongClickListener();
    }

    private void updateAllStudents() {
        listStudents = studentDAO.getAllStudents();
    }

    private void setupClickListener() {
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student studentColetado = (Student) parent.getItemAtPosition(position);
                startActitvityToUpdateStudent(position, studentColetado);
            }
        });
    }

    private void setupLongClickListener() {
        lvStudents.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                studentDAO.removeStudent(position);
                updateAllStudents();
                configureAdapter();
                return true;
            }
        });
    }

    private void startActitvityToUpdateStudent(int position, Student studentColected) {
        Intent intent = new Intent(ListAllStudentsStored.this, StoreNewStudent.class);
        intent.putExtra(TAG_INTENT_DATA, studentColected);
        intent.putExtra(POSITION_TO_UPDATE,position);
        startActivity(intent);
    }

}
