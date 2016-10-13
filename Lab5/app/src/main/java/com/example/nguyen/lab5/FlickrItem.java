package com.example.nguyen.lab5;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nguyen on 10/13/2016.
 */

public class FlickrItem {
    private String title;
    private String link;
    @SerializedName("date_taken")
    private String dateTaken;

    public FlickrItem(String title, String link, String dateTaken) {
        this.title = title;
        this.link = link;
        this.dateTaken = dateTaken;
    }

    public String getTitle() {
        return title;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    Media media;

    public String getLink(){
        return media.getLink();
    }

    private class Media{
        @SerializedName("m")
        private String link;

        public String getLink() {
            return link;
        }
    }
}
