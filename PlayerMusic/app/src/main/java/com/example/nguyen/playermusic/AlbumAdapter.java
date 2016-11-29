package com.example.nguyen.playermusic;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyen.playermusic.ItemAlbum;
import com.example.nguyen.playermusic.R;

/**
 * Created by Nguyen on 10/25/2016.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder> {


    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView =  layoutInflater.inflate(R.layout.list_item_album, parent, false);
        AlbumViewHolder albumViewHolder = new AlbumViewHolder(itemView);
        return albumViewHolder;
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        ItemAlbum itemAlbum = ItemAlbum.ALBUM_LIST.get(position);
        holder.bind(itemAlbum);
    }

    @Override
    public int getItemCount() {
        return ItemAlbum.ALBUM_LIST.size();
    }

}
