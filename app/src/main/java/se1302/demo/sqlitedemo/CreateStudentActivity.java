package se1302.demo.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.UUID;

import se1302.demo.sqlitedemo.models.StudentModel;
import se1302.demo.sqlitedemo.services.StudentService;

public class CreateStudentActivity extends AppCompatActivity {
    EditText edtName, edtCore;
    RadioGroup rdGraduate;
    StudentModel student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);
        edtName = findViewById(R.id.edtName);
        edtCore = findViewById(R.id.edtCore);
        student = new StudentModel();
        rdGraduate = (RadioGroup) findViewById(R.id.rdGraduate);
        rdGraduate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.graduated) {
                    student.setGradute(0);
                } else {
                    student.setGradute(1);
                }
            }
        });
    }


    public void clickToCreateStudent(View view) {
        student.setName(edtName.getText().toString());
        student.setCore(Integer.parseInt(edtCore.getText().toString()));
        student.setId(UUID.randomUUID().toString());
        StudentService studentService = new StudentService(this);
        Intent intent = this.getIntent();
        boolean check = studentService.create(student);
        if (check) {
            Toast.makeText(this, "Thêm học sinh thành công", Toast.LENGTH_SHORT).show();
            this.setResult(RESULT_OK, intent);
            finish();
        } else {
            Toast.makeText(this, "Thêm học sinh thất bại", Toast.LENGTH_SHORT).show();
            this.setResult(RESULT_CANCELED, intent);
            finish();
        }
    }
}
