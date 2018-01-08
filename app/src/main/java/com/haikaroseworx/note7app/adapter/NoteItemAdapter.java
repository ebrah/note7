package com.haikaroseworx.note7app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haikaroseworx.note7app.R;
import com.haikaroseworx.note7app.activity.NoteDetailActivity;
import com.haikaroseworx.note7app.pojo.NoteItem;

import java.util.List;

/**
 * Created by hikaroseworx on 1/6/18.
 */

public class NoteItemAdapter extends RecyclerView.Adapter<NoteItemAdapter.NoteViewHolder>{

    private List<NoteItem> noteItemList;
    private Context context;

    public NoteItemAdapter(Context context , List<NoteItem> noteItems){
        this.context = context;
        this.noteItemList = noteItems;
    }


    @Override
    public int getItemCount() {
        return noteItemList.size();
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(view);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.setData(noteItemList.get(position));
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title, note ,date;

        public NoteViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.title);
            note = view.findViewById(R.id.note);
            date = view.findViewById(R.id.date);

            view.setOnClickListener(this);
        }

        public void setData(NoteItem noteItem){
            title.setText(noteItem.getTitle());
            note.setText(noteItem.getNote());
            date.setText(noteItem.getDate());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, NoteDetailActivity.class);
            intent.putExtra(NoteDetailActivity.NOTE_KEY,noteItemList.get(getAdapterPosition()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
