package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int RATING1 = 1;
    public static final int RATING2 = 2;

    private Button imageButton1;
    private Button imageButton2;
    private TextView ratings1;
    private TextView ratings2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        ratings1 = findViewById(R.id.ratingReturned1);
        ratings2 = findViewById(R.id.ratingReturned2);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ImageActivity.class);

                i.putExtra("Key1", "KATANA");

                startActivityForResult(i, RATING1);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ImageActivity2.class);

                i.putExtra("Key2", "FF7REMAKE");

                startActivityForResult(i, RATING2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String mySelection;
        if (requestCode == RATING1 && resultCode == RESULT_OK) {
            if (data.hasExtra("Key1")) {
                mySelection = data.getExtras().getString("Key1");
                ratings1.setText(mySelection);
            }
        }else if(requestCode == RATING2 && resultCode == RESULT_OK){
            if(data.hasExtra("Key2")){
                mySelection = data.getExtras().getString("Key2");
                ratings2.setText(mySelection);
            }
        }
    }
}
