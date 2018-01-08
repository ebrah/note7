package com.haikaroseworx.note7app.pojo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.haikaroseworx.note7app.data_manager.NoteDatabaseHelper;

import java.sql.SQLClientInfoException;

/**
 * Created by hikaroseworx on 1/6/18.
 */

public class NoteDeleter {

    public void deleteAll(Context context){

    }

    public static void deleteNote(Context context, NoteItem noteItem){

        NoteDatabaseHelper databaseHelper = new NoteDatabaseHelper(context);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        String whereClause = "id=?";
        String whereArgs[] ={String.valueOf(noteItem.getId())};

        database.delete(NoteItem.TABLE_NAME,whereClause,whereArgs);
        database.close();
        databaseHelper.close();

    }
}
