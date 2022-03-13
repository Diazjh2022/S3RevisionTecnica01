package com.example.s3revisiontecnica01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionBD extends SQLiteOpenHelper {
    public ConexionBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table revisionT(CodigoIngreso int primary key,FechaHora DATE DEFAULT CURRENT_TIMESTAMP,Documentacion text,Patente text,Direccion text," +
                "Frenos text,Neumaticos_y_llantas text,Suspencion text,Alineacion text,Seguridad text,Cinturones text," +
                "Luces text,Puertas int ,Vidrios text,Tubo_De_Escape text,Gases text,Observaciones text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
