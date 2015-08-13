package com.example.jay.percit.Listview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jay.percit.R;

/**
 * 아이템으로 보여줄 뷰 정의
 *
 * @author Mike
 */
public class Setting_Category2_View extends LinearLayout {

    private ImageView setting_category2_nameImage;

    public Setting_Category2_View(Context context, Setting_Category2_Model aItem,int position) {
        super(context);

        // Layout Inflation
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_setting_category2, this, true);

        setting_category2_nameImage = (ImageView) findViewById(R.id.setting_category2_nameImage);

        if(position == 0) {
            setting_category2_nameImage.setImageDrawable(aItem.getSetting_category2_nameImage_foucs());
        }
        else {
            setting_category2_nameImage.setImageDrawable(aItem.getSetting_category2_nameImage_unfocus());
        }
    }

    public void Setting_unfocus(Setting_Category2_Model aItem)
    {
        setting_category2_nameImage.setImageDrawable(aItem.getSetting_category2_nameImage_unfocus());

    }


    public void Setting_focus(Setting_Category2_Model aItem) {
        setting_category2_nameImage.setImageDrawable(aItem.getSetting_category2_nameImage_foucs());
    }

}


