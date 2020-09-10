package com.pvp.doctorapp.splash.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.utils.PrefManager;
import com.pvp.doctorapp.utils.Utilities;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    Handler handler;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        prefManager=new PrefManager(SplashActivity.this);
        if(prefManager.getSELECTLANG()==null)
        {
            prefManager.setSELECTLANG("en");

        }
        else
        {

        }

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