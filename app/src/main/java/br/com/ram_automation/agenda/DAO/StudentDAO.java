package br.com.ram_automation.agenda.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.ram_automation.agenda.Model.Student;

public class StudentDAO {
    private static final  List<Student> students = new ArrayList<>();
    private static Long idIncrement = Long.valueOf(0);

    public void saveStudent(Student student) {
        student.setId(idIncrement);
        idIncrement++;
        students.add(student);

    }

    public void updateStudent(Student studentColected, int position) {
        for (Student requestedStudent : students) {
            if (studentColected.getId() ==  requestedStudent.getId()) {
                if(position >= 0){
                    students.set(position, studentColected);
                }
            }
        }
    }

    public void removeStudent(int position){
        if(position >= 0) {
            students.remove(position);
        }
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

}
