package com.example.appdevfinalprojct2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class WorkoutAdapter_Back extends RecyclerView.Adapter<WorkoutAdapter_Back.ViewHolder> {

    String[] title = {
        "Pull-ups/Chin-ups",
        "Barbell Rows",
        "Seated Cable Rows",
        "T-bar Rows"
    };



    String[] description ={
        "BE CATUIOUS, BACK INJURIES ARE LIFE LONG!! Small weight, focus on technique!!!  \n"+
        "1. Grab the Bar: Stand beneath a sturdy pull-up bar, palms facing away from you, shoulder-width apart.\n" +
            "2. Hang: Hang with arms fully extended, engage your core, and keep shoulders down.\n" +
            "3. Pull Up: Exhale, squeeze shoulder blades, and pull body up until chin reaches the bar.\n" +
            "4. Hold the Top:  Pause briefly at the top, focusing on the contraction in the back.\n" +
            "5. Lower Down Inhale, slowly lower your body to the starting position with arms fully extended.\n" +
            "6. Repeat Aim for desired reps, maintaining proper form throughout.",

        "BE CATUIOUS, BACK INJURIES ARE LIFE LONG!! Small weight, focus on technique!!! \n "+
        "1. Stand with feet shoulder-width apart, knees slightly bent, and grip an overhand grip on the barbell with hands slightly wider than shoulder-width apart.\n" +
            "2. Bend at the waist while keeping your back straight, lowering the barbell towards the floor.\n" +
            "3. Pull the barbell up towards your lower chest by squeezing your shoulder blades together, keeping your elbows close to your body.\n" +
            "4. Pause briefly at the top, feeling the contraction in your back muscles.\n" +
            "5. Lower the barbell back down with control to the starting position.\n" +
            "6. Repeat for the desired number of reps, maintaining proper form throughout.",


        "BE CATUIOUS, BACK INJURIES ARE LIFE LONG!! Small weight, focus on technique!!!  \n"+
        "1. Sit on the cable row machine with feet flat on the footrest and knees slightly bent.\n" +
            "2. Grab the cable handles with an overhand grip, hands shoulder-width apart.\n" +
            "3. Keep your back straight, shoulders relaxed, and chest up throughout the exercise.\n" +
            "4. Pull the handles towards your torso, squeezing your shoulder blades together at the end of the movement.\n" +
            "5. Slowly extend your arms, returning to the starting position while maintaining tension on the cables.\n" +
            "6. Repeat for the desired number of reps, focusing on controlled movements and proper form.\n" +
            "7. Breathe out during the pulling phase and inhale while extending your arms.",


        "BE CATUIOUS, BACK INJURIES ARE LIFE LONG!! Small weight, focus on technique!!!  \n"+
        "1. Sit on the cable row machine with feet flat on the footrest and knees slightly bent.\n" +
            "2. Grab the cable handles with an overhand grip, hands shoulder-width apart.\n" +
            "3. Keep your back straight, shoulders relaxed, and chest up throughout the exercise.\n" +
            "4. Pull the handles towards your torso, squeezing your shoulder blades together at the end of the movement.\n" +
            "5. Slowly extend your arms, returning to the starting position while maintaining tension on the cables.\n" +
            "6. Repeat for the desired number of reps, focusing on controlled movements and proper form.\n" +
            "7. Breathe out during the pulling phase and inhale while extending your arms."
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
    public WorkoutAdapter_Back.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_card_musclegroup,parent,false);

        ViewHolder viewHolder= new ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter_Back.ViewHolder holder, int position) {
            holder.title.setText(title[position]);
            holder.description.setText(description[position]);
            holder.workout.setImageResource(image[position]);
                }

    @Override
    public int getItemCount() {
        return description.length;
    }
}
