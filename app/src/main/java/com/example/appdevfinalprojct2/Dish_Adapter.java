package com.example.appdevfinalprojct2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;


public class Dish_Adapter extends RecyclerView.Adapter<Dish_Adapter.ViewHolder> {

    private ArrayList<Dish> dishArrayList;
    private Context context;

    public Dish_Adapter(ArrayList<Dish> dishArrayList, Context context) {
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
            description= view.findViewById(R.id.food_description);

            // set on click listender to send to next view with api request to details on the recipee
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
//                    Snackbar.make(v, "click detected on item" + position,
//                                    Snackbar.LENGTH_LONG).setAction("Action", null)
//                            .show();
                    //https://stackoverflow.com/questions/28767413/how-to-open-a-different-activity-on-recyclerview-item-onclick
                }});
        }
        
    }

    @NonNull
    @Override
    public Dish_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recipee_card,parent,false);
        ViewHolder viewHolder= new ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Dish_Adapter.ViewHolder holder, int position) {
        Dish dish = dishArrayList.get(position);
        holder.title.setText(dish.getTitle());
        holder.calories.setText(String.valueOf( dish.getCalories()));// when in doubt make it a string
        holder.description.setText(String.valueOf(dish.getSummary()));


        Picasso.get().load(dish.getDish_image()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dishArrayList.size();
    }
}


