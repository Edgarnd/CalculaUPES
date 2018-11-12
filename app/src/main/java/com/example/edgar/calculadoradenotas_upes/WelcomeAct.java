package com.example.edgar.calculadoradenotas_upes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.edgar.calculadoradenotas_upes.services.FirebaseId;
import com.example.edgar.calculadoradenotas_upes.services.FirebaseNotificacionesService;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

public class WelcomeAct extends AppCompatActivity {

    /*
    THESE THINGS:
    -volley
    -n_request
    -ip_server
    -requestJSON()
    -verifyFirstStep()
    -verifyNotificacion()
    -USER
    -PASSWORD

    USE WHEN YOU HAVE USERS AND PASSWORDS [ONLY]
     */
    private VolleyRP volley;
    private RequestQueue n_request;

    public static final String notificacion = "Notificación";

    private BroadcastReceiver broadcastReceiver;

    private static String ip_server = "https://calculaupes.000webhostapp.com/filesphp/Login_GETID.php?id=";
    private String USER = "";
    private String PASSWORD = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        volley = VolleyRP.getInstance(this);
        n_request = volley.getRequestQueue();

        //Get the token to PHP
        //String TOKEN = FirebaseInstanceId.getInstance().getToken();

        /*
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String body_notificacion = intent.getStringExtra("key_body");
                AlertDialog.Builder show_notificacion = new AlertDialog.Builder(WelcomeAct.this);
                show_notificacion.setIcon(android.R.drawable.stat_notify_chat);
                show_notificacion.setTitle("Nueva notificación");
                show_notificacion.setMessage(body_notificacion);
                show_notificacion.setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = show_notificacion.create();
                alertDialog.show();
            }
        };

        */
    }
    /*

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter(notificacion));
    }

    */

    //Method to Register a Subject(->calculate_0)
    public void Register(View view){
        Intent register = new Intent(this, calculate0Act.class);
        register.putExtra("materia", "det");
        startActivity(register);
    }

    //Method to View Subject(->selectSubject_0)
    public void Subjects(View view){
        Intent viewSubjects = new Intent(this, selectSubjectAct.class);
        startActivity(viewSubjects);
    }

    //Method to Developer Information
    public void Developer(View view){
        Intent dev = new Intent(this, InfDevActivity.class);
        startActivity(dev);
    }

    /*
    public void requestJSON(String url_server){
        JsonObjectRequest request = new JsonObjectRequest(url_server, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject info) {
                verifyFirstStep(info);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WelcomeAct.this, "Error, contactese con el administrador por favor", Toast.LENGTH_SHORT).show();
            }
        });

        VolleyRP.addToQueue(request, n_request,this,volley);
    }


    public void verifyFirstStep(JSONObject info){
        //Controlamos el JSON
        try {
            String result_request = info.getString("resultado");
            if(result_request.equals("CC")){
                JSONObject idk = new JSONObject(info.getString("datos"));
                String user = idk.getString("id");
                String pass = idk.getString("notificacion");
                if(user.equals(USER) && pass.equals(PASSWORD)){
                    Toast.makeText(this, "Bienvenido/a :D", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                }
                //Go to other activity but until have clients-users
            }
        } catch (JSONException e) {
        }

    }

    public void verifyNotificacion(String id){
        requestJSON(ip_server+id);
    }
    */
}
