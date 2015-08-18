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
public class Playlist_bgmDAO {

    private static final String TABLE_playlist_bgm = "playlist_bgm";
    private static final String COLUMN_playlist_index = "playlist_index";
    private static final String COLUMN_playlist_bgm_musicname = "playlist_bgm_musicname";
    private static final String COLUMN_playlist_bgm_raw = "playlist_bgm_raw";
    private static final String COLUMN_playlist_bgm_background= "playlist_bgm_background";


    private Context ctx;
    private DBHelper helper;
    private SQLiteDatabase db;

    public Playlist_bgmDAO(Context ctx) {
        this.ctx = ctx;
        helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();
        Log.i("ID_DAO", "===============");


    }

    public static Playlist_bgmDAO open(Context ctx) throws SQLException {
        Playlist_bgmDAO handler = new Playlist_bgmDAO(ctx);
        return handler;
    }


    public void setPlaylist_bgm(Playlist_bgm playlist_bgm) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_playlist_index, playlist_bgm.getPlaylist_bgm_index());
        values.put(COLUMN_playlist_bgm_musicname, playlist_bgm.getPlaylist_bgm_musicname());
        values.put(COLUMN_playlist_bgm_raw, playlist_bgm.getPlaylist_bgm_raw());
        values.put(COLUMN_playlist_bgm_background, playlist_bgm.getPlaylist_bgm_background());
        db.insert(TABLE_playlist_bgm, null, values);
    }

    public Playlist_bgm getPlaylist_bgm(String musicname) {

        db = helper.getWritableDatabase();

        Log.i("DB open ", String.valueOf(db.isOpen()));

        String query = "select * from " + TABLE_playlist_bgm + " where " +
                COLUMN_playlist_bgm_musicname + " = '" + musicname + "'";

        Log.i("=========", query);

        Cursor cursor = db.rawQuery(query, null);

        Playlist_bgm playlist_bgm = new Playlist_bgm();

        if (cursor.moveToFirst()) {

            cursor.moveToFirst();
            playlist_bgm.setPlaylist_bgm_index(Integer.parseInt(cursor.getString(0)));
            playlist_bgm.setPlaylist_bgm_musicname((cursor.getString(1)));
            playlist_bgm.setPlaylist_bgm_raw(Integer.parseInt(cursor.getString(2)));
            playlist_bgm.setPlaylist_bgm_background(Integer.parseInt(cursor.getString(3)));

            cursor.close();
        } else {

            playlist_bgm = null;
        }

        db.close();

        return playlist_bgm;
    }

    public Cursor getPlaylist_bgm() {

        db = helper.getWritableDatabase();

        Log.i("IMAGEDAO DB open ", String.valueOf(db.isOpen()));

        String query = "select * from " + TABLE_playlist_bgm + " ";

        Log.i("=========", query);

        db = helper.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.getCount() == 0) {
            Log.i("cursor count", " 0 ");
        } else {
            Log.i("cursor count", " not 0 ");
//            cursor.close();
        }
//        db.close();

        return cursor;
    }


}
