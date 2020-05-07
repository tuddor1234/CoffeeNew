package com.example.coffeetracker;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Date;
import java.util.Random;

public class AlertBroadcast extends BroadcastReceiver {

    // String for AndroidManifest
    private static final String NOTIFICATION_BROADCAST_ALERT = "RATINGNOTIF";

    @Override
    public void onReceive(Context context, Intent intent) {
        String CHANNEL_ID = "activity_channel";

        // Changed intent class to redirect to RatingActivity when clicked
        intent.setClass(context, RatingActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // Build the actual notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.notification_coffee_black)
                .setContentTitle("Productivity level")
                .setContentText("Please rate your productivity level after the last coffee")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        // notificationId is must be a unique int for each notification
        Random random = new Random();
        int notificationId = random.nextInt(9999 - 1000) + 1000;

        notificationManager.notify(notificationId, builder.build());
    }
}
