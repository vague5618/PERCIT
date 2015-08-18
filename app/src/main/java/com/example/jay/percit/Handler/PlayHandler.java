package com.example.jay.percit.Handler;

import android.os.Message;

import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Util.BluetoothConnectService;

import java.util.logging.Handler;

/**
 * Created by Jay on 2015-08-18.
 */
public class PlayHandler extends android.os.Handler{

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


    private float current_Volume = 1;

    private MusicplayerThread mMusicPlayerThread;
    private BluetoothConnectService mBluetoothConnectService;

    public PlayHandler(MusicplayerThread mMusicPlayerThread) {
        this.mMusicPlayerThread = mMusicPlayerThread;
    }

    public void handleMessage(Message msg) {

        switch (msg.what) {
            case MUSIC_START:

                break;

            case REQUEST_A:

                mMusicPlayerThread.play(1, current_Volume);

                break;

            case REQUEST_B:


                mMusicPlayerThread.play(2, current_Volume);

                break;

            case REQUEST_C:

                mMusicPlayerThread.play(3, current_Volume);

                break;

            case REQUEST_D:

                mMusicPlayerThread.play(4, current_Volume);

                break;

            case REQUEST_E:

                mMusicPlayerThread.play(4, current_Volume);

                break;

            case REQUEST_F:

                mMusicPlayerThread.play(4, current_Volume);

                break;
            case REQUEST_G:

                mMusicPlayerThread.play(4, current_Volume);

                break;

            case REQUEST_H:

                mMusicPlayerThread.play(4, current_Volume);

                break;

            case REQUEST_I:

                mMusicPlayerThread.play(4, current_Volume);

                break;

        }
    }
}
