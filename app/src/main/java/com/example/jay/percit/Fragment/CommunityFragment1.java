package com.example.jay.percit.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jay.percit.Controller.CommunityActivity;
import com.example.jay.percit.Controller.CrewActivity;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-06.
 */

public class CommunityFragment1 extends Fragment {


    private Button mButton;

    private static final String ARG_SECTION_NUMBER = "section_number";


    public static CommunityFragment1 newInstance() {

        CommunityFragment1 fragment = new CommunityFragment1();
//        Bundle args = new Bundle();
  //      args.putInt(ARG_SECTION_NUMBER, sectionNumber);
   //     fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_community, container, false);

        return v;
    }



}

