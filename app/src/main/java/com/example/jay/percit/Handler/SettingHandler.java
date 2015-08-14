package com.example.jay.percit.Handler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.example.jay.percit.Controller.SettingActivity;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-14.
 */
public class SettingHandler extends Handler {

    Context mContext;

    int temp_number;
    String temp_string;

    public SettingHandler(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        System.out.println("==================");

        switch (msg.what) {

            case R.id.setting_sub1:

                temp_number = msg.arg1;
                temp_string = (String) msg.obj;
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

            default:
                break;
        }
}
}
