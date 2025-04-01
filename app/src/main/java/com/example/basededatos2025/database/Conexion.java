package com.example.basededatos2025.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {


    //Cadena para crear la tabla
    final String CREAR_TABLA_CLIENTES = "CREATE TABLE clientes(clave INTEGER PRIMARY KEY, nombre TEXT, sueldo FLOAT)";
    public Conexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_CLIENTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Eliminar la tabla si existe
        db.execSQL("DROP TABLE IF EXISTS clientes");
        //Crear la tabla nuevamente
        this.onCreate(db);
    }
}
