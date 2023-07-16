package com.example.appdevfinalprojct2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class WorkoutAdapter_Core extends RecyclerView.Adapter<WorkoutAdapter_Core.ViewHolder> {

    String[] title = {
        "Crunches",
        "Roman Chair Sit-Ups",
        "Russian Twists",
        "Decline Bench Crunches",
    };


    String[] description ={
        "1. Lie flat on your back with knees bent and feet flat on the floor.\n" +
            "2. Place your hands behind your head, fingers gently supporting your neck.\n" +
            "3. Engage your core muscles and lift your shoulders off the ground, keeping your lower back on the floor.\n" +
            "4. Exhale as you crunch forward, aiming to bring your chest towards your knees.\n" +
            "5. Pause briefly at the top, then inhale as you lower your shoulders back down, but not completely touching the ground.\n" +
            "6. Repeat for the desired number of reps, maintaining controlled movements throughout.",



        "1. Position yourself on a Roman chair, securing your legs under the pads and sitting up straight.\n" +
            "2. Cross your arms over your chest or place your hands behind your head, avoiding interlocking fingers.\n" +
            "3. Lower your upper body slowly, engaging your core muscles to control the movement.\n" +
            "4. Descend until your upper body is parallel to the ground or slightly below it.\n" +
            "5. Pause briefly, then contract your abs to raise your torso back to the starting position.\n" +
            "6. Repeat for the desired number of reps, maintaining a controlled and steady pace throughout.",


        "1. Sit on the floor with your knees bent and feet flat, leaning back slightly.\n" +
            "2. Hold a weight or medicine ball with both hands, close to your chest.\n" +
            "3. Engage your core and lift your feet slightly off the ground.\n" +
            "4. Twist your torso to the right, bringing the weight towards the floor beside your hip.\n" +
            "5. Pause briefly, then twist to the left side, repeating the motion.\n" +
            "6. Keep the movement controlled and maintain balance on your sit bones.\n" +
            "7. Perform the desired repetitions on each side to work your obliques effectively.",


        "1. Position Lie down on a decline bench with your feet securely locked in place.\n" +
            "2. Hand Placement Cross your arms over your chest or place them behind your head, but avoid pulling on your neck.\n" +
            "3. Engage Core: Tighten your core muscles to stabilize your body throughout the movement.\n" +
            "4. Crunch Up Lift your upper body toward your knees, exhaling as you crunch.\n" +
            "5. Pause Squeeze your abs at the top for a moment.\n" +
            "6. Lower Down Inhale and slowly lower your upper body back to the starting position.\n" +
            "7. Repeat Perform the desired number of repetitions while maintaining proper form."

    };



    int[] image={
            R.drawable.crunches,
            R.drawable.chair_situps,
            R.drawable.russian,
            R.drawable.decline,
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
    public WorkoutAdapter_Core.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_card_musclegroup,parent,false);

        ViewHolder viewHolder= new ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter_Core.ViewHolder holder, int position) {
            holder.title.setText(title[position]);
            holder.description.setText(description[position]);
            holder.workout.setImageResource(image[position]);
                }

    @Override
    public int getItemCount() {
        return description.length;
    }
}
