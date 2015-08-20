package com.example.jay.percit.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jay.percit.Animation.ScaleAnim;
import com.example.jay.percit.Animation.TranslateAnim;
import com.example.jay.percit.Data.Musicstage_Id_Setup;
import com.example.jay.percit.Data.Musicstage_Image_Setup;
import com.example.jay.percit.Fragment.MusicStageFragment1;
import com.example.jay.percit.Fragment.MusicStageFragment2;
import com.example.jay.percit.Handler.MusicHandler;
import com.example.jay.percit.Model.Setting_percit;
import com.example.jay.percit.Model.Setting_percitDAO;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;

public class MusicStageActivity extends ActionBarActivity {

    private static final int CLICK_STATE_OFF = 100;

    public static int start_check = 0;

    public static int click_current_state = CLICK_STATE_OFF;

    public static int pre_choice = -1;

    public static ImageView musicstage_imageList[];

    public static ImageView musicstage_progress1List[];

    public static ImageView musicstage_progress2List[];

    public static ImageView musicstage_progress3List[];

    public static ImageView musicstage_like_img[];

    public static TextView musicstage_like_txt[];

    public static ImageView musicstage_informationList[];
    public static int musicstage_likeList[];

    Musicstage_Id_Setup musicstage_id_setup;

    Musicstage_Image_Setup musicstage_image_setup;


    public static ScaleAnim mMusicAnimation_scale;
    public static TranslateAnim mMusicAnimation_down;

    SectionsPagerAdapter mSectionsPagerAdapter;
    public static ViewPager gViewPager;
    static public Context mContext;
    public static MusicplayerThread gMusicplayerThread;
    public static RecordThread gRecordThread;
    public static MusicHandler gMusicHandler;
    public static int state;

    @Override
    protected void onDestroy() {
        gMusicplayerThread.killMediaPlayer();
        super.onDestroy();
    }

    @Override
    protected void onPause() {

        gMusicplayerThread.killMediaPlayer();
        super.onPause();
    }


    public void setting_init() {

        Setting_percitDAO setting_percitDAO = null;

        try {
            setting_percitDAO = Setting_percitDAO.open(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Setting_percit setting_percit_temp = new Setting_percit();

        setting_percit_temp.setSetting_percit_index(1);
        setting_percit_temp.setSetting_percit_a(-1);
        setting_percit_temp.setSetting_percit_b(-1);
        setting_percit_temp.setSetting_percit_c(-1);
        setting_percit_temp.setSetting_percit_d(-1);
        setting_percit_temp.setSetting_percit_e(-1);
        setting_percit_temp.setSetting_percit_f(-1);
        setting_percit_temp.setSetting_percit_g(-1);
        setting_percit_temp.setSetting_percit_h(-1);
        setting_percit_temp.setSetting_percit_i(-1);

        setting_percitDAO.updateSetting_percit(setting_percit_temp);

        Log.i("=====setting init====","======");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicstage);

        if(start_check == 0) {
            setting_init();
            start_check++;
        }

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        gViewPager = (ViewPager) findViewById(R.id.pager);

        gViewPager.setAdapter(mSectionsPagerAdapter);

        gViewPager.setOnTouchListener(onTouchPager);

        gViewPager.setPageMargin(-120);

        mContext = this;

        gMusicplayerThread = new MusicplayerThread(this);

        gRecordThread = new RecordThread();

        gMusicHandler = new MusicHandler(gRecordThread);

        Setup_UI();
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            if (position == 1) {
                gMusicplayerThread.killMediaPlayer();
                return MusicStageFragment2.newInstance();
            } else {
                gMusicplayerThread.killMediaPlayer();
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
        musicstage_likeList = new int[10];

//        mMusicAnimation_scale = new ScaleAnim(1, 1, 1, 6.09461f);


        if (musicstage_id_setup == null)
            musicstage_id_setup = new Musicstage_Id_Setup(this);
        if (musicstage_image_setup == null)
            musicstage_image_setup = new Musicstage_Image_Setup(this);

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