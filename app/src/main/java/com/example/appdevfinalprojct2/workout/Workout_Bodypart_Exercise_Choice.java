package com.example.appdevfinalprojct2.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.appdevfinalprojct2.workout.WorkoutAdapter_bulk;

public class Workout_Bodypart_Exercise_Choice extends AppCompatActivity {



    private Spinner spinner;
    private Boolean changePage=false;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private TextView motivation;


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


        setNavigation();
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
                        intent= new Intent(Workout_Bodypart_Exercise_Choice.this, Landing_Page.class);
                    }
                    else if(destination.equalsIgnoreCase("User Basic Info")){
                        intent= new Intent(Workout_Bodypart_Exercise_Choice.this, User_BasicInfo.class);
                    }
                    else if(destination.equalsIgnoreCase("BMI Calculator")){
                        intent= new Intent(Workout_Bodypart_Exercise_Choice.this, User_getBMI.class);
                    }else if(destination.equalsIgnoreCase("Workout")){
                        intent= new Intent(Workout_Bodypart_Exercise_Choice.this, Workout_Bodypart_Exercise_Choice.class);
                    }
                    else if(destination.equalsIgnoreCase("Food stuff")){
                        intent= new Intent(Workout_Bodypart_Exercise_Choice.this, Dish_Get_Ingredients.class);
                    }
                    startActivity(intent);
                }
                changePage=true;

            }@Override public void onNothingSelected(AdapterView<?> parent) {}
        });

    }

}