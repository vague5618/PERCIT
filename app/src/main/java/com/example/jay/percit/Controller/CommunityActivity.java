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
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jay.percit.Fragment.CommunityFragment1;
import com.example.jay.percit.Fragment.CommunityFragment2;
import com.example.jay.percit.Handler.MusicHandler;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Util.BluetoothConnectService;
import com.example.jay.percit.Util.BluetoothScan;
import com.example.jay.percit.Util.BluetoothThread;

import java.util.Locale;

public class CommunityActivity extends ActionBarActivity {

    public static final int NOMAL_MODE = 5;
    public static final int RECORD_MODE = 6;
    public static final int PLAY_MODE = 7;

    public static BluetoothThread gBluetoothThread;
    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

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

        mViewPager = (ViewPager) findViewById(R.id.pager);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOnTouchListener(onTouchPager);

        mContext = this;

        Log.d("process","===================");

        Log.d("process","onCreate");

        Log.d("process","===================");

//        Intent Service = new Intent(this, BluetoothConnectService.class);
//        startService(Service);
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

            if(position == 2)
                return CommunityFragment2.newInstance();
            else
                return CommunityFragment1.newInstance();
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

            if (Math.abs(y_distance) < 100 || Math.abs(x_distance) > 300) {
                return false;
            }

            if (y_distance > 0) {

                Intent intent = new Intent(mContext, CrewActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
                finish();

            } else {
                //Siwpe up content
            }
            return true;
        }


    };

}