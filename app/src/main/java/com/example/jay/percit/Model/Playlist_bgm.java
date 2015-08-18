package com.example.jay.percit.Model;

/**
 * Created by Jay on 2015-08-18.
 */
public class Playlist_bgm {

    private int Playlist_bgm_index;
    private int Playlist_bgm_raw;
    private String Playlist_bgm_musicname;
    private int Playlist_bgm_background;

    public Playlist_bgm(int playlist_bgm_index, int playlist_bgm_raw, String playlist_bgm_musicname, int playlist_bgm_background) {
        Playlist_bgm_index = playlist_bgm_index;
        Playlist_bgm_raw = playlist_bgm_raw;
        Playlist_bgm_musicname = playlist_bgm_musicname;
        Playlist_bgm_background = playlist_bgm_background;
    }

    public Playlist_bgm() {
    }

    public int getPlaylist_bgm_index() {
        return Playlist_bgm_index;
    }

    public void setPlaylist_bgm_index(int playlist_bgm_index) {
        Playlist_bgm_index = playlist_bgm_index;
    }

    public int getPlaylist_bgm_raw() {
        return Playlist_bgm_raw;
    }

    public void setPlaylist_bgm_raw(int playlist_bgm_raw) {
        Playlist_bgm_raw = playlist_bgm_raw;
    }

    public String getPlaylist_bgm_musicname() {
        return Playlist_bgm_musicname;
    }

    public void setPlaylist_bgm_musicname(String playlist_bgm_musicname) {
        Playlist_bgm_musicname = playlist_bgm_musicname;
    }

    public int getPlaylist_bgm_background() {
        return Playlist_bgm_background;
    }

    public void setPlaylist_bgm_background(int playlist_bgm_background) {
        Playlist_bgm_background = playlist_bgm_background;
    }
}
