package com.boyhotkey96.funnystories.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyhotkey96.funnystories.R;

public class Fragment_ThongTin extends Fragment {

    public Fragment_ThongTin() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thong_tin, container, false);

        return view;
    }

}
