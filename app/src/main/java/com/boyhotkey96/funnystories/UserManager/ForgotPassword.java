package com.boyhotkey96.funnystories.UserManager;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.boyhotkey96.funnystories.R;

import java.util.ArrayList;
import java.util.List;

public class ForgotPassword extends AppCompatActivity {

    LinearLayout lnForgot;
    TextView tvSdt;
    EditText etForgotUsername, etForgotPassword;
    ListView lvForgot;
    Button btForgotLogin;
    List<User> dsUser;
    UserDAO userDAO = new UserDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_forgot_password);

        AnhXa();

        // Click TexView => Chuyen sang goi dien thoai cho admin de xin lai pass :('
        xulyTVSdt();

        // Click TextView Forgot => Chuyen sang trang quen mat khau.
        xulyButtonForgot();
    }

    public void AnhXa() {
        lnForgot = (LinearLayout) findViewById(R.id.lnForgot);
        tvSdt = (TextView) findViewById(R.id.tvSdt);
        etForgotUsername = (EditText) findViewById(R.id.etForgotUsername);
        etForgotPassword = (EditText) findViewById(R.id.etForgotPassword);
        lvForgot = (ListView) findViewById(R.id.lvForgot);
        btForgotLogin = (Button) findViewById(R.id.btForgotLogin);
    }


    private void xulyTVSdt() {
        tvSdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("tel:901")));
            }
        });

    }


    private void xulyButtonForgot() {
        // An LinearLayout
        lnForgot.setVisibility(View.INVISIBLE);

        btForgotLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtForgotUsername = etForgotUsername.getText().toString();
                String txtForgotPassword = etForgotPassword.getText().toString();

                if (txtForgotUsername.trim().isEmpty() || txtForgotPassword.trim().isEmpty()) {
                    Toast.makeText(ForgotPassword.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                } else if (txtForgotUsername.equals("admin") && txtForgotPassword.equals("admin")) {
                    etForgotUsername.setText("");
                    etForgotPassword.setText("");
                    //Toast.makeText(ForgotPassword.this, "Thành công", Toast.LENGTH_SHORT).show();
                    dsUser = new ArrayList<User>();
                    dsUser = userDAO.LoadDSUser();

                    CustomForgotAdapter adapter = new CustomForgotAdapter(ForgotPassword.this, R.layout.user_custom_one_item_forgot, dsUser);
                    lvForgot.setAdapter(adapter);

                    // Hien LinearLayout va ListView khi dang nhap thanh cong.
                    lnForgot.setVisibility(View.VISIBLE);
                    lvForgot.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(ForgotPassword.this, "Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                    // An LinearLayout va ListView khi dang nhap that bai.
                    lnForgot.setVisibility(View.INVISIBLE);
                    lvForgot.setVisibility(View.INVISIBLE);
                    etForgotUsername.setText("");
                    etForgotPassword.setText("");
                }
            }
        });
    }
}
