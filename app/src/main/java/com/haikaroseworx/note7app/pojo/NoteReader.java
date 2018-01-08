package com.haikaroseworx.note7app.pojo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.haikaroseworx.note7app.data_manager.NoteDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hikaroseworx on 1/6/18.
 */

public class NoteReader {

    public  static List<NoteItem> getAllNotes(Context context){

        List<NoteItem> noteItemList = new ArrayList<>();

        NoteDatabaseHelper db = new NoteDatabaseHelper(context);
        SQLiteDatabase database= db.getReadableDatabase();


        Cursor cursor = database.query("NOTEITEM",
                new String[]{"id","date","title","note"},null,null,null,null,null);

        cursor.moveToFirst();
        while(cursor.moveToNext()){

            NoteItem noteItem = new NoteItem();
            noteItem.setId(cursor.getInt(0));
            noteItem.setDate(cursor.getString(1));
            noteItem.setTitle(cursor.getString(2));
            noteItem.setNote(cursor.getString(3));
            noteItemList.add(noteItem);

        }

        cursor.close();
        database.close();


        return noteItemList;

    }
}
