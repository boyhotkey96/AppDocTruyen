package com.boyhotkey96.funnystories.Fragment.DanhSachTruyen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.boyhotkey96.funnystories.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnlyFragment extends Fragment {
    TextView tvtentruyen;
    TextView tvnoidung;

    public OnlyFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_only, container, false);
        tvtentruyen = (TextView) view.findViewById(R.id.txtname);
        tvnoidung = (TextView) view.findViewById(R.id.txtnoidung);

        if (getArguments() != null) {
            String ten = getArguments().getString("tentruyen").toString();
            tvtentruyen.setText(ten);
            String noidung = getArguments().getString("noidungtruyen").toString();
            tvnoidung.setText(noidung);
        }

        return view;
    }

}
