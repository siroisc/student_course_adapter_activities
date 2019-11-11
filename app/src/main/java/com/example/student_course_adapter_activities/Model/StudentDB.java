package com.example.student_course_adapter_activities.Model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();
    protected ArrayList<Student> aStudents;

    public static StudentDB getInstance() {
        return ourInstance;
    }

    private StudentDB() {

    }

    public ArrayList<Student> getStudents() {
        return aStudents;
    }

    public void setStudents(ArrayList<Student> students) {
        aStudents = students;
    }

    public void addStudent(Student student) {
        aStudents.add(student);
    }

}
