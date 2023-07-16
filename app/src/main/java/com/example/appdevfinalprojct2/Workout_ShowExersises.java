package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class Workout_ShowExersises extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
// recycler view area



    Spinner navigation;
    TextView heading;


//variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_recycler_bodyparts);

        Intent intent= getIntent();
        Bundle bundle= intent.getExtras();

        navigation= findViewById(R.id.spinner2);
        heading= findViewById(R.id.weight_goals);


        int position=0;
//        //variable ini area

        position= bundle.getInt("position");
        String position_heading=getBodyPartSelected(position); // i set the GLOBAL VAR: adapter
        heading.setText(String.valueOf( position_heading));





        recyclerView=findViewById(R.id.recycler_workout);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    private String getBodyPartSelected(Integer position){
        String choice ="";
        if(position == 1){
            //chest and arms
            adapter= new WorkoutAdapter_Chest();
            choice="Chest is the best";
        }
        else if(position ==2){
            //back and tries
            adapter= new WorkoutAdapter_Back();
            choice="back is the best";

        }
        else if(position ==3){
            //core
            adapter= new WorkoutAdapter_Core();
            choice="core is the best";

        }
        else if(position ==4){
//            legs
            adapter= new WorkoutAdapter_Legs();
            choice="legs is the best";

        }

        return choice;
    }

}