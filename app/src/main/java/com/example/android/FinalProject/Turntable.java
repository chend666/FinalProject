package com.example.android.FinalProject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Turntable extends AppCompatActivity {


    private static final String LOG_TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turntable);

    }



    public void createTable(View view) {
        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this,newTurn.class);
        startActivity(intent);
    }

    public void DrawTable(View view) {

        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this,DrawTable.class);
        intent.putExtra("value",1);
        startActivity(intent);
    }

    public void SavedTable(View view) {

        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this,newTurn.class);
        intent.putExtra("mode",22);
        startActivity(intent);
    }
}
