package com.example.jay.percit.Controller;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jay.percit.Data.Setting_Category1;
import com.example.jay.percit.Data.Setting_Category2;
import com.example.jay.percit.Handler.SettingHandler;
import com.example.jay.percit.Listener.DragEventListener;
import com.example.jay.percit.Listener.SettingClickListener;
import com.example.jay.percit.Listview.Setting_Category1_ListAdapter;
import com.example.jay.percit.Listview.Setting_Category2_ListAdapter;
import com.example.jay.percit.Model.Setting_percit;
import com.example.jay.percit.Model.Setting_percitDAO;
import com.example.jay.percit.R;

public class SettingActivity extends AppCompatActivity implements View.OnTouchListener {

    ListView mCategory1_listView;
    ListView mCategory2_listView;

    public static String[] setting_musicnumber_list;
    public static String[] setting_musicname_list;

    public static ImageView setting_sub1;
    public static ImageView setting_sub2;
    public static ImageView setting_sub3;
    public static ImageView setting_sub4;
    public static ImageView setting_sub5;
    public static ImageView setting_sub6;
    public static ImageView setting_mainboard;
    public static ImageView setting_kick1;
    public static ImageView setting_kick2;
    public static TextView setting_sub1_text;
    public static TextView setting_sub2_text;
    public static TextView setting_sub3_text;
    public static TextView setting_sub4_text;
    public static TextView setting_sub5_text;
    public static TextView setting_sub6_text;
    public static TextView setting_mainboard_text;
    public static TextView setting_kick1_text;
    public static TextView setting_kick2_text;

    public static DragEventListener gDragEventListener;
    SettingClickListener mSettingClickListener;

    Setting_Category1_ListAdapter mCategory1_adapter;
    Setting_Category2_ListAdapter mCategory2_adapter;
    Setting_Category1 mCategory1_setup;
    Setting_Category2 mCategory2_setup;
    public static SettingHandler gSettingHandler;
    private float mPressedY;
    private float mPressedX;
    ImageView mActivitySetting;
    Setting_percitDAO setting_percitDAO;

    String temp_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setting_musicnumber_list = new String[9];
        setting_musicname_list = new String[9];

        try {
            setting_percitDAO = Setting_percitDAO.open(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        gSettingHandler = new SettingHandler(this, getResources());
        setting_sub1 = (ImageView) findViewById(R.id.setting_sub1);
        setting_sub2 = (ImageView) findViewById(R.id.setting_sub2);
        setting_sub3 = (ImageView) findViewById(R.id.setting_sub3);
        setting_sub4 = (ImageView) findViewById(R.id.setting_sub4);
        setting_sub5 = (ImageView) findViewById(R.id.setting_sub5);
        setting_sub6 = (ImageView) findViewById(R.id.setting_sub6);
        setting_mainboard = (ImageView) findViewById(R.id.setting_mainboard);
        setting_kick1 = (ImageView) findViewById(R.id.setting_kick1);
        setting_kick2 = (ImageView) findViewById(R.id.setting_kick2);

        setting_sub1_text = (TextView) findViewById(R.id.setting_sub1_text);
        setting_sub2_text = (TextView) findViewById(R.id.setting_sub2_text);
        setting_sub3_text = (TextView) findViewById(R.id.setting_sub3_text);
        setting_sub4_text = (TextView) findViewById(R.id.setting_sub4_text);
        setting_sub5_text = (TextView) findViewById(R.id.setting_sub5_text);
        setting_sub6_text = (TextView) findViewById(R.id.setting_sub6_text);
        setting_mainboard_text = (TextView) findViewById(R.id.setting_mainboard_text);
        setting_kick1_text = (TextView) findViewById(R.id.setting_kick1_text);
        setting_kick2_text = (TextView) findViewById(R.id.setting_kick2_text);


        mCategory1_listView = (ListView) findViewById(R.id.setting_category1_listview);

        mCategory2_listView = (ListView) findViewById(R.id.setting_category2_listview);

        mCategory1_adapter = new Setting_Category1_ListAdapter(this);

        mCategory2_adapter = new Setting_Category2_ListAdapter(this);

        gDragEventListener = new DragEventListener(this, gSettingHandler);

        mSettingClickListener = new SettingClickListener(this);

        mCategory1_listView.setAdapter(mCategory1_adapter);

        mCategory2_listView.setAdapter(mCategory2_adapter);

        mCategory1_setup = new Setting_Category1(mCategory1_adapter, getResources());
        mCategory2_setup = new Setting_Category2(mCategory2_adapter, getResources());

        mCategory1_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mCategory1_adapter.select(position);
                mCategory2_adapter.clear();
                //             mCategory2_adapter.select(0);

                temp_name = mCategory1_adapter.getItem(position).getSetting_category1_name();
                mCategory2_setup.add_index(position);
                mCategory2_adapter.notifyDataSetInvalidated();
                mCategory1_adapter.notifyDataSetInvalidated();

            }
        });

        mCategory2_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mCategory2_adapter.select(position);
                mCategory2_adapter.notifyDataSetInvalidated();

            }
        });

        mCategory2_listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                mCategory2_adapter.select(position);
                mCategory2_adapter.notifyDataSetInvalidated();

                String temp_number = mCategory2_adapter.getItem(position).getSetting_catergory2_number();

                ClipData.Item item = new ClipData.Item(temp_number + " " + temp_name);
                String[] mineType = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData drogData = new ClipData((CharSequence) view.getTag(), mineType, item);

                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(view);

                return view.startDrag(drogData, myShadow, null, 0);
            }
        });

        mActivitySetting = (ImageView) findViewById(R.id.activity_handler);
        mActivitySetting.setOnTouchListener(this);


        setting_mainboard.setOnDragListener(gDragEventListener);
