package br.com.ram_automation.agenda.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {
    private long id;
    private String nameStudent;
    private String telephoneStudent;
    private String emailStudent;
    private boolean genderStudent;

    public Student(String nameStudent, String telephoneStudent, String emailStudent, Boolean genderStudent) {
        this.nameStudent = nameStudent;
        this.telephoneStudent = telephoneStudent;
        this.emailStudent = emailStudent;
        this.genderStudent = genderStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public void setTelephoneStudent(String telephoneStudent) {
        this.telephoneStudent = telephoneStudent;
    }

    public void setEmailStudent(String emailStudent) {
        this.emailStudent = emailStudent;
    }

    public void setGenderStudent(Boolean genderStudent) {
        this.genderStudent = genderStudent;
    }

    public long getId() {
        return id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public String getTelephoneStudent() {
        return telephoneStudent;
    }

    public String getEmailStudent() {
        return emailStudent;
    }

    public boolean getGenderStudent() {
        return genderStudent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return this.nameStudent;
    }
}
