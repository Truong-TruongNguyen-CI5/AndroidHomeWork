package com.example.nguyen.hw_note;

import android.content.ClipData;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nguyen on 10/29/2016.
 */

public class ItemNote  {

    public static final ItemNote ARRY[] = {
            new ItemNote("Tool for learning android"),
            new ItemNote("View"),
            new ItemNote("Activity")
    };

    private String title;

    public ItemNote(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static List<ItemNote> itemNoteList = new ArrayList<>(Arrays.asList(ARRY));


}
