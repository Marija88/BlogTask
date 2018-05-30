package com.example.marija.blogtask.events;

import com.example.marija.blogtask.model.BlogItem;
import com.example.marija.blogtask.model.User;

/**
 * Created by Marija on 30/5/2018.
 */

public class ItemEvents {
    private BlogItem item;

    public ItemEvents(BlogItem item) {
        this.item = item;
    }

    public BlogItem getItem() {
        return item;
    }

    public void setItem(BlogItem item) {
        this.item = item;
    }
}
