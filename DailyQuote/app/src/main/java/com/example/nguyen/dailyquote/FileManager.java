package com.example.nguyen.dailyquote;

import android.content.Context;
import android.graphics.Bitmap;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;

/**
 * Created by Nguyen on 10/15/2016.
 */

public class FileManager {
    private final  static String IMAGE_DIR = "images";
    private Storage storage;

    public FileManager(Context context) {
        this.storage = SimpleStorage.getInternalStorage(context);
    }

    private static FileManager instance;
    public static FileManager getInstance(){
        return  instance;
    }
    public void createImage(Bitmap bitmap, String fileName){
        storage.createFile(IMAGE_DIR, fileName, bitmap );

    }
    public File imageLoadFile(String fileName){
        return storage.getFile(IMAGE_DIR, fileName);
    }
    public static void init(Context context){
        instance = new FileManager(context);
    }
}
