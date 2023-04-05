package com.example.androidpractise4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment {

    private List<ExerciseItem> exercises = new ArrayList<>();

    public static RecyclerViewFragment newInstance() {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter.MyOnItemClickListener listener = (exercise, position) -> {
            Log.i("RecyclerView", "Selected item " + position);
            Toast.makeText(getContext(), "Selected item " + position, Toast.LENGTH_SHORT).show();
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        for(int i = 0; i < 200; i++){
            exercises.add(new ExerciseItem("Crunches", R.drawable.ic_launcher_background));
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(exercises, listener);
        recyclerView.setAdapter(adapter);
    }
}