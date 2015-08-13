package com.example.jay.percit.Data;

import android.content.res.Resources;

import com.example.jay.percit.Listview.Setting_Category1_ListAdapter;
import com.example.jay.percit.Listview.Setting_Category1_Model;
import com.example.jay.percit.R;

/**
 * Created by 재용 on 2015-08-11.
 */
public class Setting_Category1 {

    Setting_Category1_ListAdapter mListAdapter;
    Resources res;

    public Setting_Category1(Setting_Category1_ListAdapter mListAdapter, Resources res) {
        this.mListAdapter = mListAdapter;
        this.res = res;

        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_01_icon_focus),
                res.getDrawable(R.drawable.setting_main_category1_01_text_focus),
                res.getDrawable(R.drawable.setting_main_category1_01_number),
                res.getDrawable(R.drawable.setting_main_category1_01_number),
                res.getDrawable(R.drawable.setting_main_category1_01_number),
                res.getDrawable(R.drawable.setting_main_category1_01_number),
                "Drum-Snare"
        ));


        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_02_icon_focus),
                res.getDrawable(R.drawable.setting_main_category1_02_text_focus),
                res.getDrawable(R.drawable.setting_main_category1_02_number),
                res.getDrawable(R.drawable.setting_main_category1_02_number),
                res.getDrawable(R.drawable.setting_main_category1_02_number),
                res.getDrawable(R.drawable.setting_main_category1_02_number),
                "KICK"
        ));

        mListAdapter.notifyDataSetChanged();
    }
}
