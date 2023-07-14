package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class User_Registration_login extends AppCompatActivity {
    private static final String TAG= User_Registration_login.class.getSimpleName();


    Switch register_login_switch;
    EditText email, password, name;
    Button button;
    TextView enter_your_name, error_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration_login);

        register_login_switch= findViewById(R.id.register);
        email= findViewById(R.id.email);

        password=findViewById(R.id.password);
        name= findViewById(R.id.name);

        button= findViewById(R.id.btn_register);
        enter_your_name= findViewById(R.id.name_txt_view);

        error_box= findViewById(R.id.errors);
            error_box.setVisibility(View.INVISIBLE);

        // when we load the app the toggle is set to register
        register_login_switch.setChecked(false);
            // handle the changes to display
        register_login_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if ( isChecked){
                    name.setVisibility(View.GONE);
                    enter_your_name.setVisibility(View.GONE);
                    button.setText("Log In");
                }else{
                    name.setVisibility(View.VISIBLE);
                    enter_your_name.setVisibility(View.VISIBLE);
                    button.setText("Register");
                }
            }
        });

        // button click

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // see if they are logging in or registering....
                    // logining in need to get the info and see if credentials match


                    //registrations is below

                // validate for empty/null values in the fields.
                String _email, _password, _name, err_msg="";
                Boolean logging_in=button.getText().toString().equalsIgnoreCase("log in");

                _email=email.getText().toString();
                _password=password.getText().toString();
                _name= name.getText().toString();

                if(!_email.contains("@")){
                    if(_email == "" | _email ==null  | _email.isEmpty() ){
                        err_msg+=" | Email cant be empty ";
                    }else{
                        err_msg+="Email needs to have @";
                    }
                }

                if(_password == "" | _password ==null | _password.isEmpty()){
                    if(logging_in){
                        err_msg+= " | Password cant be empty";

                    }else if ( _password.equalsIgnoreCase("qwerty") || _password.length() <= 5 ){
                        err_msg+= " | Password is easy to hack";
                    }else{
                        err_msg+= " | Password cant be empty";
                    }

                }

                        // if the user is logging in they dont need to provide a name.
                if (! logging_in) {
                    if(_name =="" || _name ==null  | _name.isEmpty() ){
                        if (_name.length() <5 ) {
                            err_msg +=" | Name is too short ";
                        }else{
                            err_msg +=" | Name cant be empty ";
                        }
                    }
                }

                // display error messages and return else
                if (err_msg != ""){
                    error_box.setVisibility(View.VISIBLE);
                    error_box.setText(err_msg);
                    return;
                }else{
                    error_box.setText("Awsome corrections :)");
                }

                // save the values in shared preferences.
                SharedPreferences sharedPreferences= getSharedPreferences("user_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();

                editor.putString("user_email", _email);
                editor.putString("user_password",_password);
                editor.putString("user_name", _name);
                editor.apply();

                // send to landing page.
                Intent intent= new Intent(User_Registration_login.this, Landing_Page.class);
                startActivity(intent);
            }
        });




    }
}