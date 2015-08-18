package com.example.jay.percit.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jay on 2015-08-17.
 */
public class MusicStage_IdDAO extends SQLiteOpenHelper {


    private static MusicStage_IdDAO musicStageIdDAO;
    private static final String DATABASE_NAME = "my.db";
    private static final String TABLE_MUSICSTAGE_ID = "musicstage_id";
    private static final String COLUMN_musicstage_index = "musicstage_index";
    private static final String COLUMN_musicstage_image_id = "musicstage_image_id";
    private static final String COLUMN_musicstage_information_id = "musicstage_information_id";
    private static final String COLUMN_musicstage_progress1_id = "musicstage_progress1_id";
    private static final String COLUMN_musicstage_progress2_id = "musicstage_progress2_id";
    private static final String COLUMN_musicstage_progress3_id = "musicstage_progress3_id";
    private static final String COLUMN_musicstage_like_txt_id = "musicstage_like_txt_id";
    private static final String COLUMN_musicstage_like_img_id = "musicstage_like_image_id";

    public MusicStage_IdDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static synchronized MusicStage_IdDAO getHelper(Context context)
    {
        if(musicStageIdDAO==null) {

            Log.i("DB IS NULL", "HELPER");

            musicStageIdDAO = new MusicStage_IdDAO(context, DATABASE_NAME, null, 1);
        }

        return musicStageIdDAO;
    }

    public void onCreate(SQLiteDatabase db) {

        String CREATE_MUSICSTATE_ID_TABLE = "CREATE TABLE " +
                TABLE_MUSICSTAGE_ID + "("
                + COLUMN_musicstage_index + " INTEGER PRIMARY KEY,"
                + COLUMN_musicstage_image_id + " INTEGER,"
                + COLUMN_musicstage_information_id + " INTEGER,"
                + COLUMN_musicstage_progress1_id + " INTEGER,"
                + COLUMN_musicstage_progress2_id + " INTEGER,"
                + COLUMN_musicstage_progress3_id + " INTEGER,"
                + COLUMN_musicstage_like_txt_id + " INTEGER,"
                + COLUMN_musicstage_like_img_id + " INTEGER" + ")";

        db.execSQL(CREATE_MUSICSTATE_ID_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSICSTAGE_ID);
        onCreate(db);
    }

    public void add_musicstage_id(MusicStage_Id musicstage_id) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_musicstage_index, musicstage_id.getMusicstage_index());
        values.put(COLUMN_musicstage_image_id, musicstage_id.getMusicstage_image_id());
        values.put(COLUMN_musicstage_information_id, musicstage_id.getMusicstage_image_id());
        values.put(COLUMN_musicstage_progress1_id, musicstage_id.getMusicstage_progress1_id());
        values.put(COLUMN_musicstage_progress2_id, musicstage_id.getMusicstage_progress2_id());
        values.put(COLUMN_musicstage_progress3_id, musicstage_id.getMusicstage_progress3_id());
        values.put(COLUMN_musicstage_like_txt_id, musicstage_id.getMusicstage_like_txt_id());
        values.put(COLUMN_musicstage_like_img_id, musicstage_id.getMusicstage_like_img_id());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_MUSICSTAGE_ID, null, values);
    }

    public MusicStage_Id findMusicStage_Id(int target_index) {

        String query = "select * from " + TABLE_MUSICSTAGE_ID + " where " +
                COLUMN_musicstage_index + " = " + String.valueOf(target_index) + "";

        Log.i("=========", query);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        MusicStage_Id musicstage_id = new MusicStage_Id();


        if (cursor.moveToFirst()) {

            cursor.moveToFirst();
            musicstage_id.setMusicstage_index(Integer.parseInt(cursor.getString(0)));
            musicstage_id.setMusicstage_image_id(Integer.parseInt(cursor.getString(1)));
            musicstage_id.setMusicstage_information_id(Integer.parseInt(cursor.getString(2)));
            musicstage_id.setMusicstage_progress1_id(Integer.parseInt(cursor.getString(3)));
            musicstage_id.setMusicstage_progress2_id(Integer.parseInt(cursor.getString(4)));
            musicstage_id.setMusicstage_progress3_id(Integer.parseInt(cursor.getString(5)));
            musicstage_id.setMusicstage_like_txt_id(Integer.parseInt(cursor.getString(6)));
            musicstage_id.setMusicstage_like_img_id(Integer.parseInt(cursor.getString(7)));

            cursor.close();
        } else {

            musicstage_id = null;
        }

        db.close();

        return musicstage_id;
    }
}
