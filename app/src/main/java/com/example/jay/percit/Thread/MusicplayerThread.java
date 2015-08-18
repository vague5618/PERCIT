package com.example.jay.percit.Thread;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.example.jay.percit.Data.Music_findRaw;
import com.example.jay.percit.R;


public class MusicplayerThread extends Thread implements Runnable {

    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private Context mContext;
    private Music_findRaw music_findRaw;
    private int currentPosition = 0;

    boolean isPlay = true;
    int m_Sound_id1, m_Sound_id2, m_Sound_id3, m_Sound_id4, m_Sound_id5, m_Sound_id6, m_Sound_id7, m_Sound_id8, m_Sound_id9;

    public MusicplayerThread(Context mContext) {

        this.mContext = mContext;
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
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

    public void play(int target, float power) {
        switch (target) {
            case 1:
                soundPool.play(m_Sound_id1, power, power, 0, 0, 1);
                break;
            case 2:
                soundPool.play(m_Sound_id2, power, power, 0, 0, 1);
                break;
            case 3:
                soundPool.play(m_Sound_id3, power, power, 0, 0, 1);
                break;
            case 4:
                soundPool.play(m_Sound_id4, power, power, 0, 0, 1);
                break;
            case 5:
                soundPool.play(m_Sound_id5, power, power, 0, 0, 1);
                break;
            case 6:
                soundPool.play(m_Sound_id6, power, power, 0, 0, 1);
                break;
            case 7:
                soundPool.play(m_Sound_id7, power, power, 0, 0, 1);
                break;
            case 8:
                soundPool.play(m_Sound_id8, power, power, 0, 0, 1);
                break;
            case 9:
                soundPool.play(m_Sound_id9, power, power, 0, 0, 1);
                break;
        }
    }

    public void select_playBGM(int raw) throws Exception {

        try {
            killMediaPlayer();

            mediaPlayer = MediaPlayer.create(mContext, raw);

            mediaPlayer.setLooping(false);
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playBGM(int index) throws Exception {

        try {
            killMediaPlayer();

            mediaPlayer = MediaPlayer.create(mContext, R.raw.zz_bg_a_marryyou_brunomars);

            mediaPlayer.setLooping(false);
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopBGM() {
        try {
            currentPosition = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resumeBGM() {
        if (currentPosition == 0) {

        } else {
            mediaPlayer.seekTo(currentPosition);
            mediaPlayer.start();
        }
    }

    public void killMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
