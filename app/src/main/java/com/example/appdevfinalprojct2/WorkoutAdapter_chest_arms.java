package com.example.appdevfinalprojct2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WorkoutAdapter_chest_arms extends RecyclerView.Adapter<WorkoutAdapter_chest_arms.ViewHolder> {

    String[] title = {
        "Arms of steel ",

    };
    String[] description ={
        "Darebee workout -darebee.com \n get them arms PUMPED in 3minutes",
    };

    int[] image={
            R.drawable.arms_of_steel,
    };



    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView title, description;
            ImageView workout;

            public ViewHolder(View itemView){
                super(itemView);

                title=itemView.findViewById(R.id.workout_card_title);
                workout= itemView.findViewById(R.id.workout_card_image);
                description=itemView.findViewById(R.id.workout_card_description);
            }
    }

    @NonNull
    @Override
    public WorkoutAdapter_chest_arms.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_card_exersises,parent,false);

        ViewHolder viewHolder= new ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter_chest_arms.ViewHolder holder, int position) {
            holder.title.setText(title[position]);
            holder.description.setText(description[position]);
            holder.workout.setImageResource(image[position]);
                }

    @Override
    public int getItemCount() {
        return description.length;
    }
}
