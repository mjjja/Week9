package com.example.kmj.week8;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by KMJ on 2017-04-27.
 */

public class GridItem extends LinearLayout {
    TextView tv1, tv2;
    ImageView img;

    public GridItem(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.gridview, this);

        tv1 = (TextView)findViewById(R.id.tvname);
        tv2 = (TextView)findViewById(R.id.tvprice);
        img = (ImageView)findViewById(R.id.image1);
    }

    public void setData(Fruit one) {
        tv1.setText(one.name);
        tv2.setText(one.price + "원");
        img.setImageResource(Fruit.imagelist[one.imgno]);
    }

    public void hideprice(){
        tv2.setVisibility(GONE);
    }

    public void showprice(){
        tv2.setVisibility(VISIBLE);
    }
}