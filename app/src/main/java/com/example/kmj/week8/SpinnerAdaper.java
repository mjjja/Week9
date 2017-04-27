package com.example.kmj.week8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by KMJ on 2017-04-27.
 */

public class SpinnerAdaper extends BaseAdapter {

    String[] fruit;
    Context context;

    public SpinnerAdaper(String[] fruit, Context context){
        this.fruit=fruit;
        this.context=context;
    }

    @Override
    public int getCount() {
        return fruit.length;
    }

    @Override
    public Object getItem(int position) {
        return fruit[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner, null);

        final TextView tv = (TextView)convertView.findViewById(R.id.textView);
        final CheckBox cb = (CheckBox)convertView.findViewById(R.id.checkBox);
        tv.setText(fruit[position]);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg = "선택되었습니다";
                if (!isChecked) msg = "선택되지 않았습니다.";
            }
        });
        return convertView;
    }
}
