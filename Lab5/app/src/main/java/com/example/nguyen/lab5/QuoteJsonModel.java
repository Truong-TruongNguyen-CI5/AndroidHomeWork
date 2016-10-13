package com.example.nguyen.lab5;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen on 10/12/2016.
 */

public class QuoteJsonModel implements Serializable {
    private String title;
    private String body;
    private String userId;

    public QuoteJsonModel(String title, String content, String userId) {
        this.title = title;
        this.body = content;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return getTitle() + getBody() + getUserId();
    }
}
