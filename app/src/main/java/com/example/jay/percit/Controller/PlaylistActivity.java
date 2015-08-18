package com.example.jay.percit.Controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.jay.percit.Data.Playlist_Bgm_Setup;
import com.example.jay.percit.Data.Playlist_Id_Setup;
import com.example.jay.percit.Data.Playlist_Image_Setup;
import com.example.jay.percit.Fragment.PlaylistFragment1;
import com.example.jay.percit.Fragment.PlaylistFragment2;
import com.example.jay.percit.R;

public class PlaylistActivity extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;
    public static ViewPager gViewPager;
    static public Context mContext;
    Playlist_Id_Setup playlist_id_setup;
    Playlist_Image_Setup playlist_image_setup;
    Playlist_Bgm_Setup playlist_bgm_setup;
    Resources res;

    public static ImageView playlist_imageList[];

    public static ImageView playlist_progress1List[];

    public static ImageView playlist_progress2List[];

    public static ImageView playlist_progress3List[];

    public static ImageView playlist_informationList[];

    public static String playlist_MusicnameList[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        gViewPager = (ViewPager) findViewById(R.id.pager);
        gViewPager.setAdapter(mSectionsPagerAdapter);
        gViewPager.setOnTouchListener(onTouchPager);
        gViewPager.setPageMargin(-120);

        mContext = this;

        if (playlist_id_setup == null) {
            Log.i("playlist_id_setup", "setup!");
            playlist_id_setup = new Playlist_Id_Setup(this);
        }

        if (playlist_image_setup == null) {
            Log.i("playlist_image_setup", "setup!");
            playlist_image_setup = new Playlist_Image_Setup(this);
        }

        if( playlist_bgm_setup ==null)
        {
            playlist_bgm_setup = new Playlist_Bgm_Setup(this);
        }


        Setup_UI();

    }

    private void Setup_UI() {

        playlist_imageList = new ImageView[10];
        playlist_progress1List = new ImageView[10];
        playlist_progress2List = new ImageView[10];
        playlist_progress3List = new ImageView[10];
        playlist_informationList = new ImageView[10];
        playlist_MusicnameList = new String[10];
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 1) {
                return PlaylistFragment2.newInstance();
            } else {
                return PlaylistFragment1.newInstance();
            }
        }

        @Override
        public int getCount() {
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

            if (Math.abs(y_distance) < 100 || Math.abs(x_distance) > 300) {
                return false;
            }

            if (y_distance > 0) {

                Intent intent = new Intent(mContext, CrewActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                finish();

            } else {

                Intent intent = new Intent(mContext, MusicStageActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                finish();
            }

            return true;
        }
    };

}
