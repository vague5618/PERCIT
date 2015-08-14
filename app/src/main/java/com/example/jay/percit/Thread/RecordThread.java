package com.example.jay.percit.Thread;

import com.example.jay.percit.Controller.MusicStageActivity;
import com.example.jay.percit.Fragment.MusicStageFragment2;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by Jay on 2015-07-31.
 */
public class RecordThread {

    private TimerTask mTimer;
    int time_sec = 0;
    private static final int NOMAL_MODE = 5;
    private static final int RECORD_MODE = 6;
    private static final int PLAY_MODE = 7;
    private int temp_arr[];

    public void record_start(){

        MusicStageActivity.gMusicHandler.sendEmptyMessage(RECORD_MODE);

        time_sec = 0;

        mTimer = new TimerTask() {

            public void run() {

                if(time_sec==500 || MusicStageActivity.state==NOMAL_MODE)
                {
                    cancel_timer();
                }

                time_sec++;
            }
        };

        Timer timer = new Timer();
        timer.schedule(mTimer, 0, 30);
    }

    public int get_time()
    {
        return time_sec;
    }

    public void cancel_timer()
    {
        MusicStageActivity.gMusicHandler.sendEmptyMessage(NOMAL_MODE);
        MusicStageFragment2.guiHandler.sendEmptyMessage(NOMAL_MODE);
        MusicStageActivity.state = NOMAL_MODE;
        time_sec = 0;
        mTimer.cancel();
    }

    public void Play_Recorded(final int temp_arr[],final int temp_power[])
    {
        MusicStageActivity.gMusicHandler.sendEmptyMessage(PLAY_MODE);

       this.temp_arr=temp_arr;

        time_sec = 0;

        mTimer = new TimerTask() {

           public void run() {

                if(temp_arr[time_sec]!=0)
                {
                    MusicStageActivity.gMusicHandler.sendEmptyMessage(temp_arr[time_sec]);
                    MusicStageActivity.gMusicHandler.sendEmptyMessage(temp_power[time_sec]);
                }

                if(time_sec==500 || MusicStageActivity.state==NOMAL_MODE)
                {
                    cancel_timer();
                }

                time_sec++;
            }
        };

        Timer timer = new Timer();
        timer.schedule(mTimer, 0, 30);
    }
}
