package com.example.android.FinalProject;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class PickOne extends AppCompatActivity {

    public TextView amountOfPpl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MultiTouch(this));
    }
}
