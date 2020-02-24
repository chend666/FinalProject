package com.example.android.FinalProject;

<<<<<<< Updated upstream:app/src/main/java/com/example/finalproject/MainActivity.java
=======
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
>>>>>>> Stashed changes:app/src/main/java/com/example/android/FinalProject/MainActivity.java
import android.os.Bundle;

import com.example.android.FinalProject.R;

public class MainActivity extends AppCompatActivity {

<<<<<<< Updated upstream:app/src/main/java/com/example/finalproject/MainActivity.java
=======

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

>>>>>>> Stashed changes:app/src/main/java/com/example/android/FinalProject/MainActivity.java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
<<<<<<< Updated upstream:app/src/main/java/com/example/finalproject/MainActivity.java
=======


    public void PickNumber(View view) {

        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this, PickNumber.class);
        startActivity(intent);
    }

    public void YesOrNo(View view) {

        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this, newTurn.class);
        intent.putExtra("mode",22);
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
>>>>>>> Stashed changes:app/src/main/java/com/example/android/FinalProject/MainActivity.java
}
