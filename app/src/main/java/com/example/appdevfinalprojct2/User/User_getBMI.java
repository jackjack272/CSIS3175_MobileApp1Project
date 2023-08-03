package com.example.appdevfinalprojct2.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appdevfinalprojct2.Dish.Dish_Get_Ingredients;
import com.example.appdevfinalprojct2.Landing_Page;
import com.example.appdevfinalprojct2.R;
import com.example.appdevfinalprojct2.workout.Workout_Bodypart_Exercise_Choice;

public class User_getBMI extends AppCompatActivity {
    private static final String TAG = User_getBMI.class.getSimpleName();
    private Spinner spinner;
    private Boolean changePage=false;
    private TextView outputField,iWantToLoose , caloryDef;
    private  EditText weeks, lbs;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_get_bmi);

        String age, height, weight, gainWeight, bulk_slim, getBMI, weeklyCalories ;

        // variable definition area

        outputField = findViewById(R.id.textView12);
        iWantToLoose= findViewById(R.id.textView14);
        caloryDef= findViewById(R.id.calory_deficency);
        button= findViewById(R.id.button3);

        weeks=findViewById(R.id.weight_weeks);
        lbs=findViewById(R.id.weight_weight);
        //find the fields

        caloryDef.setVisibility(View.INVISIBLE);


        SharedPreferences sharedPreferences= getSharedPreferences("user_info", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        age=    sharedPreferences.getString("age", "23");
        height= sharedPreferences.getString("height", "6' 1");
        weight= sharedPreferences.getString("lbs", "170.32");
        gainWeight= sharedPreferences.getString("less_weight",String.valueOf(false));
        // i use a method to save the user info as a string i dident want to make a
        // different save method  :)



        int bmi=(int) getBMI(height, weight );
        String outOfRange=getBMIRangeOutcome(bmi);

        getBMI="A "+age+ " year old standing at "+height+ " weighing "
                    +weight+" is considered " +outOfRange +"." +
                "\n BMI:"+bmi;

        if(gainWeight.equalsIgnoreCase("false")){
            bulk_slim="Lets loose some weight "+
                    "according to bmi you should loose: "+getIdealWeight(height, weight) + " lbs";
            // ideal weight.

            if((double) bmi <= 18.5){
                bulk_slim="You need to gain weight. ";
                // record that the user needs to gain weight.
                editor.remove("less_weight");
                editor.apply();

                editor.putString("less_weight","false");
                editor.apply();
            }
        }else{
            bulk_slim="Lets gain some weight!";
        }
        outputField.setText(getBMI);
        iWantToLoose.setText(bulk_slim);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences1 = getSharedPreferences("user_info",
                        Context.MODE_PRIVATE);

                double weeklyCaloriesNeeded=getWeeklyCalory(weeks.getText().toString(), lbs.getText().toString());
                if(weeklyCaloriesNeeded== -1.0){
                    weeklyCaloriesNeeded=0;
                }
                String weeklyCalories= "To meet your goal you' need to eat daily "+ String.valueOf(weeklyCaloriesNeeded );

                String xx=sharedPreferences1.getString("less_weight","false");

                if(sharedPreferences1.getString("less_weight","false")
                        .equalsIgnoreCase("true")){
                    // user want to loose weight.
                    weeklyCalories+=" less calories";
                }else{
                    weeklyCalories+=" more calories";
                }
                weeklyCalories+=". This info is saved and will go to recomending dishes for you :)";

                caloryDef.setText(weeklyCalories);
                caloryDef.setVisibility(View.VISIBLE);

                SharedPreferences.Editor editor= sharedPreferences1.edit();
                editor.putFloat("weekly_cals",(float) weeklyCaloriesNeeded );
                editor.apply();
            }
        });
        setNavigation();
    }

    private void setNavigation(){
        //----------------- Navigation need on all pages-------
        spinner = findViewById(R.id.spinner5);

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
                        intent= new Intent(User_getBMI.this, Landing_Page.class);
                    }
                    else if(destination.equalsIgnoreCase("User Basic Info")){
                        intent= new Intent(User_getBMI.this, User_BasicInfo.class);
                    }
                    else if(destination.equalsIgnoreCase("BMI Calculator")){
                        intent= new Intent(User_getBMI.this, User_getBMI.class);
                    }else if(destination.equalsIgnoreCase("Workout")){
                        intent= new Intent(User_getBMI.this, Workout_Bodypart_Exercise_Choice.class);
                    }
                    else if(destination.equalsIgnoreCase("Food stuff")){
                        intent= new Intent(User_getBMI.this, Dish_Get_Ingredients.class);
                    }
                    startActivity(intent);
                }
                changePage=true;

            }@Override public void onNothingSelected(AdapterView<?> parent) {}
        });

    }
    private double  getWeeklyCalory(String weeks, String lbs){

        try{
    //        5 weeks gain 10lbs thus per week i must gain 5 weeks/10lbs =2lbs per week.
    //        1lbs of fat= 3500 so 2lbs *3500cals = weekly calory intake.
    //        weekly calories/ 7 = daily calories needed

            double _weeks, _lbs;

            _weeks= Integer.parseInt(weeks);
            _lbs=Integer.parseInt(lbs);


            double weekly_lbs=_lbs/_weeks;
            double weekly_calories=weekly_lbs*3500;
            double daily_calories=weekly_calories/7;
            // broke it down incase i want to return some thing else later on

            return daily_calories;
        }catch (Exception e ){
            Log.e(TAG, e.getMessage());
        }

        return -1;
    }

    private double getIdealWeight(String heihgt, String weight){
        //BMI= kg/m^2 -> kg= BMI * m^2;
        try{
            String[] feet_inch= heihgt.split("'");
            double m=0 ;
            double kg=0;
            double ideal_from_lbs=0;

            m+= Integer.parseInt(feet_inch[0]) *30.48;
            m+= Integer.parseInt(feet_inch[1]) *2.54;
            m= m/100;

            kg=  25*Math.pow(m,2)  ;
            ideal_from_lbs= (kg/0.45359237)- Double.parseDouble(weight);

            return ideal_from_lbs;

        }catch (Exception e){
            Log.v(TAG,"user_getBMI line getIdealWeight() line 149");
        }
        return -1;

    }

    private double getBMI(String height, String _weight){
        try{
            String[] feet_inch= height.split("'");
            double feet=0, inches=0, bmi=0, weight=0;
            weight=Double.parseDouble(_weight);
            feet=Integer.valueOf( feet_inch[0]);
            inches= Integer.parseInt(feet_inch[1]);
            inches+=feet*12;

            bmi= weight/ Math.pow(inches,2)*703;
            // lbs/  inches^2 *703

            return bmi;
        }catch (Exception e){
            Log.v(TAG,"user_getBMI line getBMI() line 167");
        }
        return -1;
    }

    private String getBMIRangeOutcome(int x){
        String msg="";


        if(35 <= x | x< 40){
            msg="verry chunky";
        }
        else if(30 <= x | x< 35){
            msg="little chunky";
        }
        else if(25 <= x | x< 30){
            msg="overweight";
        }
        else if(18.5 <= x | x< 25){
            msg="perfect weight ;)";
        }
        else if(16 <= x | x< 18.5){
            msg="underweight";
        }
        else if(15 <= x | x< 16){
            msg="seriously underweight";
        }
        if(x<15){
            msg="super seriously underweight";
        }


        return msg;
    }

}