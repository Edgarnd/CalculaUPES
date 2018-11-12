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

    public Button bot0, bot1, bot2, bot3, bot4, bot5;
    public Cursor row;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_subject);

        bot0 = (Button)findViewById(R.id.bot_sub0);
        bot1 = (Button)findViewById(R.id.bot_sub1);
        bot2 = (Button)findViewById(R.id.bot_sub2);
        bot3 = (Button)findViewById(R.id.bot_sub3);
        bot4 = (Button)findViewById(R.id.bot_sub4);
        bot5 = (Button)findViewById(R.id.bot_sub5);

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


        //HERE FOR ONE SUBJECTS
        if(amount > 0 && amount <= 6){
            //Toast.makeText(this, "Hay "+ amount + " materias.", Toast.LENGTH_SHORT).show();
            switch(amount){
                case 1:
                    while(bot0.getText().toString().isEmpty()){
                        for(int i = 1; i <= 50; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    bot0.setText(temp);
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    while(bot0.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    bot0.setText(temp);
                                }
                            }
                        }
                    }

                    while(bot1.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString())){
                                        bot1.setText(temp);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    while(bot0.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    bot0.setText(temp);
                                }
                            }
                        }
                    }

                    while(bot1.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString())){
                                        bot1.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot2.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString())){
                                        bot2.setText(temp);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    while(bot0.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    bot0.setText(temp);
                                }
                            }
                        }
                    }

                    while(bot1.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString())){
                                        bot1.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot2.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString())){
                                        bot2.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot3.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString()) && !temp.equals(bot2.getText().toString())){
                                        bot3.setText(temp);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 5:
                    while(bot0.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    bot0.setText(temp);
                                }
                            }
                        }
                    }

                    while(bot1.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString())){
                                        bot1.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot2.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString())){
                                        bot2.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot3.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString()) && !temp.equals(bot2.getText().toString())){
                                        bot3.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot4.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString()) && !temp.equals(bot2.getText().toString()) && !temp.equals(bot3.getText().toString())){
                                        bot4.setText(temp);
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    while(bot0.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    bot0.setText(temp);
                                }
                            }
                        }
                    }

                    while(bot1.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString())){
                                        bot1.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot2.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString())){
                                        bot2.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot3.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString()) && !temp.equals(bot2.getText().toString())){
                                        bot3.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot4.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString()) && !temp.equals(bot2.getText().toString()) && !temp.equals(bot3.getText().toString())){
                                        bot4.setText(temp);
                                    }
                                }
                            }
                        }
                    }

                    while(bot5.getText().toString().isEmpty()){
                        for(int i = 1; i <= 100; i++){
                            String indeex = String.valueOf(i);
                            row = db.rawQuery("SELECT namemateria FROM Notas WHERE id_mat=?",new String[]{indeex});
                            if(row.moveToFirst()){
                                String temp = row.getString(0);
                                if(!temp.isEmpty()){
                                    if(!temp.equals(bot0.getText().toString()) && !temp.equals(bot1.getText().toString()) && !temp.equals(bot2.getText().toString()) && !temp.equals(bot3.getText().toString()) && !temp.equals(bot4.getText().toString())){
                                        bot5.setText(temp);
                                    }
                                }
                            }
                        }
                    }
                    break;
                default:
                    Toast.makeText(this, "Nada! O B V I O", Toast.LENGTH_SHORT).show();
                    break;
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

    public void goSubjects(View view){
        int id = view.getId();
        String materia;
        switch(id){
            case R.id.bot_sub0:
                materia = bot0.getText().toString();
                if(!materia.isEmpty()){
                    Intent sub0 = new Intent(this, calculate0Act.class);
                    sub0.putExtra("materia", materia);
                    startActivity(sub0);

                }
                break;
            case R.id.bot_sub1:
                materia = bot1.getText().toString();
                if(!materia.isEmpty()){
                    Intent sub0 = new Intent(this, calculate0Act.class);
                    sub0.putExtra("materia", materia);
                    startActivity(sub0);
                }
                break;
            case R.id.bot_sub2:
                materia = bot2.getText().toString();
                if(!materia.isEmpty()){
                    Intent sub0 = new Intent(this, calculate0Act.class);
                    sub0.putExtra("materia", materia);
                    startActivity(sub0);
                }
                break;
            case R.id.bot_sub3:
                materia = bot3.getText().toString();
                if(!materia.isEmpty()){
                    Intent sub0 = new Intent(this, calculate0Act.class);
                    sub0.putExtra("materia", materia);
                    startActivity(sub0);
                }
                break;
            case R.id.bot_sub4:
                materia = bot4.getText().toString();
                if(!materia.isEmpty()){
                    Intent sub0 = new Intent(this, calculate0Act.class);
                    sub0.putExtra("materia", materia);
                    startActivity(sub0);
                }
                break;
            case R.id.bot_sub5:
                materia = bot5.getText().toString();
                if(!materia.isEmpty()){
                    Intent sub0 = new Intent(this, calculate0Act.class);
                    sub0.putExtra("materia", materia);
                    startActivity(sub0);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
