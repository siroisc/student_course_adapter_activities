package com.example.student_course_adapter_activities;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.student_course_adapter_activities.Model.CourseEnrollment;
import com.example.student_course_adapter_activities.Model.Student;
import com.example.student_course_adapter_activities.Model.StudentDB;

import java.util.ArrayList;

public class StudentAddEditActivity extends AppCompatActivity {
    private String TAG = "StudentAddEditActivity";

    ArrayList<EditText> editStudentList = new ArrayList<EditText>();
    //I'm here d
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");
        setContentView(R.layout.student_summary);
        editStudentList.add((EditText) findViewById(R.id.courseID_edit)); // Add the current course list
        editStudentList.add((EditText) findViewById(R.id.gradeID_edit)); //ADd the corresponding grade
        Button addCourseButton = findViewById(R.id.middle_button); // User wants to input
        addCourseButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) { //When user wanst to add
                        LinearLayout cID_ll = findViewById(R.id.courseID_layout);
                        LinearLayout grade_ll = findViewById(R.id.grade_ll);
                        LayoutInflater inflater = LayoutInflater.from(v.getContext());
                        EditText courseID = (EditText) inflater.inflate(R.layout.edit_text_row, cID_ll, false);
                        EditText grade = (EditText) inflater.inflate(R.layout.edit_text_row, grade_ll, false);
                        editStudentList.add(courseID);
                        editStudentList.add(grade);
                        cID_ll.addView(courseID);
                        grade_ll.addView(grade);
                    }
                }
        );
        Log.d(TAG, "setOnClickListener() called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.donebt_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final EditText edit_fName = findViewById(R.id.edit_first_name);
        final EditText edit_lName = findViewById(R.id.edit_last_name);
        final EditText edit_cwid = findViewById(R.id.edit_cwid);
        edit_fName.getText().toString();
        edit_lName.getText().toString();
        edit_cwid.getText().toString();
        if(item.getItemId() == R.id.action_done){
            ArrayList<CourseEnrollment> courseList = new ArrayList<CourseEnrollment>();
            for(int i = 0; i < editStudentList.size(); i += 2){
                courseList.add(new CourseEnrollment(editStudentList.get(i).getText().toString(),
                        editStudentList.get(i+1).getText().toString()));
            }
            Log.d(TAG, "onOptionsItemSelected called() before Student)");
            Student s = new Student(edit_fName.getText().toString(), edit_lName.getText().toString(), edit_cwid.getText().toString());

            s.setCourses(courseList);
            StudentDB.getInstance().addStudent(s);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
