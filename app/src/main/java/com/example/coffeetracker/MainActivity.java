package com.example.coffeetracker;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    CoffeeFactory factory = new CoffeeFactory();


    CoffeeViewModel coffeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();


        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_coffee, R.id.navigation_statistics, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        coffeeViewModel =   new ViewModelProvider(this).get(CoffeeViewModel.class);


    }

    public void registerCoffee(View view) {



        // Separate the cases for each type of coffee
        switch (view.getId()) {
            case R.id.frag_small_coffee_img:

                Coffee smallCoffee = factory.createCoffee("SMALL");


                if(smallCoffee != null)
                     coffeeViewModel.insert(smallCoffee);

                Toast.makeText(MainActivity.this, "Small coffee registered", Toast.LENGTH_LONG).show();
                break;
            case R.id.frag_medium_coffee_img:

                Coffee midCoffee = factory.createCoffee("MEDIUM");

                if(midCoffee != null)
                    coffeeViewModel.insert(midCoffee);

                Toast.makeText(MainActivity.this, "Medium coffee registered", Toast.LENGTH_LONG).show();
                break;
            case R.id.frag_large_coffee_img:

                Coffee largeCoffee = factory.createCoffee("LARGE");

                if(largeCoffee != null)
                     coffeeViewModel.insert(largeCoffee);

                Toast.makeText(MainActivity.this, "Large coffee registered", Toast.LENGTH_LONG).show();
                break;
        }

        // Prepare intent to call in alarm manager
        Intent intent = new Intent(MainActivity.this, AlertBroadcast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // Get system time when button is clicked and number of seconds for when to show notification
        long timeButtonClicked = System.currentTimeMillis();
        long fiveSeconds = 1000 * 5;

        // Set the actual alarm
        if (alarmManager != null) {
            alarmManager.set(AlarmManager.RTC_WAKEUP, timeButtonClicked + fiveSeconds, pendingIntent);
        }
    }

    private void createNotificationChannel() {

        String CHANNEL_ID = "activity_channel";
        // Create the NotificationChannel, but only on API 26+ because the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Activity Channel";
            String description = "Notification channel for rating productivity after a coffee";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            // Register the channel with the system; you can't change the importance or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }
}
