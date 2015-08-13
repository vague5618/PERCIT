package com.example.jay.percit.Listview;

import android.graphics.drawable.Drawable;

/**
 * 데이터를 담고 있을 아이템 정의
 *
 * @author Mike
 */
public class Setting_Category2_Model {

    private Drawable setting_category2_nameImage_foucs;
    private Drawable setting_category2_nameImage_unfocus;

    private String setting_catergory2_name;
    /**
     * True if this item is selectable
     */
    private boolean mSelectable = true;

    public Drawable getSetting_category2_nameImage_unfocus() {
        return setting_category2_nameImage_unfocus;
    }

    public Drawable getSetting_category2_nameImage_foucs() {
        return setting_category2_nameImage_foucs;
    }

    public Setting_Category2_Model(Drawable setting_category2_nameImage_unfocus,Drawable setting_category2_nameImage_focus, String data) {

        this.setting_category2_nameImage_unfocus = setting_category2_nameImage_unfocus;
        this.setting_category2_nameImage_foucs = setting_category2_nameImage_focus;
        this.setting_catergory2_name = data;

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
    public String getSetting_catergory2_name() {
        return setting_catergory2_name;
    }

}
