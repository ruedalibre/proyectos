package com.example.reto2.casos_uso;

import android.database.Cursor;

import com.example.reto2.modelos.Servicio;

import java.util.ArrayList;

public class CasoUsoServicio {
    public ArrayList<Servicio> llenarListaServicios(Cursor cursor){
        ArrayList<Servicio> list = new ArrayList<>();
        if(cursor.getCount() == 0){
            return list;
        }else{
            while (cursor.moveToNext()){
                Servicio servicios = new Servicio(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getBlob(4)
                );
                list.add(servicios);
            }
            return list;
        }
    }
}
