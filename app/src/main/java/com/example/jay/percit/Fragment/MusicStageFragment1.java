package com.example.jay.percit.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jay.percit.Controller.MusicStageActivity;
import com.example.jay.percit.Controller.MusicStageSubActivity;
import com.example.jay.percit.Controller.PlaylistActivity;
import com.example.jay.percit.Model.MusicStage_IdDAO;
import com.example.jay.percit.Model.MusicStage_ImageDAO;
import com.example.jay.percit.Model.Playlist_IdDAO;
import com.example.jay.percit.Model.Playlist_ImageDAO;
import com.example.jay.percit.R;

import org.w3c.dom.Text;

/**
 * Created by Jay on 2015-08-06.
 */

public class MusicStageFragment1 extends Fragment implements View.OnClickListener {

    private static final int CLICK_STATE_ON = 99;
    private static final int CLICK_STATE_OFF = 100;
    private static final int CLICK_STATE_ING = 101;
    private static final int CONTENT_NUMBER = 4;
    private static final int PLAY_BGM = 8;
    private static final int PAUSE_BGM = 9;
    private static final int RESUME_BGM = 10;
    private static final int CLEAR_BGM = 11;
    //

    MusicStage_ImageDAO musicstage_imageDAO;
    MusicStage_IdDAO musicstage_idDAO;
    Cursor musicstage_imageCursor;
    Cursor musicstage_IdCursor;


    //    public static int click_current_state = CLICK_STATE_OFF;
//
//    public static int pre_choice = -1;
    int target_index = 0;


    public static MusicStageFragment1 newInstance() {

        MusicStageFragment1 fragment = new MusicStageFragment1();

        MusicStageActivity.click_current_state = CLICK_STATE_OFF;

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Resources res = getResources();

        View v = inflater.inflate(R.layout.fragment_musicstage1, container, false);


        try {
            musicstage_imageDAO = MusicStage_ImageDAO.open(MusicStageActivity.mContext);
            musicstage_idDAO = MusicStage_IdDAO.open(MusicStageActivity.mContext);
        } catch (Exception e) {
            Log.i("DB Query", "Error");
            e.printStackTrace();
        }

        musicstage_IdCursor = musicstage_idDAO.getMusicStage_Id();

        musicstage_IdCursor.move(0);

        for (int i = 0; i < 4; i++) {

            while (musicstage_IdCursor.moveToNext() && i < 4) {

                Log.i("=====errorcursor1=====", musicstage_IdCursor.getString(1));
                MusicStageActivity.musicstage_imageList[i] = (ImageView) v.findViewById(Integer.parseInt(musicstage_IdCursor.getString(1)));
                MusicStageActivity.musicstage_informationList[i] = (ImageView) v.findViewById(Integer.parseInt(musicstage_IdCursor.getString(2)));
                MusicStageActivity.musicstage_progress1List[i] = (ImageView) v.findViewById(Integer.parseInt(musicstage_IdCursor.getString(3)));
                MusicStageActivity.musicstage_progress2List[i] = (ImageView) v.findViewById(Integer.parseInt(musicstage_IdCursor.getString(4)));
                MusicStageActivity.musicstage_progress3List[i] = (ImageView) v.findViewById(Integer.parseInt(musicstage_IdCursor.getString(5)));
                MusicStageActivity.musicstage_like_txt[i] = (TextView) v.findViewById(Integer.parseInt(musicstage_IdCursor.getString(6)));
                MusicStageActivity.musicstage_like_img[i] = (ImageView) v.findViewById(Integer.parseInt(musicstage_IdCursor.getString(7)));

                i++;
            }
        }

        musicstage_imageCursor = musicstage_imageDAO.getMusicstage_image();

        for (int i = 0; i < 4; i++) {

            while (musicstage_imageCursor.moveToNext() && i < 4) {

                Log.i("=====errorimage1=====", musicstage_imageCursor.getString(1));
                MusicStageActivity.musicstage_imageList[i].setBackground(res.getDrawable(Integer.parseInt(musicstage_imageCursor.getString(1))));

                MusicStageActivity.musicstage_informationList[i].setBackground(res.getDrawable(Integer.parseInt(musicstage_imageCursor.getString(2))));

                MusicStageActivity.musicstage_progress1List[i].setBackground(res.getDrawable(Integer.parseInt(musicstage_imageCursor.getString(3))));

                MusicStageActivity.musicstage_progress2List[i].setBackground(res.getDrawable(Integer.parseInt(musicstage_imageCursor.getString(4))));

                MusicStageActivity.musicstage_progress3List[i].setBackground(res.getDrawable(Integer.parseInt(musicstage_imageCursor.getString(5))));

                MusicStageActivity.musicstage_likeList[i] = Integer.parseInt(musicstage_imageCursor.getString(6));

                MusicStageActivity.musicstage_like_txt[i].setText(musicstage_imageCursor.getString(6));

                MusicStageActivity.musicstage_progress1List[i].setVisibility(View.INVISIBLE);

                MusicStageActivity.musicstage_progress2List[i].setVisibility(View.INVISIBLE);

                MusicStageActivity.musicstage_progress3List[i].setVisibility(View.INVISIBLE);

                MusicStageActivity.musicstage_imageList[i].setOnClickListener(this);

                MusicStageActivity.musicstage_informationList[i].setOnClickListener(this);

                MusicStageActivity.musicstage_like_img[i].setOnClickListener(this);

                i++;
            }
        }

        return v;
    }

