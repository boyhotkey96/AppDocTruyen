package com.boyhotkey96.funnystories.UserManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boyhotkey96 on 21/11/2017.
 */

public class UserDAO {

    UserDatabase database;
    SQLiteDatabase db;

    public UserDAO(Context context) {
        database = new UserDatabase(context);
    }


    // Them User (Useername, Email, Password) ==> Phan dang ky taikhoan.
    public void themUser(User user) {
        db = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(database.TB_USERNAME, user.getUsername().toString());
        values.put(database.TB_EMAIL, user.getEmail().toString());
        values.put(database.TB_PASSWORD, user.getPassword().toString());
        db.insert(database.TB_USER, null, values);
        db.close();
    }


    // Lay Username hoac Email va Password de Login (Username or Email, Password) ==> Phan Dang nhap taikhoan.
    public boolean loadUser(String usernameOrPass, String password) {
        db = database.getReadableDatabase();

        //Cach 1
        String truyvan = "SELECT * FROM " + database.TB_USER + " WHERE "
                + database.TB_USERNAME + " = " + "'"+usernameOrPass+"'"
                +  " OR " + database.TB_EMAIL + " = " + "'"+usernameOrPass+"'"
                +  " AND " + database.TB_PASSWORD + " = " + "'"+password+"'";
        Cursor cursor = db.rawQuery(truyvan, null);

        /*String table = database.TB_USER;
        String[] columns = null;
        String selection = "(" + database.TB_USERNAME + " =? OR " + database.TB_EMAIL + " =? )" + " AND " + database.TB_PASSWORD + " =?";
        String[] selectionArgs = new String[] {usernameOrPass, usernameOrPass, password};
        String groupby = null;
        String having = null;
        String orderby = null;
        String limit = null;
        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupby, having, orderby, limit);*/

        /*Cursor cursor = db.query(database.TB_USER, null, "(" + database.TB_USERNAME
                        + " =? OR " + database.TB_EMAIL + " =?)"
                        + " AND " + database.TB_PASSWORD + " =?",
                new String[]{usernameOrPass, usernameOrPass, password}, null, null, null, null);*/

        if (cursor != null && cursor.getCount() > 0) {
            return true;
        }
        cursor.moveToFirst();
        database.close();

        return false;
    }


    // Kiem tra Username hoac Email da ton tai chua khi Dang ky taikhoan ==> neu ton tai Dang ky that bai.
    public boolean checkUser(String username, String email) {
        db = database.getReadableDatabase();
        String truyvan = "SELECT * FROM " + database.TB_USER + " WHERE "
                + database.TB_USERNAME + " = " + "'" + username + "'"
                + " OR " + database.TB_EMAIL + " = " + "'" + email + "'";
        Cursor cursor = db.rawQuery(truyvan, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }
        database.close();

        return false;
    }


    // Hien thi danh sach user (Username, Email va Password) => Xu ly cho trang Quen Mat Khau.
    public List<User> LoadDSUser() {
        List<User> dsUser = new ArrayList<User>();

        db = database.getReadableDatabase();
        String truyvan = "SELECT * FROM " + database.TB_USER;
        Cursor cursor = db.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            User us = new User();
            us.setUsername(cursor.getString(0));
            us.setEmail(cursor.getString(1));
            us.setPassword(cursor.getString(2));
            dsUser.add(us);
            cursor.moveToNext();
        }
        database.close();

        return dsUser;
    }
}
