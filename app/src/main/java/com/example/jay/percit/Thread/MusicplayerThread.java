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
    int m_Sound_id1, m_Sound_id2, m_Sound_id3, m_Sound_id4;

    public MusicplayerThread(Context mContext) {

        this.mContext = mContext;
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        music_findRaw = new Music_findRaw();

        m_Sound_id1 = soundPool.load(mContext, music_findRaw.Music_effect[0], 1);
        m_Sound_id2 = soundPool.load(mContext, music_findRaw.Music_effect[1], 1);
        m_Sound_id3 = soundPool.load(mContext, music_findRaw.Music_effect[2], 1);
        m_Sound_id4 = soundPool.load(mContext, music_findRaw.Music_effect[3], 1);
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
        }
    }

    public void playBGM(int index) throws Exception {

        try {
            killMediaPlayer();

            if (index == 3) {
                mediaPlayer = MediaPlayer.create(mContext, R.raw.zz_bg_a_marryyou_brunomars);
            } else {

                mediaPlayer = MediaPlayer.create(mContext, music_findRaw.Music_bgm[index]);
            }
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
