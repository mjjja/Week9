package com.example.kmj.week8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    Spinner spinner;
    String[] fruit={"사과","복숭아","자몽","포도"};
    SpinnerAdaper adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = new SpinnerAdaper(fruit,this);
        spinner.setAdapter(adapter);
    }
}
