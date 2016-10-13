package com.example.nguyen.lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen on 10/13/2016.
 */

public class FlickrFeed {
    private String title;
    private ArrayList<FlickrItem> items;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FlickrItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<FlickrItem> items) {
        this.items = items;
    }
}
