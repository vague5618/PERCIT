package com.example.jay.percit.Handler;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.jay.percit.Controller.SettingActivity;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-14.
 */
public class SettingHandler extends Handler {

    public final static int MAIN_FOCUS = 10;
    public final static int SUB_FOCUS = 11;

    Context mContext;
    Animation mAnimation_blink;
    int temp_number;
    String temp_string;
    Resources res;

    public SettingHandler(Context mContext, Resources res) {

        this.mContext = mContext;
        this.res = res;
        mAnimation_blink = AnimationUtils.loadAnimation(mContext, R.anim.image_blink);
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        System.out.println("==================");

        switch (msg.what) {

            case R.id.setting_sub1:

                temp_number = msg.arg1;
                temp_string = (String) msg.obj;

                SettingActivity.setting_list[1]=temp_string;
                SettingActivity.setting_sub1_text.setText(temp_string);

                break;

            case R.id.setting_sub2:

                temp_number = msg.arg1;
                temp_string = (String) msg.obj;
                SettingActivity.setting_sub2_text.setText(temp_string);
                break;

            case R.id.setting_sub3:

                temp_number = msg.arg1;
                temp_string = (String) msg.obj;
                SettingActivity.setting_sub3_text.setText(temp_string);
                break;

            case R.id.setting_sub4:

                temp_number = msg.arg1;
                temp_string = (String) msg.obj;
                SettingActivity.setting_sub4_text.setText(temp_string);
                break;

            case R.id.setting_sub5:

                temp_number = msg.arg1;
                temp_string = (String) msg.obj;
                SettingActivity.setting_sub5_text.setText(temp_string);
                break;

            case R.id.setting_sub6:

                temp_number = msg.arg1;
                temp_string = (String) msg.obj;
                SettingActivity.setting_sub6_text.setText(temp_string);
                break;

            case R.id.setting_mainboard:

                System.out.println("===========================123");
                temp_number = msg.arg1;
                temp_string = (String) msg.obj;
                SettingActivity.setting_list[0]=temp_string;
                SettingActivity.setting_mainboard_text.setText(temp_string);
                break;

            case R.id.setting_kick1:


                temp_number = msg.arg1;
                temp_string = (String) msg.obj;
                SettingActivity.setting_kick1_text.setText(temp_string);
                break;

            case R.id.setting_kick2:

                temp_number = msg.arg1;
                temp_string = (String) msg.obj;
                SettingActivity.setting_kick2_text.setText(temp_string);
                break;


            case MAIN_FOCUS:


                SettingActivity.setting_mainboard.setImageDrawable(res.getDrawable(R.drawable.setting_mainboard_focus));

                SettingActivity.setting_sub1.setImageDrawable(res.getDrawable(R.drawable.setting_sub1_unfocus));
                SettingActivity.setting_sub2.setImageDrawable(res.getDrawable(R.drawable.setting_sub2_unfocus));
                SettingActivity.setting_sub3.setImageDrawable(res.getDrawable(R.drawable.setting_sub3_unfocus));
                SettingActivity.setting_sub4.setImageDrawable(res.getDrawable(R.drawable.setting_sub4_unfocus));
                SettingActivity.setting_sub5.setImageDrawable(res.getDrawable(R.drawable.setting_sub5_unfocus));
                SettingActivity.setting_sub6.setImageDrawable(res.getDrawable(R.drawable.setting_sub6_unfocus));
                SettingActivity.setting_kick1.setImageDrawable(res.getDrawable(R.drawable.setting_kick1_unfocus));
                SettingActivity.setting_kick2.setImageDrawable(res.getDrawable(R.drawable.setting_kick2_unfocus));

                SettingActivity.setting_mainboard.startAnimation(mAnimation_blink);

                break;

            case SUB_FOCUS:


                SettingActivity.setting_mainboard.setImageDrawable(res.getDrawable(R.drawable.setting_mainboard_unfocus));

                SettingActivity.setting_sub1.setImageDrawable(res.getDrawable(R.drawable.setting_sub1_focus));
                SettingActivity.setting_sub2.setImageDrawable(res.getDrawable(R.drawable.setting_sub2_focus));
                SettingActivity.setting_sub3.setImageDrawable(res.getDrawable(R.drawable.setting_sub3_focus));
                SettingActivity.setting_sub4.setImageDrawable(res.getDrawable(R.drawable.setting_sub4_focus));
                SettingActivity.setting_sub5.setImageDrawable(res.getDrawable(R.drawable.setting_sub5_focus));
                SettingActivity.setting_sub6.setImageDrawable(res.getDrawable(R.drawable.setting_sub6_focus));
                SettingActivity.setting_kick1.setImageDrawable(res.getDrawable(R.drawable.setting_kick1_focus));
                SettingActivity.setting_kick2.setImageDrawable(res.getDrawable(R.drawable.setting_kick2_focus));


                SettingActivity.setting_sub1.startAnimation(mAnimation_blink);
                SettingActivity.setting_sub2.startAnimation(mAnimation_blink);
                SettingActivity.setting_sub3.startAnimation(mAnimation_blink);
                SettingActivity.setting_sub4.startAnimation(mAnimation_blink);
                SettingActivity.setting_sub5.startAnimation(mAnimation_blink);
                SettingActivity.setting_sub6.startAnimation(mAnimation_blink);
                SettingActivity.setting_kick1.startAnimation(mAnimation_blink);
                SettingActivity.setting_kick2.startAnimation(mAnimation_blink);

                break;


            default:
                break;
        }
    }
}
