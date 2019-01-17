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

public class Fragment_TruyenCuoiNguoiLon extends Fragment {
    ViewPager vp;

    public Fragment_TruyenCuoiNguoiLon() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__truyen_cuoi_nguoi_lon, container, false);
        vp = (ViewPager) view.findViewById(R.id.viewpager3);

        MyAdapterFragment3 adapterFragment = new MyAdapterFragment3(getActivity().getSupportFragmentManager());
        vp.setAdapter(adapterFragment);

        return view;
    }

    private class MyAdapterFragment3 extends FragmentStatePagerAdapter {

        public MyAdapterFragment3(FragmentManager fm) {
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
                    b0.putString("tentruyen", "Ai là sếp");
                    // nội dung truyện
                    b0.putString("noidungtruyen", "-Hãy nói xem, cậu là sếp ở đây à?\n" +
                            "\n" +
                            "-Không ạ, thưa ông giám đốc\n" +
                            "\n" +
                            "-Vậy tại sao lại nói những cái nhảm nhí vậy?");
                    // chạy Fragment
                    ol0.setArguments(b0);

                    return ol0;
                case 1:
                    OnlyFragment ol1 = new OnlyFragment();
                    Bundle b1 = new Bundle();
                    b1.putString("tentruyen", "Ai hư");
                    b1.putString("noidungtruyen", "Thủ trưởng bảo tài xế:\n" +
                            "\n" +
                            "-Cậu liệt kê các phụ tùng ở trong xe bị hư khoảng năm triệu, đưa tôi ký, rồi qua thủ quỹ lãnh tiền nghe chưa?\n" +
                            "\n" +
                            "-Thưa thủ trưởng, xe mình đâu có hư?\n" +
                            "\n" +
                            "-Nếu xe không hư, thì cậu hư rồi đó hiểu chưa?");
                    ol1.setArguments(b1);

                    return ol1;
                case 2:
                    OnlyFragment ol2 = new OnlyFragment();
                    Bundle b2 = new Bundle();
                    b2.putString("tentruyen", "Tài nếm rượu");
                    b2.putString("noidungtruyen", "Một tay đệ tử Lưu Linh đứng tụa vào quầy quán bar, khoe khoang có khả năng phân biệt bất kỳ loại rượu nào khi bị bịt mắt.\n" +
                            "\n" +
                            "Nhiều người trong quán cả cược là anh ta sẽ không làm được điều đó.\n" +
                            "\n" +
                            "Anh hầu bàn đưa ra từng loại rượu và lần nào anh ta cũng đoán trúng.\n" +
                            "\n" +
                            "Tức mình, anh bồi mang ra một cốc nước lã. Tay thử rượu uống một ngụm và nhổ toẹt ngay ra, thú nhận:\n" +
                            "\n" +
                            "-Không biết là cái thứ đồ uống quái quỷ gì, nhưng tôi đoán chắc một điểm: sẽ không bán được.");
                    ol2.setArguments(b2);

                    return ol2;
                case 3:
                    OnlyFragment ol3 = new OnlyFragment();
                    Bundle b3 = new Bundle();
                    b3.putString("tentruyen", "Ai tài hơn?");
                    b3.putString("noidungtruyen", "Con của hai luật sư khoe với nhau:\n" +
                            "\n" +
                            "-Mày xem bố tao có tài không? Ông X tham ô 9 tỉ đồng, nhờ bố tao, nói có một giờ mà ông chị bị có 2 năm 'tù treo'\n" +
                            "\n" +
                            "-Nhằm nhò gì, lão Y buôn lậu tới 2kg heroin, nhờ bố tao nói có một câu mà lão khỏi phải tù ngày nào.\n" +
                            "\n" +
                            "-Bố mày nói câu gì mà tài thế?\n" +
                            "\n" +
                            "-Câu ngắn thôi: 'Đề nghị tử hình'");
                    ol3.setArguments(b3);

                    return ol3;
                case 4:
                    OnlyFragment o14 = new OnlyFragment();
                    Bundle b4 = new Bundle();
                    b4.putString("tentruyen", "Chức cao");
                    b4.putString("noidungtruyen", "Hai người bạn thân lâu ngày mới gặp nhau. Sau một hồi hàn huyên ôn lại chuyện xưa, họ chuyển sang đề tài công việc. Một người hỏi:\n" +
                            "\n" +
                            "-Này, cậu nhận công việc mới thế nào?\n" +
                            "\n" +
                            "-Cũng bình thường thôi, nhưng 70 người làm việc dưới chân tớ.\n" +
                            "\n" +
                            "-Chúc mừng cậu! Cậu được lên chức rồi à? Quản đốc hay phó quản đốc thế?\n" +
                            "\n" +
                            "-Đâu có! Vẫn chân trắng thôi, nhưng hiện giờ tớ làm việc trên tầng 3.");
                    o14.setArguments(b4);

                    return o14;
            }

            return null;
        }
    }

}
