package com.example.marija.blogtask;

import com.example.marija.blogtask.model.BlogItem;
import com.example.marija.blogtask.model.Content;

import java.util.List;

/**
 * Created by Marija on 23/5/2018.
 */

public interface DetailsModelInter {
    interface OnFinishListener{
        void onFinish(Content content);
        void onFailure();
    }

    void getData(OnFinishListener listener, String token, long id);
}
