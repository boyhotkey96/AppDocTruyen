package com.boyhotkey96.funnystories.Fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.boyhotkey96.funnystories.Fragment.RSSTruyen.MyTask;
import com.boyhotkey96.funnystories.R;

import java.io.InputStream;
import java.util.List;

public class Fragment_TruyenCuoiNgonTinh extends Fragment {
    ListView lvTruyen;

    public Fragment_TruyenCuoiNgonTinh() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_truyen_cuoi_ngon_tinh, container, false);
        lvTruyen = (ListView) view.findViewById(R.id.lvTruyen);

        MyTask task = new MyTask(getActivity(), lvTruyen);
        task.execute();

        boolean kiemtra = KiemTraKetNoi(getActivity());
        if (kiemtra == true) {
            Toast.makeText(getActivity(), "Kết nối Iternet thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Vui lòng kết nối Internet để đọc truyện", Toast.LENGTH_SHORT).show();
        }

        return view;
    }


    // Kiem tra ket noi Internet
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
