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
public class Playlist_ImageDAO {

    private static final String TABLE_playlist_image = "playlist_images";
    private static final String COLUMN_playlist_index = "playlist_index";
    private static final String COLUMN_playlist_image = "playlist_image";
    private static final String COLUMN_playlist_information = "playlist_information";
    private static final String COLUMN_playlist_progress1 = "playlist_progress1";
    private static final String COLUMN_playlist_progress2 = "playlist_progress2";
    private static final String COLUMN_playlist_progress3 = "playlist_progress3";
    private static final String COLUMN_playlist_category = "playlist_category";
    private static final String COLUMN_playlist_level = "playlist_level";
    private static final String COLUMN_playlist_musicname = "playlist_musicname";


    private Context ctx;
    private DBHelper helper;
    private SQLiteDatabase db;

    public Playlist_ImageDAO(Context ctx) {
        this.ctx = ctx;
        helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();


    }

    public static Playlist_ImageDAO open(Context ctx) throws SQLException {
        Playlist_ImageDAO handler = new Playlist_ImageDAO(ctx);
        return handler;
    }


    public void setPlaylist_image(Playlist_Image playlist_image) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_playlist_index, playlist_image.getPlaylist_index());
        values.put(COLUMN_playlist_image, playlist_image.getPlaylist_image());
        values.put(COLUMN_playlist_information, playlist_image.getPlaylist_information());
        values.put(COLUMN_playlist_progress1, playlist_image.getPlaylist_progress1());
        values.put(COLUMN_playlist_progress2, playlist_image.getPlaylist_progress2());
        values.put(COLUMN_playlist_progress3, playlist_image.getPlaylist_progress3());
        values.put(COLUMN_playlist_category, playlist_image.getPlaylist_category());
        values.put(COLUMN_playlist_level, playlist_image.getPlaylist_level());
        values.put(COLUMN_playlist_musicname,playlist_image.getPlaylist_musicname());

        db.insert(TABLE_playlist_image, null, values);
    }

    public Cursor getPlaylist_image() {

        db = helper.getWritableDatabase();

        Log.i("IMAGEDAO DB open ", String.valueOf(db.isOpen()));

        String query = "select * from " + TABLE_playlist_image + " ";

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

    public Cursor getPlaylist_image(String target_category, String target_level) {

        db = helper.getWritableDatabase();

        String query;

        if (target_level==null) {
            Log.i("target_category", " 0 ");

            query = "select * from " + TABLE_playlist_image + " where " +
                    COLUMN_playlist_category + " = "+ "'"+target_category+"'";

        } else if (target_category==null) {
            Log.i("target_level", " 0 ");

            query = "select * from " + TABLE_playlist_image + " where " +
                    COLUMN_playlist_level + " = " + " '"+target_level +"' ";
        } else {
            query = "select * from " + TABLE_playlist_image + " where " +
                    COLUMN_playlist_category + " =  '" + target_category + "' and where " +
                    COLUMN_playlist_level + " = '"+ target_level + "' ";
        }


        Log.i("=========", query);

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.getCount() == 0) {
            Log.i("cursor count", " 0 ");
        } else {
   //         cursor.close();
        }

        db.close();

        return cursor;
    }
}
