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

    public static boolean isFinish = true;

    public MusicplayerThread(Context mContext) {
        this.mContext = mContext;
    }

    public void select_playBGM(int raw) throws Exception {
        try {
            killMediaPlayer();
            mediaPlayer = MediaPlayer.create(mContext, raw);
            mediaPlayer.setLooping(false);
            mediaPlayer.setVolume(0.01f, 0.01f);
            mediaPlayer.start();
            isFinish = false;

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    isFinish = true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getState() {
        return mediaPlayer.isPlaying();
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
            mediaPlayer.setVolume(0.01f,0.01f);
            mediaPlayer.start();
        }
    }

    public void killMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                isFinish = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
