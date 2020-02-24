package com.example.android.FinalProject;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
//import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SavedTable extends AppCompatActivity {

    String roomName;
    EditText etAddARoom;
    LinearLayout layout;
    LinearLayout.LayoutParams layoutParam;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup.LayoutParams params =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

        //create a layout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);


        ArrayList<Integer> lnum = new ArrayList<Integer>();
        lnum = getIntent().getIntegerArrayListExtra("lnum");

        ArrayList<String> label = new ArrayList<String>();
        label = getIntent().getStringArrayListExtra("label");


        int pos = 0;
        for(int i = 0;i<label.size();i++){
            if(label.get(i).equals("mark")){
                pos = lnum.get(i);
            }
        }

        Button tt[] = new Button[pos];
        ArrayList<Integer> count = new ArrayList<Integer>();

        int a = 0;


        for(int i = 0;i<pos;i++){
            for (int j = 0;j<lnum.size();j++){
                if(lnum.get(j) == i){
                  a++;
                  count.add(i);
                  break;
                }
            }
        }

        Log.d(LOG_TAG,"table num: " + a);


        for(int i = 0;i<a;i++){

            tt[i] = new Button(this);
            tt[i].setText("Table " + (i+1));
            tt[i].setLayoutParams(params);
            tt[i].setId(i);
            layout.addView(tt[i]);
        }


        LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        setContentView(layout,layoutParam);



        // ArrayList<String> temp = new ArrayList<String>();

        for(int i = 0;i<pos;i++){
            ArrayList<String> temp = new ArrayList<String>();
            for (int j = 0;j<lnum.size();j++){
                if(lnum.get(j) == i){


                    temp.add(label.get(j));
                }else{

                    if(temp.size()>0){

                    }
                }



            }
        }


        final Intent intent = new Intent(this,DrawTable.class);
        final int n = pos;
        final ArrayList<Integer> ln = lnum;
        final ArrayList<String> l = label;
        final ArrayList<Integer> p = count;

        for(int i = 0;i<a;i++){

            final int id = tt[i].getId();

            tt[i] = findViewById(tt[i].getId());

            tt[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {


                    ArrayList<String> aa = getIntent().getStringArrayListExtra("label");
                    ArrayList<String> temp = new ArrayList<String>();


                        for (int j = 0;j<ln.size();j++){
                            if(ln.get(j) == p.get(id)){
                                temp.add(l.get(j));
                            }
                        }


                    intent.putExtra("num",temp);
                    startActivity(intent);
                }
            });

        }



    }
}
