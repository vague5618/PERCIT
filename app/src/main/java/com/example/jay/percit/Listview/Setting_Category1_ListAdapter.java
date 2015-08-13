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


public class Setting_Category1_ListAdapter extends BaseAdapter {

    private int selected = 0;
    private Context mContext;
    private List<Setting_Category1_Model> mItems = new ArrayList<Setting_Category1_Model>();

    public Setting_Category1_ListAdapter(Context context) {
        mContext = context;
    }

    public void addItem(Setting_Category1_Model it) {
        mItems.add(it);
    }

    public void setListItems(List<Setting_Category1_Model> lit) {
        mItems = lit;
    }

    public void clear() {
        mItems.clear();
    }

    public int getCount() {
        return mItems.size();
    }

    public Setting_Category1_Model getItem(int position) {
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

    public long getItemId(int position) {
        return position;
    }

    public void select(int temp) {
        selected = temp;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Setting_Category1_View itemView;

        if (convertView == null) {
            itemView = new Setting_Category1_View(mContext, mItems.get(position),position);

        } else {
            itemView = (Setting_Category1_View) convertView;

            if (position == selected) {
                itemView.Setting_focus(mItems.get(position));
            } else {
                itemView.Setting_unfocus(mItems.get(position));
            }
        }

        return itemView;
    }

}
