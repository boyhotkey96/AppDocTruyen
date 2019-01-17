package com.boyhotkey96.funnystories.Fragment.DanhSachTruyen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;;
import com.boyhotkey96.funnystories.R;

public class Fragment_TruyenCuoiCongSo extends Fragment {
    ViewPager vp;

    public Fragment_TruyenCuoiCongSo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__truyen_cuoi_cong_so, container, false);
        vp = (ViewPager) view.findViewById(R.id.viewpager4);

        MyAdapterFragment4 adapterFragment = new MyAdapterFragment4(getActivity().getSupportFragmentManager());
        vp.setAdapter(adapterFragment);

        return view;
    }

    private class MyAdapterFragment4 extends FragmentStatePagerAdapter {

        public MyAdapterFragment4(FragmentManager fm) {
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
                    // Khởi tạo fragment mới
                    OnlyFragment ol0 = new OnlyFragment();
                    // truyền bundle từ class OnlyFragment
                    Bundle b0 = new Bundle();
                    // truyền tham số từ OnlyFragment qua (key phải trùng với bên OnlyFragment)
                    // tên truyện
                    b0.putString("tentruyen", "Nỗi lo nặng kí");
                    // nội dung truyện
                    b0.putString("noidungtruyen", "Một thanh niên tìm đến địa chỉ rao vặt \"Cơ hội nghìn năm có một\", được diện kiến một nhân vật đầy ưu tư. Người ấy giải thích:\n" +
                            "\n" +
                            "- Công việc của anh sẽ là gánh vác mọi lo toan của tôi.\n" +
                            "\n" +
                            "- Việc này không dễ! Ông sẽ trả tôi bao nhiêu?:\n" +
                            "\n" +
                            "- 20.000 USD để làm mọi nỗi lo của tôi thành nỗi lo của chính anh.\n" +
                            "\n" +
                            "- Tôi sẽ bắt đầu lo cho ông việc gì?\n" +
                            "\n" +
                            "- Kiếm 40.000 USD!");
                    // chạy Fragment
                    ol0.setArguments(b0);

                    return ol0;
                case 1:
                    OnlyFragment ol1 = new OnlyFragment();
                    Bundle b1 = new Bundle();
                    b1.putString("tentruyen", "Chẳng ai thèm lấy");
                    b1.putString("noidungtruyen", "Một nhóm bạn thân nhân kỳ nghỉ rủ nhau vào rừng săn hươu. Họ chia thành từng tốp hai người và bắt đầu cuộc đi săn. Đêm đó, thợ săn nọ trở về một mình oằn lưng dưới sức nặng của một con hươu lớn.\n" +
                            "\n" +
                            "- Thằng Ba đâu? - Những người khác hỏi.\n" +
                            "\n" +
                            "- Nó bị đau tim, đang nằm đâu đó cách đây vài cây số, trên lối mòn này. - Tay thợ săn đáp.\n" +
                            "\n" +
                            "- Mày để thằng Ba nằm đó và khiêng con hươu này về đây? - Mọi người kêu lên. - Mày còn tim không vậy?\n" +
                            "\n" +
                            "- Một lựa chọn khó khăn. - Anh chàng thợ săn thành công thừa nhận. - Nhưng cuối cùng tớ sực nghĩ ra là chẳng ai thèm ăn cắp xác thằng Ba cả.");
                    ol1.setArguments(b1);

                    return ol1;
                case 2:
                    OnlyFragment ol2 = new OnlyFragment();
                    Bundle b2 = new Bundle();
                    b2.putString("tentruyen", "Biếu không");
                    b2.putString("noidungtruyen", "- Các con bị thua à?\n" +
                            "\n" +
                            "- Không! Nhưng con lại thi đấu cho đội bóng khác.\n" +
                            "\n" +
                            "- Họ bán con à?\n" +
                            "\n" +
                            "- Họ cho không!\n" +
                            "\n" +
                            "Trong một sân vận động xảy ra chuyện ẩu đả.\n" +
                            "\n" +
                            "- Có gì xảy ra thế? Một khán giả ngây thơ hỏi.\n" +
                            "\n" +
                            "- Anh không thấy à? Bọn hu-li-gân Luân Đôn đánh trọng tài – Người ngồi cạnh giải thích.\n" +
                            "\n" +
                            "- Nhưng tại sao? Trận đấu vẫn chưa bắt đầu kia mà!\n" +
                            "\n" +
                            "- Tại vì ngay sau khi trận đấu kết thúc thì chuyến tàu thủy cuối cùng xuyên về Anh sẽ khởi hành, và đám ấy sợ không kịp chuyến tàu…");
                    ol2.setArguments(b2);

                    return ol2;
                case 3:
                    OnlyFragment ol3 = new OnlyFragment();
                    Bundle b3 = new Bundle();
                    b3.putString("tentruyen", "Vì sao phải đứng?");
                    b3.putString("noidungtruyen", "- Tại sao những người chỉ huy thường đứng khi đi thuyền?\n" +
                            "\n" +
                            "- Vì nếu ngồi xuống, ông ta sẽ phải chèo như những người khác.");
                    ol3.setArguments(b3);

                    return ol3;
                case 4:
                    OnlyFragment o14 = new OnlyFragment();
                    Bundle b4 = new Bundle();
                    b4.putString("tentruyen", "Đãng trí hay không?");
                    b4.putString("noidungtruyen", "Một thương gia đang nằm chờ chết, thều thào đọc chúc thư cho viên luật sư:\n" +
                            "\n" +
                            "- ...Có lẽ cũng phải nghĩ đến các nhân viên của tôi một chút. Hãy chia cho mỗi người phục vụ trên 25 năm nửa triệu USD...\n" +
                            "\n" +
                            "- Luật sư ngạc nhiên: Nhưng hãng của ngài chỉ mới thành lập có 15 năm thôi mà?\n" +
                            "\n" +
                            "- Vị thương gia thở hắt: Vâng, tôi nhớ. Nhưng phải quảng cáo chứ! ");
                    o14.setArguments(b4);

                    return o14;
            }
            return null;
        }

    }

}
