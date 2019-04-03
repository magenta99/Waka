package com.wakaproject.waka.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import static com.wakaproject.waka.Constant.CREATE_PRODUCT_CART_TABLE;
import static com.wakaproject.waka.Constant.CREATE_PRODUCT_TABLE;
import static com.wakaproject.waka.Constant.CREATE_USER_TABLE;
import static com.wakaproject.waka.Constant.PRODUCT_CART_TABLE;
import static com.wakaproject.waka.Constant.PRODUCT_TABLE;
import static com.wakaproject.waka.Constant.USER_TABLE;

public class Database extends SQLiteOpenHelper {
    public Database(Context context){
        super(context,"lehuyanh61.sql",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PRODUCT_TABLE);
        db.execSQL(CREATE_PRODUCT_CART_TABLE);
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_CART_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
    }

}
