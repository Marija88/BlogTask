package com.example.marija.blogtask.model;

/**
 * Created by Marija on 23/5/2018.
 */

public class Content {
    public Content(String content) {
        this.content = content;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;
}
