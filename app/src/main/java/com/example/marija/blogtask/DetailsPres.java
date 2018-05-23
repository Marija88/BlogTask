package com.example.marija.blogtask;

import com.example.marija.blogtask.model.BlogItem;
import com.example.marija.blogtask.model.Content;

import java.util.List;

/**
 * Created by Marija on 23/5/2018.
 */

public class DetailsPres implements DetailsPresInter, DetailsModel.OnFinishListener{


    private DetailsViewInter viewInterface;
    private DetailsModelInter modelInterface;
    DetailsPres(DetailsViewInter viewInterface, DetailsModelInter modelInterface){
        this.modelInterface = modelInterface;
        this.viewInterface = viewInterface;
    }
    @Override
    public void onResume(String token, long id) {
        modelInterface.getData(this, token, id);

    }

    @Override
    public void onDestroy() {
        viewInterface = null;
    }


    @Override
    public void onFinish(Content content) {
        viewInterface.showData(content);
    }

    @Override
    public void onFailure() {
        viewInterface.showMessage("Error");
    }
}
