package com.example.marija.blogtask;

import android.util.Log;

import com.example.marija.blogtask.config.ApiUtil;
import com.example.marija.blogtask.model.BlogItem;
import com.example.marija.blogtask.model.Content;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Marija on 23/5/2018.
 */

public class DetailsModel implements DetailsModelInter {
    @Override
    public void getData( final OnFinishListener listener, String token, long id) {
        ApiUtil.getService().getItemDetails(token, "application/json", "/blogs:"+id).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<Content>() {
                    @Override
                    public void onCompleted() {
                        Log.i("getData", "finish");
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure();
                    }

                    @Override
                    public void onNext(Content content) {
                        listener.onFinish(content);
                    }
                });
        }
    }

