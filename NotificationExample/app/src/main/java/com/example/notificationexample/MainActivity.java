package com.example.notificationexample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID =  "Message channel";
    private static final int NOTIFICATION_ID =  100;
    private static final int REQ_CODE =  50;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        get a drawable
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.android_logo, null);
//        convert drawable to bitmap drawable
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        assert bitmapDrawable != null;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQ_CODE, intent, PendingIntent.FLAG_IMMUTABLE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.android_logo)
                    .setContentIntent(pendingIntent)
                    .setContentText("New message")
                    .setSubText("New Message from Narendra")
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "Message Channel", NotificationManager.IMPORTANCE_DEFAULT));
        }
        else{
            notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.android_logo)
                    .setContentIntent(pendingIntent)
                    .setContentText("New message")
                    .setSubText("New Message from Narendra")
                    .build();
        }
        nm.notify(NOTIFICATION_ID, notification);

    }
}