package com.example.jay.percit.Handler;

import android.os.Message;
import android.util.Log;

import com.example.jay.percit.Controller.PlaylistMusic;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Thread.SoundpoolThread;
import com.example.jay.percit.Util.BluetoothConnectService;

import java.util.logging.Handler;

/**
 * Created by Jay on 2015-08-18.
 */
public class RecordHandler extends android.os.Handler {

    public static final int REQUEST_RECORD = 127;

    private static final int MUSIC_START = 0;
    private static final int REQUEST_A = 'a';
    private static final int REQUEST_B = 'b';
    private static final int REQUEST_C = 'c';
    private static final int REQUEST_D = 'd';
    private static final int REQUEST_E = 'e';
    private static final int REQUEST_F = 'f';
    private static final int REQUEST_G = 'g';
    private static final int REQUEST_H = 'h';
    private static final int REQUEST_I = 'i';


    RecordThread recordThread;

    private float current_Volume = 1;

    public RecordHandler(RecordThread recordThread) {
        this.recordThread = recordThread;
    }

    public void handleMessage(Message msg) {

        switch (msg.what) {

            case REQUEST_RECORD:

                int get_time = recordThread.get_time();

                Log.d("===recorded handler====","");

                PlaylistMusic.record_arr[get_time] = msg.arg1;
                PlaylistMusic.record_power[get_time] = (float) msg.obj;

                break;

//            case REQUEST_A:
//
//                soundpoolThread.play(REQUEST_A, current_Volume);
//
//                break;
//
//            case REQUEST_B:
//
//
//                soundpoolThread.play(2, current_Volume);
//
//                break;
//
//            case REQUEST_C:
//
//                soundpoolThread.play(3, current_Volume);
//
//                break;
//
//            case REQUEST_D:
//
//                soundpoolThread.play(4, current_Volume);
//
//                break;
//
//            case REQUEST_E:
//
//                soundpoolThread.play(4, current_Volume);
//
//                break;
//
//            case REQUEST_F:
//
//                soundpoolThread.play(4, current_Volume);
//
//                break;
//            case REQUEST_G:
//
//                soundpoolThread.play(4, current_Volume);
//
//                break;
//
//            case REQUEST_H:
//
//                soundpoolThread.play(4, current_Volume);
//
//                break;
//
//            case REQUEST_I:
//
//                soundpoolThread.play(4, current_Volume);
//
//                break;

        }
    }
}
