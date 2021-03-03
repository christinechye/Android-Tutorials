package com.example.quiz3_sqlite;

import android.provider.BaseColumns;

public class CourseInfoContact {
    private CourseInfoContact() {

    }
    public static class Course implements BaseColumns {
        public static final String TABLE_NAME = "CoursesInfo";
        public static final String COURSE_NAME = "course_name";
        public static final String PROF_NAME = "prof_name";
    }
}
