package com.project.lab3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyService extends Service {
    private static final String TAG = "MyService";
    boolean isStart = false;
    Thread t;
    int rand_num;

    public MyService() {

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "On Start Service");
        Log.i(TAG, "Thread ID: " + Thread.currentThread().getId());
        Log.i(TAG, "Start ID: " + startId);

        // we check if the generator is running
        // Every time we click on startService() it will create multiple threads as startService()
        // is be clicked on many times.
        // Therefore, we need this condition. We just need one thread to handle this method.
        // Always start the new thread if it is already false.
        if (isStart == false) {
            Runnable runnable = () -> { // interface provided by Java
                //ToDo: set the boolean variable to True generateRandomNumber();
                isStart = true;
                generateRandomNumber();
            };

            t = new Thread(runnable);
            t.start(); // when the thread starts, it will call runnable
        }

        return START_NOT_STICKY;
    }

    public void onDestroy() {
        Log.i(TAG, "On Destroy");
        isStart = false;
        t = null;
    }

    public void generateRandomNumber() {
        while (isStart == true) {
            Random rand = new Random(); // creating new instance
            rand_num = rand.nextInt();
            // print info log:
            Log.i(TAG, "Thread ID: " + Thread.currentThread().getId() + ", Random Number: " + rand_num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public int getRandomNumber() {
        return rand_num;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        Log.i(TAG, "On Bind");
        return  myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "On UnBind");
        return super.onUnbind(intent);
    }

    class MyLocalBinder extends Binder {
        public MyService getService(){
            return MyService.this; }
    }

    private Binder myBinder = new MyLocalBinder();
}
