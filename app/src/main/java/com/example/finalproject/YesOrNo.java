package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class YesOrNo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_or_no);
    }

    public void clicked(){
        int rand = (int) Math.random();
        rand = (rand*10)%2;
        if(rand == 0) {

        } else {

        }
    }

    
}
