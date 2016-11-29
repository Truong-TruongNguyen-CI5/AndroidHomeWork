package com.example.nguyen.playermusic;

import android.app.Activity;

/**
 * Created by Nguyen on 11/27/2016.
 */
public class MessageEvent {

    int position;

    Activity activity;

    public MessageEvent(Activity activity, int position) {
        this.activity = activity;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
