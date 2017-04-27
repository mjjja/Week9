package com.example.kmj.week8;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by KMJ on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener {
    int imageno = 0;
    int pos;
    int price;
    Context context;
    AutoCompleteTextView actv;
    ImageView img;
    Button b_next, b_add;
    EditText et;
    boolean isClick = false;

    public AddFruit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        this.context = context;
    }

    void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.fruit_add, this);
        actv = (AutoCompleteTextView) findViewById(R.id.f_name);
        img = (ImageView) findViewById(R.id.image1);
        b_next = (Button) findViewById(R.id.b_next);
        b_add = (Button) findViewById(R.id.b_add);
        b_next.setOnClickListener(this);
        b_add.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == b_add) {
            View view = View.inflate(context, R.layout.dialog, null);
            et = (EditText) view.findViewById(R.id.pricetext);
            AlertDialog.Builder dlg = new AlertDialog.Builder(context);
            dlg.setNegativeButton("취소", null);
            dlg.setPositiveButton("확인",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int price = Integer.parseInt(et.getText().toString());
                            if (isClick)
                                onAddListener.onModify(actv.getText().toString(), imageno, price, pos);
                            onAddListener.onAdd(actv.getText().toString(), imageno, price);
                        }
                    });
            dlg.setView(view);
            dlg.show();
        } else {
            imageno = (imageno + 1) % 8;
            img.setImageResource(Fruit.imagelist[imageno]);
        }
    }

    interface OnAddListener {
        void onAdd(String name, int imageno, int price);
        void onModify(String name, int imageno, int price, int position);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener) {
        this.onAddListener = onAddListener;
    }

    public void setClick(int pos) {
        isClick = true;
        this.pos = pos;
        b_add.setText("M");
    }
}