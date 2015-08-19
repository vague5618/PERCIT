package com.example.jay.percit.Controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jay.percit.Animation.ScaleAnim;
import com.example.jay.percit.Animation.TranslateAnim;
import com.example.jay.percit.Handler.FeedbackHandler;
import com.example.jay.percit.Handler.PlayHandler;
import com.example.jay.percit.Model.Playlist_bgm;
import com.example.jay.percit.Model.Playlist_bgmDAO;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Thread.SoundpoolThread;
import com.example.jay.percit.Util.BluetoothScan;
import com.example.jay.percit.Util.BluetoothThread;

public class PlaylistBasic extends ActionBarActivity implements View.OnClickListener {

    ImageView playlist_basic_back;
    Playlist_bgmDAO playlist_bgmDAO;
    MusicplayerThread musicplayerThread;
    SoundpoolThread soundpoolThread;
    LinearLayout playlist_basic_background;
    Button playlist_playbtn;
    Button playlist_stopbtn;
    PlayHandler playHandler;

    public static BluetoothThread gBluetoothThread;
    public BluetoothAdapter mBluetoothAdapter;
    public BluetoothScan mBluetoothScan;

    Playlist_bgm playlist_bgm_temp;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        musicplayerThread.killMediaPlayer();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_basic);

        Intent intent = getIntent();
        String musicname = intent.getExtras().getString("Musicname");

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        try {
            playlist_bgmDAO = Playlist_bgmDAO.open(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        playlist_bgm_temp = playlist_bgmDAO.getPlaylist_bgm(musicname);

        musicplayerThread = new MusicplayerThread(this);
        soundpoolThread = new SoundpoolThread(this,null);


        playlist_basic_background = (LinearLayout) findViewById(R.id.playlist_basic_background);
        playlist_basic_back = (ImageView) findViewById(R.id.playlist_basic_back);
        playlist_playbtn = (Button) findViewById(R.id.playlist_basic_playbtn);
        playlist_stopbtn = (Button) findViewById(R.id.playlist_basic_stopbtn);

        playlist_basic_background.setBackground(getResources().getDrawable(playlist_bgm_temp.getPlaylist_bgm_background()));

        playlist_playbtn.setOnClickListener(this);
        playlist_stopbtn.setOnClickListener(this);
        playlist_basic_back.setOnClickListener(this);
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
            case R.id.playlist_basic_back:

                Intent intent = new Intent(this, PlaylistActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_hold, R.anim.slide_out_left);
                finish();

                break;

            case R.id.playlist_basic_playbtn:
                try {

                    musicplayerThread.select_playBGM(playlist_bgm_temp.getPlaylist_bgm_raw());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.playlist_basic_stopbtn:
                try {
                    musicplayerThread.stopBGM();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
