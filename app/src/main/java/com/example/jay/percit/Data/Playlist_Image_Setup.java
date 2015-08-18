package com.example.jay.percit.Data;

import android.content.Context;
import android.util.Log;

import com.example.jay.percit.Model.Playlist_Id;
import com.example.jay.percit.Model.Playlist_IdDAO;
import com.example.jay.percit.Model.Playlist_Image;
import com.example.jay.percit.Model.Playlist_ImageDAO;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-18.
 */
public class Playlist_Image_Setup {

    Playlist_ImageDAO playlist_ImageDAO;

    public Playlist_Image_Setup(Context mContext) {

        try {
            playlist_ImageDAO = Playlist_ImageDAO.open(mContext);
        } catch (Exception e) {
            Log.i("SQL SETUP ERROR", " ");

            e.printStackTrace();
        }

        setUp();
    }

    void setUp() {

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(1, R.drawable.playlist_main_folk_01_pattern,
                        R.drawable.playlist_main_folk_01_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "FOLK", "LOW","FORK1"
                )
        );
        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(2, R.drawable.playlist_main_folk_02_pattern,
                        R.drawable.playlist_main_folk_02_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "FOLK", "LOW","FORK2"
                )
        );
        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(3, R.drawable.playlist_main_folk_03_pattern,
                        R.drawable.playlist_main_folk_03_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "FOLK", "LOW","FORK3"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(4, R.drawable.playlist_main_folk_04_pattern,
                        R.drawable.playlist_main_folk_04_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "FOLK", "LOW","FORK4"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(5, R.drawable.playlist_main_folk_05_pattern,
                        R.drawable.playlist_main_folk_05_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "FOLK", "LOW","FORK5"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(6, R.drawable.playlist_main_folk_06_pattern,
                        R.drawable.playlist_main_folk_06_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "FOLK", "LOW","FORK6"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(7, R.drawable.playlist_main_folk_07_pattern,
                        R.drawable.playlist_main_folk_07_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "FOLK", "LOW","FORK7"
                )
        );
        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(8, R.drawable.playlist_main_folk_08_pattern,
                        R.drawable.playlist_main_folk_08_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "FOLK", "LOW","FORK8"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(9, R.drawable.playlist_main_pop_01_pattern,
                        R.drawable.playlist_main_pop_01_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "POP", "LOW","BASIC LOW"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(10, R.drawable.playlist_main_pop_02_pattern,
                        R.drawable.playlist_main_pop_02_text, R.drawable.playlist_projressbar_middle_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_middle_02,
                        "POP", "MIDDLE","HAPPY"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(11, R.drawable.playlist_main_pop_03_pattern,
                        R.drawable.playlist_main_pop_03_text, R.drawable.playlist_projressbar_high_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_high_02,
                        "POP", "HIGH","MARRY YOU"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(12, R.drawable.playlist_main_pop_04_pattern,
                        R.drawable.playlist_main_pop_04_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "POP", "LOW","SUGAR"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(13, R.drawable.playlist_main_pop_05_pattern,
                        R.drawable.playlist_main_pop_05_text, R.drawable.playlist_projressbar_middle_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_middle_02,
                        "POP", "MIDDLE","UPTOWN FUNK"
                )
        );


        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(14, R.drawable.playlist_main_pop_06_pattern,
                        R.drawable.playlist_main_pop_06_text, R.drawable.playlist_projressbar_middle_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_middle_02,
                        "POP", "MIDDLE","ANIMALS"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(15, R.drawable.playlist_main_pop_07_pattern,
                        R.drawable.playlist_main_pop_07_text, R.drawable.playlist_projressbar_high_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_high_02,
                        "POP", "HIGH","DAWN"
                )
        );

        playlist_ImageDAO.setPlaylist_image(
                new Playlist_Image(16, R.drawable.playlist_main_pop_08_pattern,
                        R.drawable.playlist_main_pop_08_text, R.drawable.playlist_projressbar_low_01, R.drawable.playlist_projressbar_1dp, R.drawable.playlist_projressbar_low_02,
                        "POP", "LOW","UNBROKEN"
                )
        );
    }
}
