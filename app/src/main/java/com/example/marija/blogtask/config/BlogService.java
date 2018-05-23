package com.example.marija.blogtask.config;


import com.example.marija.blogtask.model.Token;
import com.example.marija.blogtask.model.UserPass;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Marija on 23/5/2018.
 */

public interface BlogService {

    @POST("/login")
    Call<Token> getToken(@Header("Content-Type") String content_type,
                        @Header("Content-Length") int content_lng,
                        @Header("Accept") String accept,
                        @Body UserPass userPass);


}
