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
public class MusicStage_ImageDAO {

    private static final String TABLE_musicstage_image = "musicstage_images";
    private static final String COLUMN_musicstage_index="musicstage_index";
    private static final String COLUMN_musicstage_image = "musicstage_image";
    private static final String COLUMN_musicstage_information = "musicstage_information";
    private static final String COLUMN_musicstage_progress1 = "musicstage_progress1";
    private static final String COLUMN_musicstage_progress2 = "musicstage_progress2";
    private static final String COLUMN_musicstage_progress3 = "musicstage_progress3";
    private static final String COLUMN_musicstage_like = "musicstage_like";

    private Context ctx;
    private DBHelper helper;
    private SQLiteDatabase db;

    public MusicStage_ImageDAO(Context ctx) {
        this.ctx = ctx;
        helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public static MusicStage_ImageDAO open(Context ctx) throws SQLException {
        MusicStage_ImageDAO handler = new MusicStage_ImageDAO(ctx);
        return handler;
    }

    public void setMusicsage_image(MusicStage_Image musicsage_image) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_musicstage_index, musicsage_image.getMusicstage_index());
        values.put(COLUMN_musicstage_image, musicsage_image.getMusicstage_image());
        values.put(COLUMN_musicstage_information, musicsage_image.getMusicstage_information());
        values.put(COLUMN_musicstage_progress1, musicsage_image.getMusicstage_progress1());
        values.put(COLUMN_musicstage_progress2, musicsage_image.getMusicstage_progress2());
        values.put(COLUMN_musicstage_progress3, musicsage_image.getMusicstage_progress3());
        values.put(COLUMN_musicstage_like, musicsage_image.getMusicstage_like());

        db.insert(TABLE_musicstage_image, null, values);
    }

    public Cursor getPlaylist_image() {

        db = helper.getWritableDatabase();

        Log.i("IMAGEDAO DB open ", String.valueOf(db.isOpen()));

        String query = "select * from " + TABLE_musicstage_image + " ";

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
