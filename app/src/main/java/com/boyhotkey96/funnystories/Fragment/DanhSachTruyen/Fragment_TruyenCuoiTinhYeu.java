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

public class Fragment_TruyenCuoiTinhYeu extends Fragment {
    ViewPager vp;

    public Fragment_TruyenCuoiTinhYeu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__truyen_cuoi_tinh_yeu, container, false);
        vp = (ViewPager) view.findViewById(R.id.viewpager);

        MyAdapterFragment adapterFragment = new MyAdapterFragment(getActivity().getSupportFragmentManager());
        vp.setAdapter(adapterFragment);

        return view;
    }

    public class MyAdapterFragment extends FragmentStatePagerAdapter {

        public MyAdapterFragment(FragmentManager fm) {
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
                    b0.putString("tentruyen", "Sẽ Cố Gắng...");
                    // nội dung truyện
                    b0.putString("noidungtruyen", "Một gia đình đang lái xe trên đường thì con cóc nhảy ngang qua. Ông chồng thắng xe kip thời, bước xuống, mang con cóc đặt qua vệ đường.\n" +
                            "\n" +
                            "Con cóc bỗng nói:\n" +
                            "\n" +
                            "- Cám ơn ông đã cứu mạng. Tôi sẽ cho gia đình ông một điều ước!\n" +
                            "Người đàn ông nói:\n" +
                            "\n" +
                            "- Vậy hãy làm cho con chó của tôi thắng cuộc đua hôm nay?\n" +
                            "\n" +
                            "Ông ta gọi con chó ra, và khi thấy nó chỉ có ba chân, con cóc nói:\n" +
                            "\n" +
                            "- Khó quá… Hay ông xin điều khác đi!\n" +
                            "\n" +
                            "Lúc đó bà vợ trong xe bước ra và nói:\n" +
                            "\n" +
                            "- Vậy hãy làm cho tôi thắng cuộc thi hoa hậu năm nay được không?\n" +
                            "\n" +
                            "Cóc nhìn bà vợ rồi quay lại nói với ông chồng:\n" +
                            "\n" +
                            "- Ông… cho tôi xem lại con chó, tôi sẽ cố gắng.");
                    // chạy Fragment
                    ol0.setArguments(b0);

                    return ol0;
                case 1:
                    OnlyFragment ol1 = new OnlyFragment();
                    Bundle b1 = new Bundle();
                    b1.putString("tentruyen", "Không mua bằng tiền được");
                    b1.putString("noidungtruyen", "Cô gái nói với chàng trai:\n" +
                            "\n" +
                            "- Em không thích tiền, tình yêu không mua bằng tiền được!\n" +
                            "\n" +
                            "- Thế em thích gì? Một chiếc xe máy xịn màu đỏ nhé?\n" +
                            "\n" +
                            "- Vâng vâng! Một chiếc như vậy thì tình yêu mới nồng thắm.");
                    ol1.setArguments(b1);

                    return ol1;
                case 2:
                    OnlyFragment ol2 = new OnlyFragment();
                    Bundle b2 = new Bundle();
                    b2.putString("tentruyen", "Gánh chịu một mình");
                    b2.putString("noidungtruyen", "Trời mưa. Một cặp vợ chồng đi ngoài phố. Người chồng cầm ô che mưa một mình, người vợ bực tức gắt.\n" +
                            "\n" +
                            "-Anh chỉ biết có mình! Em bị ướt hết cả rồi mà anh không đau khổ sao?\n" +
                            "\n" +
                            "-Em yêu! Em bị ướt anh rất đau khổ, còn nếu anh bị thì em lại đau khổ!... Vậy hãy để anh gánh chịu đau khổ một mình.");
                    ol2.setArguments(b2);

                    return ol2;
                case 3:
                    OnlyFragment ol3 = new OnlyFragment();
                    Bundle b3 = new Bundle();
                    b3.putString("tentruyen", "Không cần nhiều đến thế");
                    b3.putString("noidungtruyen", "Một triệu phú trẻ nói với cô đào xinh đẹp mà anh ta đang chết mê chết mệt:\n" +
                            "\n" +
                            "-Em nghĩ thế nào nếu hai ta cùng nhau tiêu tiền của anh?\n" +
                            "\n" +
                            "-Được thôi!\n" +
                            "\n" +
                            "-Anh muốn suốt đời chúng mình làm như vậy!\n" +
                            "\n" +
                            "-Em không nghĩ là phải tốn nhiều thời gian đến thế để tiêu hết tiền của anh");
                    ol3.setArguments(b3);

                    return ol3;
                case 4:
                    OnlyFragment o14 = new OnlyFragment();
                    Bundle b4 = new Bundle();
                    b4.putString("tentruyen", "Gía của món quà");
                    b4.putString("noidungtruyen", "Tên trộm tặng cho bồ của hắn chiếc nhẫn quý, cô này suýt xoa hỏi:\n" +
                            "\n" +
                            "-Ôi, đẹp quá! Nó có giá bao nhiêu vậy anh?\n" +
                            "\n" +
                            "7 năm tù và bị tịch thu toàn bộ tài sản.");
                    o14.setArguments(b4);

                    return o14;
            }
            return null;
        }
    }

}
