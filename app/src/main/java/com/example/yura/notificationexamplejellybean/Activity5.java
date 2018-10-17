package com.example.yura.notificationexamplejellybean;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.cancel(3);


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity5);

    }


}

