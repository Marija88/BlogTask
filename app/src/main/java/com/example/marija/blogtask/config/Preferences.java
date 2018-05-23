package com.example.marija.blogtask.config;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Marija on 23/5/2018.
 */

public class Preferences {


        private static final Preferences INSTANCE = new Preferences();
        private static boolean mIsInitialized;


        private static SharedPreferences sharedPrefs = null;
        private static SharedPreferences.Editor sharedEditor = null;



        public interface Keys {
            final String TOKEN = "token";
            final String NOT_LOGGED_IN = "NOT_LOGGED";
            final String LOGGED_IN = "LOGGED_IN";
        }






}
