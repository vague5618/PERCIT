package com.example.jay.percit.Listener;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.jay.percit.Controller.SettingActivity;
import com.example.jay.percit.R;

/**
 * Created by 재용 on 2015-08-15.
 */
public class MusicStageClickListener implements View.OnClickListener {

    public final static int MAIN_FOCUS = 10;
    public final static int SUB_FOCUS = 11;


    Context mContext;

    public MusicStageClickListener(Context mContext) {
        this.mContext = mContext;
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.setting_kick1:
            case R.id.setting_kick2:
            case R.id.setting_sub1:
            case R.id.setting_sub2:
            case R.id.setting_sub3:
            case R.id.setting_sub4:
            case R.id.setting_sub5:
            case R.id.setting_sub6:

                SettingActivity.gSettingHandler.sendEmptyMessage(SUB_FOCUS);

                break;

            case R.id.setting_mainboard:

                SettingActivity.gSettingHandler.sendEmptyMessage(MAIN_FOCUS);

                break;
        }
    }
}
