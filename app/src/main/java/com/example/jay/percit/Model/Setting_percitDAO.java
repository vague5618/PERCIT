package com.example.jay.percit.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.jay.percit.Util.DBHelper;

import java.sql.SQLException;

/**
 * Created by Jay on 2015-08-18.
 */
public class Setting_percitDAO {

    private static final String TABLE_setting_percit = "setting_percit";
    private static final String COLUMN_setting_percit_index = "setting_percit_index";
    private static final String COLUMN_setting_percit_a = "setting_percit_a";
    private static final String COLUMN_setting_percit_b = "setting_percit_b";
    private static final String COLUMN_setting_percit_c = "setting_percit_c";
    private static final String COLUMN_setting_percit_d = "setting_percit_d";
    private static final String COLUMN_setting_percit_e = "setting_percit_e";
    private static final String COLUMN_setting_percit_f = "setting_percit_f";
    private static final String COLUMN_setting_percit_g = "setting_percit_g";
    private static final String COLUMN_setting_percit_h = "setting_percit_h";
    private static final String COLUMN_setting_percit_i = "setting_percit_i";

    private Context ctx;
    private DBHelper helper;
    private SQLiteDatabase db;

    public Setting_percitDAO(Context ctx) {
        this.ctx = ctx;
        helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();

    }

    public static Setting_percitDAO open(Context ctx) throws SQLException {
        Setting_percitDAO handler = new Setting_percitDAO(ctx);
        return handler;
    }

    public void setSetting_percit(Setting_percit setting_percit) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_setting_percit_index, setting_percit.getSetting_percit_index());
        values.put(COLUMN_setting_percit_a, setting_percit.getSetting_percit_a());
        values.put(COLUMN_setting_percit_b, setting_percit.getSetting_percit_b());
        values.put(COLUMN_setting_percit_c, setting_percit.getSetting_percit_c());
        values.put(COLUMN_setting_percit_d, setting_percit.getSetting_percit_d());
        values.put(COLUMN_setting_percit_e, setting_percit.getSetting_percit_e());
        values.put(COLUMN_setting_percit_f, setting_percit.getSetting_percit_f());
        values.put(COLUMN_setting_percit_g, setting_percit.getSetting_percit_g());
        values.put(COLUMN_setting_percit_h, setting_percit.getSetting_percit_h());
        values.put(COLUMN_setting_percit_i, setting_percit.getSetting_percit_i());

        db.insert(TABLE_setting_percit, null, values);
    }

    public int updateSetting_percit(Setting_percit setting_percit) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_setting_percit_a, setting_percit.getSetting_percit_a());
        values.put(COLUMN_setting_percit_b, setting_percit.getSetting_percit_b());
        values.put(COLUMN_setting_percit_c, setting_percit.getSetting_percit_c());
        values.put(COLUMN_setting_percit_d, setting_percit.getSetting_percit_d());
        values.put(COLUMN_setting_percit_e, setting_percit.getSetting_percit_e());
        values.put(COLUMN_setting_percit_f, setting_percit.getSetting_percit_f());
        values.put(COLUMN_setting_percit_g, setting_percit.getSetting_percit_g());
        values.put(COLUMN_setting_percit_h, setting_percit.getSetting_percit_h());
        values.put(COLUMN_setting_percit_i, setting_percit.getSetting_percit_i());

        return db.update(TABLE_setting_percit, values, COLUMN_setting_percit_index + " = 1", null);
    }


    public Setting_percit getSetting_percit() {

        db = helper.getWritableDatabase();

        Setting_percit setting_percit_temp = new Setting_percit();

        Log.i("IMAGEDAO DB open ", String.valueOf(db.isOpen()));

        String query = "select * from " + TABLE_setting_percit + " ";

        Log.i("=========", query);

        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        if (cursor.moveToFirst()) {

            setting_percit_temp.setSetting_percit_index(Integer.parseInt(cursor.getString(0)));
            setting_percit_temp.setSetting_percit_a(Integer.parseInt(cursor.getString(1)));
            setting_percit_temp.setSetting_percit_b(Integer.parseInt(cursor.getString(2)));
            setting_percit_temp.setSetting_percit_c(Integer.parseInt(cursor.getString(3)));
            setting_percit_temp.setSetting_percit_d(Integer.parseInt(cursor.getString(4)));
            setting_percit_temp.setSetting_percit_e(Integer.parseInt(cursor.getString(5)));
            setting_percit_temp.setSetting_percit_f(Integer.parseInt(cursor.getString(6)));
            setting_percit_temp.setSetting_percit_g(Integer.parseInt(cursor.getString(7)));
            setting_percit_temp.setSetting_percit_h(Integer.parseInt(cursor.getString(8)));
            setting_percit_temp.setSetting_percit_h(Integer.parseInt(cursor.getString(9)));

            cursor.close();
        } else {

//
        }
        db.close();

        return setting_percit_temp;
    }

}
