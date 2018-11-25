package com.duxetech.spinner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    public DBHelper(Context context) {

        super(context, "places.db", null, '1');
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table countries(country varchar)");
        db.execSQL("create table states(state varchar)");
        db.execSQL("create table cities(city varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void getCountry(){
        db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from countries",null);
        while(c.moveToNext()){
            c.getString(0);
        }
    }

    void getState(){
        db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from states",null);
        while(c.moveToNext()){
            c.getString(0);
        }
    }
    void getCity(){
        db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from cities",null);
        while(c.moveToNext()){
            c.getString(0);
        }
    }

    void insert(){
        db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put("");
    }

}
