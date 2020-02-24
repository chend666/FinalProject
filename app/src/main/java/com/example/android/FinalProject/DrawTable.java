package com.example.android.FinalProject;


import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DrawTable extends AppCompatActivity {



    int view = R.layout.activity_draw_table;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    TextView text;


    Button bb;
    // ImageView arrow;
    PieChartView image;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int randomColor(){

        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        return Color.rgb(r,g,b);
    }

    public int randomRound(){

        Random rand = new Random();
        return rand.nextInt((10 - 5) + 1) + 5;
    }

    public int randomPos(){

        Random rand = new Random();
        return rand.nextInt(360 + 1);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public PieChartView createTurntable(ArrayList<String> aa){
        PieChartView pieChartView = findViewById(R.id.chart);
        List<SliceValue> pieData = new ArrayList<>();

        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();


        for(int i = 0;i<aa.size();i++){

            pieData.add(new SliceValue(1, randomColor()).setLabel(aa.get(i)));
        }
        

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartView.setRotation(45);
        pieChartView.setPieChartData(pieChartData);

        return pieChartView;

    }






    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_table);

        int value = getIntent().getIntExtra("value",0);


        if(value == 1){
            ArrayList<String> aa = new ArrayList<String>();
            aa.add("apple");
            aa.add("banana");
            aa.add("peach");
            aa.add("cherry");
            aa.add("melon");
            aa.add("pineapple");
            aa.add("kiwi");

            image = createTurntable(aa);

        }else if(value == 2){

            ArrayList<String> aa = new ArrayList<String>();
            aa.add("apple");
            aa.add("banana");
            aa.add("peach");
            aa.add("cherry");
            aa.add("melon");
            aa.add("pineapple");
            aa.add("kiwi");

            image = createTurntable(aa);



        }else{

            ArrayList<String> aa = getIntent().getStringArrayListExtra("num");
            Log.d(LOG_TAG,Integer.toString(aa.size()));


                image = createTurntable(aa);





        }

        text = findViewById(R.id.button);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation rotate = new RotateAnimation(0, randomRound()*360+randomPos(), Animation.RELATIVE_TO_SELF, 0.5f,          Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(5000);
                rotate.setInterpolator(new AccelerateDecelerateInterpolator());
                rotate.setFillAfter(true);

                image.startAnimation(rotate);
            }
        });




    }

    public void Turntable(View view) {

        Log.d(LOG_TAG,"Click");

        Intent intent = new Intent(this,Turntable.class);
        startActivity(intent);
    }
}
