package com.example.jay.percit.Data;

/**
 * Created by Jay on 2015-08-13.
 */
public class Music_information {

    public String music_name;
    public int music_arr[];
    public int music_power[];

    public Music_information(String music_name , int music_arr[], int music_power[])
    {
        this.music_name = music_name;
        this.music_arr = music_arr;
        this.music_power = music_power;
    }

    public String getMusic_name() {
        return music_name;
    }

    public int[] getMusic_arr() {
        return music_arr;
    }

    public int[] getMusic_power() {
        return music_power;
    }
}
