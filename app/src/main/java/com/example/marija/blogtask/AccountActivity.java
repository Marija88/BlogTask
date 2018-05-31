package com.example.marija.blogtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.marija.blogtask.database.AppDatabase;

public class AccountActivity extends AppCompatActivity implements DBViewInter {

    private TextView tv, tv2;
    private DBPresenter presenter;
    private AppDatabase appDatabase;

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        AppDatabase.destroyInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        appDatabase = AppDatabase.getInstance(this);
        presenter = new DBPresenter(this, appDatabase.userDao());

    }

    @Override
    public void showFields(String username, String password) {
        tv.setText(username);
        tv2.setText(password);
    }

    @Override
    public void showEmptyMessage() {

    }
}
