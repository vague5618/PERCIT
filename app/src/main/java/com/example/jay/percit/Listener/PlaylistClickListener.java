package com.example.jay.percit.Listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.jay.percit.Controller.MusicStageActivity;
import com.example.jay.percit.Controller.MusicStageSubActivity;
import com.example.jay.percit.Controller.SettingActivity;
import com.example.jay.percit.R;

/**
 * Created by 재용 on 2015-08-15.
 */
public class PlaylistClickListener implements View.OnClickListener {

    Context mContext;

    public PlaylistClickListener(Context mContext) {
        this.mContext = mContext;
    }

    public void onClick(View v) {

        switch (v.getId()) {




            case R.id.setting_mainboard:


                break;
        }
    }
}
