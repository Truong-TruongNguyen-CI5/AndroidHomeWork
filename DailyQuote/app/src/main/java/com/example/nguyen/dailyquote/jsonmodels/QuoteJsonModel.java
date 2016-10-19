package com.example.nguyen.dailyquote.jsonmodels;

/**
 * Created by Nguyen on 10/12/2016.
 */

public class QuoteJsonModel {
    private String title;
    private String content;

    public QuoteJsonModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content.replace("\n", "");
    }

    public void setContent(String content) {
        this.content = content;
    }
}
