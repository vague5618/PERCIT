package com.example.jay.percit.Data;

import android.content.res.Resources;

import com.example.jay.percit.Listview.Setting_Category1_ListAdapter;
import com.example.jay.percit.Listview.Setting_Category2_ListAdapter;
import com.example.jay.percit.Listview.Setting_Category2_Model;
import com.example.jay.percit.R;

/**
 * Created by 재용 on 2015-08-11.
 */
public class Setting_Category2 {

    Setting_Category2_ListAdapter mListAdapter;
    Resources res;

    public Setting_Category2(Setting_Category2_ListAdapter mListAdapter, Resources res) {

        this.mListAdapter = mListAdapter;
        this.res = res;
    }

    public void add_index(String data) {

        mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_bombo_unfocus),
                (res.getDrawable(R.drawable.setting_main_category2_01_bombo_focus)),
                "bombo1"
        ));

        mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_bombo_unfocus),
                (res.getDrawable(R.drawable.setting_main_category2_02_bombo_focus)),
                "bombo2"
        ));

        mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_bombo_unfocus),
                (res.getDrawable(R.drawable.setting_main_category2_03_bombo_focus)),
                "bombo3"
        ));
    }
}
