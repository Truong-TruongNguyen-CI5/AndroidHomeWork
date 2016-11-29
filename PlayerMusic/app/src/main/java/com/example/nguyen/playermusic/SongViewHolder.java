package com.example.nguyen.playermusic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Nguyen on 11/27/2016.
 */

public class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.im_song)
    CircleImageView imSong;
    @BindView(R.id.tv_songname)
    TextView tvSongName;
    @BindView(R.id.tv_singer)
    TextView tvSingerName;

    public SongViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(ItemSong itemSong){
        imSong.setImageResource(itemSong.getIdImage());
        tvSongName.setText(itemSong.getSongName());
        tvSingerName.setText(itemSong.getSingerName());
    }

    @Override
    public void onClick(View v) {

    }
}
