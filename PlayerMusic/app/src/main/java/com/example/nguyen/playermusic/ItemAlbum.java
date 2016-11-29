package com.example.nguyen.playermusic;

import android.content.ClipData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Nguyen on 10/24/2016.
 */
public class ItemAlbum extends RealmObject {

    private String title;
    private int idImage;

    public ItemAlbum(){

    }

    public ItemAlbum(String title, int idImage) {
        this.title = title;
        this.idImage = idImage;
    }


    public String getTitle() {
        return title;
    }

    public int getIdImage() {
        return idImage;
    }


    public static List<ItemAlbum> ALBUM_LIST = new ArrayList<>();

    @Override
    public String toString() {
        return title + " " + idImage;
    }
}
