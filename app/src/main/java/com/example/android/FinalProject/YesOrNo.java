package com.example.android.FinalProject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class YesOrNo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_or_no);
    }

    public void startRandom(View view) {
        TextView display = findViewById(R.id.yon);

        int num = (int) (Math.random()*10)%2;
        if (num == 0){
            display.setText("Yes!");
        } else {
            display.setText(("No!"));
        }
    }
}


