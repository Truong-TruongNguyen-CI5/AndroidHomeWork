package com.example.nguyen.dailyquote.application;

import android.app.Application;

import com.example.nguyen.dailyquote.FileManager;
import com.example.nguyen.dailyquote.managers.Preferences;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Nguyen on 10/12/2016.
 */

public class QuoteApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.init(this);
        FileManager.init(this);
        //initImageLoader();
    }
    private void initImageLoader() { //init config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }
}
