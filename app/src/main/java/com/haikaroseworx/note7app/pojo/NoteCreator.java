package com.haikaroseworx.note7app.pojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.haikaroseworx.note7app.data_manager.NoteDatabaseHelper;

/**
 * Created by hikaroseworx on 1/6/18.
 */

public class NoteCreator {

    public static void createNote( Context context,NoteItem noteItem){

        NoteDatabaseHelper databaseHelper = new NoteDatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteItem.TABLE_COLUMNS[1],noteItem.getDate());
        contentValues.put(NoteItem.TABLE_COLUMNS[2],noteItem.getTitle());
        contentValues.put(NoteItem.TABLE_COLUMNS[3],noteItem.getNote());

        if(database.insert(NoteItem.TABLE_NAME,null,contentValues)>0){
            Log.e("created code","code above 0");
        }else{
            Log.e("created code","code bellow 1");
        }
        database.close();
        databaseHelper.close();

    }
}
