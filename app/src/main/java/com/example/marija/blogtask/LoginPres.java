package com.example.marija.blogtask;

import android.content.SharedPreferences;

import com.example.marija.blogtask.model.Token;

/**
 * Created by Marija on 23/5/2018.
 */

public class LoginPres implements PresenterInterface, LoginModelInter.OnFinishListener {

    private LoginViewInter viewInterface;
    private LoginModelInter modelInterface;
    LoginPres(LoginViewInter viewInterface, LoginModelInter modelInterface){
        this.modelInterface = modelInterface;
        this.viewInterface = viewInterface;
    }


    @Override
    public void onDestroy() {
        if (viewInterface != null)
            viewInterface = null;
    }

    @Override
    public void onClicked(String email, String password) {
        modelInterface.getData(email, password, this);
    }


    @Override
    public void onFinish(Token token) {
        viewInterface.successLogin(token);

    }

    @Override
    public void onFailure(String s) {
        viewInterface.showError(s);
    }
}
