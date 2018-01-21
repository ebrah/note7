package com.haikaroseworx.note7app.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.haikaroseworx.note7app.R;
import com.haikaroseworx.note7app.pojo.NoteCreator;
import com.haikaroseworx.note7app.pojo.NoteItem;
import com.haikaroseworx.note7app.pojo.NoteUpdater;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.haikaroseworx.note7app.activity.NoteDetailActivity.NOTE_KEY;

public class NoteCreatorActivity extends AppCompatActivity {

    private EditText title, note;
    private TextView save, cancel;
    private boolean isUpdate;
    private NoteItem noteItem;
    public static String UPDATE_INTENT_DATA = "UPDATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_creator);


        isUpdate = getIntent().getBooleanExtra(UPDATE_INTENT_DATA, false);


        title = findViewById(R.id.title);
        note = findViewById(R.id.note);

        if(isUpdate){
            noteItem = (NoteItem) getIntent().getSerializableExtra(NOTE_KEY);
            title.setText(noteItem.getTitle());
            note.setText(noteItem.getNote());
        }



        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(NoteCreatorActivity.this);

                if (isUpdate) {
                    alert.setTitle("Update note");
                } else {
                    alert.setTitle("Save note?");
                }

                alert.setMessage("Are you sure you want to persist the changes to this note?");

                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (isUpdate) {

                            noteItem.setTitle(title.getText().toString().trim());
                            noteItem.setNote(note.getText().toString().trim());

                            NoteUpdater.updateNote(getBaseContext(),noteItem);
                            Toast.makeText(getBaseContext(),"Note updated",Toast.LENGTH_LONG).show();
                            finish();


                        }else{
                            NoteItem noteItem = new NoteItem();
                            noteItem.setTitle(title.getText().toString().trim());
                            noteItem.setNote(note.getText().toString().trim());
                            String dateString = new SimpleDateFormat("EEE, d yyyy").format(new Date());
                            noteItem.setDate(dateString);
                            NoteCreator.createNote(getBaseContext(),noteItem);
                            Toast.makeText(getBaseContext(),"Note created",Toast.LENGTH_LONG).show();
                            finish();

                        }
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(NoteCreatorActivity.this);
                alert.setTitle("Cancel note creation");
                alert.setMessage("Are you sure , you want to cancel this operation?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
            }
        });
    }
}
