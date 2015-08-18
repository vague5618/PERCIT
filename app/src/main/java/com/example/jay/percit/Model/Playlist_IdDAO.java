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
public class Playlist_IdDAO {

    private static final String DATABASE_NAME = "my.db";

    private static final String TABLE_playlist_ID = "playlist_ids";
    private static final String COLUMN_playlist_index = "playlist_index";
    private static final String COLUMN_playlist_image_id = "playlist_image_id";
    private static final String COLUMN_playlist_information_id = "playlist_information_id";
    private static final String COLUMN_playlist_progress1_id = "playlist_progress1_id";
    private static final String COLUMN_playlist_progress2_id = "playlist_progress2_id";
    private static final String COLUMN_playlist_progress3_id = "playlist_progress3_id";

    private Context ctx;
    private DBHelper helper;
    private SQLiteDatabase db;

    public Playlist_IdDAO(Context ctx) {
        this.ctx = ctx;
        helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();
        Log.i("ID_DAO", "===============");


    }

    public static Playlist_IdDAO open(Context ctx) throws SQLException {
        Playlist_IdDAO handler = new Playlist_IdDAO(ctx);
        return handler;
    }


    public void setPlaylist_id(Playlist_Id playlist_id) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_playlist_index, playlist_id.getPlaylist_index());
        values.put(COLUMN_playlist_image_id, playlist_id.getPlaylist_image_id());
        values.put(COLUMN_playlist_information_id, playlist_id.getPlaylist_information_id());
        values.put(COLUMN_playlist_progress1_id, playlist_id.getPlaylist_progress1_id());
        values.put(COLUMN_playlist_progress2_id, playlist_id.getPlaylist_progress2_id());
        values.put(COLUMN_playlist_progress3_id, playlist_id.getPlaylist_progress3_id());

        db.insert(TABLE_playlist_ID, null, values);
    }

    public Playlist_Id getPlaylist_id(int target_index) {

        db = helper.getWritableDatabase();

        Log.i("DB open ", String.valueOf(db.isOpen()));

        String query = "select * from " + TABLE_playlist_ID + " where " +
                COLUMN_playlist_index + " = " + String.valueOf(target_index) + "";

        Log.i("=========", query);

        Cursor cursor = db.rawQuery(query, null);

        Playlist_Id playlist_id = new Playlist_Id();

        if (cursor.moveToFirst()) {

            cursor.moveToFirst();
            playlist_id.setPlaylist_index(Integer.parseInt(cursor.getString(0)));
            playlist_id.setPlaylist_image_id(Integer.parseInt(cursor.getString(1)));
            playlist_id.setPlaylist_information_id(Integer.parseInt(cursor.getString(2)));
            playlist_id.setPlaylist_progress1_id(Integer.parseInt(cursor.getString(3)));
            playlist_id.setPlaylist_progress2_id(Integer.parseInt(cursor.getString(4)));
            playlist_id.setPlaylist_progress3_id(Integer.parseInt(cursor.getString(5)));

            cursor.close();
        } else {

            playlist_id = null;
        }

        db.close();

        return playlist_id;
    }

    public Cursor getPlaylist_id() {

        db = helper.getWritableDatabase();

        Log.i("IMAGEDAO DB open ", String.valueOf(db.isOpen()));

        String query = "select * from " + TABLE_playlist_ID + " ";

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
