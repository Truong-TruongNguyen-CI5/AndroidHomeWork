package com.example.nguyen.hw_note;

/**
 * Created by Nguyen on 10/29/2016.
 */

public class Note {

    private int id;
    private String title;
    private String content;
    private String time_created;

    public Note(int id, String title, String content, String time_created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.time_created = time_created;
    }

    public Note(String title, String content, String time_created) {
        this.title = title;
        this.content = content;
        this.time_created = time_created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime_created() {
        return time_created;
    }

    public void setTime_created(String time_created) {
        this.time_created = time_created;
    }
}
