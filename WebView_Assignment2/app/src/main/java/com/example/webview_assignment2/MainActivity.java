package com.example.webview_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    // array of strings to map list items
    String[] foodArr = {"Pad_thai", "Pho", "Ramen", "Fried_rice", "Matcha", "Ube_ice_cream"};
    int[] imageid = {
            R.drawable.pad_thai,
            R.drawable.pho,
            R.drawable.ramen,
            R.drawable.fried_rice,
            R.drawable.matcha,
            R.drawable.ube
    };

    ListView lView;
    ListAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lView = (ListView) findViewById(R.id.list_view);

        lAdapter = new ListAdapter(MainActivity.this, foodArr, imageid);

        lView.setAdapter(lAdapter);

//        // list view needs an adapter to put the contents into the view
//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_list_row, foodArr);
//
//        ListView listView = (ListView) findViewById(R.id.list_view);
//        listView.setAdapter(adapter);


        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String foodID;
                switch(position) {
                    case 0:
                        foodID = foodArr[0];
                        Intent pad_thai = new Intent(MainActivity.this, SecondActivity.class);
                        pad_thai.putExtra("food", foodID); // stores an object for your intent
                        MainActivity.this.startActivity(pad_thai);
                        break;
                    case 1:
                        foodID = foodArr[1];
                        Intent pho = new Intent(MainActivity.this, SecondActivity.class);
                        pho.putExtra("food", foodID);
                        MainActivity.this.startActivity(pho);
                        break;
                    case 2:
                        foodID = foodArr[2];
                        Intent ramen = new Intent(MainActivity.this, SecondActivity.class);
                        ramen.putExtra("food", foodID);
                        MainActivity.this.startActivity(ramen);
                        break;
                    case 3:
                        foodID = foodArr[3];
                        Intent fried_rice = new Intent(MainActivity.this, SecondActivity.class);
                        fried_rice.putExtra("food", foodID);
                        MainActivity.this.startActivity(fried_rice);
                        break;
                    case 4:
                        foodID = foodArr[4];
                        Intent matcha = new Intent(MainActivity.this, SecondActivity.class);
                        matcha.putExtra("food", foodID);
                        MainActivity.this.startActivity(matcha);
                        break;
                    case 5:
                        foodID = foodArr[5];
                        Intent ube = new Intent(MainActivity.this, SecondActivity.class);
                        ube.putExtra("food", foodID);
                        MainActivity.this.startActivity(ube);
                        break;
                }

//                Toast.makeText(getApplicationContext(),"You Selected "+ foodArr[position-1]+ " as Food",Toast.LENGTH_SHORT).show();
            }
        });
    }
}