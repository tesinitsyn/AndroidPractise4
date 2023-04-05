package com.example.androidpractise4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MediaHolder> {
    private List<ExerciseItem> exercises;

    interface MyOnItemClickListener{
        void onClick(ExerciseItem exercise, int position);
    }

    private final MyOnItemClickListener myOnItemClickListener;

    public RecyclerViewAdapter(List<ExerciseItem> exercises, MyOnItemClickListener myOnItemClickListener){
        this.exercises = exercises;
        this.myOnItemClickListener = myOnItemClickListener;
    }
    @NonNull
    @Override
    public MediaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_layout, parent, false);
        MediaHolder viewHolder = new MediaHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MediaHolder holder, int position) {
        ExerciseItem exercise = exercises.get(position);
        holder.textView.setText(exercise.getExerciseName());
        holder.imageView.setImageResource(exercise.getImageId());
        holder.itemView.setOnClickListener(v -> {
            myOnItemClickListener.onClick(exercise, holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}

