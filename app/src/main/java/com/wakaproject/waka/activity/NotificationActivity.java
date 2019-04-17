package com.wakaproject.waka.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.wakaproject.waka.R;
import com.wakaproject.waka.base.BaseActivity;
import com.wakaproject.waka.mainfragment.HomeFragment;
import com.wakaproject.waka.mainfragment.MallFragment;
import com.wakaproject.waka.mainfragment.ProfileFragment;

public class NotificationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Thông báo");

    }
}
