package com.example.marija.blogtask.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Marija on 30/5/2018.
 */

//@Entity
public class Item {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private String imageUrl;

    public Item() {
    }
    @Ignore
    public Item(String title, String imageUrl, String description) {
//        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    @ColumnInfo
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
