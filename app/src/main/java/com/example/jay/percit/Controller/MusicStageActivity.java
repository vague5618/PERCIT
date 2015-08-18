package com.example.jay.percit.Controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jay.percit.Animation.ScaleAnim;
import com.example.jay.percit.Animation.TranslateAnim;
import com.example.jay.percit.Fragment.MusicStageFragment1;
import com.example.jay.percit.Fragment.MusicStageFragment2;
import com.example.jay.percit.Handler.MusicHandler;
import com.example.jay.percit.Model.MusicStage_Id;
import com.example.jay.percit.Listview.MusicStage_IdSetup;
import com.example.jay.percit.Model.MusicStage_IdDAO;
import com.example.jay.percit.Model.MusicStage_Image;
import com.example.jay.percit.Listview.MusicStage_ImageSetup;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;

import java.util.ArrayList;

public class MusicStageActivity extends ActionBarActivity {

    public static final int NOMAL_MODE = 5;
    public static final int RECORD_MODE = 6;
    public static final int PLAY_MODE = 7;
    private static final int PLAY_BGM = 8;
    private static final int PAUSE_BGM = 9;
    private static final int RESUME_BGM = 10;
    private static final int CLEAR_BGM = 11;
    private static final int CLICK_STATE_ON = 99;
    private static final int CLICK_STATE_OFF = 100;
    private static final int CLICK_STATE_ING = 101;

    public static int click_current_state = CLICK_STATE_OFF;

    public static int pre_choice = -1;

    public static ImageView musicstage_imageList[];

    public static ImageView musicstage_progress1List[];

    public static ImageView musicstage_progress2List[];

    public static ImageView musicstage_progress3List[];

    public static ImageView musicstage_like_img[];

    public static TextView musicstage_like_txt[];

    public static ImageView musicstage_informationList[];

    public static ArrayList<MusicStage_Image> musicstage_Image_modelList;

    public static MusicStage_ImageSetup musicstage_Image_setup;

    public static ArrayList<MusicStage_Id> musicstage_Id_modelList;

    public static MusicStage_IdSetup musicStage_id_setup;

    public static ScaleAnim mMusicAnimation_scale;
    public static TranslateAnim mMusicAnimation_down;

    SectionsPagerAdapter mSectionsPagerAdapter;
    public static ViewPager gViewPager;
    static public Context mContext;
    Resources res;
    private MusicplayerThread mMusicplayerThread;
    public static RecordThread gRecordThread;
    public static MusicHandler gMusicHandler;
    private Handler mHandler;
    private Button mButton;
    public static int state;
    public static int record_arr[];
    public static int record_power[];
    public static int current_fragment = 0;

    @Override
    protected void onDestroy() {
//
//        gMusicHandler.sendEmptyMessage(RESUME_BGM);
        mMusicplayerThread.killMediaPlayer();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //commit check
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicstage);
//
//        MusicStage_IdDAO  db_Handler = MusicStage_IdDAO.getHelper(this);
//
//        MusicStage_Id
//                temp_musicstage_id = new MusicStage_Id(R.id.playlist_image1, R.id.musicstage_information1,
//                R.id.musicstage_main1_progress1, R.id.musicstage_main1_progress2, R.id.musicstage_main1_progress3,
//                R.id.musicstage_main1_like_txt, R.id.musicstage_main1_like_img);
//
//        temp_musicstage_id.setMusicstage_index(0);
//
//        db_Handler.add_musicstage_id(temp_musicstage_id);

        //Create Classs

        record_arr = new int[1500];
        record_power = new int[1500];

        mSectionsPagerAdapter = new
                SectionsPagerAdapter(getSupportFragmentManager()

        );

        mMusicplayerThread = new

                MusicplayerThread(this);

        gRecordThread = new

                RecordThread();

        gMusicHandler = new

                MusicHandler(mMusicplayerThread, gRecordThread);

        gViewPager = (ViewPager)

                findViewById(R.id.pager);

        gViewPager.setAdapter(mSectionsPagerAdapter);
//
        gViewPager.setOnTouchListener(onTouchPager);

        gViewPager.setPageMargin(-120);

        Setup_UI();

        mContext = this;

        mMusicplayerThread.play(2, 1);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_musicstage_actionbar, menu);

        return true;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            if (position == 1) {
                mMusicplayerThread.killMediaPlayer();
                return MusicStageFragment2.newInstance();
            } else {
                mMusicplayerThread.killMediaPlayer();
                return MusicStageFragment1.newInstance();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

    }

    // up-down swipe

    private View.OnTouchListener onTouchPager = new View.OnTouchListener() {

        private float mPressedY;
        private float mPressedX;

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            float y_distance = 0;

            float x_distance = 0;

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mPressedY = event.getY();
                    mPressedX = event.getX();
                    break;

                case MotionEvent.ACTION_UP:
                    y_distance = mPressedY - event.getY();
                    x_distance = mPressedX - event.getX();
                    break;
            }


            System.out.println("x_distance =" + x_distance + "y_distance = " + y_distance);

            if (Math.abs(y_distance) < 200 || Math.abs(x_distance) > 300) {

                return false;
            }

            if (y_distance > 0) {

                Intent intent = new Intent(mContext, PlaylistActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                finish();
                return false;

            } else {
                //Siwpe up content

            }

            return true;
        }


    };

    private void Setup_UI() {
        musicstage_imageList = new ImageView[10];
        musicstage_progress1List = new ImageView[10];
        musicstage_progress2List = new ImageView[10];
        musicstage_progress3List = new ImageView[10];
        musicstage_like_img = new ImageView[10];
        musicstage_like_txt = new TextView[10];
        musicstage_informationList = new ImageView[10];
        musicstage_Image_modelList = new ArrayList<>();
        musicstage_Id_modelList = new ArrayList<>();
        musicstage_Image_setup = new MusicStage_ImageSetup(musicstage_Image_modelList);
        musicStage_id_setup = new MusicStage_IdSetup(musicstage_Id_modelList);

//        mMusicAnimation_scale = new ScaleAnim(1, 1, 1, 6.09461f);

        mMusicAnimation_scale = new ScaleAnim(1, 1, 1, 5.528291f);

        mMusicAnimation_scale.setDuration(15000);
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
                Animation.RELATIVE_TO_SELF, 10f);

        mMusicAnimation_down.setDuration(15000);

    }

}