package com.example.appdevfinalprojct2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class WorkoutAdapter_bulk extends RecyclerView.Adapter<WorkoutAdapter_bulk.ViewHolder> {

    private static String TAG = WorkoutAdapter_bulk.class.getSimpleName();

    String[] workout_title={
            "Imitate the best!",
            "Chest Without Rest!",
            "Backs for the that V taper !",
            "Core Until I cant no more!",
            "Legs for EXPLOSIVE power!"
    };

    String[] workout_subtext={
            "In this module we'll be using arnold schwarzenegger work out routines " +
                    "as a template. We'll be emmiting certain recovery techniques...",

            "Shred youre chest with ananld's 5 favourate chest exercises by clicking the card.",

            "Unleash Your Inner Arnold: 5 Chest Exercises to Sculpt Your Pecs Like the Legend Himself!" +
                    "Click the card and get the scoop!",


            "Unlock the Secrets of Arnold Schwarzenegger's Back Routine: Build a Herculean Back with These Jaw-Dropping Exercises!"+
                    "Click the card and get the scoop!",


            "Get Ripped Like Arnold: Unleash Your Core Power with His Insane Workout Routine!"+
                    "Click the card and get the scoop!",


            "Get Legendary Legs Like Arnold: Unveil His Top Secret Leg Workout for Massive Gains!"+
                "Click the card and get the scoop!",

    };

    int[] workout_image={
            R.drawable.anri,
            R.drawable.chest,
            R.drawable.back,
            R.drawable.core,
            R.drawable.legs,
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




                    if(position ==0){
                        Snackbar
                            .make(v,
                                    "This is the myth the legened 8x MR.Olimipa!" +
                                            " The terminator!"
                                            + "The one the only ARI!!",
                                    Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
                        return;

                    }

                    // if position 1 take me to this work out....
                    Intent intent= new Intent(v.getContext(),Workout_ShowExersises.class );
                    Bundle bundle=new Bundle();
                    bundle.putInt("position",position);

                    //                    Log.e(TAG, String.valueOf( position) );


                    intent.putExtras(bundle);
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
    public WorkoutAdapter_bulk.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_card_musclegroup, parent, false);
        ViewHolder viewHolder= new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter_bulk.ViewHolder holder, int position) {
        holder.title.setText(workout_title[position]);
        holder.subtext.setText(workout_subtext[position]);
        holder.image.setImageResource(workout_image[position]);

    }

    @Override
    public int getItemCount() {
        return workout_title.length;
    }
}
