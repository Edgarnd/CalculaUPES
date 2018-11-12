package com.example.edgar.calculadoradenotas_upes.services;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.SupportActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import com.example.edgar.calculadoradenotas_upes.WelcomeAct;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseNotificacionesService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        /*
        String notificacion = remoteMessage.getData().get("body");
        Notificacion(notificacion);

        */
    }

    /*
    private void Notificacion(String notificacion){
        Intent idk = new Intent(WelcomeAct.notificacion);
        idk.putExtra("key_body", notificacion);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(idk);
    }
    */
}
