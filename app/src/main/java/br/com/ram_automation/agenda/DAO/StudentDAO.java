package br.com.ram_automation.agenda.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.ram_automation.agenda.Model.Student;

public class StudentDAO {
    private static final  List<Student> students = new ArrayList<>();
    private static Long idIncrement = 0L;

    public void saveStudent(Student student) {
        student.setId(idIncrement);
        idIncrement++;
        students.add(student);

    }

    public void updateStudent(Student studentCollected, int position) {
        for (Student requestedStudent : students) {
            if (studentCollected.getId() ==  requestedStudent.getId()) {
                if(position >= 0){
                    students.set(position, studentCollected);
                }
            }
        }
    }

    public void removeStudent(Student student){
        students.remove(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

}
