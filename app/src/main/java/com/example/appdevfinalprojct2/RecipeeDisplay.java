package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecipeeDisplay extends AppCompatActivity {
    private static String TAG = RecipeeDisplay.class.getSimpleName();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private RequestQueue requestQueue;
    private ArrayList<Dish> dishArrayList;
    // api call components


    // call from the bundle and pass it to the string in the get Recipe




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipee_destination);


        // on click send to another page with intent and do api call and display on that page.
        recyclerView = findViewById(R.id.recipee_destination);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        requestQueue = VollySingolton.getInstance(this).getRequestQueue();
        dishArrayList = new ArrayList<>();
        getRecipee();
    }

    private void getRecipee() {
//                String cusineStyle, String diet, int numDishes, int maxCalories,
//                             String ingrident1, String ingrident2,  String ingrident3  ){

        String url = "https://api.spoonacular.com/recipes/complexSearch?apiKey=3e14d423c5b54657a99a4fa84e8d3905" +
                "&cuisine=italian&diet=vegetarian&query=rice&maxCalories=2400&number=3&sourceUrl";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

//                        https://stackoverflow.com/questions/1568762/accessing-members-of-items-in-a-jsonarray-with-java
                try {
                    JSONArray response_array = response.getJSONArray("results");
                    for (int i = 0; i < response_array.length(); i++) {

                        JSONObject jsonObject = response_array.getJSONObject(i);

                        JSONArray xx = jsonObject.getJSONObject("nutrition").getJSONArray("nutrients");
                        JSONObject z;
                        double calories = 0;
                        for (int a = 0; a < xx.length(); a++) {
                            z = xx.getJSONObject(i);
                            Log.v(TAG, z.getString("amount"));
                            calories = z.getDouble("amount");
                        }

                        Dish dish = new Dish(
                                jsonObject.getInt("id"),
                                jsonObject.getString("title"),
                                jsonObject.getString("image"),
                                calories
                        );
//                                Log.v(TAG, String.valueOf("***************** DISH OBJ TO ARRAY ************************** "));
//                                Log.v(TAG, String.valueOf(dish));
                        dishArrayList.add(dish);

                    }
                } catch (Exception e) {
                }


                // Reccle adapter comes here.
                RecipeeAdapter recipeeAdapter = new RecipeeAdapter(dishArrayList, RecipeeDisplay.this);
                recyclerView.setAdapter(recipeeAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        Log.v(TAG, String.valueOf("************* DISH ARRAY ****************************** "));
        Log.v(TAG, String.valueOf(dishArrayList));

        requestQueue.add(request);
    }


}