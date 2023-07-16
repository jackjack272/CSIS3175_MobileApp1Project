package com.example.appdevfinalprojct2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class WorkoutAdapter_Chest extends RecyclerView.Adapter<WorkoutAdapter_Chest.ViewHolder> {

    String[] title = {
        "Bench Press",
        "Dumbbell Flyess",
        "Dips",
        "Cabel Crossovers"


    };
    String[] description ={
            "To perform Flat Bench Press:\n" +
                    "1. Lie flat on a bench, feet firmly on the ground.\n" +
            "2. Grip the barbell with hands shoulder-width apart.\n" +
            "3. Lower the barbell to your chest while inhaling.\n" +
            "4. Push the barbell up explosively, exhaling as you go.\n" +
            "5. Keep your back, head, and glutes in contact with the bench.\n" +
            "6. Aim for controlled movements throughout.\n" +
            "7. Perform 3-4 sets of 8-12 reps with appropriate weight.\n" +
            "8. Rest between sets for optimal muscle recovery.\n" +
            "9. Incorporate this compound exercise into your routine for a strong and sculpted chest.",
//                BENCH



            "To perform Dumbbell Flyes:\n" +
                    "\n" +
                    "1. Lie flat on a bench, holding a dumbbell in each hand with palms facing each other.\n" +
                    "2. Extend your arms upward directly above your chest, slightly bending your elbows.\n" +
                    "3. With a controlled motion, lower the dumbbells out to the sides in a wide arc, maintaining a slight bend in your elbows.\n" +
                    "4. Feel the stretch in your chest muscles and pause briefly.\n" +
                    "5. Contract your chest muscles to raise the dumbbells back to the starting position.\n" +
                    "6. Repeat for the desired number of repetitions, focusing on maintaining proper form throughout.",
            //                Flies

            "To perform Dips:\n" +
                    "1. Find parallel bars or dip station, shoulder-width apart.\n" +
                    "2. Grip the bars firmly, arms straight, and body upright.\n" +
                    "3. Lower your body by bending elbows until shoulders are at elbow level.\n" +
                    "4. Keep elbows close to your body, not flaring out.\n" +
                    "5. Pause briefly at the bottom.\n" +
                    "6. Push yourself up until arms are straight, engaging chest and triceps.\n" +
                    "7. Avoid locking elbows at the top to maintain tension.\n" +
                    "8. Perform desired reps, focusing on controlled movements.\n" +
                    "9. Add weight for extra challenge once comfortable with bodyweight dips.\n" +
                    "10. Always warm-up and consult a professional for proper form and safety.",

            "To perform Cabel Cross Over:\n" +
                    "1. Stand between two cable machines, feet shoulder-width apart.\n" +
                    "2. Adjust the pulleys to the highest position and attach a D-handle to each side.\n" +
                    "3. Grasp the handles with palms facing down, slightly bend elbows.\n" +
                    "4. Step forward, creating tension on the cables, engage core.\n" +
                    "5. Keep a slight bend in elbows and bring arms forward, crossing them in front of your body.\n" +
                    "6. Exhale as you squeeze your chest muscles.\n" +
                    "7. Slowly return arms to the starting position.\n" +
                    "8. Repeat for the desired number of reps, focusing on controlled movements throughout.",

    };

    int[] image={
            R.drawable.benchpress,
            R.drawable.flys,
            R.drawable.dips,
            R.drawable.cross
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
    public WorkoutAdapter_Chest.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.workout_card_musclegroup,parent,false);

        ViewHolder viewHolder= new ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter_Chest.ViewHolder holder, int position) {
            holder.title.setText(title[position]);
            holder.description.setText(description[position]);
            holder.workout.setImageResource(image[position]);
                }

    @Override
    public int getItemCount() {
        return description.length;
    }
}
