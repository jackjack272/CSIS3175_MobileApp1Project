package com.example.appdevfinalprojct2.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appdevfinalprojct2.Dish.Dish_Get_Ingredients;
import com.example.appdevfinalprojct2.Landing_Page;
import com.example.appdevfinalprojct2.R;
import com.example.appdevfinalprojct2.User.User_BasicInfo;
import com.example.appdevfinalprojct2.User.User_getBMI;
import com.example.appdevfinalprojct2.workout.WorkoutAdapter_Back;
import com.example.appdevfinalprojct2.workout.WorkoutAdapter_Chest;
import com.example.appdevfinalprojct2.workout.WorkoutAdapter_Core;
import com.example.appdevfinalprojct2.workout.WorkoutAdapter_Legs;

public class Workout_ShowExersises extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Boolean changePage=false;
    private RecyclerView.Adapter adapter;
// recycler view area



    Spinner spinner;
    TextView heading;


//variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_recycler_bodyparts);

        Intent intent= getIntent();
        Bundle bundle= intent.getExtras();

        spinner= findViewById(R.id.spinner2);
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

        setNavigation();
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


    private void setNavigation(){
        //----------------- Navigation need on all pages-------
        spinner = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.navigation, android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // need to reset the selected one by default.

                if(changePage){
                    Intent intent=null;
                    String destination= parent.getSelectedItem().toString();

                    if(destination.equalsIgnoreCase("Landing Page")){
                        intent= new Intent(Workout_ShowExersises.this, Landing_Page.class);
                    }
                    else if(destination.equalsIgnoreCase("User Basic Info")){
                        intent= new Intent(Workout_ShowExersises.this, User_BasicInfo.class);
                    }
                    else if(destination.equalsIgnoreCase("BMI Calculator")){
                        intent= new Intent(Workout_ShowExersises.this, User_getBMI.class);
                    }else if(destination.equalsIgnoreCase("Workout")){
                        intent= new Intent(Workout_ShowExersises.this, Workout_Bodypart_Exercise_Choice.class);
                    }
                    else if(destination.equalsIgnoreCase("Food stuff")){
                        intent= new Intent(Workout_ShowExersises.this, Dish_Get_Ingredients.class);
                    }
                    startActivity(intent);
                }
                changePage=true;

            }@Override public void onNothingSelected(AdapterView<?> parent) {}
        });

    }

}