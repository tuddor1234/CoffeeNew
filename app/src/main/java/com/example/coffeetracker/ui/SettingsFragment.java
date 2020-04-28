package com.example.coffeetracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.coffeetracker.R;
import com.example.coffeetracker.RatingActivity;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Test button for the RatingActivity
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Button testRating = (Button) view.findViewById(R.id.rating_test_btn);
        testRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), RatingActivity.class);
                startActivity(i);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
