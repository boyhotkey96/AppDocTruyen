package com.boyhotkey96.funnystories.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.boyhotkey96.funnystories.Fragment.DanhSachTruyen.Fragment_TruyenCuoiCongSo;
import com.boyhotkey96.funnystories.Fragment.DanhSachTruyen.Fragment_TruyenCuoiDanGian;
import com.boyhotkey96.funnystories.Fragment.DanhSachTruyen.Fragment_TruyenCuoiNguoiLon;
import com.boyhotkey96.funnystories.Fragment.DanhSachTruyen.Fragment_TruyenCuoiTinhYeu;
import com.boyhotkey96.funnystories.Fragment.DanhSachTruyen.Fragment_TruyenCuoiTrangQuynh;
import com.boyhotkey96.funnystories.Fragment.DanhSachTruyen.MyAdapterdst;
import com.boyhotkey96.funnystories.Fragment.DanhSachTruyen.Picture;
import com.boyhotkey96.funnystories.R;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class Fragment_DanhSachTruyen extends Fragment {
    private FeatureCoverFlow coverFlow;
    public MyAdapterdst pictureAdapter;
    public List<Picture> pictureList = new ArrayList<>();
    private TextSwitcher mTitle;

    public Fragment_DanhSachTruyen() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_danh_sach_truyen, container, false);

        // Load danh sach truyen (Title, Image).
        initData();

        // Xu ly Title.
        mTitle = (TextSwitcher) view.findViewById(R.id.title);
        mTitle.setBackgroundColor(Color.GRAY);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                TextView txt = (TextView) inflater.inflate(R.layout.dst_layout_title, null);

                return txt;
            }
        });

        // Xu ly hieu ung cho Title
        Animation in = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_out_bottom);
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        // Xu ly Picture
        pictureAdapter = new MyAdapterdst(pictureList, getActivity());
        coverFlow = (FeatureCoverFlow) view.findViewById(R.id.coverflow);
        coverFlow.setAdapter(pictureAdapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(pictureList.get(position).getName());
            }

            @Override
            public void onScrolling() {

            }
        });

        // Xu ly Click vao Anh
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (position) {
                    case 0:
                        fragmentTransaction.replace(R.id.fragmentdst, new Fragment_TruyenCuoiTinhYeu());
                        fragmentTransaction.commit();
                        fragmentTransaction.addToBackStack(null);
                        break;
                    case 1:
                        fragmentTransaction.replace(R.id.fragmentdst, new Fragment_TruyenCuoiDanGian());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case 2:
                        fragmentTransaction.replace(R.id.fragmentdst, new Fragment_TruyenCuoiTrangQuynh());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case 3:
                        fragmentTransaction.replace(R.id.fragmentdst, new Fragment_TruyenCuoiNguoiLon());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case 4:
                        fragmentTransaction.replace(R.id.fragmentdst, new Fragment_TruyenCuoiCongSo());
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                }
            }
        });

        return view;
    }

    private void initData() {
        pictureList.add(new Picture(0, "Truyện cười tình yêu", "http://4.bp.blogspot.com/-Cvp5n47FSnM/UZI3wj8jpBI/AAAAAAAAIsQ/Vg2x0jtXM2E/s1600/truyen-cuoi-tinh-yeu.jpg"));
        pictureList.add(new Picture(1, "Truyện cười dân gian", "http://bbbooks.vn/wp-content/uploads/2016/07/cover-278.jpg"));
        pictureList.add(new Picture(2, "Truyện cười trạng Quỳnh", "http://bbbooks.vn/wp-content/uploads/2016/07/cover-273.jpg"));
        pictureList.add(new Picture(3, "Truyện cười người lớn", "http://4.bp.blogspot.com/-GyUIOapr6Nk/UbyDBZY31BI/AAAAAAAALHU/E7wD7eMn-Ds/s1600/truyen_cuoi_nguoi_lon.jpg"));
        pictureList.add(new Picture(4, "Truyện cười công sở", "http://trivietbook.com/upload/product/14275079511.jpg"));
    }

}