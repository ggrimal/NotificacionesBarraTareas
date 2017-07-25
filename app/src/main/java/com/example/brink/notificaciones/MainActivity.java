package com.example.brink.notificaciones;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
        Notificaciones de la barra de Tareas al clicar un boton!
 */

public class MainActivity extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.notificacion);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Crear notificacion i elegir como sera la estructura de esta notificacion(loS ELMENTOS QUE TENDRA) --> FORMATO NOTIFICACION
                NotificationCompat.Builder manager = (NotificationCompat.Builder) new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(android.R.drawable.ic_dialog_alert)
                        .setContentTitle("Titulo")
                        .setContentText("Ejemplo de Notificacion")
                        .setPriority(2)
                        .setColor(Color.argb(0,400,100,100))
                        .setContentInfo("Info")
                        .setAutoCancel(true)
                        ;

                //Declarar iTENT para llevarnos a la actividad2 elegida al clicar el boton
                Intent intent = new Intent(MainActivity.this,MainActivity.class);

                //Para llamarlo es , se coge la actividad , el 0 son estados
                PendingIntent notItent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

                //Cargar los elementos a manager.
                manager.setContentIntent(notItent);

                //Crear
                NotificationManager notManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                //Cargarlo
                notManager.notify(0,manager.build());


            }
        });
    }



}
