package com.example.marija.blogtask;

import com.example.marija.blogtask.model.BlogItem;

import java.util.List;

/**
 * Created by Marija on 23/5/2018.
 */

public interface BlogViewInter {

    void showData(List<BlogItem> items);
    void showMessage(String s);
}
