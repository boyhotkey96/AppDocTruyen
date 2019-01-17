package com.boyhotkey96.funnystories.Fragment.RSSTruyen;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.boyhotkey96.funnystories.R;

public class LuotActivity extends AppCompatActivity {

    WebView vv;
    String link;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_activity_luot);
        vv = (WebView) findViewById(R.id.vv);

        link = getIntent().getExtras().getString("link");
        Toast.makeText(this, link, Toast.LENGTH_SHORT).show();

        dialog = new ProgressDialog(LuotActivity.this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
        dialog.show();

        //vv.loadUrl(link);
        vv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageCommitVisible(WebView view, String url) {
                dialog.dismiss();
                super.onPageCommitVisible(view, url);
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                vv.loadUrl(link);

                return super.shouldOverrideKeyEvent(view, event);
            }
        });

        vv.loadUrl(link);
    }
}
