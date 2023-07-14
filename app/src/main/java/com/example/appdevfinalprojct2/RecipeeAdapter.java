package com.example.appdevfinalprojct2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.squareup.picasso.Picasso;


public class RecipeeAdapter extends RecyclerView.Adapter<RecipeeAdapter.ViewHolder> {

    private ArrayList<Dish> dishArrayList;
    private Context context;

    public RecipeeAdapter(ArrayList<Dish> dishArrayList, Context context) {
        this.dishArrayList = dishArrayList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title;
        TextView description;
        TextView calories;

        
        public ViewHolder(@NonNull View view){
            super(view);

            imageView= view.findViewById(R.id.food_image);
            title=view.findViewById(R.id.food_title);
            calories= view.findViewById(R.id.food_calories);
        }
        
    }

    @NonNull
    @Override
    public RecipeeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recipee_card,parent,false);
        ViewHolder viewHolder= new ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeeAdapter.ViewHolder holder, int position) {
        Dish dish = dishArrayList.get(position);
        holder.title.setText(dish.getTitle());
        holder.calories.setText(String.valueOf( dish.getCalories()));// when in doubt make it a string

        Picasso.get().load(dish.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dishArrayList.size();
    }
}


