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

        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_01_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_01_icon_focus),
          //      res.getDrawable(R.drawable.setting_main_category1_01_number),
           //     res.getDrawable(R.drawable.setting_main_category1_01_number),
            //    res.getDrawable(R.drawable.setting_main_category1_01_number),
             //   res.getDrawable(R.drawable.setting_main_category1_01_number),
                "snare-drum"
        ));


        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_02_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_02_icon_focus),
                "djembe"
        ));

        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_03_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_03_icon_focus),
                "cajon"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_04_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_04_icon_focus),
                "bongo"
        )); mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_05_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_05_icon_focus),
                "bongo"
        )); mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_06_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_06_icon_focus),
                "bongo"
        )); mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_07_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_07_icon_focus),
                "bongo"
        )); mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_08_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_08_icon_focus),
                "bongo"
        ));


        mListAdapter.notifyDataSetChanged();
    }
}
