package com.example.marija.blogtask;

import com.example.marija.blogtask.database.AppDatabase;
import com.example.marija.blogtask.database.UserDao;
import com.example.marija.blogtask.events.UserEvents;
import com.example.marija.blogtask.model.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Marija on 29/5/2018.
 */

public class DBPresenter implements DBPresenterInter{

    private DBViewInter dbViewInter;
    private UserDao userDao;
    private Executor executor = Executors.newSingleThreadExecutor();


    public DBPresenter(DBViewInter dbViewInter, UserDao userDao){
        this.dbViewInter = dbViewInter;
        this.userDao = userDao;
    }
    @Override
    public void onResume() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                User user = userDao.getUser();
                EventBus.getDefault().post(new UserEvents(user));
            }
        });

        EventBus.getDefault().register(this);
//        showUserAndPass();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showUserAndPass(UserEvents user) {
        dbViewInter.showFields(user.getUser().getEmail(), user.getUser().getPassword());
    }

    @Override
    public void onDestroy() {
        AppDatabase.destroyInstance();
        dbViewInter = null;
        EventBus.getDefault().unregister(this);
    }


}
