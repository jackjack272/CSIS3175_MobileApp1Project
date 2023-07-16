package com.example.appdevfinalprojct2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;

public class Dish_RecipeeDisplay extends AppCompatActivity {
//    private static final String TAG= Dish_RecipeeDisplay.class.getSimpleName();

    private static String TAG = Dish_RecipeeDisplay.class.getSimpleName();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private RequestQueue requestQueue;
    private List<Dish> dishArrayList;
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








    // the recycler view area
//        // on click send to another page with intent and do api call and display on that page.
//        recyclerView = findViewById(R.id.recipee_destination);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);


        requestQueue = VollySingolton.getInstance(this).getRequestQueue();
        dishArrayList = new ArrayList<>();

        getRecipee(
                getTheURL( culture,restriction , 6,
                        weeklyCals,1500,ing1,ing2, ing3, ing4 )
        );
    }

    private void getRecipee(String url ) {
        Log.e(TAG,"************** URL ***************");
        Log.e(TAG,url);


        JsonObjectRequest apiToSpoonacular= new JsonObjectRequest(Request.Method.GET, url,
                null, response -> {
            try {
                JSONArray listOfDishes= response.getJSONArray("results");
                for(int indi_dish=0; indi_dish<listOfDishes.length(); indi_dish++){
                    JSONObject one_dish= listOfDishes.getJSONObject(indi_dish);

                    Log.e(TAG,"************** ONE DISH ***************");
                    Log.e(TAG, String.valueOf( one_dish));




                }






            } catch (Exception e) {
                Log.e(TAG, "DISH RECIPEE DISPLAY ERROR");
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Dish_RecipeeDisplay.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(apiToSpoonacular);

    }


    private String getTheURL(
            String cusineStyle, String diet, int numDishes,float minCals, int maxCals,
            String ingrident1, String ingrident2,  String ingrident3, String ingrident4
    ){
//      https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
//      http://theoryapp.com/parse-json-in-java/
//      https://stackoverflow.com/questions/1568762/accessing-members-of-items-in-a-jsonarray-with-java
//      https://api.spoonacular.com/recipes/complexSearch?apiKey=3e14d423c5b54657a99a4fa84e8d3905&cuisine=italian&type=main course&query=potatoe&number=5&addRecipeNutrition=true&addRecipeInformation=true&Sort=calories&minCalories=500&maxCalories=1200
        String url="https://api.spoonacular.com/recipes/complexSearch?apiKey=3e14d423c5b54657a99a4fa84e8d3905" +
                "&cuisine=" + cusineStyle+
                "&diet="+diet+
                "&includeIngredients="+ingrident1+","+ingrident2+","+ingrident3+","+ingrident4+","+
                "&minCalories=" +String.valueOf( minCals)+
                "&maxCalories="+String.valueOf(maxCals)+
                "&number=" +String.valueOf(numDishes)+
                "&addRecipeNutrition=true&addRecipeInformation=true&Sort=calories"+
                "&type='main course'" ;
        return url;

    }


}




/* api call going to rip parts out as i need to make it work.
   JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v(TAG, String.valueOf("************* HERE 1 ****************************** "));

                try {
                    if(response ==null){
//                        Log.e(TAG, "ran out of API calls for today, come back 6pm western standard. ");
                        throw new Exception("ran out of api calls for today ");
                    }
                    Log.v(TAG, String.valueOf("************* HERE 2 ****************************** "));



                    Boolean isVegetarian;
                    String dishTitle, dishCredit, summayrHowToMake, dishImage;
                    Double pricePerServing, calories, weightPerServing,prepTime,
                            fat, saturated_fat, carbs, sugar, sodium, protine, fiber ;
                    Long  dishId;

                    Log.v(TAG, String.valueOf("************* HERE 3 ****************************** "));


                    JSONArray response_array = response.getJSONArray("results");
                    for (int i = 0; i < response_array.length(); i++) {
                        JSONObject oneDish = response_array.getJSONObject(i);

                        Log.v(TAG, String.valueOf("************* HERE 4 ****************************** "));

                    //get the weight related stuff
                        JSONArray nutrients_JA=oneDish.getJSONObject("nutrition").getJSONArray("nutrients");
                        calories=nutrients_JA.getJSONObject(0).getDouble("amount");
                        fat=nutrients_JA.getJSONObject(1).getDouble("amount");
                        saturated_fat=nutrients_JA.getJSONObject(2).getDouble("amount");
                        carbs=nutrients_JA.getJSONObject(3).getDouble("amount");
                        sugar=nutrients_JA.getJSONObject(5).getDouble("amount");
                        sodium=nutrients_JA.getJSONObject(7).getDouble("amount");
                        protine=nutrients_JA.getJSONObject(8).getDouble("amount");
                        fiber=nutrients_JA.getJSONObject(9).getDouble("amount");
                        Log.v(TAG, String.valueOf("************* HERE 5 ****************************** "));

                        Dish_nutrition nutrients= new Dish_nutrition(
                                calories,fat, saturated_fat,carbs,sugar,sodium,protine, fiber
                        );
                        Log.v(TAG, String.valueOf("************* HERE 6 ****************************** "));


                    // get the ingredients
                        JSONArray allIngredient= oneDish.getJSONObject("nutrition").getJSONArray("ingredients");
                        List<Dish_Ingredient> ingredients = new ArrayList<Dish_Ingredient>();
                        for(int j=0; j<allIngredient.length(); j++){
                            JSONObject oneIngredient=allIngredient.getJSONObject(i);
                            ingredients.add(
                                new Dish_Ingredient(
                                    oneIngredient.getString("name"),
                                    oneIngredient.getString("unit"),
                                    oneIngredient.getDouble("amount")
                                )
                            );
                        }
                        Log.v(TAG, String.valueOf("************* HERE 7 ****************************** "));


                    //get the instructions
                        JSONArray instructions=  oneDish.getJSONObject("analyzedInstructions").getJSONArray("steps");
                        List<Dish_Instruction> dish_instruction= new ArrayList<Dish_Instruction>();
                        for(int a=0; a<instructions.length(); a++){
                            dish_instruction.add(
                                new Dish_Instruction(
                                            instructions.getJSONObject(a).getInt("number"),
                                            instructions.getJSONObject(a).getString("step")
                                    )
                            );
                        }
                        Log.v(TAG, String.valueOf("************* HERE 8 ****************************** "));


                        //get meta data about the dish
                        isVegetarian=Boolean.valueOf(oneDish.getString("vegetarian"));
                        dishTitle=oneDish.getString("title");
                        dishCredit=oneDish.getString("creditsText");
                        pricePerServing=oneDish.getDouble("pricePerServing")/100; //in cents/100 -> $
                        dishId=oneDish.getLong("id");
                        prepTime=oneDish.getDouble("readyInMinutes");
                        dishImage=oneDish.getString("image");
                        summayrHowToMake= oneDish.getString("summary");
                        Log.v(TAG, String.valueOf("************* HERE 9 ****************************** "));

                        Dish dish= new Dish(
                                dish_instruction, nutrients, dishId, dishTitle, calories, isVegetarian,
                                pricePerServing, summayrHowToMake, dishImage
                        );
                        Log.v(TAG, String.valueOf("************* HERE 10 ****************************** "));


                        Log.e(TAG, "******************* STRING VALUE OF DISH ************" );
                        Log.e(TAG, String.valueOf( dish) );


                        dishArrayList.add(dish);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Dish_RecipeeDisplay: line 136, message"+e.getMessage());
                }

                // Reccle adapter comes here.
//                Dish_Adapter recipeeAdapter = new Dish_Adapter(dishArrayList, Dish_RecipeeDisplay.this);
//                recyclerView.setAdapter(recipeeAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, String.valueOf("************* GET API CALL ERROR ****************************** "));
                Log.v(TAG, String.valueOf(error.getMessage() ));

            }
        });

        Log.v(TAG, String.valueOf("************* DISH ARRAY ****************************** "));
        Log.v(TAG, String.valueOf(dishArrayList));

//        requestQueue.add(request);




 */



//         Log.e(TAG, "********************* SELECTED THE FOLLOWING INGREDIENTS *********************");
//                 Log.e(TAG, String.valueOf( isVegetarian ));
//                 Log.e(TAG, String.valueOf( dishTitle ));
//                 Log.e(TAG, String.valueOf( dishCredit ));
//                 Log.e(TAG, String.valueOf( pricePerServing ));
//                 Log.e(TAG, String.valueOf( dishId ));
//                 Log.e(TAG, String.valueOf( prepTime ));
//                 Log.e(TAG, String.valueOf( dishImage ));
//                 Log.e(TAG, String.valueOf( calories ));
//



// old code section
    // i work
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