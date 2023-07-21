package com.example.appdevfinalprojct2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.appdevfinalprojct2.Dish.Dish_Get_Ingredients;
import com.example.appdevfinalprojct2.Landing_Page;
import com.example.appdevfinalprojct2.R;
import com.example.appdevfinalprojct2.workout.Workout_Bodypart_Exercise_Choice;

public class User_BasicInfo extends AppCompatActivity {

    private static final String TAG= User_BasicInfo.class.getSimpleName();
    private Spinner spinner ;
    private Boolean changePage=false;
    //Navigation


    private Switch weightChoice;
    private EditText age, height, lbs,  weight_convert_imperial, height_convert_imperial,
        weight_destination, height_destination;

    private TextView this_page_autosaves;
    private Button button;
    // this page's content


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_basicinfo);

        //finders
        age=findViewById(R.id.age);
        height= findViewById(R.id.height_in_feet);
        lbs=findViewById(R.id.weight);
        weightChoice= findViewById(R.id.switch1);

        weight_convert_imperial=findViewById(R.id.imperial_weight);
        height_convert_imperial=findViewById(R.id.imperial_heihgt);
        weight_destination=findViewById(R.id.metric_weight);
        height_destination=findViewById(R.id.metric_heihgt);
        this_page_autosaves=findViewById(R.id.textView13);
        button=findViewById(R.id.logout);

        //log out
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(User_BasicInfo.this, User_Registration_login.class);
                startActivity(intent);
            }
        });

        //Converter
        weight_convert_imperial.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String imperial_weight=weight_convert_imperial.getText().toString();
                if( imperial_weight.isEmpty() || imperial_weight.equalsIgnoreCase(" ")) {
                    return false;
                }

                try{ // 190 lbs is 86.18 kg
                    // parse the weight
                    Double lbs=Double.parseDouble(imperial_weight);
                    convertWeight(lbs);

                    //display in the container
                    weight_destination.setText(String.format("%.2f kg", (convertWeight(lbs)) ));
                }catch (Exception e){
                    weight_destination.setText("invalid input");
                }
                return false;
            }
        });
        height_convert_imperial.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                try{ // 6'1 is 185.42cm
                    // get the heihgt
                    String height_compoenents= height_convert_imperial.getText().toString();

                    // split the height into its components
                    String[] height_ft_in=height_compoenents.split("'");

                    // what is 6' into centemeters
                    double cm_feet= Double.parseDouble(height_ft_in[0])*30.48;
                    // what is 1" into centemeters?
                    double cm_inch=Double.parseDouble(height_ft_in[1])*2.54;

                    //  display in the text box
                    height_destination.setText(String.valueOf(cm_feet+cm_inch)+"cm");

                }catch (Exception e){
                    height_destination.setText("invalid input");
                }

                return false;
            }
        });

        // load values from memory into the fields.
        getUserInfo();

        // event listenders to make the app auto save
        age.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // check for empty
                // check that is a valid number
                // save the valid number
                // this page just saved your "age : "+new age+ " !"

                try{

                    String _age= age.getText().toString();
                    int int_age= Integer.parseInt(_age); // to check if its valid number
                    Log.e(TAG, String.valueOf(int_age));
                    // save the age.
                    saveNewItem("age", String.valueOf(int_age));
                    changeThisPageAutoSaves( String.valueOf(int_age));
                }catch (Exception e ){
                    age.setHint("The age previously entered was invalid");
                }
                return false;
            }
        });
        height.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // get the field
                // break into 6 and 1
                // check both if valid  <= 12 each
                // save and display
                try{

                    String _height= height.getText().toString();
                    String[] height_compoenents= _height.split("'");
                //get input

                    int feet=Integer.parseInt(height_compoenents[0]);
                    int inches=Integer.parseInt(height_compoenents[1]);
                    if( feet >12 | inches > 12){
                        throw new Exception();
                    }
                //validate input

                    saveNewItem("height",_height);
                    changeThisPageAutoSaves(_height);
                //save and display
                }catch (Exception e){
                    height.setHint("Invalid input, mind the formatting! 6' 1");
                }
                return false;
            }
        });
        lbs.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // check for empty
                // check that is a valid number
                // save the valid number
                // this page just saved your "age : "+new age+ " !"

                try{

                    String _age= lbs.getText().toString();
                    int int_age= Integer.parseInt(_age); // to check if its valid number
                    // save the age.
                    saveNewItem("lbs", String.valueOf(int_age));
                    changeThisPageAutoSaves( String.valueOf(int_age));

                }catch (Exception e ){
                    lbs.setHint("The age previously entered was invalid");
                }
                return false;
            }
        });
        weightChoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){ // not "put on weight"
                    changeThisPageAutoSaves("less weight");
                    saveNewItem("less_weight",String.valueOf(isChecked) );
                }else{
                    changeThisPageAutoSaves("more weight");
                    saveNewItem("less_weight",String.valueOf(isChecked) );
                }
            }
        });
        // incase the button isent check i can save something
        if(weightChoice.isChecked()== false){
            changeThisPageAutoSaves("more weight");
            saveNewItem("less_weight",String.valueOf(false) );
        }



        setNavigation();

    }
    public void setNavigation(){
//        setNavigation();

        //----------------- Navigation need on all pages-------
        spinner = findViewById(R.id.nav_user_basicInfo);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.navigation, android.R.layout.simple_spinner_dropdown_item );
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(changePage){
                    Intent intent=null;
                    String destination= parent.getSelectedItem().toString();

                    if(destination.equalsIgnoreCase("Landing Page")){
                        intent= new Intent(User_BasicInfo.this, Landing_Page.class);
                    }
                    else if(destination.equalsIgnoreCase("User Basic Info")){
                        intent= new Intent(User_BasicInfo.this, User_BasicInfo.class);
                    }
                    else if(destination.equalsIgnoreCase("BMI Calculator")){
                        intent= new Intent(User_BasicInfo.this, User_getBMI.class);

                    }else if(destination.equalsIgnoreCase("Workout")){
                        intent= new Intent(User_BasicInfo.this, Workout_Bodypart_Exercise_Choice.class);
                    }
                    else if(destination.equalsIgnoreCase("Food stuff")){
                        intent= new Intent(User_BasicInfo.this, Dish_Get_Ingredients.class);
                    }
                    startActivity(intent);
                }
                changePage=true;
            }@Override public void onNothingSelected(AdapterView<?> parent) {}
        });


    }

    private void getUserInfo(){
        // this method will set the field with the content saved into memory
            // for when the page is reloaded.

        SharedPreferences sharedPreferences= getSharedPreferences("user_info",Context.MODE_PRIVATE);

        age.setText(
                sharedPreferences.getString("age","23")
        );

        height.setText(
                sharedPreferences.getString("height", "6' 1")
        );

        lbs.setText(
                sharedPreferences.getString("lbs", "170")
        );

    }

    private void saveNewItem(String key, String value){
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString(key,value);
        editor.apply();
//        Log.e(TAG, "******************");
//        Log.e(TAG, "USER INFO: saved "+value+" into key "+key+"user_info shared pref");

    }

    private void changeThisPageAutoSaves(String saved_value){
        this_page_autosaves.setText(" click enter \nThis page just saved: "+saved_value);
    }

    private double convertWeight(double lbs){
        return lbs / 2.205;
    }
}