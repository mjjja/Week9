package com.example.kmj.week8;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by KMJ on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter {
    Boolean ischecked=false;
    ArrayList<Fruit> fruit;
    Context context;

    public GridAdapter(ArrayList<Fruit> fruit, Context context) {
        this.fruit = fruit;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fruit.size();
    }

    @Override
    public Object getItem(int position) {
        return fruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = new GridItem(context);
        ((GridItem) convertView).setData(fruit.get(position));
        if (ischecked){
            ((GridItem) convertView).showprice();
        }else{
            ((GridItem) convertView).hideprice();
        }
        return convertView;
    }

    public void refresh() {
        notifyDataSetChanged();
    }

    public void addFruit(Fruit one) {
        fruit.add(one);
    }

    public void modifyFruit(String name, int imageno, int price, int position) {
        Fruit modify = fruit.get(position);
        modify.setName(name);
        modify.setImgno(imageno);
        modify.setPrice(price);
    }
}