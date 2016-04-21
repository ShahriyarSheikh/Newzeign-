package com.example.rssreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "newzeign :p", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setTitle(null);
//        getActionBar().setSubtitle(null);
//
//        ImageView img = new ImageView(getApplicationContext());
//        img.setImageResource(R.drawable.newlogoz);
//        getActionBar().setCustomView(img);
//
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        ReadRss readRss=new ReadRss(this,recyclerView);
        readRss.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.home){
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickAboutUs(MenuItem item) {
        Intent aboutUs= new Intent(MainActivity.this,aboutusActivity.class);
        startActivity(aboutUs);
        finish();
    }

    public void onClickSettings(MenuItem item) {
        Intent aboutUs= new Intent(MainActivity.this, settingsActivity.class);
        startActivity(aboutUs);
        finish();
    }
}
