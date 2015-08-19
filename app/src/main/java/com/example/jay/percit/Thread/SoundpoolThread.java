package com.example.jay.percit.Thread;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.jay.percit.Data.Music_findRaw;

/**
 * Created by Jay on 2015-08-19.
 */
public class SoundpoolThread {

    private SoundPool soundPool;
    private Context mContext;
    private Music_findRaw music_findRaw;
    int m_Sound_id1, m_Sound_id2, m_Sound_id3, m_Sound_id4, m_Sound_id5, m_Sound_id6, m_Sound_id7, m_Sound_id8, m_Sound_id9;

    public SoundpoolThread(Context mContext, int setting[]) {

        this.mContext = mContext;
        soundPool = new SoundPool(9, AudioManager.STREAM_MUSIC, 0);

        music_findRaw = new Music_findRaw();

        m_Sound_id1 = soundPool.load(mContext, music_findRaw.Music_effect[0], 1);
        m_Sound_id2 = soundPool.load(mContext, music_findRaw.Music_effect[1], 1);
        m_Sound_id3 = soundPool.load(mContext, music_findRaw.Music_effect[2], 1);
        m_Sound_id4 = soundPool.load(mContext, music_findRaw.Music_effect[3], 1);
        m_Sound_id5 = soundPool.load(mContext, music_findRaw.Music_effect[4], 1);
        m_Sound_id6 = soundPool.load(mContext, music_findRaw.Music_effect[5], 1);
        m_Sound_id7 = soundPool.load(mContext, music_findRaw.Music_effect[6], 1);
        m_Sound_id8 = soundPool.load(mContext, music_findRaw.Music_effect[7], 1);
        m_Sound_id9 = soundPool.load(mContext, music_findRaw.Music_effect[8], 1);
    }

    public void play(char target, float power) {
        switch (target) {
            case 'a':
                soundPool.play(m_Sound_id1, power, power, 0, 0, 1.5f);
                break;
            case 'b':
                soundPool.play(m_Sound_id2, power, power, 0, 0, 1.5f);
                break;
            case 'c':
                soundPool.play(m_Sound_id3, power, power, 0, 0, 1.5f);
                break;
            case 'd':
                soundPool.play(m_Sound_id4, power, power, 0, 0, 1.5f);
                break;
            case 'e':
                soundPool.play(m_Sound_id5, power, power, 0, 0, 1.5f);
                break;
            case 'f':
                soundPool.play(m_Sound_id6, power, power, 0, 0, 1.5f);
                break;
            case 'g':
                soundPool.play(m_Sound_id7, power, power, 0, 0, 1.5f);
                break;
            case 'h':
                soundPool.play(m_Sound_id8, power, power, 0, 0, 1.5f);
                break;
            case 'i':
                soundPool.play(m_Sound_id9, power, power, 0, 0, 1.5f);
                break;
        }
    }
}
