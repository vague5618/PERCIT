package com.example.jay.percit.Thread;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.example.jay.percit.R;


public class MusicplayerThread extends Thread implements Runnable {

    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private Context mContext;
    boolean isPlay = true;
    int m_Sound_id1, m_Sound_id2, m_Sound_id3, m_Sound_id4;

    public MusicplayerThread(Context mContext) {

        this.mContext = mContext;
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);

        m_Sound_id1 = soundPool.load(mContext, R.raw.drum1, 1);
        m_Sound_id2 = soundPool.load(mContext, R.raw.drum2, 1);
        m_Sound_id3 = soundPool.load(mContext, R.raw.drum3, 1);
        m_Sound_id4 = soundPool.load(mContext, R.raw.drum4, 1);
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

    public void playAudio() throws Exception {

        killMediaPlayer();
        mediaPlayer = MediaPlayer.create(mContext, R.raw.beat2);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
    }

    private void killMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
