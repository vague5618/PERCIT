package com.example.jay.percit.Listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 어댑터 클래스 정의
 *
 * @author Mike
 */


public class Setting_Category2_ListAdapter extends BaseAdapter {

    private int selected = 0;
    private Context mContext;
    private List<Setting_Category2_Model> mItems = new ArrayList<Setting_Category2_Model>();

    public Setting_Category2_ListAdapter(Context context) {
        mContext = context;
    }

    public void addItem(Setting_Category2_Model it) {
        mItems.add(it);
    }

    public void setListItems(List<Setting_Category2_Model> lit) {
        mItems = lit;
    }

    public void clear() {
        mItems.clear();
    }

    public int getCount() {
        return mItems.size();
    }

    public Object getItem(int position) {
        return mItems.get(position);
    }

    public boolean areAllItemsSelectable() {
        return false;
    }

    public boolean isSelectable(int position) {
        try {
            return mItems.get(position).isSelectable();
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public void select(int data) {
        selected = data;
    }

    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        Setting_Category2_View itemView;

        if (convertView == null) {

            itemView = new Setting_Category2_View(mContext, mItems.get(position), position);
        } else {

            if (position == selected) {
                itemView = (Setting_Category2_View) convertView;
                itemView.Setting_focus(mItems.get(position));
            } else {
                itemView = (Setting_Category2_View) convertView;
                itemView.Setting_unfocus(mItems.get(position));
            }
        }
        return itemView;
    }

}
