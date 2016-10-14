package com.example.nguyen.makepostdemo;

/**
 * Created by Nguyen on 10/14/2016.
 */

public class Item {
    private String userId;
    private String link;
    private String body;

    public Item(String userId, String link, String body) {
        this.userId = userId;
        this.link = link;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
