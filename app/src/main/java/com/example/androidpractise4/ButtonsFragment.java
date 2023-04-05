package com.example.androidpractise4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.Nullable;

public class ButtonsFragment extends Fragment {

    final public static String TAG = ButtonsFragment.class.getSimpleName();

    public ButtonsFragment() {
    }

    public static ButtonsFragment newInstance() {
       return new ButtonsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buttons, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button listViewButton = (Button) view.findViewById(R.id.listViewButton);
        Button recyclerViewButton = (Button) view.findViewById(R.id.recyclerViewButton);

        listViewButton.setOnClickListener(someView -> {
            ListViewFragment listViewFragment = ListViewFragment.newInstance();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, listViewFragment)
                    .addToBackStack(null)
                    .commit();
        });

        recyclerViewButton.setOnClickListener(someView -> {
            RecyclerViewFragment recyclerViewFragment = RecyclerViewFragment.newInstance();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, recyclerViewFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}