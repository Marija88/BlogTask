package com.example.marija.blogtask;

import com.example.marija.blogtask.model.Token;

/**
 * Created by Marija on 23/5/2018.
 */

public interface LoginViewInter {


    void successLogin(Token token);
    void showError(String error);
    void login(String email, String password);
}
