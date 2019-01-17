package com.boyhotkey96.funnystories.Fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.boyhotkey96.funnystories.Fragment.GopY.ChatMessage;
import com.boyhotkey96.funnystories.R;
import com.boyhotkey96.funnystories.UserManager.Login;

public class Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
        toolbar = (Toolbar) findViewById(R.id.toobar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        XuLyToolBar();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.muc2);
        navigationView.getMenu().performIdentifierAction(R.id.muc2, 0);
//        navigationView.setSelected(true);
    }

    private void XuLyToolBar() {
        /*setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        actionBar.setTitle("Funny Stories");
        actionBar.setDisplayHomeAsUpEnabled(true);*/

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(Navigation.this, drawerLayout, R.string.open, R.string.close);
        drawerToggle.syncState();

        // Thay icon khac
        //toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        // Su kien Onclick icon Navigation
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (item.getItemId()) {
            /*case R.id.muc1:
                transaction.replace(R.id.content_Layout, new Fragment_TrangChu()).commit();
                break;*/
            case R.id.muc2:
                transaction.replace(R.id.content_Layout, new Fragment_DanhSachTruyen());
                transaction.commit();
                        /*FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.content_Layout, new Fragment_DanhSachTruyen())
                                .commit();*/
                break;
            case R.id.muc3:
                transaction.replace(R.id.content_Layout, new Fragment_TruyenCuoiNgonTinh()).commit();
                break;
            case R.id.muc4_0:
                transaction.replace(R.id.content_Layout, new Fragment_GopY()).commit();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(Navigation.this, ChatMessage.class));
                    }
                }, 0000);
                break;
            case R.id.muc4_1:
                transaction.replace(R.id.content_Layout, new Fragment_ThongTin()).commit();
                break;
            case R.id.muc4_2:
                startActivity(new Intent(Navigation.this, Login.class));
                Toast.makeText(Navigation.this, "Đã đăng xuất!!", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.thoatapp, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.thoatapp) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    // Nhan nut back
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
        Toast.makeText(this, "Vui lòng nhấn quay lại thêm 1 lần nữa để thoát", Toast.LENGTH_SHORT).show();
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
}
