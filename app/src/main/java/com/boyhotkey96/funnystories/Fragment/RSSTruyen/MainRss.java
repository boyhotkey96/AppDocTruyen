package com.boyhotkey96.funnystories.Fragment.RSSTruyen;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.boyhotkey96.funnystories.R;

public class MainRss extends AppCompatActivity {

    ListView lv;
    private boolean kiemtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_main);
        lv = (ListView) findViewById(R.id.lv);

        MyTask task = new MyTask(MainRss.this, lv);
        task.execute();

        boolean  kiemtra = KiemTraKetNoi(MainRss.this);
        if (kiemtra == true) {
            Toast.makeText(MainRss.this, "Kết nối net thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainRss.this, "Vui lòng bật kết nối mạng", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean KiemTraKetNoi(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);

        // Kiểm tra kết nối Wifi
        NetworkInfo wifiNetwork = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }

        // Kiểm tra kết nối 3G
        NetworkInfo mobileNetwork = connectivityManager.getNetworkInfo((ConnectivityManager.TYPE_MOBILE));
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }

        // Kiểm tra đã Active chưa
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }

        return true;
    }
}

