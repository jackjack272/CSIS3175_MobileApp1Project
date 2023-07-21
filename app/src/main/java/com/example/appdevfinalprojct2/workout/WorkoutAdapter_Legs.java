package com.example.appdevfinalprojct2.workout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdevfinalprojct2.R;

public class WorkoutAdapter_Legs extends RecyclerView.Adapter<WorkoutAdapter_Legs.ViewHolder> {

    String[] title = {
            "Squats",
            "Lunges",
            "Leg Extensions",
            "Leg Curls:",

    };

    String[] description ={
        "1. Stand with feet shoulder-width apart.\n" +
            "2. Keep your chest up, shoulders back.\n" +
            "3. Lower your body by bending your knees and hips.\n" +
            "4. Go as low as comfortable or until thighs are parallel to the floor.\n" +
            "5. Keep knees aligned with toes, not beyond.\n" +
            "6. Push through heels to return to the starting position.\n" +
            "7. Engage core throughout the movement.\n" +
            "8. Perform 3-4 sets of 8-12 reps.\n" +
            "9. Use proper form and gradually increase weight for progression.\n" +
            "10. Consult a fitness professional if unsure.",


        "1. Stand tall with feet hip-width apart.\n" +
            "2. Take a step forward with one leg, lowering your body until both knees are at 90-degree angles.\n" +
            "3. Keep your back straight and shoulders relaxed.\n" +
            "4. Push through the front heel to return to the starting position.\n" +
            "5. Alternate legs and repeat for the desired number of reps.\n" +
            "6. Maintain control and balance throughout the movement.\n" +
            "7. To intensify, hold dumbbells in each hand or use a barbell on your shoulders.\n" +
            "8. Lunges target quadriceps, hamstrings, and glutes, promoting leg strength and stability.",


            "1. Sit on a leg extension machine with your back against the backrest and feet under the padded bar.\n" +
                "2. Adjust the machine so that your knees align with the machine's axis.\n" +
                "3. Grasp the handles for stability and engage your core.\n" +
                "4. Slowly extend your legs, lifting the padded bar until your legs are almost straight.\n" +
                "5. Hold for a brief moment, then lower the weight in a controlled manner back to the starting position.\n" +
                "6. Avoid locking your knees and maintain a smooth, controlled motion throughout the exercise.\n" +
                "7. Perform the desired number of reps and sets as part of your leg workout routine.",



            "1. Lie face down on a leg curl machine with your ankles against the padded lever.\n" +
                "2. Grip the handles for support and keep your legs fully extended.\n" +
                "3. Exhale and curl your legs upward by flexing your knees until your thighs are vertical.\n" +
                "4. Hold the contracted position briefly, focusing on squeezing your hamstrings.\n" +
                "5. Inhale and slowly lower your legs back to the starting position.\n" +
                "6. Repeat for the desired number of repetitions, maintaining controlled movements throughout.\n" +
                "7. Adjust the machine settings to suit your comfort and ensure proper form.",

    };


    int[] image={
            R.drawable.squat,
            R.drawable.lunges,
            R.drawable.leg_curls,


            R.drawable.curls,
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
