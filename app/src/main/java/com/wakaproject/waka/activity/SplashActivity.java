package com.wakaproject.waka.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wakaproject.waka.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread th = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2500);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent obj = new Intent(SplashActivity.this, SliderActivity.class);
                    startActivity(obj);
                }
            }
        };
        th.start();
    }
    @Override
    public void onPause() {
        super.onPause();
        finish();

    }
}
