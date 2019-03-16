package com.example.edgar.calculadoradenotas_upes;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class selectSubjectAct extends AppCompatActivity {

    public static final String notificacion = "Notificación";

    private BroadcastReceiver broadcastReceiver;
    public Cursor row;
    private LinearLayout ll_botones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_subject);

        /*
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String body_notificacion = intent.getStringExtra("body");
                AlertDialog.Builder show_notificacion = new AlertDialog.Builder(selectSubjectAct.this);
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
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"admin",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor check = db.rawQuery("SELECT id_mat FROM Notas", null);
        int amount = check.getCount();

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        ll_botones = (LinearLayout)findViewById(R.id.layout_bots_materias);

        //HERE FOR ONE SUBJECTS
        if(amount > 0 && amount <= 6){
            for(int i = 1; i <= amount; i++){
                final Button bot_materia = new Button(this);
                final Cursor row_materia = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat = ?",
                        new String[]{String.valueOf(i)});
                if(row_materia.moveToFirst()){
                    bot_materia.setText(row_materia.getString(0));
                    bot_materia.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    bot_materia.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent sub0 = new Intent(selectSubjectAct.this, calculate0Act.class);
                            sub0.putExtra("materia", bot_materia.getText().toString());
                            startActivity(sub0);
                        }
                    });
                    bot_materia.setTextColor(getResources().getColor(R.color.colorAccent));
                    ll_botones.addView(bot_materia);
                }
            }
        } else {
            Toast.makeText(this, "No hay materias registradas aun.", Toast.LENGTH_SHORT).show();

        }
    }

    /*

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver, new IntentFilter(notificacion));
    }


    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter(notificacion));
    }

    */

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
