package com.example.marija.blogtask.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.marija.blogtask.model.BlogItem;
import com.example.marija.blogtask.model.User;

/**
 * Created by Marija on 29/5/2018.
 */

@Database(entities = {User.class, BlogItem.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;
    public abstract UserDao userDao();
    public abstract ItemsDao itemsDao();

    public static AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app-database")
//                    .allowMainThreadQueries()
                    .build();

        }
        return instance;

    }

    public static void destroyInstance(){
        instance = null;
    }
}
