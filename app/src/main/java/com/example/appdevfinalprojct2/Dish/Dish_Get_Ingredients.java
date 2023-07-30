package com.example.appdevfinalprojct2.Dish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appdevfinalprojct2.Landing_Page;
import com.example.appdevfinalprojct2.R;
import com.example.appdevfinalprojct2.User.User_BasicInfo;
import com.example.appdevfinalprojct2.User.User_getBMI;
import com.example.appdevfinalprojct2.workout.Workout_Bodypart_Exercise_Choice;

public class Dish_Get_Ingredients extends AppCompatActivity {
//
//    RecyclerView recyclerView;
//    RecyclerView.LayoutManager layoutManager;
//    private RequestQueue requestQueue;
//
//    private ArrayList<Dish> dishArrayList;
//    // api call components


    /// Pretains to the view

    private static String TAG = Dish_Get_Ingredients.class.getSimpleName();

    private Spinner spinner;
    private Boolean changePage=false;

    TextView yummy;
    private Button button;
    private EditText foodRestriction, foodCountryStyle, ing1, ing2, ing3, ing4;
    //ingredient

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_recipies);

        foodRestriction = findViewById(R.id.editTextTextPersonName3);
        foodCountryStyle = findViewById(R.id.editTextTextPersonName4);
        ing1 = findViewById(R.id.ingredient1);
        ing2 = findViewById(R.id.ingredient2);
        ing3 = findViewById(R.id.ingredient3);
        ing4 = findViewById(R.id.ingredient4);
        button= findViewById(R.id.chef_it_up);
        yummy= findViewById(R.id.textView11);

//        autoSetTheValuesForDev(); //lil helper util :)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //validate that there are no empty
                if(foodRestriction.getText().toString().isEmpty()){
                    foodRestriction.setHint("Cant be Empty ");
                    return;
                }
                else if (foodCountryStyle.getText().toString().isEmpty()){
                    foodCountryStyle.setHint("Cant be Empty ");
                    return;

                }else if (ing1.getText().toString().isEmpty()){
                    ing1.setHint("Cant be Empty ");
                    return;

                }else if (ing2.getText().toString().isEmpty() ){
                    ing2.setHint("Cant be Empty ");
                    return;

                }else if (ing3.getText().toString().isEmpty() ){
                    ing3.setHint("Cant be Empty ");
                    return;

                }else if (ing4.getText().toString().isEmpty()){
                    ing4.setHint("Cant be Empty ");
                    return;
                }

                Bundle bundle = new Bundle();
                bundle.putString("restriction", foodRestriction.getText().toString());
                bundle.putString("culture", foodCountryStyle.getText().toString());
                bundle.putString("ing1", ing1.getText().toString());
                bundle.putString("ing2", ing2.getText().toString());
                bundle.putString("ing3", ing3.getText().toString());
                bundle.putString("ing4", ing4.getText().toString());


                Intent intent = new Intent(Dish_Get_Ingredients.this, Dish_RecipeeDisplay.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        setNavigation();
    }

    private void setNavigation(){
        //----------------- Navigation need on all pages-------
        spinner = findViewById(R.id.spinner4);

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
                        intent= new Intent(Dish_Get_Ingredients.this, Landing_Page.class);
                    }
                    else if(destination.equalsIgnoreCase("User Basic Info")){
                        intent= new Intent(Dish_Get_Ingredients.this, User_BasicInfo.class);
                    }
                    else if(destination.equalsIgnoreCase("BMI Calculator")){
                        intent= new Intent(Dish_Get_Ingredients.this, User_getBMI.class);
                    }else if(destination.equalsIgnoreCase("Workout")){
                        intent= new Intent(Dish_Get_Ingredients.this, Workout_Bodypart_Exercise_Choice.class);
                    }
                    else if(destination.equalsIgnoreCase("Food stuff")){
                        intent= new Intent(Dish_Get_Ingredients.this, Dish_Get_Ingredients.class);
                    }
                    startActivity(intent);
                }
                changePage=true;

            }@Override public void onNothingSelected(AdapterView<?> parent) {}
        });

    }

    public void autoSetTheValuesForDev(){
        foodRestriction.setText("vegetarian");
        foodCountryStyle.setText("Mexcian");
        ing1.setText("Cellery");
        ing2.setText("Noodles");
        ing3.setText("Butter");
        ing4.setText("noodles");
    }

}