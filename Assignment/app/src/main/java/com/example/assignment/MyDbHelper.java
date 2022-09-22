package com.example.assignment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Objects;

public class MyDbHelper extends SQLiteOpenHelper {
//    database name
    private static final String DATABASE_NAME = "MoneyDB";
//    table name
    private static final String TABLE_NAME = "money";
//    table keys
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_AMOUNT = "amount";
    private static final String KEY_REMARKS = "remarks";
//    database version
    private static final int DATABASE_VERSION = 1;

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        create table in database
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                KEY_CATEGORY + " TEXT, " +
                KEY_AMOUNT + " INTEGER, " +
                KEY_REMARKS + " TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(String category, String amount, String remarks){
//        to add data in the table
//        create a writable for the database table
        SQLiteDatabase db = this.getWritableDatabase();
//        create values to set in table
        ContentValues values = new ContentValues();

        values.put(KEY_CATEGORY, category);
        values.put(KEY_AMOUNT, amount);
        values.put(KEY_REMARKS, remarks);

//        insert the values into the table
        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<DataModel> getAllData(){
//        to get all the data from the table (except for income)
        SQLiteDatabase db = this.getReadableDatabase();

//        create cursor to iterate in table
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//        arraylist to fetch data to and pass further
        ArrayList<DataModel> arrayList = new ArrayList<>();

//        loop to check when data is empty, move cursor
        while (cursor.moveToNext()){
//            continue if category is income
            if (Objects.equals(cursor.getString(0), "Income")){
                continue;
            }

            DataModel model = new DataModel();
            model.category = cursor.getString(0);
            model.amount = cursor.getInt(1);
            model.remarks = cursor.getString(2);

            arrayList.add(model);
        }
        cursor.close();
        return arrayList;
    }

    public ArrayList<DataModel> getCategoryData(String category){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME
                + " WHERE " + KEY_CATEGORY + " = '" + category +"'", null);
        ArrayList<DataModel> arrayList = new ArrayList<>();
        if (cursor.getCount() == 0){
            return arrayList;
        }
        else {
            while (cursor.moveToNext()) {
                DataModel model = new DataModel();
                model.category = cursor.getString(0);
                model.amount = cursor.getInt(1);
                model.remarks = cursor.getString(2);

                arrayList.add(model);
            }
        }
        cursor.close();
        return arrayList;
    }

    public int getCategoryTotal(String category){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME
                + " WHERE " + KEY_CATEGORY + " = '" + category + "'", null);
        int sum=0;
        if (cursor.getCount() == 0){
            return 0;
        }
        else {
            while (cursor.moveToNext()) {
                sum = sum + cursor.getInt(1);
            }
        }
        cursor.close();
        return sum;
    }

    public int getTotal(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        int sum=0;
        if (cursor.getCount() == 0){
            return 0;
        }
        else {
            while (cursor.moveToNext()) {
                if (Objects.equals(cursor.getString(0), "Income")) {
                    continue;
                }
                sum = sum + cursor.getInt(1);
            }
        }
        cursor.close();
        return sum;
    }

    public int getCategoryCount(String category){
        SQLiteDatabase db = this.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME
                + " WHERE " + KEY_CATEGORY + " = '" + category + "'", null);
        return cursor.getCount();
    }
}
