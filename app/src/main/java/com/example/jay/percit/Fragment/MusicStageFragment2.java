package com.example.jay.percit.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jay.percit.Controller.MusicStageActivity;
import com.example.jay.percit.Controller.MusicStageSubActivity;
import com.example.jay.percit.Controller.SettingActivity;
import com.example.jay.percit.Model.MusicStage_Id;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-06.
 */
public class MusicStageFragment2 extends Fragment implements View.OnClickListener {

    private static final int CLICK_STATE_ON = 99;
    private static final int CLICK_STATE_OFF = 100;
    private static final int CLICK_STATE_ING = 101;
    private static final int CONTENT_NUMBER = 4;
    private static final int PLAY_BGM = 8;
    private static final int PAUSE_BGM = 9;
    private static final int RESUME_BGM = 10;
    private static final int CLEAR_BGM = 11;

    public static int click_current_state = CLICK_STATE_OFF;

    public static int pre_choice = -1;
    private View mSetting_handle;
    private Resources res;
    private int target_index = 0;


    public static MusicStageFragment2 newInstance() {

        MusicStageFragment2 fragment = new MusicStageFragment2();
        click_current_state = CLICK_STATE_OFF;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_musicstage2, container, false);

        res = v.getResources();

        mSetting_handle = (ImageView) v.findViewById(R.id.musicstage_setting_handler);

        mSetting_handle.setOnTouchListener(

                new View.OnTouchListener() {

                    private float PressedY;
                    private float PressedX;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        float y_distance = 0;
                        float x_distance = 0;


                        if (v.getId() == R.id.musicstage_setting_handler) {

                            MusicStageActivity.gViewPager.requestDisallowInterceptTouchEvent(true);

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

                                MusicStageActivity.gViewPager.requestDisallowInterceptTouchEvent(false);

                                return true;
                            }

                            if (x_distance > 0 && y_distance < 200) {

                                Intent intent = new Intent(MusicStageActivity.mContext, SettingActivity.class);
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_hold);
                                getActivity().finish();

                                return true;

                            } else if (x_distance < 0) {

                                MusicStageActivity.gViewPager.requestDisallowInterceptTouchEvent(false);

                                return true;

                            }
                            return true;

                        }

