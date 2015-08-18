package com.example.jay.percit.Model;

/**
 * Created by Jay on 2015-08-18.
 */
public class Playlist_Image {

    private int playlist_index;
    private int playlist_image;
    private int playlist_information;
    private int playlist_progress1;
    private int playlist_progress2;
    private int playlist_progress3;
    private String playlist_category;
    private String playlist_level;
    private String playlist_musicname;

    public Playlist_Image(int playlist_index, int playlist_image, int playlist_information, int playlist_progress1, int playlist_progress2, int playlist_progress3, String playlist_category, String playlist_level, String playlist_musicname) {
        this.playlist_index = playlist_index;
        this.playlist_image = playlist_image;
        this.playlist_information = playlist_information;
        this.playlist_progress1 = playlist_progress1;
        this.playlist_progress2 = playlist_progress2;
        this.playlist_progress3 = playlist_progress3;
        this.playlist_category = playlist_category;
        this.playlist_level = playlist_level;
        this.playlist_musicname = playlist_musicname;
    }

    public String getPlaylist_musicname() {
        return playlist_musicname;
    }

    public void setPlaylist_musicname(String playlist_musicname) {
        this.playlist_musicname = playlist_musicname;
    }

    public String getPlaylist_level() {
        return playlist_level;
    }

    public void setPlaylist_level(String playlist_level) {
        this.playlist_level = playlist_level;
    }

    public Playlist_Image() {
    }

    public int getPlaylist_index() {
        return playlist_index;
    }

    public void setPlaylist_index(int playlist_index) {
        this.playlist_index = playlist_index;
    }

    public int getPlaylist_image() {
        return playlist_image;
    }

    public void setPlaylist_image(int playlist_image) {
        this.playlist_image = playlist_image;
    }

    public int getPlaylist_information() {
        return playlist_information;
    }

    public void setPlaylist_information(int playlist_information) {
        this.playlist_information = playlist_information;
    }

    public int getPlaylist_progress1() {
        return playlist_progress1;
    }

    public void setPlaylist_progress1(int playlist_progress1) {
        this.playlist_progress1 = playlist_progress1;
    }

    public int getPlaylist_progress2() {
        return playlist_progress2;
    }

    public void setPlaylist_progress2(int playlist_progress2) {
        this.playlist_progress2 = playlist_progress2;
    }

    public int getPlaylist_progress3() {
        return playlist_progress3;
    }

    public void setPlaylist_progress3(int playlist_progress3) {
        this.playlist_progress3 = playlist_progress3;
    }

    public String getPlaylist_category() {
        return playlist_category;
    }

    public void setPlaylist_category(String playlist_category) {
        this.playlist_category = playlist_category;
    }
}
