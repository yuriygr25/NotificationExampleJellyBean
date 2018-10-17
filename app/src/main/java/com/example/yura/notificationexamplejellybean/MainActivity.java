package com.example.yura.notificationexamplejellybean;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView mInfoTextView;
    public String bigText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void sendActionNotification(View view) {
//            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            // Намерение для запуска второй активности
            Intent intent = new Intent(this, Activity2.class);
            Intent intent1 = new Intent(this, MainActivity.class);
//            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,  PendingIntent.FLAG_CANCEL_CURRENT);
            PendingIntent pendingIntent1 = PendingIntent.getActivity(this, 0, intent1,  0);


            // Строим уведомление
            Notification builder = new Notification.Builder(this)
                    .setContentIntent(pendingIntent)
                    .setTicker("Пришла посылка!")
                    .setContentTitle("Посылка")
                    .setDefaults(Notification.FLAG_INSISTENT|Notification.FLAG_AUTO_CANCEL)
                    .setContentText(
                            "Это я, почтальон Печкин. Принес для вас посылку")
                    .setSmallIcon(R.mipmap.ic_launcher)

                    .addAction(R.mipmap.ic_launcher_round, "Открыть", pendingIntent)
                    .addAction(R.mipmap.ic_launcher, "Отказаться", pendingIntent1)
                    .addAction(R.mipmap.ic_launcher, "Другой вариант", pendingIntent)

                    .setAutoCancel(true) // автоматически закрыть уведомление после нажатия
                    .setWhen(System.currentTimeMillis())
                    .build();

            // убираем уведомление, когда его выбрали
//            builder.flags |= Notification.FLAG_AUTO_CANCEL;

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, builder);
        }

    public void sendBigTextStyleNotification(View view) {

        Intent intent = new Intent(MainActivity.this, Activity3.class);
        bigText = "Это я, почтальон Печкин. Принес для вас посылку. "
                + "Только я вам ее не отдам. Потому что у вас документов нету. ";
        intent.putExtra("hello", bigText);
//        startActivity(intent);

//            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,  0);



        Notification.Builder builder = new Notification.Builder(this)
                .setTicker("Пришла посылка!")
                .setContentTitle("Уведомление с большим текстом")
                .setContentText("Это я, почтальон Печкин. Принес для вас посылку")
                .setSmallIcon(R.mipmap.ic_launcher)
                .addAction(R.mipmap.ic_launcher, "Запустить активность",pendingIntent)
                .setAutoCancel(true);

/*
        mInfoTextView = (TextView) findViewById(R.id.textView3);
        mInfoTextView.setText(bigText);
*/


        Notification notification = new Notification.BigTextStyle(builder)
                .bigText(bigText).build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());

    }

    public void sendBigPictureStyleNotification(View view) {
        Intent intent = new Intent(this, Activity4.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, intent, 0);

        Notification.Builder builder = new Notification.Builder(this);

        builder.setContentTitle("Большая посылка")
                .setTicker("Пришла посылка!")
                .setContentText("Уведомление с большой картинкой")
                .setSmallIcon(R.mipmap.ic_launcher)
                // большая картинка из ресурсов
                .setStyle(new Notification.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(),
                                R.drawable.cat)))
                .setAutoCancel(true)
                .addAction(R.mipmap.ic_launcher, "Запустить активность",
                        pendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(2, builder.build());
    }

    public void sendInboxStyleNotification(View view) {
        Intent intent = new Intent(this, Activity5.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, intent, 0);

        Notification.MessagingStyle messagingStyle = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            messagingStyle = new Notification.MessagingStyle
                    ("Вы");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            messagingStyle.setConversationTitle("Android chat")
                    .addMessage("Привет котаны!", System.currentTimeMillis(), "Мурзик")
                    .addMessage("А вы знали, что chat по-французски кошка?", System
                                    .currentTimeMillis(),
                            "Мурзик")
                    .addMessage("Круто!", System.currentTimeMillis(),
                            "Васька");
        }

        Notification.Builder builder = new Notification.Builder(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.setContentTitle("Уютный чатик")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setStyle(messagingStyle)
                    .setAutoCancel(true)
                    .addAction(R.mipmap.ic_launcher, "Запустить активность",
                            pendingIntent);
        }

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(3, builder.build());

    }


}
