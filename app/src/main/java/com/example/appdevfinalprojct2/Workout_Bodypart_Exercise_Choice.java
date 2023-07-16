package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Workout_Bodypart_Exercise_Choice extends AppCompatActivity {



    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    TextView motivation;


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_recycler_bodyparts);


        // i display the cycler view with the body parts.

        motivation= findViewById(R.id.weight_goals);
        SharedPreferences sharedPreferences= getSharedPreferences("user_info", Context.MODE_PRIVATE);

// variable initalisation area

        String loose_weight=sharedPreferences.getString("less_weight", "error: no data pulled out");
        String msg="";
        if(loose_weight.equalsIgnoreCase("true")){
            msg="LETS GET THEM GAAAAAAINS!!!";
//            adapter= new WorkoutAdapter_bulk();
        }
        // ----------BULK ADAPTER
        else{
            msg="BET! LETS GET SHREEEEEDED!";
//            adapter= new WorkoutAdapter_slim();
            // this might be too much contnetnt o have to fill in so maybe come back


        }
        // ----------SLIM ADAPTER
        motivation.setText(msg);

        // i show the muscle groups to workout
        recyclerView=findViewById(R.id.recycler_workout);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter= new WorkoutAdapter_bulk();
        recyclerView.setAdapter(adapter);

    }
}