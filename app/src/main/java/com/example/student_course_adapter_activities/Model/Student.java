package com.example.student_course_adapter_activities.Model;

import java.util.ArrayList;

public class Student {
    protected String sFirstName;
    protected String sLastName;
    protected String cCWID;
    protected ArrayList<CourseEnrollment> cCourses;

    public Student(String firstName, String lastName, String CWID) {
        sFirstName = firstName;
        sLastName = lastName;
        cCWID = CWID;
    }
    public String getFirstName() {
        return sFirstName;
    }

    public void setsFirstName(String firstName) {
        sFirstName = firstName;
    }

    public String getLastName() {

        return sLastName;
    }

    public void setLastName(String lastName) {

        sLastName = lastName;
    }

    public String getCWID() {
        return cCWID;
    }

    public void setcCWID(String CWID) {
        cCWID = CWID;
    }

    public ArrayList<CourseEnrollment> getCourses() {
        return cCourses;
    }

    public void setCourses(ArrayList<CourseEnrollment> courses) {
        cCourses = courses;
    }
}
