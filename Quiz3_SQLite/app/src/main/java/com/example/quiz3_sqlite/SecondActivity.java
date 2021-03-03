package com.example.quiz3_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView tv_all_info;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // instantiate/access database
        DBHelper dbHelper_ = new DBHelper(SecondActivity.this);

        // get data repo in read mode
        SQLiteDatabase db = dbHelper_.getReadableDatabase();

        // query method
        Cursor cursor = db.query(CourseInfoContact.Course.TABLE_NAME, null, null, null, null, null, CourseInfoContact.Course.COURSE_NAME);

        // retrieve data from the query result (cursor returns obj)
        String result = "";
            while(cursor.moveToNext()){
            String course = cursor.getString(cursor.getColumnIndex(CourseInfoContact.Course.COURSE_NAME));
            String prof = cursor.getString(cursor.getColumnIndex(CourseInfoContact.Course.PROF_NAME));
            //append this record to result
            result = result + "\n\nCOURSE: "+course+"\nPROFESSOR: "+prof;
        }

        // close db connection
        db.close();

        // check results
        if (result.isEmpty()) {
            result = "No records found.";
        }

        // display results
        tv_all_info.setText(result);
    }
}
