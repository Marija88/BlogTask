package com.example.marija.blogtask.events;

import com.example.marija.blogtask.model.User;

/**
 * Created by Marija on 29/5/2018.
 */

public class UserEvents {
    private User user;

    public UserEvents(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
