package com.example.jay.percit.Handler;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;

import com.example.jay.percit.Controller.MusicStageSubActivity;
import com.example.jay.percit.R;
import com.example.jay.percit.Thread.MusicplayerThread;
import com.example.jay.percit.Thread.RecordThread;
import com.example.jay.percit.Util.BluetoothThread;

/**
 * Created by Jay on 2015-08-17.
 */
public class FeedbackHandler extends Handler {

    final static int FEEDBACK_START = 1;
    final static int FEEDBACK_PAUSE = 2;
    final static int FEEDBACK_RESUME = 3;
    final static int REQUEST_A = 65;
    final static int REQUEST_B = 66;
    final static int REQUEST_C = 67;
    final static int REQUEST_D = 68;
    final static int REQUEST_E = 69;
    final static int REQUEST_F = 70;
    final static int REQUEST_G = 71;
    final static int REQUEST_H = 72;
    final static int REQUEST_I = 73;
    int time = 0;

    int record_arr[];

    BluetoothThread mbluetoothThread;
    MusicplayerThread musicplayerThread;
    RecordThread recordThread;

    public FeedbackHandler(BluetoothThread mbluetoothThread, MusicplayerThread musicplayerThread, RecordThread recordThread) {
        this.mbluetoothThread = mbluetoothThread;
        this.musicplayerThread = musicplayerThread;
        this.recordThread = recordThread;

        record_arr = new int[2000];
        datasetup();
    }

    void datasetup() {
        record_arr[100] = REQUEST_E;
        record_arr[540] = REQUEST_E;
        record_arr[983] = REQUEST_E;

        record_arr[121] = REQUEST_B;
        record_arr[131] = REQUEST_B;
        record_arr[341] = REQUEST_B;
        record_arr[452] = REQUEST_B;
        record_arr[562] = REQUEST_B;
        record_arr[672] = REQUEST_B;
        record_arr[783] = REQUEST_B;
        record_arr[893] = REQUEST_B;
        record_arr[1003] = REQUEST_B;
        record_arr[1114] = REQUEST_B;
        record_arr[1224] = REQUEST_B;
        record_arr[1334] = REQUEST_B;

        record_arr[161] = REQUEST_G;
        record_arr[272] = REQUEST_G;
        record_arr[383] = REQUEST_G;
        record_arr[493] = REQUEST_G;
        record_arr[603] = REQUEST_G;
        record_arr[714] = REQUEST_G;
        record_arr[824] = REQUEST_G;
        record_arr[934] = REQUEST_G;
        record_arr[1045] = REQUEST_G;
        record_arr[1155] = REQUEST_G;
        record_arr[1265] = REQUEST_G;
        record_arr[1376] = REQUEST_G;

        record_arr[203] = REQUEST_A;
        record_arr[314] = REQUEST_A;
        record_arr[424] = REQUEST_A;
        record_arr[534] = REQUEST_A;
        record_arr[645] = REQUEST_A;
        record_arr[755] = REQUEST_A;
        record_arr[865] = REQUEST_A;
        record_arr[976] = REQUEST_A;
        record_arr[1086] = REQUEST_A;
        record_arr[1196] = REQUEST_A;
        record_arr[1307] = REQUEST_A;
        record_arr[1417] = REQUEST_A;


        record_arr[141]=REQUEST_I;

        record_arr[183]=REQUEST_I;

        record_arr[252]=REQUEST_I;

        record_arr[293]=REQUEST_I;

        record_arr[307]=REQUEST_I;

        record_arr[362]=REQUEST_I;

        record_arr[403]=REQUEST_I;

        record_arr[472]=REQUEST_I;

        record_arr[514]=REQUEST_I;

        record_arr[528]=REQUEST_I;

        record_arr[583]=REQUEST_I;

        record_arr[624]=REQUEST_I;

        record_arr[693]=REQUEST_I;


        record_arr[734]=REQUEST_I;

        record_arr[748]=REQUEST_I;

        record_arr[803]=REQUEST_I;

        record_arr[845]=REQUEST_I;

        record_arr[859]=REQUEST_I;

        record_arr[913]=REQUEST_I;

        record_arr[941]=REQUEST_I;

        record_arr[948]=REQUEST_I;

        record_arr[954]=REQUEST_I;

        record_arr[962]=REQUEST_I;

        record_arr[969]=REQUEST_I;

        record_arr[1024]=REQUEST_I;

        record_arr[1065]=REQUEST_I;

        record_arr[1134]=REQUEST_I;

        record_arr[1176]=REQUEST_I;

        record_arr[1190]=REQUEST_I;

        record_arr[1245]=REQUEST_I;

        record_arr[1286]=REQUEST_I;

        record_arr[1355]=REQUEST_I;

        record_arr[1396]=REQUEST_I;

        record_arr[1410]=REQUEST_I;
    }


