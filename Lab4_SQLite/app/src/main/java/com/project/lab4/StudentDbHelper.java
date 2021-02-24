package com.project.lab4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "students.db";
    private static final int DATABASE_VERSION = 2; // NOTE: CHANGE VERSION WHENEVER UPDATING THE FOLLOWING METHODS

    public StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // create table
    private static final String CREATE_TABLE = "CREATE TABLE " + StudentInfoContract.Students.TABLE_NAME + "(" + StudentInfoContract.Students._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            StudentInfoContract.Students.STUDENT_NAME + " TEXT NOT NULL, " + StudentInfoContract.Students.STUDENT_ID + " TEXT NOT NULL, " + StudentInfoContract.Students.STUDENT_EMAIL + " TEXT" + ")";

    // delete table
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ StudentInfoContract.Students.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //create all tables
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop existing tables
        sqLiteDatabase.execSQL(DROP_TABLE);
        //start over
        onCreate(sqLiteDatabase);
    }

}
