package com.haikaroseworx.note7app.pojo;

import java.io.Serializable;

/**
 * Created by hikaroseworx on 1/6/18.
 */

public class NoteItem implements Serializable{

    private int id;
    private String date;
    private String title;
    private String note;

    public static final String TABLE_NAME = "NOTEITEM";
    public static final String TABLE_COLUMNS[] = {"id","date","title","note"};
    public static final String NOTE_TABLE_SQL_CREATE="CREATE TABLE NOTEITEM(id INTEGER PRIMARY KEY,"+
            "date TEXT, title TEXT, note TEXT)";
    public static final String NOTE_TABLE_SQL_DROP = "DROP TABLE IF EXISTS NOTEITEM";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
