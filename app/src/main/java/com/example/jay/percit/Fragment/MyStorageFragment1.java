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
public class MyStorageFragment1 extends Fragment {


    public static MyStorageFragment1 newInstance() {

        MyStorageFragment1 fragment = new MyStorageFragment1();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mystorage1, container, false);

        return v;
    }

}

