package com.example.androidpractise4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MediaHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public ImageView imageView;

    public MediaHolder(@NonNull View itemView, TextView textView, ImageView imageView) {
        super(itemView);
        this.textView = textView;
        this.imageView = imageView;
    }
}
