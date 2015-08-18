package com.example.jay.percit.Util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jay.percit.Model.Setting_percit;
import com.example.jay.percit.Model.Setting_percitDAO;

/**
 * Created by Jay on 2015-08-18.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "really6.db";
    private static final int DB_VER = 1;             // DB 버전

    private static final String TABLE_playlist_image = "playlist_images";
    private static final String COLUMN_playlist_image = "playlist_image";
    private static final String COLUMN_playlist_information = "playlist_information";
    private static final String COLUMN_playlist_progress1 = "playlist_progress1";
    private static final String COLUMN_playlist_progress2 = "playlist_progress2";
    private static final String COLUMN_playlist_progress3 = "playlist_progress3";
    private static final String COLUMN_playlist_category = "playlist_category";
    private static final String COLUMN_playlist_level = "playlist_level";
    private static final String COLUMN_playlist_musicname = "playlist_musicname";


    private static final String TABLE_playlist_ID = "playlist_ids";
    private static final String COLUMN_playlist_image_id = "playlist_image_id";
    private static final String COLUMN_playlist_information_id = "playlist_information_id";
    private static final String COLUMN_playlist_progress1_id = "playlist_progress1_id";
    private static final String COLUMN_playlist_progress2_id = "playlist_progress2_id";
    private static final String COLUMN_playlist_progress3_id = "playlist_progress3_id";

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


    private static final String TABLE_playlist_bgm = "playlist_bgm";
    private static final String COLUMN_playlist_index = "playlist_index";
    private static final String COLUMN_playlist_bgm_musicname = "playlist_bgm_musicname";
    private static final String COLUMN_playlist_bgm_raw = "playlist_bgm_raw";
    private static final String COLUMN_playlist_bgm_background= "playlist_bgm_background";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i("DBHelper", "CREATE DB");

        String CREATE_PLAYLIST_ID_TABLE = "CREATE TABLE " +
                TABLE_playlist_ID + "("
                + COLUMN_playlist_index + " INTEGER PRIMARY KEY,"
                + COLUMN_playlist_image_id + " INTEGER,"
                + COLUMN_playlist_information_id + " INTEGER,"
                + COLUMN_playlist_progress1_id + " INTEGER,"
                + COLUMN_playlist_progress2_id + " INTEGER,"
                + COLUMN_playlist_progress3_id + " INTEGER"
                + ")";

        db.execSQL(CREATE_PLAYLIST_ID_TABLE);

        String CREATE_PLAYLIST_IMAGE_TABLE = "CREATE TABLE " +
                TABLE_playlist_image + "("
                + COLUMN_playlist_index + " INTEGER PRIMARY KEY,"
                + COLUMN_playlist_image + " INTEGER,"
                + COLUMN_playlist_information + " INTEGER,"
                + COLUMN_playlist_progress1 + " INTEGER,"
                + COLUMN_playlist_progress2 + " INTEGER,"
                + COLUMN_playlist_progress3 + " INTEGER,"
                + COLUMN_playlist_category + " TEXT,"
                + COLUMN_playlist_level + " TEXT,"
                + COLUMN_playlist_musicname + " TEXT"
                + ")";

        db.execSQL(CREATE_PLAYLIST_IMAGE_TABLE);


        String CREATE_PLAYLIST_BGM_TABLE = "CREATE TABLE " +
                TABLE_playlist_bgm + "("
                + COLUMN_playlist_index + " INTEGER PRIMARY KEY,"
                + COLUMN_playlist_bgm_musicname + " TEXT,"
                + COLUMN_playlist_bgm_raw + " INTEGER,"
                + COLUMN_playlist_bgm_background + " INTEGER"
                + ")";

        db.execSQL(CREATE_PLAYLIST_BGM_TABLE);



        String CREATE_TABLE_setting_percit = "CREATE TABLE " +
                TABLE_setting_percit + "("
                + COLUMN_setting_percit_index + " INTEGER PRIMARY KEY,"
                + COLUMN_setting_percit_a + " INTEGER,"
                + COLUMN_setting_percit_b + " INTEGER,"
                + COLUMN_setting_percit_c + " INTEGER,"
                + COLUMN_setting_percit_d + " INTEGER,"
                + COLUMN_setting_percit_e + " INTEGER,"
                + COLUMN_setting_percit_f + " INTEGER,"
                + COLUMN_setting_percit_g + " INTEGER,"
                + COLUMN_setting_percit_h + " INTEGER,"
                + COLUMN_setting_percit_i + " INTEGER"
                + ")";

        db.execSQL(CREATE_TABLE_setting_percit
        );

        Setting_percit setting_percit_temp = new Setting_percit(1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        ContentValues values = new ContentValues();
        values.put(COLUMN_setting_percit_index, setting_percit_temp.getSetting_percit_index());
        values.put(COLUMN_setting_percit_a, setting_percit_temp.getSetting_percit_a());
        values.put(COLUMN_setting_percit_b, setting_percit_temp.getSetting_percit_b());
        values.put(COLUMN_setting_percit_c, setting_percit_temp.getSetting_percit_c());
        values.put(COLUMN_setting_percit_d, setting_percit_temp.getSetting_percit_d());
        values.put(COLUMN_setting_percit_e, setting_percit_temp.getSetting_percit_e());
        values.put(COLUMN_setting_percit_f, setting_percit_temp.getSetting_percit_f());
        values.put(COLUMN_setting_percit_g, setting_percit_temp.getSetting_percit_g());
        values.put(COLUMN_setting_percit_h, setting_percit_temp.getSetting_percit_h());
        values.put(COLUMN_setting_percit_i, setting_percit_temp.getSetting_percit_i());

        db.insert(TABLE_setting_percit, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //DB의 버전이 바뀌면 수행
        db.execSQL("drop table if exist tb_score");
        onCreate(db);
    }
}