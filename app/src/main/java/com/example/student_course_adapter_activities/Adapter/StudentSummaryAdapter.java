package com.example.student_course_adapter_activities.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.student_course_adapter_activities.R;
import com.example.student_course_adapter_activities.Model.Student;
import com.example.student_course_adapter_activities.Model.StudentDB;
import com.example.student_course_adapter_activities.StudentAddEditActivity;
public class StudentSummaryAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return StudentDB.getInstance().getStudents().size();
    }

    @Override
    public Object getItem(int position) {
        return StudentDB.getInstance().getStudents().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View row_view;

        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            row_view = inflater.inflate(R.layout.student_row, parent, false);
        } else row_view = convertView;

        final Student s = StudentDB.getInstance().getStudents().get(position);

        ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFirstName());
        ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLastName());
        ((TextView) row_view.findViewById(R.id.cwid)).setText(s.getCWID().toString());

        row_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Showing: Student Course, Grade", Toast.LENGTH_SHORT).show();
                Integer courseSize = s.getCourses().size();
                for(int i=0; i < courseSize; i++) {
                    Toast.makeText(view.getContext(), s.getCourses().get(i).getcCourseID(),
                            Toast.LENGTH_SHORT).show();
                    Toast.makeText(view.getContext(), s.getCourses().get(i).getcGrade(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    /*    TextView firstNameView = row_view.findViewById(R.id.first_name);
        TextView lastNameView = row_view.findViewById(R.id.last_name);
        firstNameView.setText(s.getFirstName());
        lastNameView.setText(s.getLastName());
        row_view.setTag(new Integer(position));*/

        return row_view;
    }
}
