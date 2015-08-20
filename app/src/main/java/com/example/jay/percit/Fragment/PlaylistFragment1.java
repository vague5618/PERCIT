package com.example.jay.percit.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jay.percit.Controller.PlaylistActivity;
import com.example.jay.percit.Controller.PlaylistBasic;
import com.example.jay.percit.Controller.PlaylistMusic;
import com.example.jay.percit.Model.MusicStage_IdDAO;
import com.example.jay.percit.Model.Playlist_IdDAO;
import com.example.jay.percit.Model.Playlist_ImageDAO;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-06.
 */
public class PlaylistFragment1 extends Fragment implements View.OnClickListener {

    Playlist_ImageDAO playlist_imageDAO;
    Playlist_IdDAO playlist_idDAO;
    Cursor playlist_imageCursor;
    Cursor playlist_IdCursor;
    int target_index;

    Resources res;

    public static PlaylistFragment1 newInstance() {

        PlaylistFragment1 fragment = new PlaylistFragment1();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_playlist1, container, false);

        res = container.getResources();

        try {
            playlist_imageDAO = playlist_imageDAO.open(PlaylistActivity.mContext);
            playlist_idDAO = playlist_idDAO.open(PlaylistActivity.mContext);
        } catch (Exception e) {
            Log.i("DB Query", "Error");
            e.printStackTrace();
        }

        playlist_IdCursor = playlist_idDAO.getPlaylist_id();

        playlist_IdCursor.move(0);

        for (int i = 0; i < 4; i++) {

            while (playlist_IdCursor.moveToNext() && i < 4) {

                PlaylistActivity.playlist_imageList[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(1)));
                PlaylistActivity.playlist_informationList[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(2)));
                Log.i(" Cursor check ", playlist_IdCursor.getString(2));
                PlaylistActivity.playlist_progress1List[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(3)));
                PlaylistActivity.playlist_progress2List[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(4)));
                PlaylistActivity.playlist_progress3List[i] = (ImageView) v.findViewById(Integer.parseInt(playlist_IdCursor.getString(5)));
                i++;
            }
        }

        playlist_imageCursor = playlist_imageDAO.getPlaylist_image("POP", null);

      //  playlist_imageCursor.moveToFirst();

        //  Log.i("Cursor count", String.valueOf(playlist_imageCursor.getCount()));

        for (int i = 0; i < 4; i++) {

            while (playlist_imageCursor.moveToNext() && i < 4) {

                PlaylistActivity.playlist_imageList[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(1))));

                PlaylistActivity.playlist_informationList[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(2))));

                PlaylistActivity.playlist_progress1List[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(3))));

                PlaylistActivity.playlist_progress2List[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(4))));

                PlaylistActivity.playlist_progress3List[i].setBackground(res.getDrawable(Integer.parseInt(playlist_imageCursor.getString(5))));

                PlaylistActivity.playlist_MusicnameList[i] = playlist_imageCursor.getString(8);

                PlaylistActivity.playlist_progress1List[i].setVisibility(View.INVISIBLE);

                PlaylistActivity.playlist_progress2List[i].setVisibility(View.INVISIBLE);

                PlaylistActivity.playlist_progress3List[i].setVisibility(View.INVISIBLE);

                PlaylistActivity.playlist_informationList[i].setOnClickListener(this);

                i++;
            }
        }

        return v;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.playlist_information1:

                Intent intent = new Intent(PlaylistActivity.mContext, PlaylistBasic.class);

                getActivity().startActivity(intent);

                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_hold);

                getActivity().finish();

                break;

            case R.id.playlist_information2:
            case R.id.playlist_information3:
            case R.id.playlist_information4:
            case R.id.playlist_information5:
            case R.id.playlist_information6:
            case R.id.playlist_information7:
            case R.id.playlist_information8:

                for (int i = 0; i < 8; i++) {
                    if (v.getId() == PlaylistActivity.playlist_informationList[i].getId()) {
                        target_index = i;
                        Log.i("Click on ",PlaylistActivity.playlist_MusicnameList[i]);
                    }
                }

                Intent intent2 = new Intent(PlaylistActivity.mContext, PlaylistMusic.class);

                intent2.putExtra("Musicname", PlaylistActivity.playlist_MusicnameList[target_index]);

                getActivity().startActivity(intent2);

                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_hold);

                getActivity().finish();

                break;
        }


    }
}
