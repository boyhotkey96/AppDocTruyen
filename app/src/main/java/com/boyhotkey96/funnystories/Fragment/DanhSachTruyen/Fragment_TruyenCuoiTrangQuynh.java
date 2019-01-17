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

public class Fragment_TruyenCuoiTrangQuynh extends Fragment {
    ViewPager vp;

    public Fragment_TruyenCuoiTrangQuynh() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__truyen_cuoi_trang_quynh, container, false);
        vp = (ViewPager) view.findViewById(R.id.viewpager2);

        MyAdapterFragment2 adapterFragment = new MyAdapterFragment2(getActivity().getSupportFragmentManager());
        vp.setAdapter(adapterFragment);

        return view;
    }

    public class MyAdapterFragment2 extends FragmentStatePagerAdapter {

        public MyAdapterFragment2(FragmentManager fm) {
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
                    b0.putString("tentruyen", "Hơn");
                    // nội dung truyện
                    b0.putString("noidungtruyen", "-Ông phú hộ: Quỳnh! Con gà của tao đâu rồi hả?\n" +
                            "\n" +
                            "-Quỳnh: Anh Tí thịt rồi!\n" +
                            "\n" +
                            "-Ông phú hộ: Cái gì? Tao cho mày 1 đồng để mày trông nó rồi mà!\n" +
                            "\n" +
                            "-Quỳnh: Nhưng ảnh cho con tới 2 đồng lận!");
                    // chạy Fragment
                    ol0.setArguments(b0);

                    return ol0;
                case 1:
                    OnlyFragment ol1 = new OnlyFragment();
                    Bundle b1 = new Bundle();
                    b1.putString("tentruyen", "Không đọc được");
                    b1.putString("noidungtruyen", "-Quỷnh: Con biết thế nào Quỷnh này cũng có khả năng hơn cậu Quỷnh mà!\n" +
                            "\n" +
                            "-Quỳnh: Khả năng gì vậy Quỳnh?\n" +
                            "\n" +
                            "-Quỷnh: Dạ, đó là con đọc được chữ cậu, còn cậu không đọc được chữ con ạ!\n" +
                            "\n" +
                            "-Quỳnh: Cái gì!?");
                    ol1.setArguments(b1);

                    return ol1;
                case 2:
                    OnlyFragment ol2 = new OnlyFragment();
                    Bundle b2 = new Bundle();
                    b2.putString("tentruyen", "Hội");
                    b2.putString("noidungtruyen", "-Quỷnh: cậu Quỳnh! Sao cứ thấy con lũ bạn lại hét rống lên:'Hội! Hội!' \n" +
                            "\n" +
                            "-Quỳnh: Mày thử đánh vần xem!\n" +
                            "\n" +
                            "-Quỷnh: Hờ...ôi...hoi...nặng...\n" +
                            "\n" +
                            "-Quỳnh: Đúng rồi đấy, tụi nó bảo mày hôi nặng. ha...ha\n" +
                            "\n" +
                            "-Quỷnh: Hừ...!!!");
                    ol2.setArguments(b2);

                    return ol2;
                case 3:
                    OnlyFragment ol3 = new OnlyFragment();
                    Bundle b3 = new Bundle();
                    b3.putString("tentruyen", "Ít ngủ");
                    b3.putString("noidungtruyen", "-Cha: Dạo này con thức khuya quá! Ít ngủ không có lợi đâu, con ạ!\n" +
                            "\n" +
                            "-Quỳnh: Cha đừng lo, con đã ngủ bù ở lớp rồi ạ!\n" +
                            "\n" +
                            "-Cha: Trời!!");
                    ol3.setArguments(b3);

                    return ol3;
                case 4:
                    OnlyFragment o14 = new OnlyFragment();
                    Bundle b4 = new Bundle();
                    b4.putString("tentruyen", "Không đánh lại");
                    b4.putString("noidungtruyen", "-Quỳnh: Ở lớp có bạn đánh Quỳnh không dám đánh lại!\n" +
                            "\n" +
                            "-Mắm: Chuyện lạ à nghen! Nhưng tại sao bạn ấy lại đánh Quỳnh!\n" +
                            "\n" +
                            "-Quỳnh: Vì Quỳnh đánh bạn ấy trước!!!\n" +
                            "\n" +
                            "Mắm: Hừ! Biết ngay mà!");
                    o14.setArguments(b4);

                    return o14;
            }
            return null;
        }
    }

}
