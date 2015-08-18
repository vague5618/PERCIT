package com.example.jay.percit.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jay.percit.Controller.PlaylistActivity;
import com.example.jay.percit.Controller.SettingActivity;
import com.example.jay.percit.Model.Playlist_IdDAO;
import com.example.jay.percit.Model.Playlist_ImageDAO;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-06.
 */
public class PlaylistFragment2 extends Fragment {

    private View mSetting_handle;

    Playlist_ImageDAO playlist_imageDAO;
    Playlist_IdDAO playlist_idDAO;
    Cursor playlist_imageCursor;
    Cursor playlist_IdCursor;
    Resources res;


    public static PlaylistFragment2 newInstance() {

        PlaylistFragment2 fragment = new PlaylistFragment2();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_playlist2, container, false);

        mSetting_handle = (ImageView) v.findViewById(R.id.playlist_setting_handler);

        res = container.getResources();

        try {
            playlist_imageDAO = playlist_imageDAO.open(PlaylistActivity.mContext);
            playlist_idDAO = playlist_idDAO.open(PlaylistActivity.mContext);
        } catch (Exception e) {
            Log.i("DB Query", "Error");
            e.printStackTrace();
        }

        playlist_IdCursor = playlist_idDAO.getPlaylist_id();

        playlist_IdCursor.moveToFirst();
        playlist_IdCursor.move(3);

        for (int i = 4; i < 8; i++) {

            while (playlist_IdCursor.moveToNext() && i < 8) {

                PlaylistActivity.playlist_imageList[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(1)));
                PlaylistActivity.playlist_informationList[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(2)));
                PlaylistActivity.playlist_progress1List[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(3)));
                PlaylistActivity.playlist_progress2List[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(4)));
                PlaylistActivity.playlist_progress3List[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(5)));
                i++;
            }
        }

        playlist_imageCursor = playlist_imageDAO.getPlaylist_image("POP", null);

        playlist_imageCursor.moveToFirst();

        if (playlist_imageCursor.getCount() > 4) {
            Log.i("Cursor count", String.valueOf(playlist_imageCursor.getCount()));

            playlist_imageCursor.moveToPosition(3);
        }


        for (int i = 4; i < 8; i++) {

            while (playlist_imageCursor.moveToNext() && i < 8) {

                PlaylistActivity.playlist_imageList[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(1))));

                PlaylistActivity.playlist_informationList[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(2))));

                PlaylistActivity.playlist_progress1List[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(3))));

                PlaylistActivity.playlist_progress2List[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(4))));

                PlaylistActivity.playlist_progress3List[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(5))));

                PlaylistActivity.playlist_progress1List[i].setVisibility(View.INVISIBLE);

                PlaylistActivity.playlist_progress2List[i].setVisibility(View.INVISIBLE);

                PlaylistActivity.playlist_progress3List[i].setVisibility(View.INVISIBLE);

                i++;
            }
        }


        mSetting_handle.setOnTouchListener(

                new View.OnTouchListener() {

                    private float PressedY;
                    private float PressedX;

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        float y_distance = 0;
                        float x_distance = 0;


                        if (v.getId() == R.id.playlist_setting_handler) {

                            PlaylistActivity.gViewPager.requestDisallowInterceptTouchEvent(true);

                            switch (event.getAction()) {


                                case MotionEvent.ACTION_DOWN:

                                    PressedY = event.getY();

                                    PressedX = event.getX();

                                    break;

                                case MotionEvent.ACTION_UP:

                                    y_distance = PressedY - event.getY();
                                    x_distance = PressedX - event.getX();

                                    break;

                            }

                            if (Math.abs(x_distance) > 1000) {

                                PlaylistActivity.gViewPager.requestDisallowInterceptTouchEvent(false);

                                return true;
                            }

                            if (x_distance > 0 && y_distance < 200) {

                                Intent intent = new Intent(PlaylistActivity.mContext, SettingActivity.class);
                                startActivity(intent);
                                getActivity().overridePendingTransition(R.anim.slide_in_left, R.anim.slide_hold);
                                getActivity().finish();

                                return true;

                            } else if (x_distance < 0) {

                                PlaylistActivity.gViewPager.requestDisallowInterceptTouchEvent(false);

                                return true;

                            }
                            return true;

                        }

                        return true;
                    }
                });
        return v;
    }


}
