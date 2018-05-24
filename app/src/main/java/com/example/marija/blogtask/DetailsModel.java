package com.example.marija.blogtask;

import android.util.Log;

import com.example.marija.blogtask.config.ApiUtil;
import com.example.marija.blogtask.model.BlogItem;
import com.example.marija.blogtask.model.Content;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Marija on 23/5/2018.
 */

public class DetailsModel implements DetailsModelInter {
    @Override
    public void getData( final OnFinishListener listener, String token, long id) {
        ApiUtil.getService().getItemDetails(token, "application/json", "/blogs:"+id)
                .enqueue(new Callback<Content>() {
                    @Override
                    public void onResponse(Call<Content> call, Response<Content> response) {
                        if (response.code() == 200)
                            listener.onFinish(response.body());
                        else listener.onFailure(response.code()+"");
                    }

                    @Override
                    public void onFailure(Call<Content> call, Throwable t) {
                        listener.onFailure(t.getMessage());
                    }
                });
//                subscribeOn(Schedulers.io()).
//                observeOn(AndroidSchedulers.mainThread()).
//                subscribe(new Subscriber<Content>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.i("getData", "finish");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        listener.onFailure(e);
//                    }
//
//                    @Override
//                    public void onNext(Content content) {
//                        listener.onFinish(content);
//                    }
//                });
        }
    }

