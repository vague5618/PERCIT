package com.example.jay.percit.Data;

import android.content.Context;
import android.util.Log;

import com.example.jay.percit.Model.MusicStage_Id;
import com.example.jay.percit.Model.MusicStage_IdDAO;
import com.example.jay.percit.Model.MusicStage_Image;
import com.example.jay.percit.Model.MusicStage_ImageDAO;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-19.
 */
public class Musicstage_Image_Setup {

    MusicStage_ImageDAO musicStageImageDAO;

    public Musicstage_Image_Setup(Context mContext) {

        try {
            musicStageImageDAO = musicStageImageDAO.open(mContext);
        } catch (Exception e) {
            Log.i("SQL SETUP ERROR", " ");

            e.printStackTrace();
        }

        setUp();
    }

    void setUp() {

        musicStageImageDAO.setMusicsage_image(new MusicStage_Image(1, R.drawable.musicstage_main_01_pattern,
                R.drawable.musicstage_main_01, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03, 10
        ));

        musicStageImageDAO.setMusicsage_image(new MusicStage_Image(2, R.drawable.musicstage_main_02_pattern,
                R.drawable.musicstage_main_02, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03, 10
        ));

        musicStageImageDAO.setMusicsage_image(new MusicStage_Image(3, R.drawable.musicstage_main_03_pattern,
                R.drawable.musicstage_main_03, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03, 10
        ));

        musicStageImageDAO.setMusicsage_image(new MusicStage_Image(4, R.drawable.musicstage_main_04_pattern,
                R.drawable.musicstage_main_04, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03, 10
        ));

        musicStageImageDAO.setMusicsage_image(new MusicStage_Image(5, R.drawable.musicstage_main_05_pattern,
                R.drawable.musicstage_main_05, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03, 10
        ));

        musicStageImageDAO.setMusicsage_image(new MusicStage_Image(6, R.drawable.musicstage_main_06_pattern,
                R.drawable.musicstage_main_06, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03, 10
        ));

        musicStageImageDAO.setMusicsage_image(new MusicStage_Image(7, R.drawable.musicstage_main_07_pattern,
                R.drawable.musicstage_main_07, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03, 10
        ));
        musicStageImageDAO.setMusicsage_image(new MusicStage_Image(8, R.drawable.musicstage_main_08_pattern,
                R.drawable.musicstage_main_08, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03, 10
        ));
    }
}
