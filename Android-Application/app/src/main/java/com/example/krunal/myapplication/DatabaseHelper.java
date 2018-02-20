package com.example.krunal.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Krunal on 9/27/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FNAME";
    public static final String COL_3 = "LNAME";
    public static final String COL_4 = "UNAME";
    public static final String COL_5 = "PASSWORD";
    public static final String COL_6 = "MOBILENO";
    private static final String TAG = "Android";
    private static final String CREATE_TABLE="create table "
            + TABLE_NAME + "("
            + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_2 + " TEXT NOT NULL, "
            + COL_3 + " TEXT NOT NULL, "
            + COL_4 + " TEXT NOT NULL, "
            + COL_5 + " TEXT NOT NULL, "
            + COL_6 + " TEXT NOT NULL);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fname,String lname,String uname,String pass,String mob) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,fname);
        contentValues.put(COL_3,lname);
        contentValues.put(COL_4,uname);
        contentValues.put(COL_5,pass);
        contentValues.put(COL_6, mob);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean search(){
        Log.e(TAG,"kedar");
        SQLiteDatabase db = getReadableDatabase();
        Cursor mCursor;
        mCursor = db.rawQuery("SELECT * FROM " +TABLE_NAME, null);
        if(mCursor != null  && mCursor.getCount() > 0){
            Log.e(TAG,"108");
            return true;
        }
        else{
            Log.e(TAG,"kr");
            return true;
        }
    }



}
