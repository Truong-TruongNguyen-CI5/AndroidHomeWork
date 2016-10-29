package com.example.nguyen.hw_note;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nguyen on 10/29/2016.
 */

public class ItemNoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView =  layoutInflater.inflate(R.layout.item_note_simple, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(itemView) ;

        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        ItemNote itemNote = ItemNote.itemNoteList.get(position);
        System.out.println(itemNote.getTitle().toString());
        holder.bind(itemNote);

    }

    @Override
    public int getItemCount() {
        return ItemNote.itemNoteList.size();
    }
}
