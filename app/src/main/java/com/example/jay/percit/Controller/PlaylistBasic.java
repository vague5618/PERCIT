package com.example.jay.percit.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jay.percit.Model.Playlist_bgm;
import com.example.jay.percit.Model.Playlist_bgmDAO;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.SoundpoolThread;

public class PlaylistBasic extends ActionBarActivity implements View.OnClickListener {

    ImageView playlist_basic_back;


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_basic);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        playlist_basic_back = (ImageView) findViewById(R.id.playlist_basic_back);

        playlist_basic_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playlist_basic_back:

                Intent intent = new Intent(this, PlaylistActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_hold, R.anim.slide_out_left);
                finish();

                break;
        }
    }
}
