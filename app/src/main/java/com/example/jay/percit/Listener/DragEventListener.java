package com.example.jay.percit.Listener;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jay.percit.Controller.SettingActivity;
import com.example.jay.percit.Handler.SettingHandler;
import com.example.jay.percit.R;

import java.util.StringTokenizer;

public class DragEventListener implements View.OnDragListener {

    Context mContext;
    Animation mAnimation_blink;
    SettingHandler settingHandler;

    public DragEventListener(Context mContext, SettingHandler settingHandler) {
        this.settingHandler = settingHandler;
        this.mContext = mContext;

        mAnimation_blink = AnimationUtils.loadAnimation(mContext, R.anim.image_blink);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {

        final int action = event.getAction();

        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

             //       Toast.makeText(mContext, "ACTION_DRAG_STARTED", Toast.LENGTH_SHORT).show();

                    v.invalidate();
                    return true;

                } else {
                    return false;
                }

                //영역에 들어왔을때

            case DragEvent.ACTION_DRAG_ENTERED:

                ((ImageView) v).startAnimation(mAnimation_blink);

                v.invalidate();

                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                return true;

            case DragEvent.ACTION_DRAG_EXITED:

                ((ImageView) v).clearAnimation();

          //      Toast.makeText(mContext, "ACTION_DRAG_EXIT", Toast.LENGTH_SHORT).show();
                v.invalidate();
                return true;


            case DragEvent.ACTION_DROP:

                ((ImageView) v).clearAnimation();

                ClipData.Item item = event.getClipData().getItemAt(0);

                CharSequence drogData = item.getText();

                String temp_data = drogData.toString();

                StringTokenizer token = new StringTokenizer(temp_data);

                int temp_musicnumber = Integer.parseInt(token.nextToken());

                String temp_musicname = "";

                while(token.hasMoreTokens())
                {
                    temp_musicname+=" "+token.nextToken();
                }

                Message msg = settingHandler.obtainMessage();
                msg.what = ((ImageView)v).getId();
                msg.arg1 = temp_musicnumber;
                msg.obj = (String) temp_musicname;

                settingHandler.sendMessage(msg);

                v.invalidate();
                return true;
            //드랍 끝나고나서

            case DragEvent.ACTION_DRAG_ENDED:
                ((ImageView) v).clearColorFilter();
                v.invalidate();
                if (event.getResult()) {
                  //  Toast.makeText(mContext, "drop was handled", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(mContext, "The drop didn't work", Toast.LENGTH_SHORT).show();
                }
                return true;

            default:
        }


        return false;
    }
}