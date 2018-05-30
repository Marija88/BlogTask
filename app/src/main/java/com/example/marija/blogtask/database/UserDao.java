package com.example.marija.blogtask.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marija.blogtask.model.User;

/**
 * Created by Marija on 29/5/2018.
 */

@Dao
public interface UserDao {

        @Insert
        void insert(User... users);


        @Query("SELECT * from User WHERE User.id == 1")
        User getUser();

        @Query("DELETE from User WHERE User.id == 1")
        void deleteUser();
}
