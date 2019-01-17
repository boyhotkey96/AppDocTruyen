package com.boyhotkey96.funnystories.Fragment.DanhSachTruyen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyhotkey96.funnystories.R;

public class Fragment_TruyenCuoiDanGian extends Fragment {
    ViewPager vp;

    public Fragment_TruyenCuoiDanGian() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__truyen_cuoi_dan_gian, container, false);
        vp = (ViewPager) view.findViewById(R.id.viewpager1);

        MyAdapterFragment1 adapterFragment = new MyAdapterFragment1(getActivity().getSupportFragmentManager());
        vp.setAdapter(adapterFragment);

        return view;
    }

    private class MyAdapterFragment1 extends FragmentStatePagerAdapter {

        public MyAdapterFragment1(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    // tạo fragment mới
                    OnlyFragment ol0 = new OnlyFragment();
                    // truyền bundle từ class OnlyFragment
                    Bundle b0 = new Bundle();
                    // truyền tham số từ OnlyFragment qua (key phải trùng với bên OnlyFragment)
                    b0.putString("tentruyen", "Ít ngủ");
                    // nội dung truyện
                    b0.putString("noidungtruyen", "-Cha: Dạo này con thức khuya quá! Ít ngủ không có lợi đâu, con ạ!\n" +
                            "\n" +
                            "-Mai: Cha đừng lo, con đã ngủ bù ở lớp rồi ạ!\n" +
                            "\n" +
                            "-Cha: Trời!!");
                    // chạy Fragment
                    ol0.setArguments(b0);

                    return ol0;
                case 1:
                    OnlyFragment ol1 = new OnlyFragment();
                    Bundle b1 = new Bundle();
                    b1.putString("tentruyen", "Không đánh lại");
                    b1.putString("noidungtruyen", "-Cường: Ở lớp có bạn đánh Cường không dám đánh lại!\n" +
                            "\n" +
                            "-Mắm: Chuyện lạ à nghen! Nhưng tại sao bạn ấy lại đánh Cường!\n" +
                            "\n" +
                            "-Cường: Vì Cường đánh bạn ấy trước!!!\n" +
                            "\n" +
                            "Mắm: Hừ! Biết ngay mà!");
                    ol1.setArguments(b1);

                    return ol1;
                case 2:
                    OnlyFragment ol2 = new OnlyFragment();
                    Bundle b2 = new Bundle();
                    b2.putString("tentruyen", "1x10=9");
                    b2.putString("noidungtruyen", "-Thầy: Một cái bánh giá 1 hào, vậy 10 cái giá bao nhiêu, trò?\n" +
                            "\n" +
                            "-Kiên: Thưa thầy khoảng chín hào ạ!\n" +
                            "\n" +
                            "-Thầy: Sao lại 9 hào, con tính lại đi!\n" +
                            "\n" +
                            "-Kiên: Thưa thầy, tại vì mua nhiều... họ bớt tiền cho ạ!");
                    ol2.setArguments(b2);

                    return ol2;
                case 3:
                    OnlyFragment ol3 = new OnlyFragment();
                    Bundle b3 = new Bundle();
                    b3.putString("tentruyen", "Nhật ký");
                    b3.putString("noidungtruyen", "-Huy: Đố Tài nhật ký là gì?\n" +
                            "\n" +
                            "-Tài: Ờ! Đó là chữ ký của người Nhật!\n" +
                            "\n" +
                            "-Huy: Trời!!");
                    ol3.setArguments(b3);

                    return ol3;
                case 4:
                    OnlyFragment o14 = new OnlyFragment();
                    Bundle b4 = new Bundle();
                    b4.putString("tentruyen", "208 cái");
                    b4.putString("noidungtruyen", "-Này, mày biết người ta có bao nhiêu chiếc xương không?\n" +
                            "\n" +
                            "-207 cái\n" +
                            "\n" +
                            "-Thế mà tao có 208 cái đấy!\n" +
                            "\n" +
                            "-Xạo mày!\n" +
                            "\n" +
                            "-Chứ sao, tao mới nuốt 1 cái xương cá xong!");
                    o14.setArguments(b4);

                    return o14;
            }
            return null;
        }
    }

}
