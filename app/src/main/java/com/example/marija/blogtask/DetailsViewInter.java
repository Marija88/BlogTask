package com.example.marija.blogtask;

import com.example.marija.blogtask.model.BlogItem;
import com.example.marija.blogtask.model.Content;

import java.util.List;

/**
 * Created by Marija on 23/5/2018.
 */

public interface DetailsViewInter {

    void showData(Content items);
    void showMessage(String s);
}
