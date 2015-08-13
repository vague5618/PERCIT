package com.example.jay.percit.Controller;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.jay.percit.Data.Setting_Category1;
import com.example.jay.percit.Data.Setting_Category2;
import com.example.jay.percit.Listview.Setting_Category1_ListAdapter;
import com.example.jay.percit.Listview.Setting_Category1_Model;
import com.example.jay.percit.Listview.Setting_Category1_View;
import com.example.jay.percit.Listview.Setting_Category2_ListAdapter;
import com.example.jay.percit.Listview.Setting_Category2_Model;
import com.example.jay.percit.R;

public class SettingActivity extends AppCompatActivity implements View.OnTouchListener {


    ListView mCategory1_listView;
    ListView mCategory2_listView;
    Setting_Category1_ListAdapter mCategory1_adapter;
    Setting_Category2_ListAdapter mCategory2_adapter;
    Setting_Category1 mCategory1_setup;
    Setting_Category2 mCategory2_setup;

    private float mPressedY;
    private float mPressedX;
    ImageView mActivitySetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        System.out.println("width = " + width);
        System.out.println("height = " + height);

        DisplayMetrics dm =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float widthDp = dm.widthPixels / dm.density;


        System.out.println("width ==="+dm.widthPixels + "height ====" +dm.heightPixels + "\n widthdp ===="+widthDp);

        mCategory1_listView = (ListView) findViewById(R.id.setting_category1_listview);

        mCategory2_listView = (ListView) findViewById(R.id.setting_category2_listview);

        mCategory1_adapter = new Setting_Category1_ListAdapter(this);

        mCategory2_adapter = new Setting_Category2_ListAdapter(this);

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
                mCategory2_setup.add_index("");
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

                ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
                String[] mineType = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData drogData = new ClipData((CharSequence) view.getTag(), mineType, item);

                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(view);

                return view.startDrag(drogData, myShadow, null, 0);
            }
        });

        mActivitySetting = (ImageView) findViewById(R.id.activity_handler);
        mActivitySetting.setOnTouchListener(this);
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

            Intent intent = new Intent(this, CommunityActivity.class);
            CommunityActivity.current_fragment = 2;
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
