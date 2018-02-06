package com.haikaroseworx.note7app.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.haikaroseworx.note7app.R;
import com.haikaroseworx.note7app.pojo.NoteDeleter;
import com.haikaroseworx.note7app.pojo.NoteItem;
import com.haikaroseworx.note7app.pojo.NoteShare;

import static com.haikaroseworx.note7app.activity.NoteCreatorActivity.UPDATE_INTENT_DATA;

public class NoteDetailActivity extends AppCompatActivity {

    private TextView noteTitle, note , date , update , delete;
    private NoteItem noteItem;
    public static String NOTE_KEY = "NOTE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        noteItem = (NoteItem)getIntent().getSerializableExtra(NOTE_KEY);

        noteTitle = findViewById(R.id.note_title);
        note = findViewById(R.id.note);
        date = findViewById(R.id.date);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        noteTitle.setText(noteItem.getTitle());
        note.setText(noteItem.getNote());
        date.setText(noteItem.getDate());

        findViewById(R.id.share_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                NoteShare.shareNote(NoteDetailActivity.this,noteItem);
            }
        });

        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteDetailActivity.this, NoteCreatorActivity.class);
                intent.putExtra(NOTE_KEY,noteItem);
                intent.putExtra(UPDATE_INTENT_DATA,true);
                startActivity(intent);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(NoteDetailActivity.this);
                alertDialog.setTitle("Note deletion");
                alertDialog.setMessage("Are you sure you want to delete this note?");
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NoteDeleter.deleteNote(NoteDetailActivity.this,noteItem);
                        finish();
                    }
                });

                alertDialog.setNegativeButton("NO",null);
                alertDialog.show();
            }
        });

    }
}
