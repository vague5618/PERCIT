package com.example.jay.percit.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jay.percit.Controller.CrewActivity;
import com.example.jay.percit.Controller.CrewSubActivity;
import com.example.jay.percit.Controller.PlaylistActivity;
import com.example.jay.percit.Controller.PlaylistBasic;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-06.
 */
public class CrewFragment1 extends Fragment implements View.OnClickListener {

    ImageView crew_information;

    public static CrewFragment1 newInstance() {

        CrewFragment1 fragment = new CrewFragment1();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crew1, container, false);
        crew_information = (ImageView) v.findViewById(R.id.crew_information1);

        crew_information.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.crew_information1:

                Intent intent = new Intent(CrewActivity.mContext, CrewSubActivity.class);

                getActivity().startActivity(intent);

                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_hold);

                getActivity().finish();
                break;
        }
    }
}

