package com.pvp.doctorapp.activities;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.pvp.doctorapp.R;
import com.teammandroid.dairyapplication.utils.Utilities;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        animation();
    }

    public void animation() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

             Utilities.launchActivity(SplashActivity.this, NewHomepageActivity.class, true);

            }
        }, 3000);
    }

}