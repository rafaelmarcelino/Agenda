package br.com.ram_automation.agenda.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
    }

    @Override
    protected void onResume() {
        super.onResume();
        behaviorActivity();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_list_all_students_stored_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.activity_list_all_students_menu_remove){
            callDialogToConfirmRemove(item);
        }
        return super.onContextItemSelected(item);
    }

    private void initializeVariables() {
        lvStudents = findViewById(R.id.activity_lista_alunos_cadastrados_lv);
        floatingActionButton = findViewById(R.id.activity_lista_alunos_cadastrados_fab_cadastro);

        studentDAO = new StudentDAO();
        listStudents = studentDAO.getAllStudents();
        configureAdapter();

        registerForContextMenu(lvStudents);
    }

    private void behaviorActivity() {
        configureFABRegisterNewStudent();
        defineListOfStudents();

    }

    private void configureAdapter() {
        customBaseAdapter = new CustomBaseAdapter(this);
        updateAllStudents();
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
    }

    private void updateAllStudents() {
        listStudents = studentDAO.getAllStudents();
        customBaseAdapter.updateStudents(listStudents);
    }

    private void setupClickListener() {
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student studentCollected = (Student) parent.getItemAtPosition(position);
                startActitvityToUpdateStudent(position, studentCollected);
            }
        });
    }

    private void startActitvityToUpdateStudent(int position, Student studentCollected) {
        Intent intent = new Intent(ListAllStudentsStored.this, StoreNewStudent.class);
        intent.putExtra(TAG_INTENT_DATA, studentCollected);
        intent.putExtra(POSITION_TO_UPDATE,position);
        startActivity(intent);
    }

    private void callDialogToConfirmRemove(final MenuItem item) {
        new AlertDialog.Builder(this)
                .setTitle("Deleting Student")
                .setMessage("Are you sure that you want to delete this student?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removeStudentFromList(item);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void removeStudentFromList(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Student studentToRemove = listStudents.get(menuInfo.position);
        studentDAO.removeStudent(studentToRemove);
        updateAllStudents();
    }

}
