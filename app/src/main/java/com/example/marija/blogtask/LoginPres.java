package com.example.marija.blogtask;

import android.content.SharedPreferences;

import com.example.marija.blogtask.database.AppDatabase;
import com.example.marija.blogtask.model.Token;
import com.example.marija.blogtask.model.User;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Marija on 23/5/2018.
 */

public class LoginPres implements PresenterInterface, LoginModelInter.OnFinishListener {

    private LoginViewInter viewInterface;
    private LoginModelInter modelInterface;
    private AppDatabase appDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();
    LoginPres(LoginViewInter viewInterface, LoginModelInter modelInterface, AppDatabase appDatabase){
        this.modelInterface = modelInterface;
        this.viewInterface = viewInterface;
        this.appDatabase = appDatabase;
    }


    @Override
    public void onDestroy() {
        if (viewInterface != null)
            viewInterface = null;
        AppDatabase.destroyInstance();
    }

    @Override
    public void onClicked(final String email, final String password) {
        viewInterface.showProgress(true);
        modelInterface.getData(email, password, this);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.userDao().insert(new User(1, email, password));
            }
        });


    }


    @Override
    public void onFinish(Token token) {
        viewInterface.successLogin(token);
        viewInterface.showProgress(false);

    }

    @Override
    public void onFailure(String s) {
        viewInterface.showProgress(false);
        viewInterface.showError(s);
    }
}
