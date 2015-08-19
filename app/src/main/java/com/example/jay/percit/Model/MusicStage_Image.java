package com.example.jay.percit.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by Jay on 2015-08-14.
 */
public class MusicStage_Image {

    private int musicstage_index;
    private int musicstage_image;
    private int musicstage_information;
    private int musicstage_progress1;
    private int musicstage_progress2;
    private int musicstage_progress3;
    private int musicstage_like;


    public MusicStage_Image(int musicstage_index, int musicstage_image, int musicstage_information, int musicstage_progress1, int musicstage_progress2, int musicstage_progress3, int musicstage_like) {
        this.musicstage_index = musicstage_index;
        this.musicstage_image = musicstage_image;
        this.musicstage_information = musicstage_information;
        this.musicstage_progress1 = musicstage_progress1;
        this.musicstage_progress2 = musicstage_progress2;
        this.musicstage_progress3 = musicstage_progress3;
        this.musicstage_like = musicstage_like;
    }

    public MusicStage_Image() {
    }

    public int getMusicstage_image() {
        return musicstage_image;
    }

    public void setMusicstage_image(int musicstage_image) {
        this.musicstage_image = musicstage_image;
    }

    public int getMusicstage_index() {
        return musicstage_index;
    }

    public void setMusicstage_index(int musicstage_index) {
        this.musicstage_index = musicstage_index;
    }

    public int getMusicstage_information() {
        return musicstage_information;
    }

    public void setMusicstage_information(int musicstage_information) {
        this.musicstage_information = musicstage_information;
    }

    public int getMusicstage_progress1() {
        return musicstage_progress1;
    }

    public void setMusicstage_progress1(int musicstage_progress1) {
        this.musicstage_progress1 = musicstage_progress1;
    }

    public int getMusicstage_progress2() {
        return musicstage_progress2;
    }

    public void setMusicstage_progress2(int musicstage_progress2) {
        this.musicstage_progress2 = musicstage_progress2;
    }

    public int getMusicstage_progress3() {
        return musicstage_progress3;
    }

    public void setMusicstage_progress3(int musicstage_progress3) {
        this.musicstage_progress3 = musicstage_progress3;
    }

    public int getMusicstage_like() {
        return musicstage_like;
    }

    public void setMusicstage_like(int musicstage_like) {
        this.musicstage_like = musicstage_like;
    }
}
