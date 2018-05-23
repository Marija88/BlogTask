package com.example.marija.blogtask;

import com.example.marija.blogtask.model.BlogItem;

import java.util.List;

/**
 * Created by Marija on 23/5/2018.
 */

public interface BlogModelInter {

    interface OnFinishListener{
        void onFinish(List<BlogItem> list);
        void onFailure();
    }

    void getData(OnFinishListener listener, String token);
}
