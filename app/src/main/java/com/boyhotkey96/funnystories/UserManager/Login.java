package com.boyhotkey96.funnystories.UserManager;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.boyhotkey96.funnystories.Fragment.Navigation;
import com.boyhotkey96.funnystories.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    TextView etUserOrEmail, etPass, tvSignup, tvForgot;
    Button btLogin;
    UserDAO userDAO = new UserDAO(this);

    //facebook
    LoginButton loginButton;
    CallbackManager callbackManager;
    String name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

        AnhXa();

        //FacebookSdk.sdkInitialize(getApplicationContext());
        //AppEventsLogger.activateApp(this);
        //Login bang taikhoan Facebook
        setLogin_Button();

        //Login voi taikhoan da dang ky truoc do
        LoginThuCong();

        //Chuyen qua Activity Signup de dang ky tai khoan
        XuLyTVSignup();

        //Chuyen qua Activity quen mat khau (Phan danh cho admin)
        xulyTVFotgot();
    }

    private void AnhXa() {
        etUserOrEmail = (TextView) findViewById(R.id.etUserOrMail);
        etPass = (TextView) findViewById(R.id.etPass);
        btLogin = (Button) findViewById(R.id.btLogin);

        tvSignup = (TextView) findViewById(R.id.tvSignup);
        tvForgot = (TextView) findViewById(R.id.tvForgot);
    }


    /*----------------------------------Facebook Start----------------------------------*/
    private void setLogin_Button() {
        //Nhan vao nut login facebook -> Tu sever tra ve du lieu
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //Login vao Navigation
                Intent intent = new Intent(Login.this, Navigation.class);
                startActivity(intent);
                Toast.makeText(Login.this, "Đăng nhập tài khoản Facebook thành công", Toast.LENGTH_SHORT).show();

                //Gui len server
                GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.d("JSON", response.getJSONObject().toString());
                        try {
                            name = object.getString("name");
                            email = object.getString("email");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                //Nhan du lieu ve
                Bundle parameters = new Bundle();
                parameters.putString("fields", "name, email, first_name");
                graphRequest.setParameters(parameters);
                graphRequest.executeAsync();
            }

            @Override
            //Khi huy Login
            public void onCancel() {
                Toast.makeText(Login.this, "Huỷ đăng nhập", Toast.LENGTH_SHORT).show();
                setLogin_Button();
            }

            @Override
            //Khi dang nhap that bai
            public void onError(FacebookException error) {
                Toast.makeText(Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                setLogin_Button();
            }
        });
    }

    //Cho phep Login vao facebook
    @Override
    protected void onStart() {
        //Khi click button se duoc login vao ben trong va dong thoi nut button chuyen ve trang thai da logout
        LoginManager.getInstance().logOut();
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    /*----------------------------------Facebook End----------------------------------*/


    private void LoginThuCong() {
        //Khi dang ky thanh cong se gui ve Email & Password ve va setText cho phan Login
        String nhanEmail = getIntent().getStringExtra("guiEmail");
        String nhanPassword = getIntent().getStringExtra("guiPassword");
        etUserOrEmail.setText(nhanEmail);
        etPass.setText(nhanPassword);
        //Xu ly nut Button Login bang tai khoan da dang ky truoc do
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtUserOrEmail = etUserOrEmail.getText().toString();
                String txtPass = etPass.getText().toString();

                if (userDAO.loadUser(txtUserOrEmail, txtPass)) {//Taikhoan chinh xac
                    Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(Login.this, Navigation.class));
                    Intent intent = new Intent(Login.this, Navigation.class);
                    startActivity(intent);
                } else if (txtUserOrEmail.trim().isEmpty() || txtPass.trim().isEmpty()) {//Bo trong user or pass
                    Toast.makeText(Login.this, "Làm ơn nhập Username & Password", Toast.LENGTH_SHORT).show();
                } else {//Taikhoan sai
                    Toast.makeText(Login.this, "Username hoặc Password sai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void XuLyTVSignup() {
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Signup.class));
            }
        });
    }


    private void xulyTVFotgot() {
        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ForgotPassword.class));
            }
        });
    }


    /*----------------------------------Nut Quay ve Start----------------------------------*/
    boolean twice;

    @Override
    public void onBackPressed() {
        // Thoat app khi double click nut back.
        Log.d(this.getClass().getName(), "Click: ");
        if (twice == true) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.end_in_activity, R.anim.end_out_activity);
        }

        //super.onBackPressed();
        // Click tra ve true (double click chay if o tren) sau 3s tra ve false
        Toast.makeText(this, "Vui lòng nhấn quay lại thêm 1 lần nũa để thoát", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
                Log.d(this.getClass().getName(), "TWICE: " + twice);
            }
        }, 3000);
        twice = true;
        Log.d(this.getClass().getName(), "TWICE: " + twice);
    }
    /*----------------------------------Nut Quay ve End----------------------------------*/

}
