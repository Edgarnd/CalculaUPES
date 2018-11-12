package com.example.edgar.calculadoradenotas_upes;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

import static java.lang.String.valueOf;

public class calculate0Act extends AppCompatActivity {

    private EditText texton0, grade0, grade1, grade2;
    private TextView vwtxt0, txt_view_result;
    private ImageButton bot_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculate0);


        texton0 = (EditText)findViewById(R.id.editxt_subject);
        grade0 = (EditText)findViewById(R.id.editxt_grade1);
        grade1 = (EditText)findViewById(R.id.editxt_grade2);
        grade2 = (EditText)findViewById(R.id.editxt_grade3);

        bot_register = (ImageButton)findViewById(R.id.img_bot_save);

        vwtxt0 = (TextView)findViewById(R.id.txt_view_result);
        txt_view_result = (TextView)findViewById(R.id.txt_view_final);

        String materia = getIntent().getStringExtra("materia");

        if(!materia.equals("det")){
            texton0.setText(materia);
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin",null,1);
            SQLiteDatabase db = admin.getWritableDatabase();
            Cursor row = db.rawQuery("SELECT nota1, nota2, nota3 FROM Notas WHERE namemateria = ?", new String[]{materia});
            if(row.moveToFirst()){
                grade0.setText(row.getString(0));
                grade1.setText(row.getString(1));
                grade2.setText(row.getString(2));
            }
            bot_register.setEnabled(false);
            bot_register.setBackgroundColor(0xFF9A9A9A);
        }
    }


    //Method to Register a Subject
    public void Register(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String materia = texton0.getText().toString();

        if(!materia.isEmpty()){
            txt_view_result.setText("");
            vwtxt0.setText("");
            Cursor check = db.rawQuery("SELECT namemateria FROM Notas", null);
            int amount = check.getCount();
            if(amount == 6){
                txt_view_result.setText("");
                vwtxt0.setText("");
                Toast.makeText(this, "No puede registrar esta materia", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Ya tiene 6 materias registradas", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Debe eliminar alguna primero", Toast.LENGTH_SHORT).show();

            } else {

                Cursor check_reg = db.rawQuery("SELECT namemateria FROM Notas WHERE namemateria = ?", new String[]{materia});
                if(check_reg.moveToFirst()){
                    if(check_reg.getString(0).equals(materia)){
                        Toast.makeText(this, "La materia ya esta registrada.", Toast.LENGTH_SHORT).show();
                        texton0.setText("");
                        grade0.setText("");
                        grade1.setText("");
                        grade2.setText("");
                        return;
                    }
                }

                String nota1 = grade0.getText().toString();
                String nota2 = grade1.getText().toString();
                String nota3 = grade2.getText().toString();

                if(!nota1.isEmpty() && !nota2.isEmpty() && !nota3.isEmpty()){
                    //YES
                    float value_nota1 = Float.parseFloat(nota1);
                    float value_nota2 = Float.parseFloat(nota2);
                    float value_nota3 = Float.parseFloat(nota3);

                    if((value_nota1 > 0 && value_nota1 <= 10) && (value_nota2 > 0 && value_nota2 <= 10) && (value_nota3 > 0 && value_nota3 <= 10)){
                        ContentValues register = new ContentValues();
                        register.put("namemateria", materia);
                        register.put("nota1", nota1);
                        register.put("nota2", nota2);
                        register.put("nota3", nota3);
                        db.insert("Notas", null, register);
                        texton0.setText("");
                        grade0.setText("");
                        grade1.setText("");
                        grade2.setText("");
                        grade0.setBackgroundColor(0x00FFFFFF);
                        grade1.setBackgroundColor(0x00FFFFFF);
                        grade2.setBackgroundColor(0x00FFFFFF);
                        Toast.makeText(this, "Materia registrada", Toast.LENGTH_SHORT).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                        db.close();
                    } else {
                        if(value_nota1 < 0 || value_nota1 > 10){
                            grade0.setBackgroundColor(0xB2F4070B);
                        } else {
                            grade0.setBackgroundColor(0x00FFFFFF);
                        }

                        if(value_nota2 < 0 || value_nota2 > 10){
                            grade1.setBackgroundColor(0xB2F4070B);
                        } else {
                            grade1.setBackgroundColor(0x00FFFFFF);
                        }

                        if(value_nota3 < 0 || value_nota3 > 10){
                            grade2.setBackgroundColor(0xB2F4070B);
                        } else {
                            grade2.setBackgroundColor(0x00FFFFFF);
                        }

                        Toast.makeText(this, "Escriba notas reales", Toast.LENGTH_SHORT).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                    }

                } else if(!nota1.isEmpty() && !nota2.isEmpty() && nota3.isEmpty()){
                    //YES

                    float value_nota1 = Float.parseFloat(nota1);
                    float value_nota2 = Float.parseFloat(nota2);

                    if((value_nota1 > 0 && value_nota1 <= 10) && (value_nota2 > 0 && value_nota2 <= 10)){
                        ContentValues register = new ContentValues();
                        register.put("namemateria", materia);
                        register.put("nota1", nota1);
                        register.put("nota2", nota2);
                        db.insert("Notas", null, register);
                        texton0.setText("");
                        grade0.setText("");
                        grade1.setText("");
                        grade0.setBackgroundColor(0x00FFFFFF);
                        grade1.setBackgroundColor(0x00FFFFFF);
                        Toast.makeText(this, "Materia registrada", Toast.LENGTH_SHORT).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                        db.close();
                    } else {
                        if(value_nota1 < 0 || value_nota1 > 10){
                            grade0.setBackgroundColor(0xB2F4070B);
                        } else {
                            grade0.setBackgroundColor(0x00FFFFFF);
                        }

                        if(value_nota2 < 0 || value_nota2 > 10){
                            grade1.setBackgroundColor(0xB2F4070B);
                        } else {
                            grade1.setBackgroundColor(0x00FFFFFF);
                        }

                        Toast.makeText(this, "Escriba notas reales porfavor", Toast.LENGTH_SHORT).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                    }


                } else if(!nota1.isEmpty() && nota2.isEmpty() && nota3.isEmpty()){
                    //YES
                    float value_nota1 = Float.parseFloat(nota1);
                    if(value_nota1 > 0 && value_nota1 <= 10){
                        ContentValues register = new ContentValues();
                        register.put("namemateria", materia);
                        register.put("nota1", nota1);
                        db.insert("Notas", null, register);
                        texton0.setText("");
                        grade0.setText("");
                        grade0.setBackgroundColor(0x00FFFFFF);
                        Toast.makeText(this, "Materia registrada", Toast.LENGTH_SHORT).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                        db.close();
                    } else {
                        if(value_nota1 < 0 || value_nota1 > 10){
                            grade0.setBackgroundColor(0xB2F4070B);
                        }
                        Toast.makeText(this, "Escriba una nota real porfavor", Toast.LENGTH_SHORT).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                    }

                } else if(nota1.isEmpty() && nota2.isEmpty() && nota3.isEmpty()){
                    grade0.setBackgroundColor(0xB2F4070B);
                    Toast.makeText(this, "Registre almenos una nota", Toast.LENGTH_SHORT).show();
                    txt_view_result.setText("");
                    vwtxt0.setText("");
                } else if(nota1.isEmpty() && !nota2.isEmpty() && nota3.isEmpty()){
                    grade0.setBackgroundColor(0xB2F4070B);
                    Toast.makeText(this, "Complete las notas en orden", Toast.LENGTH_SHORT).show();
                    txt_view_result.setText("");
                    vwtxt0.setText("");
                } else if(nota1.isEmpty() && !nota2.isEmpty() && !nota3.isEmpty()){
                    grade0.setBackgroundColor(0xB2F4070B);
                    Toast.makeText(this, "Complete las notas en orden", Toast.LENGTH_SHORT).show();
                    txt_view_result.setText("");
                    vwtxt0.setText("");
                } else if(!nota1.isEmpty() && nota2.isEmpty() && !nota3.isEmpty()){
                    grade1.setBackgroundColor(0xB2F4070B);
                    Toast.makeText(this, "Complete las notas en orden", Toast.LENGTH_SHORT).show();
                    txt_view_result.setText("");
                    vwtxt0.setText("");
                } else if(nota1.isEmpty() && nota2.isEmpty() && !nota3.isEmpty()){
                    grade0.setBackgroundColor(0xB2F4070B);
                    grade1.setBackgroundColor(0xB2F4070B);
                    Toast.makeText(this, "Complete las notas en orden", Toast.LENGTH_SHORT).show();
                    txt_view_result.setText("");
                    vwtxt0.setText("");
                }

                db.close();
            }

        } else {
            Toast.makeText(this, "Escribe el nombre de la materia.", Toast.LENGTH_SHORT).show();
            txt_view_result.setText("");
            vwtxt0.setText("");
        }
    }

    //Method to Search
    /*
    public void Search(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String materia = texton0.getText().toString();

        if(!materia.isEmpty()){
            Cursor row = db.rawQuery("SELECT nota1, nota2, nota3 FROM Notas WHERE namemateria =?", new String[]{materia});
            if(row.moveToFirst()){
                grade0.setText(row.getString(0));
                grade1.setText(row.getString(1));
                grade2.setText(row.getString(2));
                db.close();
            } else {
                Toast.makeText(this, "La Materia no esta registrada", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Ingrese el nombre de la materia", Toast.LENGTH_SHORT).show();
            texton0.setText("");
            grade0.setText("");
            grade1.setText("");
            grade2.setText("");
        }
    }
    */

    //Method to Modify
    public void Modify(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String materia = texton0.getText().toString();

        if(!materia.isEmpty()) {
            String nota1 = grade0.getText().toString();
            String nota2 = grade1.getText().toString();
            String nota3 = grade2.getText().toString();

            ContentValues editvalues = new ContentValues();

            if(!nota1.isEmpty()){
                float value_nota1 = Float.parseFloat(nota1);
                editvalues.put("nota1", nota1);
                if(!nota2.isEmpty() && !nota3.isEmpty()){
                    editvalues.put("nota2", nota2);
                    editvalues.put("nota3", nota3);

                    float value_nota2 = Float.parseFloat(nota2);
                    float value_nota3 = Float.parseFloat(nota3);

                    if((value_nota1 > 0 && value_nota1 <= 10) && (value_nota2 > 0 && value_nota2 <= 10) && (value_nota3 > 0 && value_nota3 <= 10)){
                        db.update("Notas", editvalues,"namemateria = ?", new String[]{materia});
                        Toast.makeText(this, "Se modifico la materia", Toast.LENGTH_SHORT).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                        db.close();
                        Intent goto_welcome = new Intent(this, WelcomeAct.class);
                        startActivity(goto_welcome);
                        this.finish();

                    } else {
                        if(value_nota1 < 0 || value_nota1 > 10){
                            grade0.setBackgroundColor(0xB2F4070B);
                        }else {
                            grade0.setBackgroundColor(0x00FFFFFF);
                        }

                        if(value_nota2 < 0 || value_nota2 > 10){
                            grade1.setBackgroundColor(0xB2F4070B);
                        } else {
                            grade1.setBackgroundColor(0x00FFFFFF);
                        }

                        if(value_nota3 < 0 || value_nota3 > 10){
                            grade2.setBackgroundColor(0xB2F4070B);
                        } else {
                            grade2.setBackgroundColor(0x00FFFFFF);
                        }

                        Toast.makeText(this, "Escriba notas reales", Toast.LENGTH_SHORT).show();
                    }


                } else if(!nota2.isEmpty() && nota3.isEmpty()){
                    editvalues.put("nota2", nota2);
                    editvalues.put("nota3", "");

                    float value_nota2 = Float.parseFloat(nota2);

                    if((value_nota1 > 0 && value_nota1 <= 10) && (value_nota2 > 0 && value_nota2 <= 10)){
                        db.update("Notas", editvalues,"namemateria = ?", new String[]{materia});
                        Toast.makeText(this, "Se modifico la materia", Toast.LENGTH_SHORT).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                        db.close();
                        Intent goto_welcome = new Intent(this, WelcomeAct.class);
                        startActivity(goto_welcome);
                        this.finish();
                    } else {
                        if(value_nota1 < 0 || value_nota1 > 10){
                            grade0.setBackgroundColor(0xB2F4070B);
                        } else {
                            grade0.setBackgroundColor(0x00FFFFFF);
                        }

                        if(value_nota2 < 0 || value_nota2 > 10){
                            grade1.setBackgroundColor(0xB2F4070B);
                        } else {
                            grade1.setBackgroundColor(0x00FFFFFF);
                        }

                        Toast.makeText(this, "Escriba notas reales", Toast.LENGTH_SHORT).show();
                    }

                } else if(nota2.isEmpty() && !nota3.isEmpty()){
                    grade1.setBackgroundColor(0xB2F4070B);
                    Toast.makeText(this, "Debe completar los registros en orden\nPorfavor complete Registro 2", Toast.LENGTH_SHORT).show();
                } else if(nota2.isEmpty() && nota3.isEmpty()){
                    editvalues.put("nota2","");
                    editvalues.put("nota3","");

                    if(value_nota1 < 0 || value_nota1 > 10){
                        Toast.makeText(this, "Escriba una nota real", Toast.LENGTH_SHORT).show();
                        grade0.setBackgroundColor(0xB2F4070B);
                    } else {
                        db.update("Notas", editvalues,"namemateria = ?", new String[]{materia});
                        Toast.makeText(this, "Se modifico la materia", Toast.LENGTH_SHORT).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                        db.close();
                        Intent goto_welcome = new Intent(this, WelcomeAct.class);
                        startActivity(goto_welcome);
                        this.finish();
                    }

                }


            } else {
                grade0.setBackgroundColor(0xB2F4070B);
                Toast.makeText(this, "Debe completar los registros en orden\nPorfavor complete Registro 1", Toast.LENGTH_LONG).show();
                txt_view_result.setText("");
                vwtxt0.setText("");
            }


        } else {
            Toast.makeText(this, "Escribe el nombre de la materia", Toast.LENGTH_SHORT).show();
            txt_view_result.setText("");
            vwtxt0.setText("");
        }

    }

    //Method to Delete
    public void Delete(View view){
        final AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        final SQLiteDatabase db = admin.getWritableDatabase();

        final String materia = texton0.getText().toString();

        if(!materia.isEmpty() && !materia.equals(".") && !materia.equals(";") && !materia.equals("<") && !materia.equals(">") && !materia.equals("/") && !materia.equals("?") && !materia.equals(",")){
            AlertDialog.Builder confirm = new AlertDialog.Builder(this);
            confirm.setTitle("Confirmar eliminar");
            confirm.setMessage("¿Seguro desea eliminar esta materia?");
            confirm.setIcon(android.R.drawable.stat_sys_warning);
            confirm.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            confirm.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    int quantify = db.delete("Notas", "namemateria = ?", new String[]{materia});
                    db.close();
                    if(quantify == 1){
                        Intent goto_welcome = new Intent(calculate0Act.this, WelcomeAct.class);
                        goto_welcome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(goto_welcome);
                        Toast.makeText(calculate0Act.this, "Se elimino la materia", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(calculate0Act.this, "La materia no esta registrada", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }
            });

            AlertDialog view_confirm = confirm.create();
            view_confirm.show();
        } else {
            Toast.makeText(this, "Esta materia no esta registrada aun.", Toast.LENGTH_SHORT).show();
        }
    }

    //Method to Evaluate
    public void Evaluate(View view){
        DecimalFormat formatter = new DecimalFormat("#0.0");
        String gradeS0 = grade0.getText().toString();
        String gradeS1 = grade1.getText().toString();
        String gradeS2 = grade2.getText().toString();


        if(gradeS0.isEmpty() && gradeS1.isEmpty() && gradeS2.isEmpty()){
            Toast.makeText(this, "Buena Suerte!", Toast.LENGTH_SHORT).show();
        } else if(!gradeS0.isEmpty() && gradeS1.isEmpty() && gradeS2.isEmpty()){
            txt_view_result.setText("");
            vwtxt0.setText("");
            //SHOW RESULTS AND INFORMATION
            if(gradeS0.equals(".")){
                grade0.setText("");
                grade1.setText("");
                grade2.setText("");
                Toast.makeText(this, "Ingrese una nota valida no puntos por favor", Toast.LENGTH_SHORT).show();
                return;
            }
            //We parse the information
            double gradeD0 = Double.parseDouble(gradeS0);



            if(gradeD0 >= 6 && gradeD0 <= 10){
                double you_have = gradeD0 * 0.30; // Less Result / 1.8
                double total = 6 - you_have;
                double idk = total - 2.4;
                double need_second_value = idk / 0.30;
                double idk_zero = 6 - (idk + you_have);
                double need_thrid_value = idk_zero / 0.40;
                String need_second_r = formatter.format(need_second_value);
                String need_third_r = formatter.format(need_thrid_value);
                Toast.makeText(this, "Aprobaste el primer registro\n" +
                                                  "Necesitas " + need_second_r + " Registro 2\n" +
                                                  "Necesitas " + need_third_r + " Registro 3", Toast.LENGTH_LONG).show();
            }else {
                if(gradeD0 < 0 || gradeD0 > 10){
                    if(gradeD0 < 0 || gradeD0 > 10){
                        grade0.setBackgroundColor(0xB2F4070B);
                    } else {
                        grade0.setBackgroundColor(0x00FFFFFF);
                    }
                    Toast.makeText(this, "Ingrese una nota valida por favor", Toast.LENGTH_SHORT).show();
                    return;
                }

                double you_have = gradeD0 * 0.30; //0.
                if(you_have < 0.6 && you_have > 0.30){
                    if(gradeD0 < 0 || gradeD0 > 10){
                        grade0.setBackgroundColor(0xB2F4070B);
                    } else {
                        grade0.setBackgroundColor(0x00FFFFFF);
                    }

                    double total = 6 - you_have; //5.43 - 5.85
                    double idk = total - 2.4; // 3.03 - 3.35
                    double need_second_value = idk / 0.35; //
                    double idk_zero = 6 - (idk + you_have);
                    double need_thrid_value = idk_zero / 0.35; //  6.85
                    String need_second_r = formatter.format(need_second_value);
                    String need_third_r = formatter.format(need_thrid_value);
                    Toast.makeText(this, "Desaprobaste el primer registro\n" +
                            "Necesitas " + need_second_r + " Registro 2\n" +
                            "Necesitas " + need_third_r + " Registro 3", Toast.LENGTH_LONG).show();

                } else if(you_have <= 0.30){
                    double total = 6 - you_have; //5.7
                    double idk = total - 2.4; // 3.3
                    double need_second_value = idk / 0.40; // 8.25
                    double idk_zero = 6 - (idk + you_have); // 2.4
                    double need_thrid_value = idk_zero / 0.30; // 8
                    String need_second_r = formatter.format(need_second_value);
                    String need_third_r = formatter.format(need_thrid_value);
                    Toast.makeText(this, "Desaprobaste el primer registro\n" +
                            "Necesitas " + need_second_r + " Registro 2\n" +
                            "Necesitas " + need_third_r + " Registro 3", Toast.LENGTH_LONG).show();
                } else if(you_have >= 0.6){
                    double total = 6 - you_have;
                    double idk = total / 2;
                    double need_second_value = idk / 0.35;
                    double need_thrid_value = idk / 0.35;
                    String need_second_r = formatter.format(need_second_value);
                    String need_third_r = formatter.format(need_thrid_value);
                    Toast.makeText(this, "Desaprobaste el primer registro\n" +
                            "Necesitas " + need_second_r + " Registro 2\n" +
                            "Necesitas " + need_third_r + " Registro 3", Toast.LENGTH_LONG).show();
                }
            }


        } else if(gradeS0.isEmpty() && !gradeS1.isEmpty() && gradeS2.isEmpty()){
            txt_view_result.setText("");
            vwtxt0.setText("");
            if(gradeS1.equals(".")){
                grade0.setText("");
                grade1.setText("");
                grade2.setText("");
                Toast.makeText(this, "Ingrese notas no puntos por favor", Toast.LENGTH_SHORT).show();
                return;
            }

            float gradeD1 = Float.parseFloat(gradeS1);

            if(gradeD1 < 0 || gradeD1 > 10){
                grade1.setBackgroundColor(0xB2F4070B);
            } else {
                grade1.setBackgroundColor(0x00FFFFFF);
            }

            grade0.setBackgroundColor(0xB2F4070B);
            grade2.setBackgroundColor(0xB2F4070B);
            Toast.makeText(this, "          Complete en orden\nPara ver el resultado o información", Toast.LENGTH_SHORT).show();
        } else if(gradeS0.isEmpty() && gradeS1.isEmpty() && !gradeS2.isEmpty()){
            txt_view_result.setText("");
            vwtxt0.setText("");
            if(gradeS2.equals(".")){
                grade0.setText("");
                grade1.setText("");
                grade2.setText("");
                Toast.makeText(this, "Ingrese notas no puntos por favor", Toast.LENGTH_SHORT).show();
                return;
            }

            float gradeF2 = Float.parseFloat(gradeS2);
            if(gradeF2 < 0 || gradeF2 > 10){
                grade2.setBackgroundColor(0xB2F4070B);
            } else {
                grade2.setBackgroundColor(0x00FFFFFF);
            }

            grade0.setBackgroundColor(0xB2F4070B);
            grade1.setBackgroundColor(0xB2F4070B);
            Toast.makeText(this, "          Complete en orden\nPara ver el resultado o información", Toast.LENGTH_SHORT).show();
        } else if(!gradeS0.isEmpty() && !gradeS1.isEmpty() && gradeS2.isEmpty()){
            //SHOW RESULTS AND INFORMATION
            if(gradeS0.equals(".") || gradeS1.equals(".")){
                grade0.setText("");
                grade1.setText("");
                grade2.setText("");
                Toast.makeText(this, "Ingrese notas no puntos por favor", Toast.LENGTH_SHORT).show();
                txt_view_result.setText("");
                vwtxt0.setText("");
                return;
            }

            double gradeD0 = Double.parseDouble(gradeS0);
            double gradeD1 = Double.parseDouble(gradeS1);

            if(gradeD0 < 0 || gradeD0 > 10){
                grade0.setBackgroundColor(0xB2F4070B);
            } else {
                grade0.setBackgroundColor(0x00FFFFFF);
            }

            if(gradeD1 < 0 || gradeD1 > 10){
                grade1.setBackgroundColor(0xB2F4070B);
            } else {
                grade1.setBackgroundColor(0x00FFFFFF);
            }

            if((gradeD0 >= 6 && gradeD0 <= 10) && (gradeD1 >= 6 && gradeD1 <= 10)){
                double i_have = (gradeD0 * 0.3)+(gradeD1 * 0.3);
                double total = 6 - i_have;
                double idk_0 = total / 0.4;
                String need_third_r = formatter.format(idk_0);
                Toast.makeText(this, "Aprobaste el primer registro\n" +
                        "Aprobaste el segundo registro\n" +
                        "Necesitas " + need_third_r + " Registro 3", Toast.LENGTH_LONG).show();
                txt_view_result.setText("");
                vwtxt0.setText("");

            } else {
                if(gradeD0 < 0 || gradeD0 > 10 || gradeD1 < 0 || gradeD1 > 10){
                    if(gradeD0 < 0 || gradeD0 > 10){
                        grade0.setBackgroundColor(0xB2F4070B);
                    } else {
                        grade0.setBackgroundColor(0x00FFFFFF);
                    }

                    if(gradeD1 < 0 || gradeD1 > 10){
                        grade1.setBackgroundColor(0xB2F4070B);
                    } else {
                        grade1.setBackgroundColor(0x00FFFFFF);
                    }
                    Toast.makeText(this, "Ingrese notas validas por favor", Toast.LENGTH_SHORT).show();
                    txt_view_result.setText("");
                    vwtxt0.setText("");
                    return;
                }

                if(gradeD0 >= 6 && gradeD1 < 6){
                    double you_have = (gradeD0 * 0.30) + (gradeD1 * 0.30);
                    double idk_0 = 6 - you_have;
                    double need_third_value = idk_0 / 0.40;
                    if(need_third_value > 10.4){
                        Toast.makeText(this, "  Aprobaste el primer registro\n" +
                                "Desaprobaste el segundo registro\n" +
                                "   Necesitas 10 en Registro 3\n" +
                                "     Podria ir o NO a EGC", Toast.LENGTH_LONG).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                    } else {
                        String need_third_r = formatter.format(need_third_value);
                        Toast.makeText(this, "  Aprobaste el primer registro\n" +
                                "Desaprobaste el segundo registro\n" +
                                "   Necesitas " + need_third_r + " en Registro 3", Toast.LENGTH_LONG).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                    }

                } else if(gradeD0 < 6 && gradeD1 >= 6){
                    double you_have = (gradeD0 * 0.30) + (gradeD1 * 0.30);
                    double idk_0 = 6 - you_have;
                    double need_third_value = idk_0 / 0.40;
                    if(need_third_value > 10.4){
                        Toast.makeText(this, "Desaprobaste el primer registro\n" +
                                "Aprobaste el segundo registro\n" +
                                "   Necesitas 10 en Registro 3\n" +
                                "     Podria ir o NO a EGC", Toast.LENGTH_LONG).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                    } else {
                        String need_third_r = formatter.format(need_third_value);
                        Toast.makeText(this, "Desaprobaste el primer registro\n" +
                                "Aprobaste el segundo registro\n" +
                                "   Necesitas " + need_third_r + " en Registro 3", Toast.LENGTH_LONG).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                    }
                } else if(gradeD0 < 6 && gradeD1 < 6){
                    double you_have = (gradeD0 * 0.30) + (gradeD1 * 0.30);
                    double idk_0 = 6 - you_have;
                    double need_third_value = idk_0 / 0.40;
                    if(need_third_value > 10 && need_third_value <= 15){
                        Toast.makeText(this, "Desaprobaste el primer registro\n" +
                                "Desaprobaste el segundo registro\n" +
                                "   Necesitas 10 en Registro 3\n" +
                                "     Podria ir o NO a EGC", Toast.LENGTH_LONG).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                    } else if(need_third_value >= 6 && need_third_value <= 10){
                        String need_third_r = formatter.format(need_third_value);
                        Toast.makeText(this, "Desaprobaste el primer registro\n" +
                                "Desaprobaste el segundo registro\n" +
                                "   Necesitas " + need_third_r +" en Registro 3\n" +
                                "     Podria ir o NO a EGC", Toast.LENGTH_LONG).show();
                        txt_view_result.setText("");
                        vwtxt0.setText("");
                    }
                }


            }


        } else if(gradeS0.isEmpty() && !gradeS1.isEmpty() && !gradeS2.isEmpty()){
            if(gradeS1.equals(".") || gradeS2.equals(".")){
                grade0.setText("");
                grade1.setText("");
                grade2.setText("");
                Toast.makeText(this, "Ingrese notas no puntos por favor", Toast.LENGTH_SHORT).show();
                txt_view_result.setText("");
                vwtxt0.setText("");
                return;
            }

            float gradeF1 = Float.parseFloat(gradeS1);
            float gradeF2 = Float.parseFloat(gradeS2);

            if(gradeF1 < 0 || gradeF1 > 10){
                grade1.setBackgroundColor(0xB2F4070B);
            } else {
                grade1.setBackgroundColor(0x00FFFFFF);
            }

            if(gradeF2 < 0 || gradeF2 > 10){
                grade2.setBackgroundColor(0xB2F4070B);
            } else {
                grade2.setBackgroundColor(0x00FFFFFF);
            }

            grade0.setBackgroundColor(0xB2F4070B);
            Toast.makeText(this, "          Complete en orden\nPara ver el resultado o información", Toast.LENGTH_SHORT).show();
            txt_view_result.setText("");
            vwtxt0.setText("");
        } else if(!gradeS0.isEmpty() && gradeS1.isEmpty() && !gradeS2.isEmpty()){
            if(gradeS0.equals(".") || gradeS2.equals(".")){
                grade0.setText("");
                grade1.setText("");
                grade2.setText("");
                Toast.makeText(this, "Ingrese notas no puntos por favor", Toast.LENGTH_SHORT).show();
                txt_view_result.setText("");
                vwtxt0.setText("");
                return;
            }

            float gradeF0 = Float.parseFloat(gradeS0);
            float gradeF2 = Float.parseFloat(gradeS2);

            if(gradeF0 < 0 || gradeF0 > 10){
                grade0.setBackgroundColor(0xB2F4070B);
            } else {
                grade0.setBackgroundColor(0x00FFFFFF);
            }

            if(gradeF2 < 0 || gradeF2 > 10){
                grade2.setBackgroundColor(0xB2F4070B);
            } else {
                grade2.setBackgroundColor(0x00FFFFFF);
            }

            grade1.setBackgroundColor(0xB2F4070B);
            Toast.makeText(this, "          Complete en orden\nPara ver el resultado o información", Toast.LENGTH_SHORT).show();
            txt_view_result.setText("");
            vwtxt0.setText("");
        } else if(!gradeS0.isEmpty() && !gradeS1.isEmpty() && !gradeS2.isEmpty()){
            //SHOW RESULTS OR INFORMATION AND ITS COMPLETED
            if(gradeS0.equals(".") || gradeS1.equals(".") || gradeS2.equals(".")){
                grade0.setText("");
                grade1.setText("");
                grade2.setText("");
                Toast.makeText(this, "Ingrese notas no puntos por favor", Toast.LENGTH_SHORT).show();
                txt_view_result.setText("");
                vwtxt0.setText("");
                return;
            }

            double gradeD0 = Double.parseDouble(gradeS0);
            double gradeD1 = Double.parseDouble(gradeS1);
            double gradeD2 = Double.parseDouble(gradeS2);

            if(gradeD0 > 10 || gradeD0 < 0 || gradeD1 > 10 || gradeD1 < 0 || gradeD2 > 10 || gradeD2 < 0){
                Toast.makeText(this, "Ingrese notas reales por favor", Toast.LENGTH_SHORT).show();
                txt_view_result.setText("");
                vwtxt0.setText("");
                if(gradeD0 < 0 || gradeD0 > 10){
                    grade0.setBackgroundColor(0xB2F4070B);
                } else {
                    grade0.setBackgroundColor(0x00FFFFFF);
                }

                if(gradeD1 < 0 || gradeD1 > 10){
                    grade1.setBackgroundColor(0xB2F4070B);
                } else {
                    grade1.setBackgroundColor(0x00FFFFFF);
                }

                if(gradeD2 < 0 || gradeD2 > 10){
                    grade2.setBackgroundColor(0xB2F4070B);
                } else {
                    grade2.setBackgroundColor(0x00FFFFFF);
                }
                return;
            }

            double total = (gradeD0 * 0.30) + (gradeD1 * 0.30) + (gradeD2 * 0.40);
            if(total >= 5.95){
                grade0.setBackgroundColor(0x00FFFFFF);
                grade1.setBackgroundColor(0x00FFFFFF);
                grade2.setBackgroundColor(0x00FFFFFF);
                txt_view_result.setText("Promedio final");
                String result = formatter.format(total);
                vwtxt0.setText("Aprobo la asignatura con " + result);
            } else if(total <= 5.94){
                grade0.setBackgroundColor(0x00FFFFFF);
                grade1.setBackgroundColor(0x00FFFFFF);
                grade2.setBackgroundColor(0x00FFFFFF);
                txt_view_result.setText("Promedio final");
                if(total >= 3.25 && total <= 5.99){
                    String result = formatter.format(total);
                    vwtxt0.setText("Desaprobo con " + result + "\nPuede ir a EGC.");
                } else {
                    String result = formatter.format(total);
                    vwtxt0.setText("Desaprobo con " + result + "\nNo puede ir a EGC.");
                }
            }
        }

    }
}
