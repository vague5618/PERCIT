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
 *
 */
public class Setting_Category1_View extends LinearLayout {
	/**
	 * Icon
	 */
	private ImageView setting_catergoy1_icon;

	private ImageView setting_catergoy1_nameImage;

	private TextView setting_category1_name;

	private ImageView setting_catergoy1_number;


	public Setting_Category1_View(Context context, Setting_Category1_Model aItem,int position) {
		super(context);

		// Layout Inflation
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.item_setting_category1, this, true);

		setting_catergoy1_icon = (ImageView) findViewById(R.id.setting_category1_icon);
		setting_catergoy1_nameImage = (ImageView)findViewById(R.id.setting_category1_nameImage);
		setting_catergoy1_number = (ImageView) findViewById(R.id.setting_category1_number);


		if(position == 0)
		{
			setting_catergoy1_icon.setImageDrawable(aItem.getSetting_category1_icon_focus());

			setting_catergoy1_nameImage.setImageDrawable(aItem.getSetting_category1_nameImage_focus());

			setting_catergoy1_number.setImageDrawable(aItem.getSetting_category1_number_focus());
		}
		else {

			setting_catergoy1_icon.setImageDrawable(aItem.getSetting_category1_icon_unfocus());

			setting_catergoy1_nameImage.setImageDrawable(aItem.getSetting_category1_nameImage_unfocus());

			setting_catergoy1_number.setImageDrawable(aItem.getSetting_category1_number_unfocus());
		}
	}

	public void Setting_unfocus(Setting_Category1_Model aItem)
	{
		setting_catergoy1_icon.setImageDrawable(aItem.getSetting_category1_icon_unfocus());
		setting_catergoy1_nameImage.setImageDrawable(aItem.getSetting_category1_nameImage_unfocus());
		setting_catergoy1_number.setImageDrawable(aItem.getSetting_category1_number_unfocus());
	}


	public void Setting_focus(Setting_Category1_Model aItem)
	{
		setting_catergoy1_icon.setImageDrawable(aItem.getSetting_category1_icon_focus());
		setting_catergoy1_nameImage.setImageDrawable(aItem.getSetting_category1_nameImage_focus());
		setting_catergoy1_number.setImageDrawable(aItem.getSetting_category1_number_focus());
	}

}
