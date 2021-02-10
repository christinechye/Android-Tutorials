package edu.scu.coen268.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public final static String TAG = "SecondActivity";
    private String userName = "";

    TextView userText;
    Button logout_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"On Create");

        // set the UI layout for this activity
        setContentView(R.layout.activity_second);

        // initialize UI elements
        userText = findViewById(R.id.tv_user);
        logout_btn = (Button) findViewById(R.id.btn_logout);

        //ToDo: 2. Get and set username
//        userName = getIntent()
        userText.setText(getIntent().getStringExtra("name"));
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
    //ToDo: 3. Implement click event handler method
    public void logout(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
