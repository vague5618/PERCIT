package com.example.jay.percit.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jay.percit.Controller.MyStorageActivity;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.RecordThread;

/**
 * Created by Jay on 2015-08-06.
 */
public class MyStorageFragment1 extends Fragment implements View.OnClickListener {

    ImageView mystorage_image1;

    public static MyStorageFragment1 newInstance() {

        MyStorageFragment1 fragment = new MyStorageFragment1();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mystorage1, container, false);

        mystorage_image1 = (ImageView) v.findViewById(R.id.mystorage_image1);

        mystorage_image1.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.mystorage_image1:

                if (MyStorageActivity.record_arr != null) {

                    MyStorageActivity.recordThread.cancel_timer();

                    MyStorageActivity.recordThread.Play_Recorded(MyStorageActivity.record_arr, MyStorageActivity.record_power, MyStorageActivity.soundpoolThread);



                    try {
                        MyStorageActivity.musicplayerThread.select_playBGM(MyStorageActivity.music_raw);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(MyStorageActivity.mContext, "save is null", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}

