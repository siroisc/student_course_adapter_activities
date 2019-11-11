package com.example.student_course_adapter_activities;

import com.example.student_course_adapter_activities.Model.Student;
import com.example.student_course_adapter_activities.Model.StudentDB;
import com.example.student_course_adapter_activities.Model.CourseEnrollment;
import com.example.student_course_adapter_activities.Adapter.StudentSummaryAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    protected ListView sSummaryListView;
    protected StudentSummaryAdapter sAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_detail_list);

        createEnrolledStudents();
        sSummaryListView = findViewById(R.id.student_summaryLV);
        sAdapter = new StudentSummaryAdapter();
        sSummaryListView.setAdapter(sAdapter);
    }

    protected void createEnrolledStudents() {
        ArrayList<Student> enrolledStudents = new ArrayList<Student>();
        ArrayList<CourseEnrollment> course = new ArrayList<CourseEnrollment>();
        Student student = new Student("Ted", "Yamashita", "1920");
        course.add(new CourseEnrollment("cpsc10", "A"));
        student.setCourses(course);
        enrolledStudents.add(student);

        student = new Student("Armond", "Sirois", "1933");
        course.add(new CourseEnrollment("cpsc900", "A"));
        student.setCourses(course);
        enrolledStudents.add(student);

        StudentDB.getInstance().setStudents(enrolledStudents);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_positive, menu);
        menu.findItem(R.id.action_add).setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, StudentAddEditActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sAdapter.notifyDataSetChanged();
    }
}
