package com.haikaroseworx.note7app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.haikaroseworx.note7app.R;
import com.haikaroseworx.note7app.adapter.NoteItemAdapter;
import com.haikaroseworx.note7app.pojo.NoteCreator;
import com.haikaroseworx.note7app.pojo.NoteItem;
import com.haikaroseworx.note7app.pojo.NoteReader;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private List<NoteItem> noteItemList;
    private NoteItemAdapter noteItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutManager = new LinearLayoutManager(getBaseContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        findViewById(R.id.add_note).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NoteCreatorActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        noteItemList = NoteReader.getAllNotes(getBaseContext());
        noteItemAdapter= new NoteItemAdapter(getBaseContext(),noteItemList);
        recyclerView.setAdapter(noteItemAdapter);

        if(noteItemList.size()>0){
            recyclerView.setVisibility(View.VISIBLE);
            findViewById(R.id.no_data).setVisibility(View.INVISIBLE);
        }else{
            recyclerView.setVisibility(View.INVISIBLE);
            findViewById(R.id.no_data).setVisibility(View.VISIBLE);
        }
    }
}
