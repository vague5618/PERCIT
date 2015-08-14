package com.example.jay.percit.Listview;

import android.graphics.drawable.Drawable;

/**
 * 데이터를 담고 있을 아이템 정의
 *
 * @author Mike
 */
public class Setting_Category2_Model {

    private Drawable setting_category2_nameImage_focus;
    private Drawable setting_category2_nameImage_unfocus;
    private String setting_catergory2_number;
    private String setting_catergory2_name;

    /**
     * True if this item is selectable
     */
    private boolean mSelectable = true;

    public Drawable getSetting_category2_nameImage_unfocus() {
        return setting_category2_nameImage_unfocus;
    }

    public Drawable getSetting_category2_nameImage_focus() {
        return setting_category2_nameImage_focus;
    }

    public Setting_Category2_Model(Drawable setting_category2_nameImage_focus, Drawable setting_category2_nameImage_unfocus, String setting_catergory2_number, String setting_catergory2_name) {

        this.setting_category2_nameImage_focus = setting_category2_nameImage_focus;
        this.setting_category2_nameImage_unfocus = setting_category2_nameImage_unfocus;
        this.setting_catergory2_number = setting_catergory2_number;
        this.setting_catergory2_name = setting_catergory2_name;
    }

    public String getSetting_catergory2_name() {
        return setting_catergory2_name;
    }

    public boolean isSelectable() {
        return mSelectable;
    }

    /**
     * Set selectable flag
     */
    public void setSelectable(boolean selectable) {
        mSelectable = selectable;
    }
    /**
     * Get data array
     *
     * @return
     */
    public String getSetting_catergory2_number() {
        return setting_catergory2_number;
    }

}
