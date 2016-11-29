package com.example.nguyen.playermusic;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nguyen.playermusic.ItemAlbum;
import com.example.nguyen.playermusic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenListActivity extends AppCompatActivity {
    @BindView(R.id.ln_gen)
    LinearLayout lnGen;
    @BindView(R.id.im_play)
    ImageView imPlay;
    @BindView(R.id.im_gen)
    ImageView imGen;
    @BindView(R.id.rcv_songs)
    RecyclerView rcvSongs;

    SongAdapter songAdapter;

    float width;
    float height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_list);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI() {

        songAdapter = new SongAdapter();

        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        height = metrics.heightPixels;
        imPlay.getLayoutParams().width = (int) (width* 0.2);
        imPlay.getLayoutParams().height = (int) (width*0.2);
        imPlay.requestLayout();

        imGen.setImageResource(ItemAlbum.ALBUM_LIST.get(getIntent().getIntExtra("POSITION", 0)).getIdImage());

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

//        ItemSong.SONG_LIST.add(new ItemSong(R.drawable.genre_0, "ABC", "XYZ"));
//
//        songAdapter.notifyDataSetChanged();
//
//        rcvSongs.setLayoutManager(manager);
//
//        rcvSongs.setAdapter(songAdapter);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        width =  lnGen.getWidth();
        height = lnGen.getHeight();

        imPlay.setX((width/5)*4);
        imPlay.setY((height*4)/9  - imPlay.getHeight()/2 );
        System.out.println(String.format("%s %s", imPlay.getX(), imPlay.getY()));
    }
}
