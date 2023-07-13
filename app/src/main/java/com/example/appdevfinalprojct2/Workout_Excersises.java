package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class Workout_Excersises extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_recycler);


        recyclerView=findViewById(R.id.recycler_workout);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter= new Workout_Recycler_Adapater();
        recyclerView.setAdapter(adapter);

    }
}