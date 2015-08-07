package com.example.jay.percit.Handler;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.jay.percit.Controller.CommunityActivity;
import com.example.jay.percit.Controller.MusicplayerActivity;
import com.example.jay.percit.Fragment.CommunityFragment2;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Util.BluetoothConnectService;

public class MusicHandler extends Handler {

    private static final int MUSIC_START = 0;
    private static final int REQUEST_A = 'a';
    private static final int REQUEST_B = 'b';
    private static final int REQUEST_C = 'c';
    private static final int REQUEST_D = 'd';
    private static final int NOMAL_MODE = 5;
    private static final int RECORD_MODE = 6;
    private static final int PLAY_MODE = 7;

    private float current_Volume = 1;
    private int save_Volume = 1;

    private MusicplayerThread mMusicPlayerThread;
    private RecordThread mRecordThread;
    private BluetoothConnectService mBluetoothConnectService;

    public MusicHandler(MusicplayerThread mMusicPlayerThread, RecordThread mRecordThread)
    {
        this.mRecordThread = mRecordThread;
        this.mMusicPlayerThread=mMusicPlayerThread;
    }

    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        switch (msg.what) {
            case MUSIC_START:

                break;

            case REQUEST_A:

                if (CommunityActivity.state == PLAY_MODE) {

                    byte[] temp_content= {'a'};

              //      mBluetoothConnectService.write(temp_content);
                    CommunityActivity.gBluetoothThread.write(temp_content);
                    CommunityFragment2.guiHandler.sendEmptyMessage(REQUEST_A);
                    mMusicPlayerThread.play(1,current_Volume);
                }

                else if (CommunityActivity.state == RECORD_MODE) {

                    int temp_index = mRecordThread.get_time();

                    CommunityActivity.record_power[temp_index] = save_Volume;
                    CommunityActivity.record_arr[temp_index] = REQUEST_A;
                    mMusicPlayerThread.play(1,current_Volume);
                }

                else{
                    mMusicPlayerThread.play(1,current_Volume);
                }

                break;

            case REQUEST_B:

                if (CommunityActivity.state == PLAY_MODE) {

                    byte[] temp_content= {'b'};

               //    mBluetoothConnectService.write(temp_content);
                    CommunityActivity.gBluetoothThread.write(temp_content);
                    CommunityFragment2.guiHandler.sendEmptyMessage(REQUEST_B);
                    mMusicPlayerThread.play(2,current_Volume);


                }

                else if (CommunityActivity.state == RECORD_MODE) {

                    int temp_index = mRecordThread.get_time();

                    CommunityActivity.record_power[temp_index] = save_Volume;

                    CommunityActivity.record_arr[temp_index] = REQUEST_B;

                    mMusicPlayerThread.play(2,current_Volume);
                }

                else{

                    mMusicPlayerThread.play(2,current_Volume);
                }

                break;


            case REQUEST_C:

                if (CommunityActivity.state == PLAY_MODE) {

                    byte[] temp_content= {'c'};

               //    mBluetoothConnectService.write(temp_content);
                    CommunityActivity.gBluetoothThread.write(temp_content);
                    CommunityFragment2.guiHandler.sendEmptyMessage(REQUEST_C);
                    mMusicPlayerThread.play(3,current_Volume);

                }

                else if (CommunityActivity.state == RECORD_MODE) {

                    int temp_index = mRecordThread.get_time();

                    CommunityActivity.record_power[temp_index] = save_Volume;

                    CommunityActivity.record_arr[temp_index] = REQUEST_C;

                    mMusicPlayerThread.play(3,current_Volume);
                }
                else
                {
                    mMusicPlayerThread.play(3,current_Volume);
                }

                break;


            case REQUEST_D:

                if (CommunityActivity.state == PLAY_MODE) {

                    byte[] temp_content= {'d'};
             //       mBluetoothConnectService.write(temp_content);
                    CommunityActivity.gBluetoothThread.write(temp_content);
                    CommunityFragment2.guiHandler.sendEmptyMessage(REQUEST_D);
                    mMusicPlayerThread.play(4,current_Volume);
                }

                else if (CommunityActivity.state == RECORD_MODE) {

                    int temp_index = mRecordThread.get_time();

                    CommunityActivity.record_power[temp_index] = save_Volume;

                    CommunityActivity.record_arr[temp_index] = REQUEST_D;

                    mMusicPlayerThread.play(4,current_Volume);
                }

                else {

                    mMusicPlayerThread.play(4,current_Volume);
                }

                break;

            case NOMAL_MODE:

                CommunityFragment2.guiHandler.sendEmptyMessage(NOMAL_MODE);
                break;

            case RECORD_MODE:

                CommunityFragment2.guiHandler.sendEmptyMessage(RECORD_MODE);
                break;

            case PLAY_MODE:

                CommunityFragment2.guiHandler.sendEmptyMessage(PLAY_MODE);
                break;

            default:

                save_Volume = msg.what;

                current_Volume = (float)((msg.what-'0'))/(float)10;

                break;
        }

    }
}



