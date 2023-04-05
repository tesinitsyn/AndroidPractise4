package com.example.androidpractise4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ExerciseItem> {
    private LayoutInflater inflater;

    private int layout;

    private List<ExerciseItem> exercises;

    static class ViewHolder {
        TextView textView;

        ImageView imageView;
    }

    public ListViewAdapter(Context context, int resource, List<ExerciseItem> exercises){
        super(context, resource, exercises);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.exercises = exercises;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.exerciseName);
            holder.imageView = convertView.findViewById(R.id.exercisePic);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        ExerciseItem exercise = exercises.get(position);
        holder.textView.setText(exercise.getExerciseName());
        holder.imageView.setImageResource(exercise.getImageId());
        return convertView;
    }
}
