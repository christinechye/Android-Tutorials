package com.example.quiz3_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "courses.db";
    private static final int DATABASE_VERSION = 3;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // create table
    private static final String CREATE_TABLE = "CREATE TABLE " + CourseInfoContact.Course.TABLE_NAME + "(" + CourseInfoContact.Course._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            CourseInfoContact.Course.COURSE_NAME + " TEXT NOT NULL, " + CourseInfoContact.Course.PROF_NAME  + ")";
    // delete table
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ CourseInfoContact.Course.TABLE_NAME;


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop existing tables
        db.execSQL(DROP_TABLE);
        //start over
        onCreate(db);
    }
}
