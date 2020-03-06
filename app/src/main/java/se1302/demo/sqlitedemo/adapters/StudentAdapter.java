package se1302.demo.sqlitedemo.adapters;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import se1302.demo.sqlitedemo.models.StudentModel;

public class StudentAdapter extends BaseAdapter<StudentModel> {
    public StudentAdapter(Context context, ArrayList<StudentModel> list) {
        super(context, list);
    }
    @Override
    public void drawText(TextView textView, StudentModel model) {
        textView.setText(model.getName());
    }

}