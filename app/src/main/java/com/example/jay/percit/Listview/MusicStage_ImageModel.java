package com.example.jay.percit.Listview;

import android.graphics.drawable.Drawable;

/**
 * Created by Jay on 2015-08-14.
 */
public class MusicStage_ImageModel {

    private int musicstage_image;
    private int musicstage_information;
    private int musicstage_progress1;
    private int musicstage_progress2;
    private int musicstage_progress3;
    private String musicstage_bgnumber;


    public MusicStage_ImageModel(int musicstage_image, int musicstage_information, int musicstage_progress1, int musicstage_progress2, int musicstage_progress3, String musicstage_bgnumber) {
        this.musicstage_image = musicstage_image;
        this.musicstage_information = musicstage_information;
        this.musicstage_progress1 = musicstage_progress1;
        this.musicstage_progress2 = musicstage_progress2;
        this.musicstage_progress3 = musicstage_progress3;
        this.musicstage_bgnumber = musicstage_bgnumber;
    }

    public MusicStage_ImageModel(int musicstage_image, int musicstage_information, int musicstage_progress1, int musicstage_progress2, String musicstage_bgnumber) {
        this.musicstage_image = musicstage_image;
        this.musicstage_information = musicstage_information;
        this.musicstage_progress1 = musicstage_progress1;
        this.musicstage_progress2 = musicstage_progress2;
        this.musicstage_bgnumber = musicstage_bgnumber;
    }


    public int getMusicstage_image() {
        return musicstage_image;
    }

    public int getMusicstage_information() {
        return musicstage_information;
    }

    public int getMusicstage_progress1() {
        return musicstage_progress1;
    }

    public int getMusicstage_progress2() {
        return musicstage_progress2;
    }

    public int getMusicstage_progress3() {
        return musicstage_progress3;
    }

    public String getMusicstage_bgnumber() {
        return musicstage_bgnumber;
    }
}
