package com.boyhotkey96.funnystories.Fragment.DanhSachTruyen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.boyhotkey96.funnystories.R;

public class LuotWeb extends AppCompatActivity {
    WebView wvLinktruyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_luot_web);

        String link = getIntent().getStringExtra("LINK");

        if (link != null) {
            wvLinktruyen.loadUrl("http://fb.me");
        }

    }
}
