package com.example.toshiba.enlistcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CartlistActivity extends AppCompatActivity {
    private TextView counterTxt;
    private ImageView minusBtn, plusBtn;
    private int counter;

    private View.OnClickListener clikListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cartquantityminus_img :
                    minusCounter();
                    break;
                case R.id.cartquantityplus_img :
                    plusCounter();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartlist);

        counterTxt = (TextView) findViewById(R.id.cartquantity_txt);
        minusBtn = (ImageView) findViewById(R.id.cartquantityminus_img);
        minusBtn.setOnClickListener(clikListener);

        plusBtn = (ImageView) findViewById(R.id.cartquantityplus_img);
        plusBtn.setOnClickListener(clikListener);

        initCounter();
    }
    private void initCounter() {
        counter = 0;
        counterTxt.setText(counter+"");
    }

    private void minusCounter() {
        counter --;
        counterTxt.setText(counter+"");
    }
    private void plusCounter() {
        counter ++;
        counterTxt.setText(counter+"");
    }
}
