package com.project.lab4;

import android.content.Context;
import android.provider.BaseColumns;

final public class StudentInfoContract {
    private StudentInfoContract () {
    }

    public static class Students implements BaseColumns{
        public static final String TABLE_NAME = "StudentsInfo";
        public static final String STUDENT_ID = "student_id";
        public static final String STUDENT_NAME = "name";
        public static final String STUDENT_EMAIL = "email";
    }
}
