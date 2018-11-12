package com.example.edgar.calculadoradenotas_upes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    String sql_create1 = "CREATE TABLE Notas(id_mat INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, namemateria TEXT, nota1 REAL, nota2 REAL, nota3 REAL)";
    String sql_create2 = "CREATE TABLE Notas(namemateria TEXT, nota1 REAL, nota2 REAL, nota3 REAL, version INTEGER)";

    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql_create1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Notas");
        db.execSQL(sql_create2);
    }
}
