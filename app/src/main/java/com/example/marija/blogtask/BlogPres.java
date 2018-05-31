package com.example.marija.blogtask;

import android.content.Context;

import com.example.marija.blogtask.database.AppDatabase;
import com.example.marija.blogtask.events.ItemEvents;
import com.example.marija.blogtask.events.ItemsEvents;
import com.example.marija.blogtask.events.UserEvents;
import com.example.marija.blogtask.model.BlogItem;
//import com.example.marija.blogtask.model.Item;
import com.example.marija.blogtask.model.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Marija on 23/5/2018.
 */

public class BlogPres implements BlogModelInter.OnFinishListener, BlogPresInter {

    private BlogViewInter viewInterface;
    private BlogModelInter modelInterface;
    private List<ItemEvents> itemList;
    private AppDatabase appDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();
    BlogPres(BlogViewInter viewInterface, BlogModelInter modelInterface){
        this.modelInterface = modelInterface;
        this.viewInterface = viewInterface;
    }
    @Override
    public void onResume(String token) {
        viewInterface.showProgress(true);
        modelInterface.getData(this, token);
        appDatabase = AppDatabase.getInstance((Context) viewInterface);

    }

    @Override
    public void onDestroy() {
        viewInterface = null;
        AppDatabase.destroyInstance();
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void onFinish(final List<BlogItem> list) {
        viewInterface.showData(list);
        viewInterface.showProgress(false);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int count = appDatabase.itemsDao().countItems();
                if (count == 0) {
                    appDatabase.itemsDao().insertItems(list);
                }

            }
        });
    }

    @Override
    public void onFailure(String e) {
        viewInterface.showProgress(false);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<BlogItem> itemList = appDatabase.itemsDao().getAllItems();
                EventBus.getDefault().post(itemList);
            }
        });

        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void showOldFields(List<BlogItem> itemsEvents) {
        List<BlogItem> blogItem = itemsEvents;
        viewInterface.showData(itemsEvents);
        viewInterface.showMessage("This is old posts");
//    }
//        viewInterface.showMessage(blogItem.toString());
    }


}
