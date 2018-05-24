package com.example.marija.blogtask;

import android.util.Log;


import com.example.marija.blogtask.config.ApiUtil;
import com.example.marija.blogtask.model.Token;
import com.example.marija.blogtask.model.UserPass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Marija on 23/5/2018.
 */

public class LoginModel implements LoginModelInter {
    @Override
    public void getData(String email, String password, final OnFinishListener listener) {

        ApiUtil.getService().getToken("application/json", 68,"application/json",new UserPass(email, password)).
                enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if (response.code() == 200)
                            listener.onFinish(response.body());
                        else if(response.code() == 401)
                            listener.onFailure("Incoret username or password");
                        else listener.onFailure("Error!");
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        listener.onFailure("Network problem");
                    }
                });


    }
}
