package com.example.jay.percit.Controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jay.percit.Animation.ScaleAnim;
import com.example.jay.percit.Animation.TranslateAnim;
import com.example.jay.percit.Handler.FeedbackHandler;
import com.example.jay.percit.Handler.MusicHandler;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Util.BluetoothScan;
import com.example.jay.percit.Util.BluetoothThread;

public class MusicStageSubActivity extends ActionBarActivity implements View.OnClickListener {


    final static int FEEDBACK_START = 1;

    ImageView musicstage_sub_back;
    ImageView musicstage_sub_imagepattern;
    ImageView musicstage_sub_progress1;
    ImageView musicstage_sub_progress2;
    ImageView musicstage_sub_progress3;


    public static ImageView musicstage_sub_mainboard;
    public static ImageView musicstage_sub_kick1;
    public static ImageView musicstage_sub_kick2;
    public static ImageView musicstage_sub_sub1;
    public static ImageView musicstage_sub_sub2;
    public static ImageView musicstage_sub_sub3;
    public static ImageView musicstage_sub_sub4;
    public static ImageView musicstage_sub_sub5;
    public static ImageView musicstage_sub_sub6;

    public static TextView musicstage_sub_sub6_text;

    public static TextView musicstage_sub_sub5_text;

    public static TextView musicstage_sub_sub4_text;

    public static TextView musicstage_sub_sub3_text;

    public static TextView musicstage_sub_sub2_text;

    public static TextView musicstage_sub_sub1_text;

    public static TextView musicstage_sub_mainboard_text;

    public static TextView musicstage_sub_kick1_text;

    public static TextView musicstage_sub_kick2_text;


    MusicplayerThread mMusicplayerThread;

