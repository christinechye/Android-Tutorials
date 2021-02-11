package com.example.webview_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.webkit.WebView;

import android.os.Bundle;
import android.webkit.WebViewClient;
import android.util.Log;
import android.webkit.WebSettings;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    private WebView webView;
    String foodID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        foodID = getIntent().getStringExtra("food");
        String url = "https://en.wikipedia.org/wiki/" + foodID;

        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}