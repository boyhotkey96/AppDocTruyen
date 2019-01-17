package com.boyhotkey96.funnystories.UserManager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.boyhotkey96.funnystories.R;

public class Signup extends AppCompatActivity {
    
    EditText etUsername, etEmail, etPassword, etPassword2;
    Button btRegister;
    TextView tvLogin;
    UserDAO userDAO = new UserDAO(Signup.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_singup);

        AnhXa();

        // Xu ly nut button Dang Ky: Dang ky thanh cong tu dong chuyen qua trang Login.
        xulybtRegister();

        // Click TextView Login => chuyen qua trang Login.
        xulytvLogin();
    }

    private void AnhXa() {
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPassword2 = (EditText) findViewById(R.id.etPassword2);
        btRegister = (Button) findViewById(R.id.btRegister);
    }


    private void xulybtRegister() {
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUsername = etUsername.getText().toString();
                String txtEmail = etEmail.getText().toString();
                String txtpassword = etPassword.getText().toString();
                String txtpassword2 = etPassword2.getText().toString();

                if (txtUsername.trim().isEmpty() || txtEmail.trim().isEmpty() || txtpassword.trim().isEmpty()
                        || txtpassword2.trim().isEmpty()) {
                    Toast.makeText(Signup.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                } else if (txtpassword.equals(txtpassword2)) {
                    if (txtUsername.length() < 4  || txtUsername.length() >= 16) {
                        Toast.makeText(Signup.this, "Username phải có độ dài 4 - 16 ký tự", Toast.LENGTH_SHORT).show();
                    } else if (txtEmail.length() <= 4) {
                        Toast.makeText(Signup.this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
                    } else if (txtpassword.length() < 4 || txtpassword.length() >= 12) {
                        Toast.makeText(Signup.this, "Password phải có độ dài 4 - 12 ký tự", Toast.LENGTH_SHORT).show();
                    } else if (userDAO.checkUser(txtUsername, txtEmail)) {
                        Toast.makeText(Signup.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                    } else {
                        User user = new User();
                        user.setUsername(etUsername.getText().toString());
                        user.setEmail(etEmail.getText().toString());
                        user.setPassword(etPassword.getText().toString());

                        UserDAO userDAO = new UserDAO(Signup.this);
                        userDAO.themUser(user);

                        Toast.makeText(Signup.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Signup.this, Login.class);
                        intent.putExtra("guiEmail", etEmail.getText().toString());
                        intent.putExtra("guiPassword", etPassword.getText().toString());
                        startActivity(intent);
                    }

                } else {
                    Toast.makeText(Signup.this, "Password không khớp nhau", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    private void xulytvLogin() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(Signup.this, Login.class);
                startActivity(intentLogin);
            }
        });
    }

    // Tao hieu ung chuyen doi activity khi nhan nut Back
    @Override
    public void onBackPressed() {
        // Back
        super.onBackPressed();
        // Hieu ung chuyen doi activity
        overridePendingTransition(R.anim.end_in_activity, R.anim.end_out_activity);
    }
}
