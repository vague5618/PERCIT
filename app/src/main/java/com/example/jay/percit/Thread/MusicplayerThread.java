package com.example.jay.percit.Thread;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.example.jay.percit.Data.Music_findRaw;
import com.example.jay.percit.R;

public class MusicplayerThread {

    private MediaPlayer mediaPlayer;
    private Context mContext;

    private int currentPosition = 0;

    boolean isPlay = false;

    public MusicplayerThread(Context mContext) {
        this.mContext = mContext;
    }

    public void select_playBGM(int raw) throws Exception {
        try {

            if (isPlay == false) {
                killMediaPlayer();
                mediaPlayer = MediaPlayer.create(mContext, raw);
                mediaPlayer.setLooping(false);
                mediaPlayer.start();
                isPlay = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopBGM() {
        try {
            if (isPlay == true) {
                currentPosition = mediaPlayer.getCurrentPosition();
                mediaPlayer.pause();
                isPlay = false;
            }
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
