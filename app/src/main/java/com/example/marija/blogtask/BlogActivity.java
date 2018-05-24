package com.example.marija.blogtask;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.marija.blogtask.config.Preferences;
import com.example.marija.blogtask.model.BlogItem;

import java.util.ArrayList;
import java.util.List;

public class BlogActivity extends AppCompatActivity implements BlogViewInter {

    String token;
    private BlogPres blogPres;
    private RecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        token = getIntent().getExtras().getString(Preferences.Keys.TOKEN);
//        Toast.makeText(this, token, Toast.LENGTH_SHORT).show();

        recyclerView = (RecyclerView) findViewById(R.id.rv_view);
        recyclerAdapter = new RecyclerAdapter(this, new ArrayList<BlogItem>(0), new RecyclerAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {
                Intent intent = new Intent(BlogActivity.this, DetailsActivity.class);
                intent.putExtra(Preferences.Keys.TOKEN, token);
                intent.putExtra(Preferences.Keys._ID, id);
                startActivity(intent);
//                Toast.makeText(BlogActivity.this, "Clicked id %d "+id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        recyclerView.setAdapter(recyclerAdapter);
        blogPres = new BlogPres(this, new BlogModel());

    }

    @Override
    protected void onResume() {
        super.onResume();
        blogPres.onResume(token);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        blogPres.onDestroy();
    }

    @Override
    public void showData(List<BlogItem> items) {
        recyclerAdapter.updateDisplayed(items);
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                DialogBuilder.createAlertDialog(this, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case DialogInterface.BUTTON_POSITIVE:
                                SharedPreferences.Editor preferences = getSharedPreferences(Preferences.Keys.LOGGED_IN, MODE_PRIVATE).edit();
                                preferences.putString(Preferences.Keys.TOKEN, null);
                                preferences.apply();
                                Intent intent = new Intent(BlogActivity.this, LoginActivity.class);
                                startActivity(intent);
                                dialogInterface.dismiss();
                                finish();
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                dialogInterface.dismiss();

                        }
                    }
                }, "Are you sure you want to logout?", null,"Yes", "No").show();

                break;
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);


        }
        return super.onOptionsItemSelected(item);
    }
}
