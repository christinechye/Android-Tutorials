package com.example.quiz3_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    // search by name
    private EditText et_name;
    private TextView tv_result;
    private Button btn_search;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        btn_search = findViewById(R.id.btn_search);
        et_name = findViewById(R.id.et_n);
        tv_result = findViewById(R.id.tv_res);
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(ThirdActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                // access database
                DBHelper dbHelper = new DBHelper(ThirdActivity.this);

                // get data repo in read mode
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                // query
                String[] columns = {CourseInfoContact.Course.COURSE_NAME, CourseInfoContact.Course.PROF_NAME};
                String selection = CourseInfoContact.Course.COURSE_NAME+ " LIKE? ";
                String[] selectionArgs = {"%"+name+"%"};
                Cursor cursor = db.query(CourseInfoContact.Course.TABLE_NAME,columns,selection,selectionArgs,null, null, CourseInfoContact.Course.COURSE_NAME);

                // iterate over records
                String result = "";
                while(cursor.moveToNext()){
                    String id_ = cursor.getString(cursor.getColumnIndex(CourseInfoContact.Course.COURSE_NAME));
                    String name_ = cursor.getString(cursor.getColumnIndex(CourseInfoContact.Course.PROF_NAME));
                    //append this record to result
                    result = result + " "+ id_ + " " + name_;
                }

                // close db connection
                db.close();

                // check results
                if (result.isEmpty()) {
                    Toast.makeText(ThirdActivity.this, "No matches", Toast.LENGTH_SHORT).show();
                }

                // display results
                tv_result.setText(result);

            }
        });

    }
}