package com.example.mypizza;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Pizza.db";
    public static final String TABLE_NAME = "CartList_table";
    public static final String COL_1 = "ItemID";

    public static final String COL_2 = "PizzaName";

    public static final String COL_3 = "Count";

    public static final String COL_4 = "Price";

    public static final String COL_5 = "Tax";

    public static final String COL_6 = "TotalPrice";
    public static final String COL_7 = "NetAmount";

    public boolean insertData(String pizzaName, int Count, Double price, Double tax, Double totalPrice, Double netAmount){

        SQLiteDatabase db = this.getWritableDatabase();

//        db.execSQL("delete from "+ TABLE_NAME);

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, pizzaName);
        contentValues.put(COL_3, Count);
        contentValues.put(COL_4, price);
        contentValues.put(COL_5, tax);
        contentValues.put(COL_6, totalPrice);
        contentValues.put(COL_7, netAmount);
        db.insert(TABLE_NAME, null, contentValues);

        return true;

    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ TABLE_NAME + "(ItemID INTEGER PRIMARY KEY AUTOINCREMENT, PizzaName TEXT, Count INTEGER, Price DOUBLE, Tax Double, Totalprice Double, NetAmount Double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        String[] selectionArgs = { "1"};
        Cursor res = db.rawQuery("select * from "+TABLE_NAME +" where "+ COL_3+">0",null);
        return res;

    }


    public void deleteData() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NAME);
    }
}
