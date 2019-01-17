package com.boyhotkey96.funnystories;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.boyhotkey96.funnystories.UserManager.Login;

public class VersionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.version_screen);

        // Sau 2.5s => chuyen sang Trang Login
        initDisplay();
    }

    private void initDisplay() {
        // An toolbar roi nen ko can an o day nua.
        //getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(VersionScreen.this, Login.class);
                startActivity(intent);
                overridePendingTransition(R.anim.start_in_activity, R.anim.start_out_activity);
            }
        }, 2500);
    }

}
