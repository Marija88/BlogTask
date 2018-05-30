package com.example.marija.blogtask;

import android.util.Log;

import com.example.marija.blogtask.config.ApiUtil;
import com.example.marija.blogtask.model.BlogItem;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.HttpException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Marija on 23/5/2018.
 */

public class BlogModel implements BlogModelInter {
    @Override
    public void getData(final OnFinishListener listener, String token) {
        ApiUtil.getService().getPosts(token, "application/json").
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<List<BlogItem>>() {
                    @Override
                    public void onCompleted() {
                        Log.i("getData", "finish");
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure(e+"");
                    }

                    @Override
                    public void onNext(List<BlogItem> items) {
                        listener.onFinish(items);
                    }
                });
    }



}
