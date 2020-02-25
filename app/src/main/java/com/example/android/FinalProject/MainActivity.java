package com.example.android.FinalProject;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements PickOneDialog.PickOneDialogListener {

    private Button pickOneButton;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static int amountPpl;



    public void applyTexts(int peopleAmount) {
        amountPpl = peopleAmount;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pickOneButton = (Button) findViewById(R.id.button3);

        pickOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                openPickOneDialog();

            }
        });
        }

    public void openPickOneDialog(){
        PickOneDialog pickOneDialog = new PickOneDialog();
        pickOneDialog.show(getSupportFragmentManager(), "Pick One Dialog");
    }

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

//    public void PickOne(View view) {
//
//        Log.d(LOG_TAG,"Click");
//
//        Intent intent = new Intent(this, PickOne.class);
//        startActivity(intent);
//    }

    public void Turntable(View view) {

        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this, Turntable.class);
        startActivity(intent);
    }
}