    void enable_click() {

        for (int i = 4; i < 8; i++) {
            MusicStageActivity.musicstage_imageList[i].setClickable(true);
        }
    }

    void disable_click() {
        for (int i = 4; i < 8; i++) {
            MusicStageActivity.musicstage_imageList[i].setClickable(false);
        }
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.musicstage_image1:
            case R.id.musicstage_image2:
            case R.id.musicstage_image3:
            case R.id.musicstage_image4:

                for (int i = 0; i < CONTENT_NUMBER; i++) {

                    if (v.getId() == MusicStageActivity.musicstage_imageList[i].getId()) {

                        target_index = i;
                        System.out.println("compare pre = " + MusicStageActivity.pre_choice + "target =" + target_index);

                        if (MusicStageActivity.pre_choice != target_index && MusicStageActivity.pre_choice != -1) {

                            System.out.println("another choice!!! " + MusicStageActivity.pre_choice);
                            //     MusicStageActivity.gMusicHandler.sendEmptyMessage(CLEAR_BGM);

                            MusicStageActivity.mMusicAnimation_down.resume();
                            MusicStageActivity.mMusicAnimation_scale.resume();

                            MusicStageActivity.musicstage_progress1List[MusicStageActivity.pre_choice].clearAnimation();
                            MusicStageActivity.musicstage_progress2List[MusicStageActivity.pre_choice].clearAnimation();
                            MusicStageActivity.musicstage_progress3List[MusicStageActivity.pre_choice].clearAnimation();

                            MusicStageActivity.mMusicAnimation_down.cancel();
                            MusicStageActivity.mMusicAnimation_scale.cancel();

                            MusicStageActivity.musicstage_progress1List[MusicStageActivity.pre_choice].setVisibility(View.GONE);
                            MusicStageActivity.musicstage_progress2List[MusicStageActivity.pre_choice].setVisibility(View.GONE);
                            MusicStageActivity.musicstage_progress3List[MusicStageActivity.pre_choice].setVisibility(View.GONE);
                            MusicStageActivity.click_current_state = CLICK_STATE_OFF;
                        }

                        if (MusicStageActivity.pre_choice == target_index && MusicStageActivity.click_current_state == CLICK_STATE_OFF) {
                            System.out.println("another CLICK_STATE_OFF " + MusicStageActivity.pre_choice);
                            MusicStageActivity.click_current_state = CLICK_STATE_ON;
                        } else if (MusicStageActivity.pre_choice == target_index && MusicStageActivity.click_current_state == CLICK_STATE_ON) {
                            System.out.println("another CLICK_STATE_STOP " + MusicStageActivity.pre_choice);
                            MusicStageActivity.click_current_state = CLICK_STATE_ON;

                        } else if (MusicStageActivity.pre_choice == target_index && MusicStageActivity.click_current_state == CLICK_STATE_ING) {
                            System.out.println("another CLICK_STATE_ING " + MusicStageActivity.pre_choice);
                            MusicStageActivity.click_current_state = CLICK_STATE_ING;
                        }
                    }
                }

                switch (MusicStageActivity.click_current_state) {
                    case CLICK_STATE_OFF:

                        MusicStageActivity.mMusicAnimation_scale.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                                Message bgm_start = MusicStageActivity.gMusicHandler.obtainMessage();
                                bgm_start.what = PLAY_BGM;
                                bgm_start.arg1 = R.raw.zz_bg_a_marryyou_brunomars;
                                MusicStageActivity.gMusicHandler.sendMessage(bgm_start);
                                disable_click();
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {

                                MusicStageActivity.click_current_state = CLICK_STATE_OFF;
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

                        MusicStageActivity.pre_choice = target_index;

                        MusicStageActivity.musicstage_progress2List[target_index].startAnimation(MusicStageActivity.mMusicAnimation_scale);

                        MusicStageActivity.musicstage_progress3List[target_index].startAnimation(MusicStageActivity.mMusicAnimation_down);

                        MusicStageActivity.click_current_state = CLICK_STATE_ON;

                        break;

                    case CLICK_STATE_ON:

                        disable_click();
                        MusicStageActivity.mMusicAnimation_scale.pause();
                        MusicStageActivity.mMusicAnimation_down.pause();

                        Message bgm_pause = MusicStageActivity.gMusicHandler.obtainMessage();
                        bgm_pause.what = PAUSE_BGM;
                        MusicStageActivity.gMusicHandler.sendMessage(bgm_pause);

                        Log.i("====stopBGM","");

                        MusicStageActivity.click_current_state = CLICK_STATE_ING;
                        break;

                    case CLICK_STATE_ING:

                        disable_click();
                        MusicStageActivity.mMusicAnimation_scale.resume();

                        MusicStageActivity.mMusicAnimation_down.resume();

                        Message bgm_resume = MusicStageActivity.gMusicHandler.obtainMessage();
                        bgm_resume.what = RESUME_BGM;
                        MusicStageActivity.gMusicHandler.sendMessage(bgm_resume);
                        MusicStageActivity.click_current_state = CLICK_STATE_ON;

                        break;
                }

                break;

            case R.id.musicstage_information1:

                Intent intent = new Intent(MusicStageActivity.mContext, MusicStageSubActivity.class);
                startActivityForResult(intent,0);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_hold);

                break;

            case R.id.musicstage_main1_like_img:
            case R.id.musicstage_main2_like_img:
            case R.id.musicstage_main3_like_img:
            case R.id.musicstage_main4_like_img:

                for (int i = 0; i < CONTENT_NUMBER; i++) {
                    if (v.getId() == MusicStageActivity.musicstage_like_img[i].getId()) {
                        target_index = i;
                        Log.i("like index!!!===",String.valueOf(target_index));
                    }
                }

                int temp_like = Integer.parseInt(MusicStageActivity.musicstage_like_txt[target_index].getText().toString()) + 1;

                MusicStageActivity.musicstage_like_txt[target_index].setText(String.valueOf(temp_like));

                MusicStageActivity.musicstage_likeList[target_index]++;

                musicstage_imageDAO.updateMusicstage_like(target_index+1, MusicStageActivity.musicstage_likeList[target_index]);

                break;
        }
    }
}


