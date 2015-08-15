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

    public void add_index(int category) {

        switch (category) {
            case 0:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_drum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_drum_unfocus)),
                        "0", "Wood Snare1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_drum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_drum_unfocus)),
                        "1", "Wood Snare2"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_drum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_drum_unfocus)),
                        "2", "Metal Snare1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_drum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_drum_unfocus)),
                        "3", "Metal Snare2"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_05_drum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_05_drum_unfocus)),
                        "4", "Metal Snare3"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_06_drum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_06_drum_unfocus)),
                        "5", "Picolo Snare1"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_07_drum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_07_drum_unfocus)),
                        "6", "Picolo Snare2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_08_drum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_08_drum_unfocus)),
                        "7", "Solid Snare1"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_09_drum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_09_drum_unfocus)),
                        "8", "Solid Snare2"
                ));

                break;


            case 1:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_djembe_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_djembe_unfocus)),
                        "9", "Djembe 1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_djembe_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_djembe_unfocus)),
                        "10", "Djembe 2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_djembe_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_djembe_unfocus)),
                        "11", "Djembe 3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_djembe_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_djembe_unfocus)),
                        "12", "Djembe 4"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_05_djembe_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_05_djembe_unfocus)),
                        "13", "Djembe 5"
                ));

                break;

            case 2:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_cajon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_cajon_unfocus)),
                        "14", "Cajon 1"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_cajon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_cajon_unfocus)),
                        "15", "Cajon 2"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_cajon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_cajon_unfocus)),
                        "16", "Cajon 3"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_cajon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_cajon_unfocus)),
                        "17", "Cajon 4"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_05_cajon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_05_cajon_unfocus)),
                        "18", "Cajon 5"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_06_cajon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_06_cajon_unfocus)),
                        "19", "Cajon 6"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_07_cajon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_07_cajon_unfocus)),
                        "20", "Cajon 7"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_08_cajon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_08_cajon_unfocus)),
                        "21", "Cajon 8"
                ));

                break;

            case 3:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_bongo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_bongo_unfocus)),
                        "22", "Bongo Hi"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_bongo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_bongo_unfocus)),
                        "23", "Bongo Lo"
                ));
                break;

            case 4:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_conga_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_conga_unfocus)),
                        "24", "Conga 1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_conga_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_conga_unfocus)),
                        "25", "Conga 2"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_conga_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_conga_unfocus)),
                        "26", "Conga 3"
                ));

                break;

            case 5:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_hangdrum_unfocus)),
                        "27", "G4"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_hangdrum_unfocus)),
                        "28", "A4"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_hangdrum_unfocus)),
                        "29", "B4"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_hangdrum_unfocus)),
                        "30", "C3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_05_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_05_hangdrum_unfocus)),
                        "31", "D3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_06_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_06_hangdrum_unfocus)),
                        "32", "E3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_07_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_07_hangdrum_unfocus)),
                        "33", "F3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_08_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_08_hangdrum_unfocus)),
                        "34", "G3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_09_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_09_hangdrum_unfocus)),
                        "35", "A3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_10_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_10_hangdrum_unfocus)),
                        "36", "B3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_11_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_11_hangdrum_unfocus)),
                        "37", "C2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_12_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_12_hangdrum_unfocus)),
                        "38", "D2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_13_hangdrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_13_hangdrum_unfocus)),
                        "39", "E2"
                ));

                break;


            case 6:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_doumbek_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_doumbek_unfocus)),
                        "40", "Doumbek 1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_doumbek_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_doumbek_unfocus)),
                        "41", "Doumbek 2"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_doumbek_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_doumbek_unfocus)),
                        "42", "Doumbek 3"
                ));


                break;

            case 7:


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_bombo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_bombo_unfocus)),
                        "43", "Bombo 1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_bombo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_bombo_unfocus)),
                        "44", "Bombo 2"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_bombo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_bombo_unfocus)),
                        "45", "Bombo 3"
                ));

                break;

            case 8:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_kenkeni_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_kenkeni_unfocus)),
                        "46", "Kenkeni 1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_kenkeni_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_kenkeni_unfocus)),
                        "47", "Kenkeni 2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_kenkeni_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_kenkeni_unfocus)),
                        "48", "Kenkeni 3"
                ));

                break;

            case 9:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_timpani_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_timpani_unfocus)),
                        "49", "Timbale Hi"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_timpani_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_timpani_unfocus)),
                        "50", "Timbale Mid"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_timpani_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_timpani_unfocus)),
                        "51", "Timbale M"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_timpani_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_timpani_unfocus)),
                        "52", "Timbale Lo"
                ));

                break;

            case 10:
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_dundun_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_dundun_unfocus)),
                        "53", "Dun Dun 1"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_dundun_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_dundun_unfocus)),
                        "54", "Dun Dun 2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_dundun_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_dundun_unfocus)),
                        "55", "Dun Dun 3"
                ));


                break;

            case 11:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_tamtam_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_tamtam_unfocus)),
                        "56", "Tam 1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_tamtam_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_tamtam_unfocus)),
                        "57", "Tam 2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_tamtam_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_tamtam_unfocus)),
                        "58", "Tam 3"
                ));

                break;

            case 12:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_steeldrum_unfocus)),
                        "59", "G4"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_steeldrum_unfocus)),
                        "60", "A4"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_steeldrum_unfocus)),
                        "61", "B4"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_steeldrum_unfocus)),
                        "62", "C3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_05_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_05_steeldrum_unfocus)),
                        "63", "D3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_06_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_06_steeldrum_unfocus)),
                        "64", "E3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_07_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_07_steeldrum_unfocus)),
                        "65", "F3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_08_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_08_steeldrum_unfocus)),
                        "66", "G3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_09_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_09_steeldrum_unfocus)),
                        "67", "A3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_10_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_10_steeldrum_unfocus)),
                        "68", "B3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_11_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_11_steeldrum_unfocus)),
                        "69", "C2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_12_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_12_steeldrum_unfocus)),
                        "70", "D2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_13_steeldrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_13_steeldrum_unfocus)),
                        "71", "E2"
                ));


                break;

            case 13:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_tumba_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_tumba_unfocus)),
                        "72", "Tumba 1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_tumba_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_tumba_unfocus)),
                        "73", "Tumba 2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_tumba_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_tumba_unfocus)),
                        "74", "Tumba 3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_tumba_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_tumba_unfocus)),
                        "75", "Tumba 4"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_05_tumba_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_05_tumba_unfocus)),
                        "76", "Tumba 5"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_06_tumba_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_06_tumba_unfocus)),
                        "77", "Tumba 6"
                ));

                break;

            case 14:


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_sangban_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_sangban_unfocus)),
                        "78", "Sangban 1"));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_sangban_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_sangban_unfocus)),
                        "79", "Sangban 2"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_sangban_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_sangban_unfocus)),
                        "80", "Sangban 3"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_sangban_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_sangban_unfocus)),
                        "81", "Sangban 4"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_05_sangban_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_05_sangban_unfocus)),
                        "82", "Sangban 5"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_06_sangban_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_06_sangban_unfocus)),
                        "83", "Sangban 6"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_07_sangban_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_07_sangban_unfocus)),
                        "84", "Sangban 7"
                ));

                break;


            case 15:


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_timpani_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_timpani_unfocus)),
                        "85", "Timpani Hi"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_timpani_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_timpani_unfocus)),
                        "86", "Timpani Mid"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_timpani_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_timpani_unfocus)),
                        "87", "Timpani Lo"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_timpani_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_timpani_unfocus)),
                        "88", "Timpani XLo"
                ));

                break;


            case 16:


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_tubanodrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_tubanodrum_unfocus)),
                        "89", "Tubano Drum Hi"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_tubanodrum_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_tubanodrum_unfocus)),
                        "90", "Tubano Drum Lo"
                ));

                break;


            case 17:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_surdo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_surdo_unfocus)),
                        "91", "Surdo 1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_surdo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_surdo_unfocus)),
                        "92", "Surdo 2"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_surdo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_surdo_unfocus)),
                        "93", "Surdo 3"
                ));

                break;


            case 18:


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_madal_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_madal_unfocus)),
                        "94", "Madal 1"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_madal_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_madal_unfocus)),
                        "95", "Madal 2"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_madal_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_madal_unfocus)),
                        "96", "Madal 3"
                ));


                break;


            case 19:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_bougarabou_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_bougarabou_unfocus)),
                        "97", "Bougarabou Hi"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_bougarabou_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_bougarabou_unfocus)),
                        "98", "Bougarabou Mid"
                ));

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_bougarabou_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_bougarabou_unfocus)),
                        "99", "Bougarabou Lo"
                ));

                break;

            case 20:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_meinl_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_meinl_unfocus)),
                        "100", "Meinl 1"
                ));


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_meinl_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_meinl_unfocus)),
                        "101", "Meinl 2"
                ));

                break;

            case 21:


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_janggu_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_janggu_unfocus)),
                        "102", "Jang Gu1"
                ));


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_janggu_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_janggu_unfocus)),
                        "103", "Jang Gu2"
                ));


                break;

            case 22:


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_remo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_remo_unfocus)),
                        "104", "Remo Hi"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_remo_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_remo_unfocus)),
                        "105", "Remo Hi"
                ));

                break;


            case 23:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_tycoon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_tycoon_unfocus)),
                        "106", "Tycoon Hi"
                ));


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_tycoon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_tycoon_unfocus)),
                        "107", "Tycoon Mid"
                ));


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_03_tycoon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_03_tycoon_unfocus)),
                        "108", "Tycoon Lo"
                ));


                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_04_tycoon_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_04_tycoon_unfocus)),
                        "109", "Tycoon XLo"
                ));


                break;


            case 24:

                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_01_cuica_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_01_cuica_unfocus)),
                        "110", "Cuica 1"
                ));
                mListAdapter.addItem(new Setting_Category2_Model(res.getDrawable(R.drawable.setting_main_category2_02_cuica_focus),
                        (res.getDrawable(R.drawable.setting_main_category2_02_cuica_unfocus)),
                        "111", "Cuica 2"
                ));


                break;

        }
    }
}
