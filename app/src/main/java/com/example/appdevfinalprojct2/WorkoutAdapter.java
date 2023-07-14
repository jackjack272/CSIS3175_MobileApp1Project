package com.example.appdevfinalprojct2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {


    String[] workout_title={
            "i work ",
            "i work ",
    };

    String[] workout_subtext={
            "i work too",
            "i work too",
    };

    int[] workout_image={
            R.drawable.sculpting,
            R.drawable.sculpting,
    };


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;
        TextView subtext;

        Button button;

        public ViewHolder (View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.workout_title);
            image= itemView.findViewById(R.id.workout_image);
            subtext= itemView.findViewById(R.id.workout_subtext);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    // if position 1 take me to this work out....
                    Intent intent= null;
                    Bundle bundle=new Bundle();


                    if(position == 0){
                        intent= new Intent(v.getContext(),Workout_ShowExersises.class );
                        bundle.putInt("position",position);
                        intent.putExtras(bundle);
                    }

                    v.getContext().startActivity(intent);
    //https://stackoverflow.com/questions/28528009/start-new-intent-from-recyclerviewadapter



//                    Snackbar.make(v, "click detected on item" + position,
//                                    Snackbar.LENGTH_LONG).setAction("Action", null)
//                            .show();
                }
            });

        }
    }

    @NonNull
    @Override
    public WorkoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_card_musclegroup, parent, false);
        ViewHolder viewHolder= new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter.ViewHolder holder, int position) {
        holder.title.setText(workout_title[position]);
        holder.subtext.setText(workout_title[position]);
        holder.image.setImageResource(workout_image[position]);

    }

    @Override
    public int getItemCount() {
        return workout_title.length;
    }
}
