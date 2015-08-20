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
public class MusicStage_IdDAO {

    private static final String TABLE_musicstage_id = "musicstage_Id";
    private static final String COLUMN_musicstage_index = "musicstage_index";
    private static final String COLUMN_musicstage_image_id = "musicstage_image_id";
    private static final String COLUMN_musicstage_information_id = "musicstage_information_id";
    private static final String COLUMN_musicstage_progress1_id = "musicstage_progress1_id";
    private static final String COLUMN_musicstage_progress2_id = "musicstage_progress2_id";
    private static final String COLUMN_musicstage_progress3_id = "musicstage_progress3_id";
    private static final String COLUMN_musicstage_like_txt_id = "musicstage_like_txt_id";
    private static final String COLUMN_musicstage_like_img_id = "musicstage_like_img_id";

    private Context ctx;
    private DBHelper helper;
    private SQLiteDatabase db;

    public MusicStage_IdDAO(Context ctx) {
        this.ctx = ctx;
        helper = new DBHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public static MusicStage_IdDAO open(Context ctx) throws SQLException {
        MusicStage_IdDAO handler = new MusicStage_IdDAO(ctx);
        return handler;
    }


    public void setMusicStage_Id(MusicStage_Id musicStage_id) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_musicstage_index, musicStage_id.getMusicstage_index());
        values.put(COLUMN_musicstage_image_id, musicStage_id.getMusicstage_image_id());
        values.put(COLUMN_musicstage_information_id, musicStage_id.getMusicstage_information_id());
        values.put(COLUMN_musicstage_progress1_id, musicStage_id.getMusicstage_progress1_id());
        values.put(COLUMN_musicstage_progress2_id, musicStage_id.getMusicstage_progress2_id());
        values.put(COLUMN_musicstage_progress3_id, musicStage_id.getMusicstage_progress3_id());
        values.put(COLUMN_musicstage_like_txt_id, musicStage_id.getMusicstage_like_txt_id());
        values.put(COLUMN_musicstage_like_img_id, musicStage_id.getMusicstage_like_img_id());
        db.insert(TABLE_musicstage_id, null, values);
    }


    public Cursor getMusicStage_Id() {

        db = helper.getWritableDatabase();

        Log.i("IMAGEDAO DB open ", String.valueOf(db.isOpen()));

        String query = "select * from " + TABLE_musicstage_id + " ";

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
