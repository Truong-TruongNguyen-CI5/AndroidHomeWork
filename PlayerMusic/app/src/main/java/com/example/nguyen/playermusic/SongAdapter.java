package com.example.nguyen.playermusic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nguyen on 11/28/2016.
 */

public class SongAdapter extends RecyclerView.Adapter<SongViewHolder> {
    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView =  layoutInflater.inflate(R.layout.list_item_song, parent, false);
        SongViewHolder songViewHolder = new SongViewHolder(itemView);
        return songViewHolder;
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        ItemSong itemSong = ItemSong.SONG_LIST.get(position);
        holder.bind(itemSong);
    }

    @Override
    public int getItemCount() {
        return ItemSong.SONG_LIST.size();
    }

}
