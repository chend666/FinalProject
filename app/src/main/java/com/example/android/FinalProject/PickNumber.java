package com.example.android.FinalProject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class PickNumber extends AppCompatActivity {

    private ShakeHelper mShakeHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_number);
        mShakeHelper = new ShakeHelper(this);
        mShakeHelper.setOnShakeListener(new ShakeHelper.OnShakeListener() {
            @Override
            public void onShake() {
                shakeHandler();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mShakeHelper.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mShakeHelper.onPause( );
    }

    public void randomNumber(View view) {

        TextView number = findViewById(R.id.number);
        TextView from = findViewById(R.id.from);
        TextView to = findViewById(R.id.to);

        int fromnum = Integer.parseInt(from.getText().toString());
        int tonum = Integer.parseInt(to.getText().toString());

        int num = new Random().nextInt((tonum - fromnum) + 1) + fromnum;

        number.setText(String.valueOf(num));

    }

    public void shakeHandler(){
        TextView number = findViewById(R.id.number);
        TextView from = findViewById(R.id.from);
        TextView to = findViewById(R.id.to);

        int fromnum = Integer.parseInt(from.getText().toString());
        int tonum = Integer.parseInt(to.getText().toString());

        int num = new Random().nextInt((tonum - fromnum) + 1) + fromnum;

        number.setText(String.valueOf(num));
    }



}
