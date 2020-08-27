package com.pvp.doctorapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


import com.pvp.doctorapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.net.Uri.decode;

public class MainActivity extends AppCompatActivity {


    private static final String VIDEO = "https://vimeo.com/429156541";
    private WebView mWebView;
    private int currentPosition = 0;

    private static final String PLAYBACK = "playback";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // attaching layout xml
        setContentView(R.layout.activity_main);

        mWebView=findViewById(R.id.videoView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);

// how plugin is enabled change in API 8
        /*if (Build.VERSION.SDK_INT < 8) {
            mWebView.getSettings().setPluginsEnabled(true);
        } else {
            mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        }*/
        mWebView.loadUrl("http://player.vimeo.com/video/429156541?player_id=player&autoplay=1&title=0&byline=0&portrait=0&api=1&maxheight=480&maxwidth=800");


    }
}