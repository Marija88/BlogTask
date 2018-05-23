package com.example.marija.blogtask.model;

/**
 * Created by Marija on 23/5/2018.
 */

public class UserPass {

    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserPass(String email, String password) {

        this.email = email;
        this.password = password;
    }

    private String password;

}
