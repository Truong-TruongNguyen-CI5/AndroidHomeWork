package com.example.nguyen.playermusic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyen.playermusic.ItemAlbum;
import com.example.nguyen.playermusic.MessageEvent;
import com.example.nguyen.playermusic.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nguyen on 10/25/2016.
 */

public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.im_album)
    ImageView imAlbum;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public AlbumViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }
    public void bind(ItemAlbum itemAlbum){
        imAlbum.setImageResource(itemAlbum.getIdImage());
        tvTitle.setText(itemAlbum.getTitle());
    }

    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new MessageEvent(new GenListActivity(), getAdapterPosition()));
    }
}
