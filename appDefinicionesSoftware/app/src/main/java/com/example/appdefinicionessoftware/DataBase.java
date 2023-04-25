package com.example.appdefinicionessoftware;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    public static final String TABLA_DEFINICIONES = "TABLA_DEFINICIONES";
    public static final String COLUMNA_ID_DEFINICION = "COLUMNA_ID_DEFINICION";
    public static final String COLUMNA_NOMBRE_DEFINICION = "COLUMNA_NOMBRE_DEFINICION";
    public static final String COLUMNA_SIGLAS_DEFINICION = "COLUMNA_SIGLAS_DEFINICION";
    public static final String COLUMNA_DESCRIPCION_DEFINICION = "COLUMNA_DESCRIPCION_DEFINICION";

    public DataBase(@Nullable Context context) {
        super(context, "definiciones.db", null, 1);
    }

    //Esto es llamado la primera vez que la base de datos es accedida. Aqui va el codigo para crear
    //una nueba db
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Aqui se crean las tablas de la base de datos y se definen los tipos de datos de las columnas
        String createTableDefiniciones = "CREATE TABLE " + TABLA_DEFINICIONES + " ( " + COLUMNA_ID_DEFINICION + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMNA_NOMBRE_DEFINICION + " TEXT, " + COLUMNA_SIGLAS_DEFINICION + " TEXT, " + COLUMNA_DESCRIPCION_DEFINICION + " TEXT)";
        db.execSQL(createTableDefiniciones);
    }
    //Este metodo es llamado si la version de la base de datos cambia. Previene que los usuarios que
    //tengan una version anterior de la bd creasheen cuando se hacen cambios a la db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean deleteOne ( DefinicionesModel def ){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + TABLA_DEFINICIONES + " WHERE " + COLUMNA_ID_DEFINICION + " = " + def.getIdDefinicion();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }
    }
    public boolean addOne (DefinicionesModel def ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COLUMNA_NOMBRE_DEFINICION,def.getNombreDefinicion());
        cv.put(COLUMNA_SIGLAS_DEFINICION, def.getSiglasDefinicion());
        cv.put(COLUMNA_DESCRIPCION_DEFINICION, def.getDescripcionDefinicion());

        long insert = db.insert(TABLA_DEFINICIONES, null , cv );
        if( insert == -1){
            return false;
        } else {
            return true;
        }

    }

    public boolean editOne (DefinicionesModel def ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        String queryString = "UPDATE " + TABLA_DEFINICIONES + " SET " + COLUMNA_NOMBRE_DEFINICION + " = " + def.getNombreDefinicion() + ", " + COLUMNA_SIGLAS_DEFINICION + " = " + def.getSiglasDefinicion()
                + ", " + COLUMNA_DESCRIPCION_DEFINICION + " = " + def.getDescripcionDefinicion() + " WHERE " + COLUMNA_ID_DEFINICION + " = " + def.getIdDefinicion();
        cv.put(COLUMNA_NOMBRE_DEFINICION,def.getNombreDefinicion());
        cv.put(COLUMNA_SIGLAS_DEFINICION, def.getSiglasDefinicion());
        cv.put(COLUMNA_DESCRIPCION_DEFINICION, def.getDescripcionDefinicion());
        Cursor cursor = db.rawQuery(queryString, null); //el cursor es el set de resultados

        if(cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }
    }
    //Metodo para obtener lista de definiciones
    public List<DefinicionesModel> getDefiniciones() {

        List<DefinicionesModel> returnList = new ArrayList<>();
        //Toma la información de la db
        String queryString = "SELECT * FROM " + TABLA_DEFINICIONES;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null); //el cursor es el set de resultados

        if(cursor.moveToFirst()){
            //Se hace un bucle a traves del cursor y crea un nuevo objeto de UserModel los cuales se pondran en la lista que se retorna.
            do{
                int userID = cursor.getInt(0);
                String definicionNombre = cursor.getString(1);
                String definicionSiglas = cursor.getString(2);
                String definicionDescripcion = cursor.getString(3);

                DefinicionesModel def = new DefinicionesModel(userID, definicionNombre, definicionSiglas, definicionDescripcion);
                returnList.add(def);

            } while (cursor.moveToNext());
        } else {
            //Fallo, no anade nada a la lista
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
