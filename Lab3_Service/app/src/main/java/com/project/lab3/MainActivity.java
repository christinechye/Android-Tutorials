package com.project.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";

    Button buttonStart, buttonStop;
    Button buttonBind, buttonUnBind;
    Button buttonGetRandomNumber;
    TextView tvRandomNumber;

    MyService myService;
    private ServiceConnection myConnection;
    Intent intent;
    boolean isBound;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set layout
        setContentView(R.layout.activity_main);

        //initialize UI elements
        buttonStart = findViewById(R.id.btn_start);
        buttonStop = findViewById(R.id.btn_stop);
        buttonBind = findViewById(R.id.btn_bind);
        buttonUnBind = findViewById(R.id.btn_unbind);
        buttonGetRandomNumber = findViewById(R.id.btn_getNumber);
        tvRandomNumber = findViewById(R.id.tv_random_number);

        //set on click listener
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonBind.setOnClickListener(this);
        buttonUnBind.setOnClickListener(this);
        buttonGetRandomNumber.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                startMyService();
                break;
            case R.id.btn_stop:
                stopMyService();
                break;
            case R.id.btn_bind:
                bindMyService();
                break;
            case R.id.btn_unbind:
                unbindMyService();
                break;
            case R.id.btn_getNumber:
                getNumber();
                break;
        }
    }

    private void startMyService(){
        //TODO: START A SERVICE
        Log.i(TAG, "Starting Service");
        Log.i(TAG, "Thread ID: " + Thread.currentThread().getId());
        intent = new Intent(this, MyService.class);
        startService(intent);
    }

    private void stopMyService(){
        //TODO: STOP A SERVICE
        Log.i(TAG, "Stopping Service");
        stopService(intent);
    }

    private void bindMyService(){
        //TODO: BIND A SERVICE
        if (myConnection == null) {
            Log.i(TAG, "Binding Service");
            myConnection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Log.i(TAG, "On Service Connected");
                    isBound = true;

                    MyService.MyLocalBinder myBinder = (MyService.MyLocalBinder)iBinder;
                    myService = myBinder.getService();
                }
                @Override
                public void onServiceDisconnected(ComponentName componentName){
                    Log.i(TAG, "On Service Disconnected");
                    isBound = false;
                }
            };
                bindService(intent, myConnection, BIND_AUTO_CREATE);
        }
    }

    private void unbindMyService(){
        //TODO: UNBIND A SERVICE
        if (isBound == true) {
            Log.i(TAG, "UnBinding Service");
            unbindService(myConnection);
            myConnection = null;
            isBound = false;
        }
    }

    private void getNumber(){
        //TODO: GET RANDOM NUMBER FROM SERVICE AND DISPLAY IT
        if (isBound == true) {
            int rand = myService.getRandomNumber();
            tvRandomNumber.setText(String.valueOf(rand));
        }
        else {
            tvRandomNumber.setText(" ");
        }
    }
}