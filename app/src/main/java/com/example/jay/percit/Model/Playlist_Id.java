package com.example.jay.percit.Model;

/**
 * Created by Jay on 2015-08-18.
 */
public class Playlist_Id {

    private int playlist_index;
    private int playlist_image_id;
    private int playlist_information_id;
    private int playlist_progress1_id;
    private int playlist_progress2_id;
    private int playlist_progress3_id;

    public Playlist_Id() {
    }

    public Playlist_Id(int playlist_index, int playlist_image_id, int playlist_information_id, int playlist_progress1_id, int playlist_progress2_id, int playlist_progress3_id) {
        this.playlist_index = playlist_index;
        this.playlist_image_id = playlist_image_id;
        this.playlist_information_id = playlist_information_id;
        this.playlist_progress1_id = playlist_progress1_id;
        this.playlist_progress2_id = playlist_progress2_id;
        this.playlist_progress3_id = playlist_progress3_id;
    }

    public int getPlaylist_index() {
        return playlist_index;
    }

    public void setPlaylist_index(int playlist_index) {
        this.playlist_index = playlist_index;
    }

    public int getPlaylist_image_id() {
        return playlist_image_id;
    }

    public void setPlaylist_image_id(int playlist_image_id) {
        this.playlist_image_id = playlist_image_id;
    }

    public int getPlaylist_information_id() {
        return playlist_information_id;
    }

    public void setPlaylist_information_id(int playlist_information_id) {
        this.playlist_information_id = playlist_information_id;
    }

    public int getPlaylist_progress1_id() {
        return playlist_progress1_id;
    }

    public void setPlaylist_progress1_id(int playlist_progress1_id) {
        this.playlist_progress1_id = playlist_progress1_id;
    }

    public int getPlaylist_progress2_id() {
        return playlist_progress2_id;
    }

    public void setPlaylist_progress2_id(int playlist_progress2_id) {
        this.playlist_progress2_id = playlist_progress2_id;
    }

    public int getPlaylist_progress3_id() {
        return playlist_progress3_id;
    }

    public void setPlaylist_progress3_id(int playlist_progress3_id) {
        this.playlist_progress3_id = playlist_progress3_id;
    }

}
