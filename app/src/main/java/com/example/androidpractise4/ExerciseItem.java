package com.example.androidpractise4;

public class ExerciseItem {
    private String exerciseName;
    private int imageId;

    public ExerciseItem(String exerciseName, int imageId) {
        this.exerciseName = exerciseName;
        this.imageId = imageId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
