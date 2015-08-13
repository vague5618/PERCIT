package com.example.jay.percit.Controller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.jay.percit.Fragment.CommunityFragment1;
import com.example.jay.percit.Fragment.CommunityFragment2;
import com.example.jay.percit.Fragment.CommunityFragment3;
import com.example.jay.percit.Handler.MusicHandler;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Util.BluetoothScan;
import com.example.jay.percit.Util.BluetoothThread;

public class CommunityActivity extends ActionBarActivity {

    public static final int NOMAL_MODE = 5;
    public static final int RECORD_MODE = 6;
    public static final int PLAY_MODE = 7;
    private static final int LOW_DPI_STATUS_BAR_HEIGHT = 19;
    private static final int MEDIUM_DPI_STATUS_BAR_HEIGHT = 25;
    private static final int HIGH_DPI_STATUS_BAR_HEIGHT = 38;

    public static BluetoothThread gBluetoothThread;
    SectionsPagerAdapter mSectionsPagerAdapter;
    public static ViewPager gViewPager;
    static public Context mContext;
    public BluetoothAdapter mBluetoothAdapter;
    public BluetoothScan mBluetoothScan;
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
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //commit check

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_community);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setElevation(0);

        actionBar.hide();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        System.out.println("width = " + width);
        System.out.println("height = " + height);

        int statusBarHeight;

        switch (displayMetrics.densityDpi) {
            case DisplayMetrics.DENSITY_HIGH:
                statusBarHeight = HIGH_DPI_STATUS_BAR_HEIGHT;
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                statusBarHeight = MEDIUM_DPI_STATUS_BAR_HEIGHT;
                break;
            case DisplayMetrics.DENSITY_LOW:
                statusBarHeight = LOW_DPI_STATUS_BAR_HEIGHT;
                break;
            default:
                statusBarHeight = MEDIUM_DPI_STATUS_BAR_HEIGHT;
        }
        System.out.println("StatusBarTest" + "onCreate StatusBar Height= " + statusBarHeight);


        final BluetoothManager bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);

        mBluetoothAdapter = bluetoothManager.getAdapter();

        //Create Classs

        record_arr = new int[1500];
        record_power = new int[1500];

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mHandler = new Handler();

        mMusicplayerThread = new MusicplayerThread(this);

        gRecordThread = new RecordThread();

        gMusicHandler = new MusicHandler(mMusicplayerThread, gRecordThread);

        gBluetoothThread = new BluetoothThread(this, gMusicHandler);

        mBluetoothScan = new BluetoothScan(mBluetoothAdapter, mHandler, gBluetoothThread);

        mBluetoothScan.start();

        gViewPager = (ViewPager) findViewById(R.id.pager);

        gViewPager.setAdapter(mSectionsPagerAdapter);
//
        gViewPager.setOnTouchListener(onTouchPager);

        gViewPager.setCurrentItem(current_fragment);

        current_fragment = 0;

        mContext = this;

        Log.d("process", "===================");

        Log.d("process", "onCreate");

        Log.d("process", "===================");

//        Intent Service = new Intent(this, BluetoothConnectService.class);
//        startService(Service);


        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            int actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            System.out.println("actionbar = " +actionBarHeight);

        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_community, menu);

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

            if (position == 2) {
                return CommunityFragment3.newInstance();
            } else if (position == 1) {
                return CommunityFragment2.newInstance();
            } else {
                return CommunityFragment1.newInstance();
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
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

                Intent intent = new Intent(mContext, CrewActivity.class);
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

}