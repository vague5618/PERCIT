package com.example.jay.percit.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.jay.percit.R;

public class CrewSubActivity extends ActionBarActivity implements View.OnClickListener {

    ImageView crew_sub_back;


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crewsub);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        crew_sub_back = (ImageView) findViewById(R.id.crew_sub_basic_back);

        crew_sub_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.crew_sub_basic_back:

                Intent intent = new Intent(this, CrewActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_hold, R.anim.slide_out_left);
                finish();

                break;
        }
    }
}
