package com.example.android.FinalProject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class YesOrNo extends AppCompatActivity {

    private ShakeHelper mShakeHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_or_no);
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

    private void shakeHandler() {
        TextView display = findViewById(R.id.yon);

        int num = (int) (Math.random()*10)%2;
        if (num == 0){
            display.setText("Yes!");
        } else {
            display.setText(("No!"));
        }
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


