package com.haikaroseworx.note7app.data_manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.haikaroseworx.note7app.pojo.NoteItem.NOTE_TABLE_SQL_CREATE;
import static com.haikaroseworx.note7app.pojo.NoteItem.NOTE_TABLE_SQL_DROP;

/**
 * Created by hikaroseworx on 1/6/18.
 */

public class NoteDatabaseHelper extends SQLiteOpenHelper{

    public static String DATABASE_NAME = "NOTE_DB";
    public static int DATABASE_VERSION = 1;



    public NoteDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( NOTE_TABLE_SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(NOTE_TABLE_SQL_DROP);
        onCreate(db);
    }
}
