package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {




    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public void PickNumber(View view) {
        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this,PickNumber.class);
        startActivity(intent);

    }

    public void YesOrNo(View view) {
        Log.d(LOG_TAG,"Click");


        Intent intent = new Intent(this, YesOrNo.class);
        intent.putExtra("mode",22);

        startActivity(intent);
    }

    public void PickOne(View view) {
        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this,PickOne.class);
        startActivity(intent);
    }

    public void Turntable(View view) {
        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this,Turntable.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
