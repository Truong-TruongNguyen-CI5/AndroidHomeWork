package com.example.nguyen.hw_note;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nguyen on 10/29/2016.
 */

public class NoteViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private static final List<Note> noteList = new ArrayList<>();

    public NoteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    public void bind(ItemNote itemNote){
        this.tvTitle.setText(itemNote.getTitle());
        noteList.add(new Note(itemNote.getTitle(), "", ""));
    }

    public static List<Note> getNoteList() {
        return noteList;
    }
}
