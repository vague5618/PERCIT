package com.example.jay.percit.Listview;

import com.example.jay.percit.R;

import java.util.ArrayList;

/**
 * Created by Jay on 2015-08-14.
 */
public class MusicStage_ImageSetup {

    private ArrayList<MusicStage_ImageModel> musicStage_Image_models;

    public MusicStage_ImageSetup(ArrayList<MusicStage_ImageModel> musicStage_Image_models) {

        musicStage_Image_models.add(new MusicStage_ImageModel(R.drawable.ic_launcher,
                R.drawable.record_mic, R.drawable.musicstage_transparent,
                R.drawable.musicstage_transparent,
                "10cm"));
    }
}
