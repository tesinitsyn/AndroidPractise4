package com.example.androidpractise4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewFragment extends Fragment {

    private List<ExerciseItem> exercise = new ArrayList<>();
    public ListViewFragment() {
        // Required empty public constructor
    }

    public static ListViewFragment newInstance() {
        ListViewFragment fragment = new ListViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for(int i = 0; i < 200; i++){
            exercise.add(new ExerciseItem("Push-ups", R.drawable.ic_launcher_foreground));
        }
        ListView listView = view.findViewById(R.id.listViewWithSMTH);
        ListViewAdapter adapter = new ListViewAdapter(getContext(), R.layout.exercise_layout, exercise);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Log.i("ListView", "Selected item " + position);
            Toast.makeText(getContext(), "Selected item " + position, Toast.LENGTH_SHORT).show();
        });
    }
}