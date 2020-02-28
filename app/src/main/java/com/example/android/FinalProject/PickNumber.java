package com.example.android.FinalProject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class PickNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_number);
    }

    public void randomNumber(View view) {
        TextView number = findViewById(R.id.number);
        TextView from = findViewById(R.id.from);
        TextView to = findViewById(R.id.to);

        int fromnum = Integer.parseInt(from.getText().toString());
        int tonum = Integer.parseInt(to.getText().toString());

        int num = new Random().nextInt((tonum - fromnum) + 1) + fromnum;

        Log.d("number", String.valueOf(num));

        number.setText(String.valueOf(num));

    }

    

}
