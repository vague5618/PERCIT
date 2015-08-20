package com.example.jay.percit.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.jay.percit.Controller.CrewActivity;
import com.example.jay.percit.Controller.PlaylistActivity;
import com.example.jay.percit.Controller.SettingActivity;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-06.
 */
public class CrewFragment2 extends Fragment {


    private View mSetting_handle;


    public static CrewFragment2 newInstance() {

        CrewFragment2 fragment = new CrewFragment2();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crew2, container, false);

        mSetting_handle = (View) v.findViewById(R.id.crew_setting_handler);


        mSetting_handle.setOnTouchListener(

                new View.OnTouchListener() {

                    private float PressedY;
                    private float PressedX;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        float y_distance = 0;
                        float x_distance = 0;


                        if (v.getId() == R.id.crew_setting_handler) {

                            CrewActivity.gViewPager.requestDisallowInterceptTouchEvent(true);

                            switch (event.getAction()) {


                                case MotionEvent.ACTION_DOWN:

                                    PressedY = event.getY();

                                    PressedX = event.getX();

                                    break;

                                case MotionEvent.ACTION_UP:

                                    y_distance = PressedY - event.getY();
                                    x_distance = PressedX - event.getX();

                                    break;

                            }

                            if (Math.abs(x_distance) > 1000) {

                                CrewActivity.gViewPager.requestDisallowInterceptTouchEvent(false);

                                return true;
                            }

                            if (x_distance > 0 && y_distance < 200) {

                                Intent intent = new Intent(CrewActivity.mContext, SettingActivity.class);

                                intent.putExtra("call", "CrewActivity");
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_hold);
                                getActivity().finish();

                                return true;

                            } else if (x_distance < 0) {

                                CrewActivity.gViewPager.requestDisallowInterceptTouchEvent(false);

                                return true;

                            }
                            return true;

                        }

                        return true;
                    }
                });


        return v;
    }


}

