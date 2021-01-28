package edu.scu.coen268.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigateToLinear(View view) {
        Intent intent = new Intent(this, LinearExample.class);
        startActivity(intent);
    }

    public void navigateToRelative(View view) {
        Intent intent = new Intent(this, RelativeExample.class);
        startActivity(intent);
    }

    public void navigateToTable(View view) {
        Intent intent = new Intent(this, TableExample.class);
        startActivity(intent);
    }

    public void navigateToGrid(View view) {
        Intent intent = new Intent(this, GridExample.class);
        startActivity(intent);
    }

    public void navigateToFrame(View view) {
        Intent intent = new Intent(this, FrameExample.class);
        startActivity(intent);
    }

    public void navigateToConstraint(View view) {
        Intent intent = new Intent(this, ConstraintExample.class);
        startActivity(intent);
    }
}