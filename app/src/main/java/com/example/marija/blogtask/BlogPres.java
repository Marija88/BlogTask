package com.example.marija.blogtask;

import com.example.marija.blogtask.model.BlogItem;

import java.util.List;

/**
 * Created by Marija on 23/5/2018.
 */

public class BlogPres implements BlogModelInter.OnFinishListener, BlogPresInter {

    private BlogViewInter viewInterface;
    private BlogModelInter modelInterface;
    BlogPres(BlogViewInter viewInterface, BlogModelInter modelInterface){
        this.modelInterface = modelInterface;
        this.viewInterface = viewInterface;
    }
    @Override
    public void onResume(String token) {
        modelInterface.getData(this, token);

    }

    @Override
    public void onDestroy() {
        viewInterface = null;
    }



    @Override
    public void onFinish(List<BlogItem> list) {
        viewInterface.showData(list);
    }

    @Override
    public void onFailure() {
        viewInterface.showMessage("Error");
    }
}
