package com.boyhotkey96.funnystories.UserManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by boyhotkey96 on 21/11/2017.
 */

public class UserDatabase extends SQLiteOpenHelper {

    // Database
    public static final String DB_NAME = "QUAN LY USER";
    public static final int DB_VERSION = 1;
    // Table User
    public static final String TB_USER = "USER";
    public static final String TB_USERNAME = "username";
    public static final String TB_EMAIL = "email";
    public static final String TB_PASSWORD = "password";

    public UserDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Table User
        String sql = "CREATE TABLE "
                + TB_USER
                + " (" + TB_USERNAME
                + " TEXT PRIMARY KEY, "
                + TB_EMAIL
                + " TEXT, "
                + TB_PASSWORD
                + " TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_USER);
        onCreate(db);
    }
}
