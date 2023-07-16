package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;

import java.util.ArrayList;

public class Dish_RecipeeDisplay extends AppCompatActivity {
    private static String TAG = Dish_RecipeeDisplay.class.getSimpleName();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private RequestQueue requestQueue;
    private ArrayList<Dish> dishArrayList;
    // api call components


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipee_destination);


        // call from the bundle and pass it to the string in the get Recipe

        Intent intent= getIntent();
        Bundle bundle= intent.getExtras();
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);

        String restriction, culture, ing1, ing2, ing3, ing4;
        Float weeklyCals;
    //-------------initalisation area


        restriction= bundle.getString("restriction","vegetarian");
        culture=bundle.getString("culture","american");
        ing1=bundle.getString("ing1","Carrot");
        ing2=bundle.getString("ing2","Celery");
        ing3=bundle.getString("ing3","Noodle");
        ing4=bundle.getString("ing4","Butter");
        weeklyCals=sharedPreferences.getFloat("weekly_cals",500);

        // see what happens if the values sent in are null/ ""


        getRecipee( culture, restriction, 6,weeklyCals,
                1500,ing1,ing2, ing3, ing4 );





        
        
        
        

    // the recycler view area 
        // on click send to another page with intent and do api call and display on that page.
        recyclerView = findViewById(R.id.recipee_destination);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        requestQueue = VollySingolton.getInstance(this).getRequestQueue();
        dishArrayList = new ArrayList<>();
    }

    private void getRecipee( //) {
                String cusineStyle, String diet, int numDishes,float minCals, int maxCals,
                String ingrident1, String ingrident2,  String ingrident3, String ingrident4
    ){

//        https://api.spoonacular.com/recipes/complexSearch?apiKey=3e14d423c5b54657a99a4fa84e8d3905&cuisine=italian&type=main course&query=potatoe&number=5&addRecipeNutrition=true&addRecipeInformation=true&Sort=calories&minCalories=500&maxCalories=1200

        String url="https://api.spoonacular.com/recipes/complexSearch?apiKey=3e14d423c5b54657a99a4fa84e8d3905" +
                "&cuisine=" + cusineStyle+
                "&diet="+diet+
                "&ingredients="+ingrident1+","+ingrident2+","+ingrident3+","+ingrident4+","+
                "&minCalories=" +String.valueOf( minCals)+
                "&maxCalories="+String.valueOf(maxCals)+
                "&number=" +String.valueOf(numDishes)+
                "&addRecipeNutrition=true&addRecipeInformation=true&Sort=calories"+
                "&type='main course'" ;


        Log.v(TAG,"******************************************");
        Log.v(TAG, url);


        url=""; // dont make the api calls


//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
////                        https://stackoverflow.com/questions/1568762/accessing-members-of-items-in-a-jsonarray-with-java
//                try {
//                    JSONArray response_array = response.getJSONArray("results");
//                    for (int i = 0; i < response_array.length(); i++) {
//
//                        JSONObject jsonObject = response_array.getJSONObject(i);
//
//                        JSONArray xx = jsonObject.getJSONObject("nutrition").getJSONArray("nutrients");
//                        JSONObject z;
//                        double calories = 0;
//                        for (int a = 0; a < xx.length(); a++) {
//                            z = xx.getJSONObject(i);
//                            Log.v(TAG, z.getString("amount"));
//                            calories = z.getDouble("amount");
//                        }
//
//                        Dish dish = new Dish(
//                                jsonObject.getInt("id"),
//                                jsonObject.getString("title"),
//                                jsonObject.getString("image"),
//                                calories
//                        );
////                                Log.v(TAG, String.valueOf("***************** DISH OBJ TO ARRAY ************************** "));
////                                Log.v(TAG, String.valueOf(dish));
//                        dishArrayList.add(dish);
//
//                    }
//                } catch (Exception e) {
//                }
//
//
//                // Reccle adapter comes here.
//                RecipeeAdapter recipeeAdapter = new RecipeeAdapter(dishArrayList, RecipeeDisplay.this);
//                recyclerView.setAdapter(recipeeAdapter);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//            }
//        });
//
//        Log.v(TAG, String.valueOf("************* DISH ARRAY ****************************** "));
//        Log.v(TAG, String.valueOf(dishArrayList));
//
//        requestQueue.add(request);
    }

}


// old code section
    // i work
//        String url = "https://api.spoonacular.com/recipes/complexSearch?" +
//                "apiKey=3e14d423c5b54657a99a4fa84e8d3905" +
//                "&cuisine="+cusineStyle+"&diet="+diet+"" +
//                "&query="+ingrident1+"" +
//                "&query="+ingrident2+"" +
//                "&query="+ingrident3+"" +
//                "&query="+ingrident4+"" +
//                "&maxCalories="+maxCalories+"" +
//                "&number="+numDishes;