package com.example.rssreader;

import android.content.Intent;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebView;

public class LauncherGIF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_launcher_gif);
        final WebView wv = (WebView) findViewById(R.id.wvsplash);
        wv.loadUrl("file:///android_asset/splashv3.gif");
        //setVolumeControlStream(AudioManager.STREAM_MUSIC);

//        setContentView(R.layout.activity_splash);
//        ImageView image = (ImageView) new ImageView(this);
//        image= (ImageView) findViewById(R.id.splashImages);
//        int res = getResources().getIdentifier("s1", "drawable", getPackageName());
//
//        image.setImageResource(res);



        Thread closeActivity = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    // Do some stuff
                    wv.loadUrl("file:///android_asset/splashv3.gif");

                } catch (Exception e) {
                    e.getLocalizedMessage();
                } finally {

                    Intent intent = new Intent(LauncherGIF.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        closeActivity.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
