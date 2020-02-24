package com.example.android.FinalProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.FinalProject.R;

public class MainActivity extends AppCompatActivity {


    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void PickNumber(View view) {

        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this, PickNumber.class);
        startActivity(intent);
    }

    public void YesOrNo(View view) {

        Log.d(LOG_TAG,"Click");


        Intent intent = new Intent(this, YesOrNo.class);
        startActivity(intent);
    }

    public void PickOne(View view) {

        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this, PickOne.class);
        startActivity(intent);
    }

    public void Turntable(View view) {

        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this, Turntable.class);
        startActivity(intent);
    }
}
