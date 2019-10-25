package com.example.borgerkong;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

public class BigKing extends AppCompatActivity {

    private TextView mViewTitle;
    private TextView pViewTitle;
    private TextView sViewTitle;

    private Food mInitialFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_king);
        mViewTitle = findViewById(R.id.textView);
        pViewTitle = findViewById(R.id.textView3);
        sViewTitle = findViewById(R.id.textView5);

        if(getIntent().hasExtra("selected_item")) {
            mInitialFood = getIntent().getParcelableExtra("selected_item");

        }
        setFoodProperties();


    }

//    private void getIncomingIntent(){
//        getIntent().hasExtra("selected_item"))
//    }

    private void setFoodProperties() {
        mViewTitle.setText(mInitialFood.getName());
        pViewTitle.setText(mInitialFood.getPrice());
        sViewTitle.setText(mInitialFood.getDesc());

    }
        private void setNewFoodProperties() {
            mViewTitle.setText("Food Title");
            pViewTitle.setText("Price");
            sViewTitle.setText("Description");

        }

    public void viewOrder(View view){
        Intent intent = new Intent (this, ViewOrder.class);
        startActivity(intent);
    }



}



