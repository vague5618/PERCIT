package com.example.jay.percit.Data;

import android.content.Context;
import android.util.Log;

import com.example.jay.percit.Model.MusicStage_Id;
import com.example.jay.percit.Model.Playlist_Id;
import com.example.jay.percit.Model.Playlist_IdDAO;
import com.example.jay.percit.R;
import com.example.jay.percit.Util.DBHelper;

/**
 * Created by Jay on 2015-08-18.
 */
public class Playlist_Id_Setup {

    Playlist_IdDAO playlist_idDAO;

    public Playlist_Id_Setup(Context mContext) {

        try {
            playlist_idDAO = Playlist_IdDAO.open(mContext);
        } catch (Exception e) {
            Log.i("SQL SETUP ERROR", " ");

            e.printStackTrace();
        }

        setUp();
    }

    void setUp() {

        playlist_idDAO.setPlaylist_id(
                new Playlist_Id(1, R.id.playlist_image1, R.id.playlist_information1,
                        R.id.playlist_main1_progress1, R.id.playlist_main1_progress2, R.id.playlist_main1_progress3)
        );

        playlist_idDAO.setPlaylist_id(
                new Playlist_Id(2, R.id.playlist_image2, R.id.playlist_information2,
                        R.id.playlist_main2_progress1, R.id.playlist_main2_progress2, R.id.playlist_main2_progress3)
        );

        playlist_idDAO.setPlaylist_id(
                new Playlist_Id(3, R.id.playlist_image3, R.id.playlist_information3,
                        R.id.playlist_main1_progress3, R.id.playlist_main3_progress2, R.id.playlist_main3_progress3)
        );

        playlist_idDAO.setPlaylist_id(
                new Playlist_Id(4, R.id.playlist_image4, R.id.playlist_information4,
                        R.id.playlist_main4_progress3, R.id.playlist_main4_progress2, R.id.playlist_main4_progress3)
        );
        playlist_idDAO.setPlaylist_id(
                new Playlist_Id(5, R.id.playlist_image5, R.id.playlist_information5,
                        R.id.playlist_main5_progress3, R.id.playlist_main5_progress2, R.id.playlist_main5_progress3)
        );

        playlist_idDAO.setPlaylist_id(
                new Playlist_Id(6, R.id.playlist_image6, R.id.playlist_information6,
                        R.id.playlist_main6_progress3, R.id.playlist_main6_progress2, R.id.playlist_main6_progress3)
        );
        playlist_idDAO.setPlaylist_id(
                new Playlist_Id(7, R.id.playlist_image7, R.id.playlist_information7,
                        R.id.playlist_main7_progress3, R.id.playlist_main7_progress2, R.id.playlist_main7_progress3)
        );
        playlist_idDAO.setPlaylist_id(
                new Playlist_Id(8, R.id.playlist_image8, R.id.playlist_information8,
                        R.id.playlist_main8_progress3, R.id.playlist_main8_progress2, R.id.playlist_main8_progress3)
        );
    }
}