                        return true;
                    }
                });

        for (int i = 4; i < 8; i++) {

            MusicStageActivity.musicstage_imageList[i] = (ImageView) v.findViewById(MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_image_id());
            MusicStageActivity.musicstage_informationList[i] = (ImageView) v.findViewById(MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_information_id());
            MusicStageActivity.musicstage_progress1List[i] = (ImageView) v.findViewById(MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_progress1_id());
            MusicStageActivity.musicstage_progress2List[i] = (ImageView) v.findViewById(MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_progress2_id());
            MusicStageActivity.musicstage_progress3List[i] = (ImageView) v.findViewById(MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_progress3_id());
            MusicStageActivity.musicstage_like_img[i] = (ImageView) v.findViewById(MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_like_img_id());
            MusicStageActivity.musicstage_like_txt[i] = (TextView) v.findViewById(MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_like_txt_id());

            MusicStageActivity.musicstage_imageList[i].setBackground(res.getDrawable(MusicStageActivity.musicstage_Image_modelList.get(i).getMusicstage_image()));
            MusicStageActivity.musicstage_informationList[i].setBackground(res.getDrawable(MusicStageActivity.musicstage_Image_modelList.get(i).getMusicstage_information()));

            MusicStageActivity.musicstage_progress1List[i].setBackground(res.getDrawable(MusicStageActivity.musicstage_Image_modelList.get(i).getMusicstage_progress1()));
            MusicStageActivity.musicstage_progress2List[i].setBackground(res.getDrawable(MusicStageActivity.musicstage_Image_modelList.get(i).getMusicstage_progress2()));
            MusicStageActivity.musicstage_progress3List[i].setBackground(res.getDrawable(MusicStageActivity.musicstage_Image_modelList.get(i).getMusicstage_progress3()));


            MusicStageActivity.musicstage_progress1List[i].setVisibility(View.INVISIBLE);
            MusicStageActivity.musicstage_progress2List[i].setVisibility(View.INVISIBLE);
            MusicStageActivity.musicstage_progress3List[i].setVisibility(View.INVISIBLE);

            MusicStageActivity.musicstage_like_img[i].setOnClickListener(this);
            MusicStageActivity.musicstage_imageList[i].setOnClickListener(this);
            MusicStageActivity.musicstage_informationList[i].setOnClickListener(this);
        }

        return v;
    }

    void enable_click() {
        for (int i = 0; i < 4; i++) {
            MusicStageActivity.musicstage_imageList[i].setClickable(true);
        }
    }

    void disable_click() {
        for (int i = 0; i < 4; i++) {
            MusicStageActivity.musicstage_imageList[i].setClickable(false);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.musicstage_image5:
            case R.id.musicstage_image6:
            case R.id.musicstage_image7:
            case R.id.musicstage_image8:



                for (int i = 4; i < 8; i++) {

                    if (v.getId() == MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_image_id()) {

                        target_index = i;
                        System.out.println("compare pre = " + pre_choice + "target =" + target_index);
                        if (pre_choice != target_index && pre_choice != -1) {

                            System.out.println("another choice!!! " + pre_choice);
                            //     MusicStageActivity.gMusicHandler.sendEmptyMessage(CLEAR_BGM);
                            System.out.println("========1=======");
                            MusicStageActivity.mMusicAnimation_down.resume();
                            MusicStageActivity.mMusicAnimation_scale.resume();

                            System.out.println("========2=======");

                            MusicStageActivity.musicstage_progress1List[pre_choice].clearAnimation();
                            MusicStageActivity.musicstage_progress2List[pre_choice].clearAnimation();
                            MusicStageActivity.musicstage_progress3List[pre_choice].clearAnimation();

                            System.out.println("========3=======");

                            MusicStageActivity.mMusicAnimation_down.cancel();
                            MusicStageActivity.mMusicAnimation_scale.cancel();

                            System.out.println("========4=======");
                            MusicStageActivity.musicstage_progress1List[pre_choice].setVisibility(View.GONE);
                            MusicStageActivity.musicstage_progress2List[pre_choice].setVisibility(View.GONE);
                            MusicStageActivity.musicstage_progress3List[pre_choice].setVisibility(View.GONE);
                            click_current_state = CLICK_STATE_OFF;
                        }

                        if (pre_choice == target_index && click_current_state == CLICK_STATE_OFF) {
                            System.out.println("another CLICK_STATE_OFF " + pre_choice);
                            click_current_state = CLICK_STATE_ON;
                        } else if (pre_choice == target_index && click_current_state == CLICK_STATE_ON) {
                            System.out.println("another CLICK_STATE_STOP " + pre_choice);
                            click_current_state = CLICK_STATE_ON;

                        } else if (pre_choice == target_index && click_current_state == CLICK_STATE_ING) {
                            System.out.println("another CLICK_STATE_ING " + pre_choice);
                            click_current_state = CLICK_STATE_ING;
                        }
                    }
                }

                switch (click_current_state) {
                    case CLICK_STATE_OFF:

                        MusicStageActivity.mMusicAnimation_scale.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                                Message bgm_start = MusicStageActivity.gMusicHandler.obtainMessage();
                                bgm_start.what = PLAY_BGM;
                                bgm_start.arg1 = 2;
                                MusicStageActivity.gMusicHandler.sendMessage(bgm_start);
                                disable_click();
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {

                                click_current_state = CLICK_STATE_OFF;
                                MusicStageActivity.gMusicHandler.sendEmptyMessage(PAUSE_BGM);
                                enable_click();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });

                        MusicStageActivity.mMusicAnimation_down.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                MusicStageActivity.musicstage_progress1List[target_index].setVisibility(View.VISIBLE);
                                MusicStageActivity.musicstage_progress2List[target_index].setVisibility(View.VISIBLE);
                                MusicStageActivity.musicstage_progress3List[target_index].setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                MusicStageActivity.musicstage_progress1List[target_index].setVisibility(View.GONE);
                                MusicStageActivity.musicstage_progress2List[target_index].setVisibility(View.GONE);
                                MusicStageActivity.musicstage_progress3List[target_index].setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });

                        pre_choice = target_index;

                        MusicStageActivity.musicstage_progress2List[target_index].startAnimation(MusicStageActivity.mMusicAnimation_scale);

                        MusicStageActivity.musicstage_progress3List[target_index].startAnimation(MusicStageActivity.mMusicAnimation_down);

                        click_current_state = CLICK_STATE_ON;

                        break;

                    case CLICK_STATE_ON:

                        disable_click();
                        MusicStageActivity.mMusicAnimation_scale.pause();
                        MusicStageActivity.mMusicAnimation_down.pause();

                        Message bgm_pause = MusicStageActivity.gMusicHandler.obtainMessage();
                        bgm_pause.what = PAUSE_BGM;
                        MusicStageActivity.gMusicHandler.sendMessage(bgm_pause);

                        click_current_state = CLICK_STATE_ING;
                        break;

                    case CLICK_STATE_ING:

                        disable_click();

                        MusicStageActivity.mMusicAnimation_scale.resume();

                        MusicStageActivity.mMusicAnimation_down.resume();

                        Message bgm_resume = MusicStageActivity.gMusicHandler.obtainMessage();
                        bgm_resume.what = RESUME_BGM;
                        MusicStageActivity.gMusicHandler.sendMessage(bgm_resume);
                        click_current_state = CLICK_STATE_ON;

                        break;
                }

                break;


            case R.id.musicstage_information5:
            case R.id.musicstage_information6:
            case R.id.musicstage_information7:
            case R.id.musicstage_information8:

                for (int i = 4; i < 8; i++) {
                    if (v.getId() == MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_image_id()) {
                        target_index = i;
                    }
                }

                Intent intent = new Intent(MusicStageActivity.mContext, MusicStageSubActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_hold);
                getActivity().finish();

                break;

            case R.id.musicstage_main5_like_img:
            case R.id.musicstage_main6_like_img:
            case R.id.musicstage_main7_like_img:
            case R.id.musicstage_main8_like_img:

                for (int i = 4; i < 8; i++) {
                    if (v.getId() == MusicStageActivity.musicstage_Id_modelList.get(i).getMusicstage_like_img_id()) {
                        target_index = i;
                    }
                }
                int temp_like = (Integer.parseInt(MusicStageActivity.musicstage_like_txt[target_index].getText().toString()) + 1);

                MusicStageActivity.musicstage_like_txt[target_index].setText(String.valueOf(temp_like));

                break;
        }

    }
}

