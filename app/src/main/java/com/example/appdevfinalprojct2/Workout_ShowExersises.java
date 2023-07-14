package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Workout_ShowExersises extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_recycler_exercises);


        Intent intent= getIntent();
        textView=findViewById(R.id.workout_creater);
        textView.setText("i worked");

        Bundle bundle= intent.getExtras();
        int selectedBodyPart=bundle.getInt("position");


        // select the adapter based on the the selected item

//        if(position == 0){}

        // i show the muscle groups to workout
        recyclerView=findViewById(R.id.workouts);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter= new WorkoutAdapter_chest_arms();
        recyclerView.setAdapter(adapter);
    }
}