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
                "Snare Drum"
        ));


        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_02_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_02_icon_focus),
                "Djembe"
        ));

        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_03_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_03_icon_focus),
                "Cajon"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_04_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_04_icon_focus),
                "Bongo"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_05_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_05_icon_focus),
                "Conga"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_06_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_06_icon_focus),
                "Hang drum"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_07_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_07_icon_focus),
                "Doumbek"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_08_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_08_icon_focus),
                "Bombo"
        ));

        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_09_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_09_icon_focus),
                "Kenkeni"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_10_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_10_icon_focus),
                "Timbales"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_11_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_11_icon_focus),
                "Dundun"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_12_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_12_icon_focus),
                "Concert Tam Tam"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_13_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_13_icon_focus),
                "Steel Drum"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_14_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_14_icon_focus),
                "Tumba"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_15_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_15_icon_focus),
                "Sangban"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_16_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_16_icon_focus),
                "Timpani"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_17_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_17_icon_focus),
                "Tubano Drum"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_18_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_18_icon_focus),
                "Surdo"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_19_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_19_icon_focus),
                "Madal"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_20_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_20_icon_focus),
                "Bougarabou"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_21_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_21_icon_focus),
                "Meinl"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_22_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_22_icon_focus),
                "Jang Gu"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_23_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_23_icon_focus),
                "Remo"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_24_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_24_icon_focus),
                "Tycoon"
        ));
        mListAdapter.addItem(new Setting_Category1_Model(res.getDrawable(R.drawable.setting_main_category1_25_icon_unfocus),
                res.getDrawable(R.drawable.setting_main_category1_25_icon_focus),
                "Cuicas"
        ));


        mListAdapter.notifyDataSetChanged();
    }


    public void add_index(String category) {




    }
}
