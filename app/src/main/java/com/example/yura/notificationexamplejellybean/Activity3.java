package com.example.yura.notificationexamplejellybean;

import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.cancel(1);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity3);
//        String post1 = "ЖЫвотное";



/*
        post1 = getIntent().getStringExtra("hello");
        post1 = getIntent().getDataString();
        TextView infoTextView = (TextView)findViewById(R.id.textView3);
        infoTextView.setText(post1);
*/

    }


}