//        setting_sub1.setOnDragListener(gDragEventListener);
//        setting_sub2.setOnDragListener(gDragEventListener);
//        setting_sub3.setOnDragListener(gDragEventListener);
//        setting_sub4.setOnDragListener(gDragEventListener);
//        setting_sub5.setOnDragListener(gDragEventListener);
//        setting_sub6.setOnDragListener(gDragEventListener);
//        setting_kick1.setOnDragListener(gDragEventListener);
//        setting_kick2.setOnDragListener(gDragEventListener);

        setting_sub1.setOnClickListener(mSettingClickListener);
        setting_sub2.setOnClickListener(mSettingClickListener);
        setting_sub3.setOnClickListener(mSettingClickListener);
        setting_sub4.setOnClickListener(mSettingClickListener);
        setting_sub5.setOnClickListener(mSettingClickListener);
        setting_sub6.setOnClickListener(mSettingClickListener);
        setting_mainboard.setOnClickListener(mSettingClickListener);
        setting_kick1.setOnClickListener(mSettingClickListener);
        setting_kick2.setOnClickListener(mSettingClickListener);

        for (int i = 0; i < 9; i++) {
            setting_musicnumber_list[i] = "-1";
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        float y_distance = 0;

        float x_distance = 0;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPressedY = event.getY();
                mPressedX = event.getX();
                break;

            case MotionEvent.ACTION_UP:
                y_distance = mPressedY - event.getY();
                x_distance = mPressedX - event.getX();
                break;
        }

        if (Math.abs(x_distance) > 1000) {

            return false;
        }

        if (x_distance < 0) {


            Setting_percit setting_percit_temp = new Setting_percit();

            for (int i = 0; i < 9; i++) {

                System.out.println("setting: " + (i + 1) + " = " + setting_musicnumber_list[i]);
                System.out.println("=====" + setting_musicname_list[i]);
            }

            setting_percit_temp.setSetting_percit_a(Integer.parseInt(setting_musicnumber_list[0]));

            setting_percit_temp.setSetting_percit_b(Integer.parseInt(setting_musicnumber_list[1]));

            setting_percit_temp.setSetting_percit_c(Integer.parseInt(setting_musicnumber_list[2]));

            setting_percit_temp.setSetting_percit_d(Integer.parseInt(setting_musicnumber_list[3]));

            setting_percit_temp.setSetting_percit_e(Integer.parseInt(setting_musicnumber_list[4]));

            setting_percit_temp.setSetting_percit_f(Integer.parseInt(setting_musicnumber_list[5]));

            setting_percit_temp.setSetting_percit_g(Integer.parseInt(setting_musicnumber_list[6]));

            setting_percit_temp.setSetting_percit_h(Integer.parseInt(setting_musicnumber_list[7]));

            setting_percit_temp.setSetting_percit_i(Integer.parseInt(setting_musicnumber_list[8]));

            setting_percitDAO.updateSetting_percit(setting_percit_temp);


            Intent intent = new Intent(this, MusicStageActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_hold);
            finish();
            return false;

        } else {
            //Siwpe up content

        }

        return true;
    }
}
