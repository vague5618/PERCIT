package com.example.jay.percit.Data;

import android.content.Context;
import android.util.Log;

import com.example.jay.percit.Model.Playlist_Id;
import com.example.jay.percit.Model.Playlist_IdDAO;
import com.example.jay.percit.Model.Playlist_bgm;
import com.example.jay.percit.Model.Playlist_bgmDAO;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-18.
 */
public class Playlist_Bgm_Setup {

    Playlist_bgmDAO playlist_bgmDAO;

    public Playlist_Bgm_Setup(Context mContext) {

        try {
            playlist_bgmDAO = Playlist_bgmDAO.open(mContext);
        } catch (Exception e) {
            Log.i("SQL SETUP ERROR", " ");

            e.printStackTrace();
        }

        setUp();
    }

    void setUp() {

        playlist_bgmDAO.setPlaylist_bgm(
                new Playlist_bgm(1, R.raw.zz_bg_b_happy_pharrellwilliams, "HAPPY", R.drawable.playlist_music_background_happy)
        );

        playlist_bgmDAO.setPlaylist_bgm(
                new Playlist_bgm(2, R.raw.zz_bg_a_marryyou_brunomars, "MARRY YOU", R.drawable.playlist_music_background_marryyou1)
        );

        playlist_bgmDAO.setPlaylist_bgm(
                new Playlist_bgm(3, R.raw.zz_bg_d_sugar_maroon5, "SUGAR", R.drawable.playlist_music_background_sugar)
        );

        playlist_bgmDAO.setPlaylist_bgm(
                new Playlist_bgm(4, R.raw.zz_bg_e_uptownfunk_markronson, "UPTOWN FUNK", R.drawable.playlist_music_background_uptownfunk)
        );

    }
}
