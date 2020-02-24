package com.example.android.FinalProject;

/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Application;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class newTurn extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private WordViewModel mWordViewModel;

    int v = 0;



    public Context getContext(){
        return this;
    }



    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);





        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);


        final Intent intent = new Intent(this, SavedTable.class);
        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.

                List<Word> current = new ArrayList<>();

                for(int i = 0;i<words.size();i++){

                        current.add(words.get(i));


                        if(words.get(i).getWord().equals("mark")){
                            v = current.get(i).getValue();
                        }


                }


                List<Word> current1 = new ArrayList<>();
                for (int i = 0;i<current.size();i++){
                    if(current.get(i).getValue() == v && !current.get(i).getWord().equals("mark")){


                        current1.add(current.get(i));
                    }
                }



                int total = words.size();

                adapter.setWords(current1);


                if(getIntent().getIntExtra("mode",0) != 0){
                    Log.d(LOG_TAG,"Yes");

                    List<Word> b = adapter.getItem();


                    ArrayList<String> aa = new ArrayList<String>();

                    for(int i = 0;i<b.size();i++){

                        if(b.get(i).getValue() == 2){

                            aa.add(b.get(i).getWord());

                        }

                    }


                    ArrayList<String> label = new ArrayList<String>();
                    ArrayList<Integer> lnum = new ArrayList<Integer>();
                    for(int i = 0;i<words.size();i++){
                        label.add(words.get(i).getWord());
                        lnum.add(words.get(i).getValue());

                    }

                    intent.putStringArrayListExtra("label",label);
                    intent.putIntegerArrayListExtra("lnum",lnum);
                    intent.putStringArrayListExtra("list",aa);
                    intent.putExtra("total",total);
                    startActivity(intent);
                    finish();
                }


            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(newTurn.this, NewWordActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {


            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY),v);
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void DrawTable(View view) {




        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });

        int a = adapter.getItemCount();

        List<Word> b = adapter.getItem();



        Log.d(LOG_TAG,"number of mark");

        for(int i = 0;i<b.size();i++){

            if(b.get(i).getWord().equals("mark")){
                v = b.get(i).getValue();
            }
        }


        ArrayList<String> aa = new ArrayList<String>();

        for(int i = 0;i<b.size();i++){


            if(b.get(i).getValue() == v && !b.get(i).getWord().equals("mark")) {

                aa.add(b.get(i).getWord());
            }



        }


        if(aa.size() == 0){
            Toast.makeText(
                    this, R.string.warnM,
                    Toast.LENGTH_LONG).show();
        }else {


            Log.d(LOG_TAG, "Finish Create one table");
            Intent intent = new Intent(this, DrawTable.class);
            intent.putStringArrayListExtra("num", aa);
            startActivity(intent);
        }
    }
}
