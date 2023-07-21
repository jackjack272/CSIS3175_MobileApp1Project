package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.appdevfinalprojct2.Dish.Dish_Get_Ingredients;
import com.example.appdevfinalprojct2.User.User_BasicInfo;
import com.example.appdevfinalprojct2.User.User_getBMI;
import com.example.appdevfinalprojct2.workout.Workout_Bodypart_Exercise_Choice;

public class Landing_Page extends AppCompatActivity {
    private Spinner spinner;
    private Boolean changePage=false;


    private static final String TAG = Landing_Page.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        setNavigation();
    }

    private void setNavigation(){
        //----------------- Navigation need on all pages-------
        spinner = findViewById(R.id.spinner);
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
                        intent= new Intent(Landing_Page.this, Landing_Page.class);
                    }
                    else if(destination.equalsIgnoreCase("User Basic Info")){
                        intent= new Intent(Landing_Page.this, User_BasicInfo.class);
                    }
                    else if(destination.equalsIgnoreCase("BMI Calculator")){
                        intent= new Intent(Landing_Page.this, User_getBMI.class);
                    }else if(destination.equalsIgnoreCase("Workout")){
                        intent= new Intent(Landing_Page.this, Workout_Bodypart_Exercise_Choice.class);
                    }
                    else if(destination.equalsIgnoreCase("Food stuff")){
                        intent= new Intent(Landing_Page.this, Dish_Get_Ingredients.class);
                    }

                    startActivity(intent);
                }
                changePage=true;

            }@Override public void onNothingSelected(AdapterView<?> parent) {}
        });

    }

}