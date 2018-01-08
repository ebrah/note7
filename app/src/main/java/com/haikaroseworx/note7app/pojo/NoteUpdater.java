package com.haikaroseworx.note7app.pojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.haikaroseworx.note7app.data_manager.NoteDatabaseHelper;

/**
 * Created by hikaroseworx on 1/6/18.
 */

public class NoteUpdater {

    public static void updateNote( Context context,NoteItem noteItem){

        NoteDatabaseHelper databaseHelper = new NoteDatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        String whereClause = "id=?";
        String whereArgs[] = {String.valueOf(noteItem.getId())};

        ContentValues contentValues = new ContentValues();
        contentValues.put(NoteItem.TABLE_COLUMNS[0],noteItem.getId());
        contentValues.put(NoteItem.TABLE_COLUMNS[1],noteItem.getDate());
        contentValues.put(NoteItem.TABLE_COLUMNS[2],noteItem.getTitle());
        contentValues.put(NoteItem.TABLE_COLUMNS[3],noteItem.getNote());

        database.update("NOTEITEM",contentValues,whereClause,whereArgs);

    }
}
