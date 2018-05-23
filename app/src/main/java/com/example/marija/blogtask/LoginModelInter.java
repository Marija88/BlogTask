package com.example.marija.blogtask;

import com.example.marija.blogtask.model.Token;

/**
 * Created by Marija on 23/5/2018.
 */

public interface LoginModelInter {

    interface OnFinishListener{
        void onFinish(Token token);
        void onFailure(String error);
    }

    void getData(String email, String password, OnFinishListener listener);
}
