package com.example.jay.percit.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.jay.percit.Controller.MusicStageActivity;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-06.
 */
public class MusicStageFragment2 extends Fragment  {
    private static final int NOMAL_MODE = 5;
    private static final int RECORD_MODE = 6;
    private static final int PLAY_MODE = 7;

    public static UiHandler guiHandler;
    private Button mButton_record_mic;
    private Button mButton_play;
    private ImageView feedback_mainboard_focus;
    private ImageView feedback_kick1_focus;
    private ImageView feedback_kick2_focus;
    private ImageView feedback_sub1_focus;
    private ProgressBar mProgressbar;
    private Animation mGrowAnim;
    private Animation mFeedbackAnim;


    private static final String ARG_SECTION_NUMBER = "section_number";

    public static MusicStageFragment2 newInstance() {

        MusicStageFragment2 fragment = new MusicStageFragment2();
//        Bundle args = new Bundle();
        //      args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        //     fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_musicstage2, container, false);

        guiHandler = new UiHandler();

        mButton_record_mic = (Button) v.findViewById(R.id.record_mic);

        mButton_play = (Button) v.findViewById(R.id.mButton_play);

        feedback_mainboard_focus = (ImageView) v.findViewById(R.id.feedback_mainboard_focus);

        feedback_kick1_focus = (ImageView) v.findViewById(R.id.feedback_kick1_focus);

        feedback_kick2_focus = (ImageView) v.findViewById(R.id.feedback_kick2_focus);

        feedback_sub1_focus = (ImageView) v.findViewById(R.id.feedback_sub1_focus);

        mProgressbar = (ProgressBar) v.findViewById(R.id.mProgressBar);

        mGrowAnim = AnimationUtils.loadAnimation(MusicStageActivity.mContext, R.anim.grow);

        mFeedbackAnim =AnimationUtils.loadAnimation(MusicStageActivity.mContext, R.anim.scale);

       mButton_record_mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               MusicStageActivity.state = RECORD_MODE;

                for(int i=0; i< MusicStageActivity.record_arr.length; i++)
                    MusicStageActivity.record_arr[i] = 0;

                for(int i=0; i< MusicStageActivity.record_power.length; i++)
                    MusicStageActivity.record_power[i] = 0;

               MusicStageActivity.gRecordThread.record_start();
                mProgressbar.startAnimation(mGrowAnim);
                            }
        });

        mButton_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicStageActivity.state = PLAY_MODE;
                MusicStageActivity.gRecordThread.Play_Recorded(MusicStageActivity.record_arr, MusicStageActivity.record_power);
                mProgressbar.startAnimation(mGrowAnim);
            }
        });

        return v;
    }


    public class UiHandler extends Handler {

        private static final int REQUEST_A = 'a';
        private static final int REQUEST_B = 'b';
        private static final int REQUEST_C = 'c';
        private static final int REQUEST_D = 'd';
        private static final int NOMAL_MODE = 5;
        private static final int RECORD_MODE = 6;
        private static final int PLAY_MODE = 7;

        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {

                case REQUEST_A:

                    feedback_mainboard_focus.startAnimation(mFeedbackAnim);

                    break;

                case REQUEST_B:

                    feedback_kick1_focus.startAnimation(mFeedbackAnim);

                    break;


                case REQUEST_C:

                    feedback_kick2_focus.startAnimation(mFeedbackAnim);

                    break;


                case REQUEST_D:

                    feedback_sub1_focus.startAnimation(mFeedbackAnim);

                    break;

                case NOMAL_MODE:

                    mButton_record_mic.setClickable(true);
                    mButton_play.setClickable(true);
                    mButton_play.setText("Nomal");
                    break;

                case RECORD_MODE:

                    mButton_play.setClickable(true);
                                        mButton_play.setText("Recording");
                    break;

                case PLAY_MODE:

                    mButton_play.setClickable(false);
                    mButton_record_mic.setClickable(false);
                    mButton_play.setText("Playing");
                    break;

                default:

                    break;
            }

        }
    }


}
