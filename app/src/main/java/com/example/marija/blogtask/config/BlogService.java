package com.example.marija.blogtask.config;


import com.example.marija.blogtask.model.BlogItem;
import com.example.marija.blogtask.model.Content;
import com.example.marija.blogtask.model.Token;
import com.example.marija.blogtask.model.UserPass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Marija on 23/5/2018.
 */

public interface BlogService {

    @POST("/login")
    Call<Token> getToken(@Header("Content-Type") String content_type,
                        @Header("Content-Length") int content_lng,
                        @Header("Accept") String accept,
                        @Body UserPass userPass);

    @GET("/blogs")
    Observable<List<BlogItem>> getPosts(@Header("X-Authorize") String token,
                                    @Header("Accept") String accept);

    @GET
    Call<Content> getItemDetails(@Header("X-Authorize") String auth,
                                       @Header("Accept") String accept,
                                       @Url String url);


}