    public void handleMessage(Message msg) {
        super.handleMessage(msg);


        switch (msg.what) {
            case FEEDBACK_START:
                try {
                    System.out.println("FEEDBACK_START");
                    musicplayerThread.select_playBGM(R.raw.zz_bg_a_marryyou_brunomars);
                    recordThread.Play_feedback(record_arr, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case FEEDBACK_PAUSE:

                musicplayerThread.stopBGM();
                time = recordThread.Get_currenttime();
                break;

            case FEEDBACK_RESUME:

                musicplayerThread.resumeBGM();
                recordThread.Play_feedback(record_arr, time);
                time = 0;
                break;

            case REQUEST_A:

                byte[] temp_a = {126,'a'};

              //  mbluetoothThread.write(temp_a);


                MusicStageSubActivity.mFeedbackAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_mainboard.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_mainboard.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                MusicStageSubActivity.musicstage_sub_mainboard.startAnimation(MusicStageSubActivity.mMusicAnimation);


                break;

            case REQUEST_B:

                byte[] temp_b = {126,'b'};

              //  mbluetoothThread.write(temp_b);

                MusicStageSubActivity.mFeedbackAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_kick1.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_kick1.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                MusicStageSubActivity.musicstage_sub_kick1.startAnimation(MusicStageSubActivity.mMusicAnimation);

                break;

            case REQUEST_C:


                byte[] temp_c = {126,'c'};

            //    mbluetoothThread.write(temp_c);

                MusicStageSubActivity.mFeedbackAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_kick2.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_kick2.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                MusicStageSubActivity.musicstage_sub_kick2.startAnimation(MusicStageSubActivity.mMusicAnimation);

                break;

            case REQUEST_D:


                byte[] temp_d = {126,'d'};

             //   mbluetoothThread.write(temp_d);


                MusicStageSubActivity.mFeedbackAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub1.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub1.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                MusicStageSubActivity.musicstage_sub_sub1.startAnimation(MusicStageSubActivity.mMusicAnimation);

                break;

            case REQUEST_E:


                byte[] temp_e = {126,'e'};

//                mbluetoothThread.write(temp_e);

                MusicStageSubActivity.mFeedbackAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub2.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub2.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                MusicStageSubActivity.musicstage_sub_sub2.startAnimation(MusicStageSubActivity.mMusicAnimation);

                break;

            case REQUEST_F:


                byte[] temp_f = {126,'f'};

         //       mbluetoothThread.write(temp_f);

                MusicStageSubActivity.mFeedbackAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub3.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub3.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                MusicStageSubActivity.musicstage_sub_sub3.startAnimation(MusicStageSubActivity.mMusicAnimation);

                break;

            case REQUEST_G:



                byte[] temp_g = {126,'g'};

          //      mbluetoothThread.write(temp_g);

                MusicStageSubActivity.mFeedbackAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub4.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub4.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                MusicStageSubActivity.musicstage_sub_sub4.startAnimation(MusicStageSubActivity.mMusicAnimation);

                break;


            case REQUEST_H:

                byte[] temp_h = {126,'h'};

          //      mbluetoothThread.write(temp_h);


                MusicStageSubActivity.mFeedbackAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub5.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub5.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                MusicStageSubActivity.musicstage_sub_sub5.startAnimation(MusicStageSubActivity.mMusicAnimation);


                break;


            case REQUEST_I:

                byte[] temp_i = {126,'i'};

             //   mbluetoothThread.write(temp_i);

                MusicStageSubActivity.mFeedbackAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub6.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        MusicStageSubActivity.musicstage_sub_sub6.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                MusicStageSubActivity.musicstage_sub_sub6.startAnimation(MusicStageSubActivity.mMusicAnimation);


                break;

        }
    }
}
