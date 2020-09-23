package com.example.proyectosemana3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BaseDeDatos extends SQLiteOpenHelper {


    public BaseDeDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaContacto="CREATE TABLE "+ConstantesBaseDatos.TABLE_CONTACTS+"("+
                ConstantesBaseDatos.TABLE_CONTACTS_ID       +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE   +" TEXT, "+
                ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO +" TEXT, "+
                ConstantesBaseDatos.TABLE_CONTACTS_EMAIL    +" TEXT, "+
                ConstantesBaseDatos.TABLE_CONTACTS_FOTO     +" INTEGER"+
                ")";

        String queryCrearTableLikesCOntacto="CREATE TABLE "+ConstantesBaseDatos.TABLE_LIKES_CONTACT +"("+
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBaseDatos.TABLE_CONTACTS_ID_CONTACTO  +" INTEGER, "+
                ConstantesBaseDatos.TABLE_CONTACTS_CONTACT_NUMERO_LIKES  +" INTEGER, "+
                "FOREIGN KEY ("+ConstantesBaseDatos.TABLE_CONTACTS_ID_CONTACTO+") "+
                "REFERENCES "+ConstantesBaseDatos.TABLE_CONTACTS+"("+ConstantesBaseDatos.TABLE_CONTACTS_ID+")"+
                ")";


        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTableLikesCOntacto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ConstantesBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS"+ConstantesBaseDatos.TABLE_LIKES_CONTACT);
        onCreate(db);
    }


    public ArrayList<Contacto> obtenerTodosLosContactos(){
        ArrayList<Contacto>contactos=new ArrayList<>();
        String query="SELECT * FROM "+ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext()){
            Contacto contactoActual=new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            //contactoActual.setLikes();
            contactos.add(contactoActual);

        }
        db.close();

        return contactos;

    }

    public void insertarContacto(ContentValues contentValues){
        SQLiteDatabase db= this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS,null, contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues c){
        SQLiteDatabase db=this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACT,null,c);
        db.close();
    }

    public int obtenerLikesContacto(Contacto contacto){
        int likes=0;

        String query="SELECT COUNT("+ConstantesBaseDatos.TABLE_CONTACTS_CONTACT_NUMERO_LIKES+") "+
                " FROM "+ConstantesBaseDatos.TABLE_LIKES_CONTACT+
                " WHERE "+ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID+"="+contacto.getId();
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor registros= db.rawQuery(query,null);

        while (registros.moveToNext()){
            likes=registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
