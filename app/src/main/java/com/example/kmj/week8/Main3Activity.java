package com.example.kmj.week8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    CheckBox cb;
    Button bt;
    ArrayList<Fruit> fruit = new ArrayList<Fruit>();
    AddFruit addFruit;
    GridView gridview;
    GridAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }

    void init() {
        cb = (CheckBox)findViewById(R.id.checkbox);
        bt = (Button)findViewById(R.id.button);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    adapter.ischecked=true;
                    adapter.refresh();
                }
                else {
                    adapter.ischecked=false;
                    adapter.refresh();
                }
            }
        });
        addFruit = (AddFruit) findViewById(R.id.add);
        addFruit.setOnAddListener(new AddFruit.OnAddListener() {
            @Override
            public void onAdd(String name, int imageno, int price) {
                adapter.addFruit(new Fruit(name, imageno, price));
                adapter.refresh();
            }

            @Override
            public void onModify(String name, int imageno, int price, int position) {
                adapter.modifyFruit(name, imageno, price, position);
                adapter.refresh();
            }
        });
        gridview = (GridView) findViewById(R.id.grid);
        adapter = new GridAdapter(fruit, this);
        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addFruit.setClick(position);
            }
        });


    }
}