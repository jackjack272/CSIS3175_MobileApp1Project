package com.example.appdevfinalprojct2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class Workout_Recycler_Adapater extends RecyclerView.Adapter<Workout_Recycler_Adapater.ViewHolder> {


    String[] workout_title={
            "i work ",
            "i work ",
            "i work ",
    };

    String[] workout_subtext={
            "i work too",
            "i work too",
            "i work too",
    };

    int[] workout_image={
            R.drawable.sculpting,
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


                    Snackbar.make(v, "click detected on item" + position,
                                    Snackbar.LENGTH_LONG).setAction("Action", null)
                            .show();
                }
            });

        }
    }

    @NonNull
    @Override
    public Workout_Recycler_Adapater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_card, parent, false);
        ViewHolder viewHolder= new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Workout_Recycler_Adapater.ViewHolder holder, int position) {
        holder.title.setText(workout_title[position]);
        holder.subtext.setText(workout_title[position]);
        holder.image.setImageResource(workout_image[position]);

    }

    @Override
    public int getItemCount() {
        return workout_title.length;
    }
}
