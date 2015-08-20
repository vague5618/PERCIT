package com.example.jay.percit.Controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jay.percit.Handler.RecordHandler;
import com.example.jay.percit.Model.Playlist_bgm;
import com.example.jay.percit.Model.Playlist_bgmDAO;
import com.example.jay.percit.Model.Setting_percitDAO;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Thread.SoundpoolThread;
import com.example.jay.percit.Util.BluetoothScan;
import com.example.jay.percit.Util.BluetoothThread;

/**
 * Created by Jay on 2015-08-20.
 */
public class PlaylistMusic extends ActionBarActivity implements View.OnClickListener {

    Playlist_bgmDAO playlist_bgmDAO;
    Setting_percitDAO setting_percitDAO;

    MusicplayerThread musicplayerThread;
    SoundpoolThread soundpoolThread;

    LinearLayout playlist_music_background;
    public static Button playlist_music_play;
    public static Button playlist_music_pause;
    public static Button playlist_music_record;
    public static Button playlist_music_save;

    ImageView playlist_music_back;
    Boolean check = false;

    public static BluetoothThread gBluetoothThread;
    public BluetoothAdapter mBluetoothAdapter;
    public BluetoothScan mBluetoothScan;

    Playlist_bgm playlist_bgm_temp;

    public static int record_arr[];
    public static float record_power[];
    public static RecordHandler recordHandler;
    RecordThread recordThread;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        musicplayerThread.killMediaPlayer();
        recordThread.cancel_timer();
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_music);

        Intent intent = getIntent();
        String musicname = intent.getExtras().getString("Musicname");

        System.out.println("music name=======" + musicname);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        try {
            playlist_bgmDAO = Playlist_bgmDAO.open(this);
            setting_percitDAO = Setting_percitDAO.open(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        playlist_bgm_temp = playlist_bgmDAO.getPlaylist_bgm(musicname);

        musicplayerThread = new MusicplayerThread(this);

        soundpoolThread = new SoundpoolThread(this, setting_percitDAO.getSetting_percit());

        playlist_music_background = (LinearLayout) findViewById(R.id.playlist_music_background);

        playlist_music_background.setBackground(getResources().getDrawable(playlist_bgm_temp.getPlaylist_bgm_background()));

        playlist_music_back = (ImageView) findViewById(R.id.playlist_music_back);
        playlist_music_play = (Button) findViewById(R.id.playlist_music_play);
        playlist_music_pause = (Button) findViewById(R.id.playlist_music_pause);
        playlist_music_record = (Button) findViewById(R.id.playlist_music_record_icon);
        playlist_music_save = (Button) findViewById(R.id.playlist_music_save);


        BluetoothOn();

        playlist_music_back.setOnClickListener(this);
        playlist_music_play.setOnClickListener(this);
        playlist_music_pause.setOnClickListener(this);
        playlist_music_record.setOnClickListener(this);
        playlist_music_save.setOnClickListener(this);
        playlist_music_save.setClickable(false);

        record_arr = new int[3000];
        record_power = new float[3000];
        recordThread = new RecordThread();
        recordHandler = new RecordHandler(recordThread);
    }

    public void recorded_init() {
        for (int i = 0; i < 3000; i++) {
            record_arr[i] = 0;
            record_power[i] = 0;
        }
    }


    public void BluetoothOn() {

        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);

        mBluetoothAdapter = bluetoothManager.getAdapter();

        gBluetoothThread = new BluetoothThread(this, soundpoolThread);

        mBluetoothScan = new BluetoothScan(mBluetoothAdapter, new Handler(), gBluetoothThread);

        mBluetoothScan.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playlist_music_back:

                Intent intent = new Intent(this, PlaylistActivity.class);
                musicplayerThread.killMediaPlayer();

                startActivity(intent);
                overridePendingTransition(R.anim.slide_hold, R.anim.slide_out_left);
                finish();

                break;

            case R.id.playlist_music_play:
                try {
                    if (musicplayerThread.isFinish == true) {
                        musicplayerThread.select_playBGM(playlist_bgm_temp.getPlaylist_bgm_raw());
                    } else {
                        musicplayerThread.resumeBGM();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.playlist_music_pause:
                try {
                    if (musicplayerThread.getState() == true) {
                        musicplayerThread.stopBGM();
                        check = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


            case R.id.playlist_music_record_icon:

                if (BluetoothThread.isRecording == false) {

                    try {
                        musicplayerThread.select_playBGM(playlist_bgm_temp.getPlaylist_bgm_raw());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    BluetoothThread.isRecording = true;
                    recorded_init();
                    recordThread.record_start();

                } else {

                    musicplayerThread.stopBGM();

                    playlist_music_save.setBackground(getResources().getDrawable(R.drawable.playlist_music_01_btn_focus));

                    recordThread.Recording_cancel();

                    BluetoothThread.isRecording = false;
                }

                break;

            case R.id.playlist_music_save:

                Toast.makeText(this, "save success", Toast.LENGTH_SHORT).show();
          //
//                recordThread.cancel_timer();
//
//                recordThread.Play_Recorded(record_arr, record_power, soundpoolThread);

                MyStorageActivity.record_arr = record_arr;
                MyStorageActivity.record_power = record_power;
                MyStorageActivity.music_raw = playlist_bgm_temp.getPlaylist_bgm_raw();
                MyStorageActivity.soundpoolThread = soundpoolThread;

                break;
        }
    }
}
