package com.example.jay.percit.Listview;

import com.example.jay.percit.R;

import java.util.ArrayList;

/**
 * Created by Jay on 2015-08-14.
 */
public class MusicStage_IdSetup {

    private ArrayList<MusicStage_IdModel> musicStage_id_models;

    public MusicStage_IdSetup(ArrayList<MusicStage_IdModel> musicStage_id_models) {

        musicStage_id_models.add(new MusicStage_IdModel(R.id.musicstage_image1,R.id.musicstage_information1, R.id.musicstage_progress1,R.id.musicstage_progress2));
    }
}
