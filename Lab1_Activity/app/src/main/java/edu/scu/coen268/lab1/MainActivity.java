package edu.scu.coen268.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import java.io.LineNumberReader;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "MainActivity";
    public final static String USERNAME = "testUser";
    public final static String PASSWORD = "123456";

    EditText username;
    EditText password;
    private Button login_btn;
    private String userTemp;
    private String passTemp;
    public int duration;
    public Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "On Create");

        // set the UI layout for this activity
        setContentView(R.layout.activity_main);

        // initialize UI elements
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);

        // set the button
        login_btn = (Button) findViewById(R.id.btn_login);
    }

    //ToDo: 1. Implement the callback methods
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "On start");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "On resume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "On pause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "On stop");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "On restart");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "On destroy");
    }
    //ToDo: 2. Implement click event handler method
    public void login(View view) {
        // create an intent to start a new activity
//        Intent intent = new Intent(this, SecondActivity.class);

        // check if the username and password is valid
        userTemp = username.getText().toString();
        passTemp = password.getText().toString();
        if (userTemp.compareTo(USERNAME) == 0 && passTemp.compareTo(PASSWORD) == 0) { // valid
            Intent intent = new Intent(this, SecondActivity.class);
            // passes the value
            intent.putExtra("name", USERNAME);
            startActivity(intent);
        }
        else {
            // notify user invalid login
            CharSequence text = "Incorrect username or password!";
            duration = Toast.LENGTH_SHORT;
            toast = Toast.makeText(this, text, duration);
            toast.show();
        }
    }
}
