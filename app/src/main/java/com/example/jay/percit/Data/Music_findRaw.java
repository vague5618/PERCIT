package com.example.jay.percit.Data;

import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-14.
 */
public class Music_findRaw {

    public int Music_raw[];

    public Music_findRaw()
    {
        Music_raw = new int[1000];

        //for Music_number

        for(int i=0; i<4; i++)
        {
            Music_raw[ i ]= R.raw.a_snaredrum_metal1_1;
        }
    }
}
