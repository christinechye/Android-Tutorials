package com.example.quiz3_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_add;
    Button btn_show;
    Button btn_searchName;
    Button btn_searchCourse;
    EditText et_course;
    EditText et_prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize UI layout
        btn_add = findViewById(R.id.bt_add);
        btn_show = findViewById(R.id.bt_show);
        btn_searchName = findViewById(R.id.bt_searchName);
        btn_searchCourse = findViewById(R.id.bt_searchCourse);
        et_course = findViewById(R.id.et_course);
        et_prof = findViewById(R.id.et_prof);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseNum = et_course.getText().toString();
                String profName = et_prof.getText().toString();
                if (courseNum.isEmpty() || profName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Error! Course and Professor name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                // add record to database
                DBHelper dBHelper_ = new DBHelper(MainActivity.this);

                // get data repo in write mode
                SQLiteDatabase db = dBHelper_.getWritableDatabase();

                // create object
                ContentValues contentValues = new ContentValues();

                // method to insert
                contentValues.put(CourseInfoContact.Course.COURSE_NAME, courseNum);
                contentValues.put(CourseInfoContact.Course.PROF_NAME, profName);

                // insert new table
                long recordId = db.insert(CourseInfoContact.Course.TABLE_NAME,null, contentValues);

                // close db connection
                db.close();

                // check whether insertion is successful or not
                int duration = Toast.LENGTH_SHORT;
                if (recordId == -1) {
                    Toast.makeText(MainActivity.this, "Failed to insert!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(MainActivity.this, "Successfully inserted!", Toast.LENGTH_SHORT).show();
                }
                // clear fields
                et_course.setText("");
                et_prof.setText("");
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        btn_searchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        btn_searchCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourthActivity.class);
                startActivity(intent);
            }
        });
    }
}