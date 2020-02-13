package br.com.ram_automation.agenda;

import android.app.Application;

import br.com.ram_automation.agenda.DAO.StudentDAO;
import br.com.ram_automation.agenda.Model.Student;

@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {
    private StudentDAO studentDAO;
    @Override
    public void onCreate() {
        super.onCreate();
        initializeVariables();


    }

    private void initializeVariables() {
        studentDAO = new StudentDAO();
        generateDefaultStudents();
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

}