    public static AlphaAnimation mMusicAnimation;
    public static ScaleAnim mMusicAnimation_scale;
    public static TranslateAnim mMusicAnimation_down;
    public static Animation mFeedbackAnim;
    public static BluetoothThread gBluetoothThread;
    public BluetoothAdapter mBluetoothAdapter;
    public RecordThread mRecordThread;
    public BluetoothScan mBluetoothScan;
    public static FeedbackHandler feedbackHandler;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_stage_sub);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        BluetoothOn();
        Anim_Prepare();
        findId();

        mRecordThread = new RecordThread();
        mMusicplayerThread = new MusicplayerThread(this);

        feedbackHandler = new FeedbackHandler(gBluetoothThread, mMusicplayerThread, mRecordThread);

        musicstage_sub_back = (ImageView) findViewById(R.id.musicstage_sub_back);
        musicstage_sub_imagepattern = (ImageView) findViewById(R.id.musicstage_sub_imagepattern);

        musicstage_sub_progress1 = (ImageView) findViewById(R.id.musicstage_sub_progressbar_01);
        musicstage_sub_progress2 = (ImageView) findViewById(R.id.musicstage_sub_progressbar_02);
        musicstage_sub_progress3 = (ImageView) findViewById(R.id.musicstage_sub_progressbar_03);

        musicstage_sub_back.setOnClickListener(this);
        musicstage_sub_imagepattern.setOnClickListener(this);
    }

    public void findId() {
        musicstage_sub_mainboard = (ImageView) findViewById(R.id.musicstage_sub_mainboard);
        musicstage_sub_kick1 = (ImageView) findViewById(R.id.musicstage_sub_kick1);
        musicstage_sub_kick2 = (ImageView) findViewById(R.id.musicstage_sub_kick2);
        musicstage_sub_sub1 = (ImageView) findViewById(R.id.musicstage_sub_sub1);
        musicstage_sub_sub2 = (ImageView) findViewById(R.id.musicstage_sub_sub2);
        musicstage_sub_sub3 = (ImageView) findViewById(R.id.musicstage_sub_sub3);
        musicstage_sub_sub4 = (ImageView) findViewById(R.id.musicstage_sub_sub4);
        musicstage_sub_sub5 = (ImageView) findViewById(R.id.musicstage_sub_sub5);
        musicstage_sub_sub6 = (ImageView) findViewById(R.id.musicstage_sub_sub6);

        musicstage_sub_sub6_text = (TextView) findViewById(R.id.musicstage_sub_sub6_text);

        musicstage_sub_sub5_text = (TextView) findViewById(R.id.musicstage_sub_sub5_text);

        musicstage_sub_sub4_text = (TextView) findViewById(R.id.musicstage_sub_sub4_text);

        musicstage_sub_sub3_text = (TextView) findViewById(R.id.musicstage_sub_sub3_text);

        musicstage_sub_sub2_text = (TextView) findViewById(R.id.musicstage_sub_sub2_text);

        musicstage_sub_sub1_text = (TextView) findViewById(R.id.musicstage_sub_sub1_text);

        musicstage_sub_mainboard_text = (TextView) findViewById(R.id.musicstage_sub_mainboard_text);

        musicstage_sub_kick1_text = (TextView) findViewById(R.id.musicstage_sub_kick1_text);

        musicstage_sub_kick2_text = (TextView) findViewById(R.id.musicstage_sub_kick2_text);


    }

    public void text_invisible()
    {
        musicstage_sub_sub6_text.setVisibility(View.GONE);
        musicstage_sub_sub5_text.setVisibility(View.GONE);
        musicstage_sub_sub4_text.setVisibility(View.GONE);
        musicstage_sub_sub3_text.setVisibility(View.GONE);
        musicstage_sub_sub2_text.setVisibility(View.GONE);
        musicstage_sub_sub1_text.setVisibility(View.GONE);
        musicstage_sub_mainboard_text.setVisibility(View.GONE);
        musicstage_sub_kick1_text.setVisibility(View.GONE);
        musicstage_sub_kick2_text.setVisibility(View.GONE);
    }

    public void text_visible()
    {

        musicstage_sub_sub6_text.setVisibility(View.VISIBLE);
        musicstage_sub_sub5_text.setVisibility(View.VISIBLE);
        musicstage_sub_sub4_text.setVisibility(View.VISIBLE);
        musicstage_sub_sub3_text.setVisibility(View.VISIBLE);
        musicstage_sub_sub2_text.setVisibility(View.VISIBLE);
        musicstage_sub_sub1_text.setVisibility(View.VISIBLE);
        musicstage_sub_mainboard_text.setVisibility(View.VISIBLE);
        musicstage_sub_kick1_text.setVisibility(View.VISIBLE);
        musicstage_sub_kick2_text.setVisibility(View.VISIBLE);

    }


    public void Anim_Prepare() {

        mMusicAnimation = new AlphaAnimation(1f,0.8f);

        mMusicAnimation.setDuration(100);

        mFeedbackAnim = AnimationUtils.loadAnimation(this, R.anim.short_image_blink);

        mMusicAnimation_scale = new ScaleAnim(1, 1, 1, 394f);

        mMusicAnimation_scale.setDuration(44000);
//
//        mMusicAnimation_down = new
//                TranslateAnim(Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 0.0f,
//                Animation.RELATIVE_TO_SELF, 11.25f);

        mMusicAnimation_down = new
                TranslateAnim(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 56f);

        mMusicAnimation_down.setDuration(44000);
    }


    public void BluetoothOn() {
        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);

        mBluetoothAdapter = bluetoothManager.getAdapter();

        gBluetoothThread = new BluetoothThread(this, null);

        Handler mHandler = new Handler();

        mBluetoothScan = new BluetoothScan(mBluetoothAdapter, mHandler, gBluetoothThread);

        mBluetoothScan.start();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.musicstage_sub_back:

                Intent intent = new Intent(this, MusicStageActivity.class);
                mMusicplayerThread.killMediaPlayer();
                startActivity(intent);
                overridePendingTransition(R.anim.slide_hold, R.anim.slide_out_left);
                finish();

                break;
            case R.id.musicstage_sub_imagepattern:

                mMusicAnimation_down.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        musicstage_sub_progress1.setVisibility(View.VISIBLE);
                        musicstage_sub_progress2.setVisibility(View.VISIBLE);
                        musicstage_sub_progress3.setVisibility(View.VISIBLE);
                        text_invisible();
                        feedbackHandler.sendEmptyMessage(FEEDBACK_START);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        musicstage_sub_progress1.setVisibility(View.GONE);
                        musicstage_sub_progress2.setVisibility(View.GONE);
                        musicstage_sub_progress3.setVisibility(View.GONE);
                        text_visible();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                musicstage_sub_progress2.startAnimation(mMusicAnimation_scale);
                musicstage_sub_progress3.startAnimation(mMusicAnimation_down);

                break;
        }
    }
}
