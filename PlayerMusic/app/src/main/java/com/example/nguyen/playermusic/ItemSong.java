package com.example.nguyen.playermusic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen on 11/27/2016.
 */

public class ItemSong {


    public ItemSong(int idImage, String songName, String singerName) {
        this.idImage = idImage;
        this.songName = songName;
        this.singerName = singerName;
    }

    ItemSong(){

    }

    private int idImage;
    private String songName;
    private String singerName;

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public static final List<ItemSong> SONG_LIST = new ArrayList<>();
}
