package com.example.marija.blogtask;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.marija.blogtask.config.Preferences;
import com.example.marija.blogtask.model.BlogItem;
import com.example.marija.blogtask.model.Content;

import java.util.List;

public class DetailsActivity extends AppCompatActivity implements DetailsViewInter{

    private TextView textView;
    private DetailsPres detailsPres;
    String token;
    long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        token = getIntent().getExtras().getString(Preferences.Keys.TOKEN);
        id = getIntent().getExtras().getLong(Preferences.Keys._ID);
        textView = (TextView) findViewById(R.id.content_details);
        detailsPres = new DetailsPres(this, new DetailsModel());
    }

    @Override
    protected void onResume() {
        super.onResume();
        detailsPres.onResume(token, id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detailsPres.onDestroy();
    }

    @Override
    public void showData(Content content) {
        if (content != null)
            textView.setText(Html.fromHtml(content.getContent()));
    }

    @Override
    public void showMessage(String s) {
        DialogBuilder.createAlertDialog(this, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case DialogInterface.BUTTON_POSITIVE:
                        dialogInterface.dismiss();
                        detailsPres.onResume(token, id);
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        dialogInterface.dismiss();
                        finish();
                        break;
                }
            }
        }, s, "Error!", "Try again", "Ok").show();
    }


}
