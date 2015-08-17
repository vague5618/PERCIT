package com.example.jay.percit.Listview;

import com.example.jay.percit.R;

import java.util.ArrayList;

/**
 * Created by Jay on 2015-08-14.
 */
public class MusicStage_ImageSetup {

    private ArrayList<MusicStage_ImageModel> musicStage_Image_models;

    public MusicStage_ImageSetup(ArrayList<MusicStage_ImageModel> musicStage_Image_models) {

        musicStage_Image_models.add(new MusicStage_ImageModel(R.drawable.musicstage_main_01_pattern,
                R.drawable.musicstage_main_01, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03,
                "0"));

        musicStage_Image_models.add(new MusicStage_ImageModel(R.drawable.musicstage_main_02_pattern,
                R.drawable.musicstage_main_02, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03,
                "1"));

        musicStage_Image_models.add(new MusicStage_ImageModel(R.drawable.musicstage_main_03_pattern,
                R.drawable.musicstage_main_03, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03,
                "2"));

        musicStage_Image_models.add(new MusicStage_ImageModel(R.drawable.musicstage_main_04_pattern,
                R.drawable.musicstage_main_04, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03,
                "3"));

        musicStage_Image_models.add(new MusicStage_ImageModel(R.drawable.musicstage_main_05_pattern,
                R.drawable.musicstage_main_05, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03,
                "4"));

        musicStage_Image_models.add(new MusicStage_ImageModel(R.drawable.musicstage_main_06_pattern,
                R.drawable.musicstage_main_06, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03,
                "5"));

        musicStage_Image_models.add(new MusicStage_ImageModel(R.drawable.musicstage_main_07_pattern,
                R.drawable.musicstage_main_07, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03,
                "6"));

        musicStage_Image_models.add(new MusicStage_ImageModel(R.drawable.musicstage_main_08_pattern,
                R.drawable.musicstage_main_08, R.drawable.musicstage_progressbar_01, R.drawable.musicstage_progressbar_02, R.drawable.musicstage_progressbar_03,
                "7"));
    }
}
