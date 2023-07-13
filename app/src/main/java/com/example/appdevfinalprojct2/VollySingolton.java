package com.example.appdevfinalprojct2;
import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VollySingolton {

    private RequestQueue requestQueue;
    private static VollySingolton instance;


    private VollySingolton(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VollySingolton getInstance(Context context){
        if(instance ==null){
            instance= new VollySingolton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue(){
        return requestQueue;
    }


}
