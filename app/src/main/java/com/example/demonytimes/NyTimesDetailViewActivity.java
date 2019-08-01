package com.example.demonytimes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by: Ashwani Kumar
 * Date: 31-07-2019
 */
public class NyTimesDetailViewActivity extends AppCompatActivity {

    public static final String POST_URL_KEY = "post_url_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ny_times_detail_view);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getIntent().getStringExtra(POST_URL_KEY));
    }
}
