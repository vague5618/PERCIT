package com.example.jay.percit.Thread;

import android.util.Log;

import com.example.jay.percit.Controller.MusicStageSubActivity;
import com.example.jay.percit.Controller.PlaylistMusic;

import com.example.jay.percit.Util.BluetoothThread;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Jay on 2015-07-31.
 */
public class RecordThread {

    private TimerTask mTimer;
    int time_sec = 0;
    private int temp_arr[];
    private int temp_recorded[];

    public void record_start() {

        time_sec = 0;

        BluetoothThread.isRecording = true;

        PlaylistMusic.playlist_music_play.setClickable(false);

        PlaylistMusic.playlist_music_pause.setClickable(false);

        mTimer = new TimerTask() {

            public void run() {

                if (time_sec == 2000) {
                    Recording_cancel();
                }


                Log.i(" =====", "====");
                time_sec++;
            }
        };

        Timer timer = new Timer();
        timer.schedule(mTimer, 0, 30);
    }

    public int get_time() {
        return time_sec;
    }

    public void cancel_timer() {

        if (mTimer != null) {
            time_sec = 0;
            mTimer.cancel();
        }

    }

    public void Recording_cancel() {

        BluetoothThread.isRecording = false;

        PlaylistMusic.playlist_music_play.setClickable(true);

        PlaylistMusic.playlist_music_pause.setClickable(true);

        PlaylistMusic.playlist_music_save.setClickable(true);

        if (mTimer != null) {
            time_sec = 0;
            mTimer.cancel();
        }
    }

    public void Play_Recorded(final int temp_arr[], final float temp_power[], final SoundpoolThread soundpoolThread) {

        this.temp_recorded = temp_arr;

        time_sec = 0;

        Log.i("come", "in");

        mTimer = new TimerTask() {

            public void run() {

                if (temp_arr[time_sec] != 0) {
                    soundpoolThread.play(temp_arr[time_sec], temp_power[time_sec]);
                }

                if (time_sec == 2000) {
                    cancel_timer();
                }


                Log.i("-----", "----------");

                time_sec++;
            }
        };

        Timer timer = new Timer();
        timer.schedule(mTimer, 0, 30);
    }

    public void Play_feedback(final int temp_arr[], int start_time) {

        this.temp_arr = temp_arr;

        time_sec = start_time;

        mTimer = new TimerTask() {

            public void run() {


                System.out.println("index : " + time_sec + "content : " + temp_arr[time_sec]);

                if (temp_arr[time_sec] != 0) {

                    MusicStageSubActivity.feedbackHandler.sendEmptyMessage(temp_arr[time_sec]);
                }

                if (time_sec == 1500) {

                    cancel_timer();
                }

                time_sec++;
            }
        };

        Timer timer = new Timer();
        timer.schedule(mTimer, 0, 30);
    }

    public int Get_currenttime() {
        int temp = time_sec;
        mTimer.cancel();
        return temp;
    }
}
