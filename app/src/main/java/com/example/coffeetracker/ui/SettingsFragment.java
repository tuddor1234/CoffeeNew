package com.example.coffeetracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.coffeetracker.Coffee;
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
        setCoffeeCaffeine(view);

        // Inflate the layout for this fragment
        return view;
    }

    private void setCoffeeCaffeine(View view) {
        final LinearLayout smallCoffeeLayout = view.findViewById(R.id.linearLayout7);
        final LinearLayout mediumCoffeeLayout = view.findViewById(R.id.linearLayout8);
        final LinearLayout largeCoffeeLayout = view.findViewById(R.id.linearLayout9);

        Button smallCoffeeBtn = view.findViewById(R.id.frag_user_small_coffee_btn);
        Button mediumCoffeeBtn = view.findViewById(R.id.frag_user_medium_coffee_btn);
        Button largeCoffeeBtn = view.findViewById(R.id.frag_user_large_coffee_btn);

        final EditText smallCoffeeEditText = view.findViewById(R.id.frag_user_small_coffee_edit);
        final EditText mediumCoffeeEditText = view.findViewById(R.id.frag_user_medium_coffee_edit);
        final EditText largeCoffeeEditText = view.findViewById(R.id.frag_user_large_coffee_edit);

        smallCoffeeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (smallCoffeeLayout.getVisibility() == View.VISIBLE) {
                    smallCoffeeLayout.setVisibility(View.INVISIBLE);
                } else if (smallCoffeeLayout.getVisibility() == View.INVISIBLE) {
                    smallCoffeeEditText.setText("100");
                    smallCoffeeLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        mediumCoffeeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (mediumCoffeeLayout.getVisibility() == View.VISIBLE) {
                    mediumCoffeeLayout.setVisibility(View.INVISIBLE);
                } else if (mediumCoffeeLayout.getVisibility() == View.INVISIBLE) {
                    mediumCoffeeEditText.setText("200");
                    mediumCoffeeLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        largeCoffeeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (largeCoffeeLayout.getVisibility() == View.VISIBLE) {
                    largeCoffeeLayout.setVisibility(View.INVISIBLE);
                } else if (largeCoffeeLayout.getVisibility() == View.INVISIBLE) {
                    largeCoffeeEditText.setText("300");
                    largeCoffeeLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}

