package com.example.appdevfinalprojct2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class WorkoutAdapter_Legs extends RecyclerView.Adapter<WorkoutAdapter_Legs.ViewHolder> {

    String[] title = {
            "",
            "",
            "",
            "",

    };



    String[] description ={
        "",
        "",
        "",
        ""

    };

    int[] image={
            R.drawable.pullup,
            R.drawable.row3,
            R.drawable.seated_row3,
            R.drawable.t_row3,
    };



    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView title, description;
            ImageView workout;

            public ViewHolder(View itemView){
                super(itemView);

                title=itemView.findViewById(R.id.workout_title);
                description=itemView.findViewById(R.id.workout_subtext);
                workout= itemView.findViewById(R.id.workout_image);


            }
    }

    @NonNull
    @Override
    public WorkoutAdapter_Legs.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_card_musclegroup,parent,false);

        ViewHolder viewHolder= new ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter_Legs.ViewHolder holder, int position) {
            holder.title.setText(title[position]);
            holder.description.setText(description[position]);
            holder.workout.setImageResource(image[position]);
                }

    @Override
    public int getItemCount() {
        return description.length;
    }
}
