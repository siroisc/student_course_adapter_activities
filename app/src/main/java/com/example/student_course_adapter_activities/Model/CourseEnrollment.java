package com.example.student_course_adapter_activities.Model;

public class CourseEnrollment {
    protected String cGrade;
    protected String cCourseID;

    public CourseEnrollment(String courseID, String grade) {
        cGrade = grade;
        cCourseID = courseID;
    }

    public String getcGrade() {
        return cGrade;
    }

    public void setcGrade(String grade) {
        cGrade = grade;
    }

    public String getcCourseID() {
        return cCourseID;
    }

    public void setcCourseID(String courseID) {
        cCourseID = courseID;
    }




}
