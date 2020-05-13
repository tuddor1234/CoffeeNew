package com.example.coffeetracker.components.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.coffeetracker.MainActivity;
import com.example.coffeetracker.R;

public class SettingsFragment extends Fragment {

    private EditText name, height, weight, age;
    private EditText smallCoffeeEditText, mediumCoffeeEditText, largeCoffeeEditText;

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

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        setCaffeineLevels(view);

        // User EditText fields
        name = view.findViewById(R.id.frag_user_name_edit);
        height = view.findViewById(R.id.frag_user_height_edit);
        weight = view.findViewById(R.id.frag_user_weight_edit);
        age = view.findViewById(R.id.frag_user_age_edit);

        // Caffeine EditText fields
        smallCoffeeEditText = view.findViewById(R.id.frag_user_small_coffee_edit);
        mediumCoffeeEditText = view.findViewById(R.id.frag_user_medium_coffee_edit);
        largeCoffeeEditText = view.findViewById(R.id.frag_user_large_coffee_edit);

        // Inflate the layout for this fragment
        return view;
    }

    // Data must be stored and fetched from onResume(), because this is what will be called when the app opens again
    @Override
    public void onResume() {
        super.onResume();

        // Fetching the stored data from the SharedPreference
        @SuppressLint("WrongConstant") SharedPreferences sh = this.getActivity().getSharedPreferences("MySharedPref", Context.MODE_APPEND);

        String userName = sh.getString("name", "");
        int userHeight = sh.getInt("height", 0);
        int userWeight = sh.getInt("weight", 0);
        int userAge = sh.getInt("age", 0);

        int smallCaffeine = sh.getInt("small coffee", 0);
        int mediumCaffeine = sh.getInt("medium coffee", 0);
        int largeCaffeine = sh.getInt("large coffee", 0);

        // Setting the fetched data in the EditTexts
        name.setText(userName);
        height.setText(String.valueOf(userHeight));
        weight.setText(String.valueOf(userWeight));
        age.setText(String.valueOf(userAge));

        smallCoffeeEditText.setText(String.valueOf(smallCaffeine));
        mediumCoffeeEditText.setText(String.valueOf(mediumCaffeine));
        largeCoffeeEditText.setText(String.valueOf(largeCaffeine));
    }

    // When the user closes the application onPause() is called and data will be stored
    @Override
    public void onPause() {
        super.onPause();

        // Creating a shared preferences object, with a file name "MySharedPref" in private mode
        SharedPreferences sharedPreferences = this.requireActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editPreferences = sharedPreferences.edit();

        editPreferences.putString("name", name.getText().toString());

        // User information
        if ((height.getText().toString().trim().length() > 0) && (weight.getText().toString().trim().length() > 0) && (age.getText().toString().trim().length() > 0)) {
            editPreferences.putInt("height", Integer.parseInt(height.getText().toString()));
            editPreferences.putInt("weight", Integer.parseInt(weight.getText().toString()));
            editPreferences.putInt("age", Integer.parseInt(age.getText().toString()));
        } else {
            Toast.makeText(this.getActivity(), "No changes saved. Fields can't be empty", Toast.LENGTH_LONG).show();
        }

        // Caffeine levels information
        if ((smallCoffeeEditText.getText().toString().trim().length() > 0) && (mediumCoffeeEditText.getText().toString().trim().length() > 0) && (largeCoffeeEditText.getText().toString().trim().length() > 0)) {
            editPreferences.putInt("small coffee", Integer.parseInt(smallCoffeeEditText.getText().toString()));
            editPreferences.putInt("medium coffee", Integer.parseInt(mediumCoffeeEditText.getText().toString()));
            editPreferences.putInt("large coffee", Integer.parseInt(largeCoffeeEditText.getText().toString()));
        } else {
            Toast.makeText(this.getActivity(), "Caffeine quantities were not updated", Toast.LENGTH_LONG).show();
        }

        editPreferences.apply();
    }

    private void setCaffeineLevels(View view) {
        final LinearLayout smallCoffeeLayout = view.findViewById(R.id.linearLayout7);
        final LinearLayout mediumCoffeeLayout = view.findViewById(R.id.linearLayout8);
        final LinearLayout largeCoffeeLayout = view.findViewById(R.id.linearLayout9);

        Button smallCoffeeBtn = view.findViewById(R.id.frag_user_small_coffee_btn);
        final Button mediumCoffeeBtn = view.findViewById(R.id.frag_user_medium_coffee_btn);
        Button largeCoffeeBtn = view.findViewById(R.id.frag_user_large_coffee_btn);


        final MainActivity mainActivity = (MainActivity) getActivity();

        smallCoffeeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // If small coffee EditText is visible, save user new value after buttonTap and hide EditText
                if (smallCoffeeLayout.getVisibility() == View.VISIBLE) {

                    String temp = smallCoffeeEditText.getText().toString();

                    if (!temp.equals(String.valueOf(mainActivity.factory.getSMALL_CAFFEINE()))) {
                        mainActivity.factory.setSMALL_CAFFEINE(Integer.parseInt(temp));
                    }

                    smallCoffeeLayout.setVisibility(View.INVISIBLE);
                }
                // If small coffee EditText is invisible, get current caffeine level and show EditText after buttonTap
                else if (smallCoffeeLayout.getVisibility() == View.INVISIBLE) {
                    smallCoffeeEditText.setText(String.valueOf(mainActivity.factory.getSMALL_CAFFEINE()));
                    smallCoffeeLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        mediumCoffeeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // If small coffee EditText is visible, save user new value after buttonTap and hide EditText
                if (mediumCoffeeLayout.getVisibility() == View.VISIBLE) {

                    String temp = mediumCoffeeEditText.getText().toString();

                    if (!temp.equals(String.valueOf(mainActivity.factory.getMEDIUM_CAFFEINE()))) {
                        mainActivity.factory.setMEDIUM_CAFFEINE(Integer.parseInt(temp));
                    }
                    mediumCoffeeLayout.setVisibility(View.INVISIBLE);
                }
                // If small coffee EditText is invisible, get current caffeine level and show EditText after buttonTap
                else if (mediumCoffeeLayout.getVisibility() == View.INVISIBLE) {
                    mediumCoffeeEditText.setText(String.valueOf(mainActivity.factory.getMEDIUM_CAFFEINE()));
                    mediumCoffeeLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        largeCoffeeBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // If small coffee EditText is visible, save user new value after buttonTap and hide EditText
                if (largeCoffeeLayout.getVisibility() == View.VISIBLE) {
                    String temp = largeCoffeeEditText.getText().toString();

                    if (!temp.equals(String.valueOf(mainActivity.factory.getLARGE_CAFFEINE()))) {
                        mainActivity.factory.setLARGE_CAFFEINE(Integer.parseInt(temp));
                    }
                    largeCoffeeLayout.setVisibility(View.INVISIBLE);
                }
                // If small coffee EditText is invisible, get current caffeine level and show EditText after buttonTap
                else if (largeCoffeeLayout.getVisibility() == View.INVISIBLE) {
                    largeCoffeeEditText.setText(String.valueOf(mainActivity.factory.getLARGE_CAFFEINE()));
                    largeCoffeeLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}

