package com.example.marija.blogtask.config;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Marija on 23/5/2018.
 */

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl){
        if (retrofit == null)
            retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).
                    baseUrl(baseUrl).
                    addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                    build();
        return retrofit;
    }
}
