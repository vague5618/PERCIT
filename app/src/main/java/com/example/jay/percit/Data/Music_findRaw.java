package com.example.jay.percit.Data;

import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-14.
 */
public class Music_findRaw {

    public int Music_effect[];

    public int Music_bgm[];

    public Music_findRaw()
    {
        Music_effect = new int[1000];
        Music_bgm = new int[1000];

        //for Music_number

        for(int i=0; i<207; i++)
        {
            Music_effect[ i ]= R.raw.a1_snaredrum_wood1+i;
        }

        for(int i=0; i<5; i++)
        {
            Music_bgm[ i ]= R.raw.z_bg_falling_love_10cm+i;
        }

    }
}
