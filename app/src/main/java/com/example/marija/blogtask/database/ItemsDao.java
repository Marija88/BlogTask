package com.example.marija.blogtask.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marija.blogtask.events.ItemEvents;
import com.example.marija.blogtask.events.ItemsEvents;
import com.example.marija.blogtask.model.BlogItem;

import java.util.List;

/**
 * Created by Marija on 30/5/2018.
 */
@Dao
public interface ItemsDao {

    @Insert
    void insertItems(List<BlogItem> items);

    @Query("SELECT * from BlogItem")
    List<BlogItem> getAllItems();

    @Query("SELECT COUNT(*) from BlogItem")
    int countItems();

}
