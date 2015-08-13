package com.example.jay.percit.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jay.percit.Controller.CommunityActivity;
import com.example.jay.percit.Controller.SettingActivity;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-06.
 */
public class CommunityFragment3 extends Fragment {

    public static UiHandler guiHandler;
    private View mSetting_handle;


    public static CommunityFragment3 newInstance() {

        CommunityFragment3 fragment = new CommunityFragment3();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_community3, container, false);

        guiHandler = new UiHandler();

        mSetting_handle = (ImageView) v.findViewById(R.id.setting_handler);

        mSetting_handle.setOnTouchListener(

                new View.OnTouchListener() {

                    private float PressedY;
                    private float PressedX;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        float y_distance = 0;
                        float x_distance = 0;


                        if (v.getId() == R.id.setting_handler)
                        {

                            CommunityActivity.gViewPager.requestDisallowInterceptTouchEvent(true);

                            switch (event.getAction()) {


                                case MotionEvent.ACTION_DOWN:

                                    System.out.println("****************** DOWN");

                                    PressedY = event.getY();

                                    PressedX = event.getX();

                                    System.out.println("get X() : " + PressedX);

                                    break;

                                case MotionEvent.ACTION_UP:

                                    System.out.println("****************** UP");
                                    y_distance = PressedY - event.getY();
                                    x_distance = PressedX - event.getX();

                                    System.out.println("UP get X() : " + event.getX());
                                    break;

                            }

                            if (Math.abs(x_distance) > 1000) {

                                Log.d("===", "========================");

                                System.out.println("very Long : " + Math.abs(x_distance));

                                Log.d("===", "========================");

                                CommunityActivity.gViewPager.requestDisallowInterceptTouchEvent(false);

                                return true;
                            }

                            if (x_distance > 0 && y_distance < 200) {

                                Log.d("===", "========================");

                                System.out.println("drag success : " + Math.abs(x_distance));

                                Intent intent = new Intent(CommunityActivity.mContext, SettingActivity.class);
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_hold);
                                getActivity().finish();

                                Log.d("===", "========================");

                                return true;

                            } else if (x_distance < 0) {
                                Log.d("===", "========================");

                                System.out.println("Right process : " + Math.abs(x_distance));

                                Log.d("===", "========================");

                                CommunityActivity.gViewPager.requestDisallowInterceptTouchEvent(false);

                                return true;

                            }
                            return true;

                        }

                        return true;
                    }
                });
        return v;
    }

    ;


    public class UiHandler extends Handler {


        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {

                default:

                    break;
            }

        }
    }


}
