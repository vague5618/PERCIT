package com.example.jay.percit.Listview;

import android.graphics.drawable.Drawable;

/**
 * 데이터를 담고 있을 아이템 정의
 *
 * @author Mike
 */
public class Setting_Category1_Model {

    private Drawable setting_category1_icon_unfocus;

    private Drawable setting_category1_nameImage_unfocus;

    private Drawable setting_category1_number_unfocus;

    private Drawable setting_category1_icon_focus;

    private Drawable setting_category1_nameImage_focus;

    private Drawable setting_category1_number_focus;

    private String setting_category1_name;

    private boolean mSelectable = true;

    public Setting_Category1_Model(Drawable icon_unfocus, Drawable nameImage_unfocus, Drawable number_unfocus, Drawable icon_focus, Drawable nameImage_focus, Drawable number_focus, String data) {


        this.setting_category1_icon_unfocus = icon_unfocus;
        this.setting_category1_nameImage_unfocus = nameImage_unfocus;
        this.setting_category1_number_unfocus = number_unfocus;

        this.setting_category1_icon_focus = icon_focus;
        this.setting_category1_nameImage_focus = nameImage_focus;
        this.setting_category1_number_focus = number_focus;
        this.setting_category1_name = data;
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
     * Get icon
     *
     * @return
     */
    public Drawable getSetting_category1_icon_unfocus() {
        return this.setting_category1_icon_unfocus;
    }

    public Drawable getSetting_category1_nameImage_unfocus() {
        return this.setting_category1_nameImage_unfocus;
    }

    public Drawable getSetting_category1_number_unfocus(){
        return this.setting_category1_number_unfocus;
    }

    public Drawable getSetting_category1_icon_focus(){
        return this.setting_category1_icon_focus;
    }

    public Drawable getSetting_category1_nameImage_focus(){
        return this.setting_category1_nameImage_focus;
    }
    public Drawable getSetting_category1_number_focus(){
        return this.setting_category1_number_focus;
    }

    public String getSetting_category1_name() {
        return this.setting_category1_name;
    }

}
