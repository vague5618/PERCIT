package com.example.jay.percit.Thread;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import com.example.jay.percit.Data.Music_findRaw;
import com.example.jay.percit.Model.Setting_percit;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-19.
 */
public class SoundpoolThread {

    private SoundPool soundPool;
    private Context mContext;
    private Music_findRaw music_findRaw;
    int m_Sound_id1, m_Sound_id2, m_Sound_id3, m_Sound_id4, m_Sound_id5, m_Sound_id6, m_Sound_id7, m_Sound_id8, m_Sound_id9;

    public SoundpoolThread(Context mContext, Setting_percit setting_percit) {

        this.mContext = mContext;
        soundPool = new SoundPool(9, AudioManager.STREAM_MUSIC, 0);

        music_findRaw = new Music_findRaw();

        if (setting_percit.getSetting_percit_a() != -1) {
            m_Sound_id1 = soundPool.load(mContext, music_findRaw.Music_effect[setting_percit.getSetting_percit_a()], 1);
        }
        else
        {
            m_Sound_id1 = soundPool.load(mContext, R.raw.zzz_noexist, 1);
        }
        if (setting_percit.getSetting_percit_b() != -1) {
            m_Sound_id2 = soundPool.load(mContext, music_findRaw.Music_effect[setting_percit.getSetting_percit_b()], 1);
        }
        else
        {
            m_Sound_id2 = soundPool.load(mContext, R.raw.zzz_noexist, 1);
        }
        if (setting_percit.getSetting_percit_c() != -1) {
            m_Sound_id3 = soundPool.load(mContext, music_findRaw.Music_effect[setting_percit.getSetting_percit_c()], 1);
        }
        else
        {
            m_Sound_id3 = soundPool.load(mContext, R.raw.zzz_noexist, 1);
        }

        if (setting_percit.getSetting_percit_d() != -1) {
            m_Sound_id4 = soundPool.load(mContext, music_findRaw.Music_effect[setting_percit.getSetting_percit_d()], 1);
        }
        else
        {
            m_Sound_id4 = soundPool.load(mContext, R.raw.zzz_noexist, 1);
        }

        if (setting_percit.getSetting_percit_e() != -1) {
            m_Sound_id5 = soundPool.load(mContext, music_findRaw.Music_effect[setting_percit.getSetting_percit_e()], 1);
        }

        else
        {
            m_Sound_id5 = soundPool.load(mContext, R.raw.zzz_noexist, 1);
        }

        if (setting_percit.getSetting_percit_f() != -1) {
            m_Sound_id6 = soundPool.load(mContext, music_findRaw.Music_effect[setting_percit.getSetting_percit_f()], 1);
        }

        else
        {
            m_Sound_id6 = soundPool.load(mContext, R.raw.zzz_noexist, 1);
        }

        if (setting_percit.getSetting_percit_g() != -1) {
            m_Sound_id7 = soundPool.load(mContext, music_findRaw.Music_effect[setting_percit.getSetting_percit_g()], 1);
        }

        else
        {
            m_Sound_id7 = soundPool.load(mContext, R.raw.zzz_noexist, 1);
        }

        if (setting_percit.getSetting_percit_h() != -1) {
            m_Sound_id8 = soundPool.load(mContext, music_findRaw.Music_effect[setting_percit.getSetting_percit_h()], 1);
        }

        else
        {
            m_Sound_id8 = soundPool.load(mContext, R.raw.zzz_noexist, 1);
        }

        if (setting_percit.getSetting_percit_i() != -1) {
            m_Sound_id9 = soundPool.load(mContext, music_findRaw.Music_effect[setting_percit.getSetting_percit_i()], 1);
        }
        else
        {
            m_Sound_id9 = soundPool.load(mContext, R.raw.zzz_noexist, 1);
        }

        Log.i("==set 1",String.valueOf(setting_percit.getSetting_percit_a()));

        Log.i("==set2",String.valueOf(setting_percit.getSetting_percit_b()));

        Log.i("==set3",String.valueOf(setting_percit.getSetting_percit_c()));

        Log.i("==set4",String.valueOf(setting_percit.getSetting_percit_d()));

        Log.i("==set5",String.valueOf(setting_percit.getSetting_percit_e()));

        Log.i("==set6",String.valueOf(setting_percit.getSetting_percit_f()));

        Log.i("==set7",String.valueOf(setting_percit.getSetting_percit_g()));

        Log.i("==set8",String.valueOf(setting_percit.getSetting_percit_h()));

        Log.i("==set9",String.valueOf(setting_percit.getSetting_percit_i()));

    }

    public void play(int target, float power) {
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
