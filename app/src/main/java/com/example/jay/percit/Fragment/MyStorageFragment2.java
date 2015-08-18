package com.example.jay.percit.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-06.
 */
public class MyStorageFragment2 extends Fragment {

    private View mSetting_handle;



    public static MyStorageFragment2 newInstance() {

        MyStorageFragment2 fragment = new MyStorageFragment2();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mystorage2, container, false);

        return v;
    }

}

