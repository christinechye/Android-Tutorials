package com.example.quiz3_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {
    // search by name
    private Button btn_search;
    private Button btn_remove;
    private EditText et_name;
    private TextView tv_result;
    private String record;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        btn_remove = findViewById(R.id.btn_delete_);
        btn_search = findViewById(R.id.btn_search_);
        et_name = findViewById(R.id.et_n_);
        tv_result = findViewById(R.id.tv_res_);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(FourthActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                // access database
                DBHelper dbHelper = new DBHelper(FourthActivity.this);

                // get data repo in read mode
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                // query
                String[] columns = {CourseInfoContact.Course.COURSE_NAME, CourseInfoContact.Course.PROF_NAME};
                String selection = CourseInfoContact.Course.PROF_NAME+ " LIKE? ";
                String[] selectionArgs = {"%"+name+"%"};
                Cursor cursor = db.query(CourseInfoContact.Course.TABLE_NAME,columns,selection,selectionArgs,null, null, CourseInfoContact.Course.PROF_NAME);

                // iterate over records
                String result = "";
                while(cursor.moveToNext()){
                    String id_ = cursor.getString(cursor.getColumnIndex(CourseInfoContact.Course.COURSE_NAME));
                    String name_ = cursor.getString(cursor.getColumnIndex(CourseInfoContact.Course.PROF_NAME));
                    //append this record to result
                    result = result + "\n\n "+ id_ + " " + name_;
                    record = name_;
                }

                // close db connection
                db.close();

                // check results
                if (result.isEmpty()) {
                    Toast.makeText(FourthActivity.this, "No matches", Toast.LENGTH_SHORT).show();
                }
//                Toast.makeText(FourthActivity.this, "Matched! Result: " + result, Toast.LENGTH_SHORT).show();
                // display results
                tv_result.setText(result);
            }
        });
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(FourthActivity.this, "Professor name cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                // access database
                DBHelper dbHelper = new DBHelper(FourthActivity.this);

                // get data repo in write mode
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                // delete records where id = user-entered id
                String whereClause = CourseInfoContact.Course.PROF_NAME+"=?";
                String[] whereArgs = {record};
                int count = db.delete(CourseInfoContact.Course.TABLE_NAME,whereClause,whereArgs);

                // close db connection
                db.close();

                // check if deleted
                int duration = Toast.LENGTH_SHORT;
                String fail = "No records updated.";
                String success = "Updated " + count + " records";
//                Toast.makeText(FourthActivity.this, count, duration).show();

                if (count != 0) {
                    Toast.makeText(FourthActivity.this, success, duration).show();
                }
                else {
                    Toast.makeText(FourthActivity.this, fail, duration).show();
                }

                // clear text fields
                et_name.setText("");
            }
        });

    }
}
