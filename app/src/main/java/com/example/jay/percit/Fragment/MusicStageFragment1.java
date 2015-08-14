package com.example.jay.percit.Fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.jay.percit.Controller.MusicStageActivity;
import com.example.jay.percit.Listview.MusicStage_IdModel;
import com.example.jay.percit.Listview.MusicStage_IdSetup;
import com.example.jay.percit.Listview.MusicStage_ImageModel;
import com.example.jay.percit.Listview.MusicStage_ImageSetup;
import com.example.jay.percit.R;

import java.util.ArrayList;

/**
 * Created by Jay on 2015-08-06.
 */

public class MusicStageFragment1 extends Fragment implements View.OnClickListener {


    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final int CONTENT_NUMBER = 1;
    private static final int PLAY_BGM = 8;
    private static final int PAUSE_BGM = 9;
    private static final int RESUME_BGM = 10;

    Animation mMusicAnimation_scale;
    Animation mMusicAnimation_down;

    private ImageView musicstage_imageList[];

    //private ArrayList<ImageView> musicstage_imageList;

    private ImageView musicstage_progress1List[];

    private ImageView musicstage_progress2List[];

    private ImageView musicstage_informationList[];

    private ArrayList<MusicStage_ImageModel> musicstage_Image_modelList;

    private MusicStage_ImageSetup musicstage_Image_setup;

    private ArrayList<MusicStage_IdModel> musicstage_Id_modelList;

    private MusicStage_IdSetup musicStage_id_setup;

    public static MusicStageFragment1 newInstance() {

        MusicStageFragment1 fragment = new MusicStageFragment1();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Resources res = getResources();

        View v = inflater.inflate(R.layout.fragment_musicstage1, container, false);

        musicstage_imageList = new ImageView[10];
        musicstage_progress1List = new ImageView[10];
        musicstage_progress2List = new ImageView[10];
        musicstage_informationList = new ImageView[10];

        //
        musicstage_Image_modelList = new ArrayList<>();
        musicstage_Id_modelList = new ArrayList<>();

        musicstage_Image_setup = new MusicStage_ImageSetup(musicstage_Image_modelList);
        musicStage_id_setup = new MusicStage_IdSetup(musicstage_Id_modelList);

        for (int i = 0; i < CONTENT_NUMBER; i++) {
            musicstage_imageList[i] = (ImageView) v.findViewById(musicstage_Id_modelList.get(i).getMusicstage_image_id());
            musicstage_informationList[i] = (ImageView) v.findViewById(musicstage_Id_modelList.get(i).getMusicstage_information_id());
            musicstage_progress1List[i] = (ImageView) v.findViewById(musicstage_Id_modelList.get(i).getMusicstage_progress1_id());
            musicstage_progress2List[i] = (ImageView) v.findViewById(musicstage_Id_modelList.get(i).getMusicstage_progress2_id());
            musicstage_imageList[i].setImageDrawable(res.getDrawable(musicstage_Image_modelList.get(i).getMusicstage_image()));
            musicstage_informationList[i].setImageDrawable(res.getDrawable(musicstage_Image_modelList.get(i).getMusicstage_information()));
         //   musicstage_progress1List[i].setImageDrawable(res.getDrawable(musicstage_Image_modelList.get(i).getMusicstage_progress1()));
         //   musicstage_progress2List[i].setImageDrawable(res.getDrawable(musicstage_Image_modelList.get(i).getMusicstage_progress2()));


            musicstage_progress1List[i].setVisibility(View.INVISIBLE);
           musicstage_progress2List[i].setVisibility(View.INVISIBLE);


            musicstage_imageList[i].setOnClickListener(this);

        }

        mMusicAnimation_scale = AnimationUtils.loadAnimation(MusicStageActivity.mContext,R.anim.musicstage_scale);

        mMusicAnimation_down = AnimationUtils.loadAnimation(MusicStageActivity.mContext,R.anim.musicstage_down);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.musicstage_image1 :

                mMusicAnimation_scale.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        musicstage_progress1List[0].setVisibility(View.VISIBLE);
                        MusicStageActivity.gMusicHandler.sendEmptyMessage(PLAY_BGM);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        musicstage_progress1List[0].setVisibility(View.GONE);
                        MusicStageActivity.gMusicHandler.sendEmptyMessage(PAUSE_BGM);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                        MusicStageActivity.gMusicHandler.sendEmptyMessage(PAUSE_BGM);
                    }
                });

                mMusicAnimation_down.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        musicstage_progress2List[0].setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        musicstage_progress2List[0].setVisibility(View.GONE);

                        System.out.println("repeat anim");
                        mMusicAnimation_scale.cancel();

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                musicstage_progress1List[0].startAnimation(mMusicAnimation_scale);
                musicstage_progress2List[0].startAnimation(mMusicAnimation_down);

                break;

        }


    }
}

