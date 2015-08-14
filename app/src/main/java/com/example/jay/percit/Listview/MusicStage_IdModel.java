package com.example.jay.percit.Listview;

/**
 * Created by Jay on 2015-08-14.
 */
public class MusicStage_IdModel {

    private int musicstage_image_id;
    private int musicstage_information_id;
    private int musicstage_progress1_id;
    private int musicstage_progress2_id;

    public MusicStage_IdModel(int musicstage_image_id, int musicstage_information_id, int musicstage_progress1_id, int musicstage_progress2_id) {
        this.musicstage_image_id = musicstage_image_id;
        this.musicstage_information_id = musicstage_information_id;
        this.musicstage_progress1_id = musicstage_progress1_id;
        this.musicstage_progress2_id = musicstage_progress2_id;
    }

    public int getMusicstage_image_id() {
        return musicstage_image_id;
    }

    public int getMusicstage_information_id() {
        return musicstage_information_id;
    }

    public int getMusicstage_progress1_id() {
        return musicstage_progress1_id;
    }

    public int getMusicstage_progress2_id() {
        return musicstage_progress2_id;
    }
}
