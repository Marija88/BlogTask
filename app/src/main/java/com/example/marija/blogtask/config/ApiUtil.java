package com.example.marija.blogtask.config;

/**
 * Created by Marija on 23/5/2018.
 */

public class ApiUtil {
        public static String BASE = "http://blogsdemo.creitiveapps.com";


        public static BlogService getService() {
            return RetrofitClient.getClient(BASE).create(BlogService.class);
        }

}
