package com.example.jay.percit.Animation;

import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

/**
 * Created by Jay on 2015-08-15.
 */
public class TranslateAnim extends TranslateAnimation {


    private long mElapsedAtPause = 0;
    private boolean mPaused = false;

    public TranslateAnim(float fromXDelta, float toXDelta, float fromYDelta,
                         float toYDelta) {
        super(fromXDelta, toXDelta, fromYDelta, toYDelta);
    }

    public TranslateAnim(int fromXType, float fromXValue, int toXType, float toXValue, int fromYType, float fromYValue, int toYType, float toYValue) {
        super(fromXType, fromXValue, toXType, toXValue, fromYType, fromYValue, toYType, toYValue);
    }


    @Override
    public boolean getTransformation(long currentTime, Transformation outTransformation) {
        if (mPaused && mElapsedAtPause == 0) {
            mElapsedAtPause = currentTime - getStartTime();
        }
        if (mPaused)
            setStartTime(currentTime - mElapsedAtPause);
        return super.getTransformation(currentTime, outTransformation);
    }

    public void pause() {
        mElapsedAtPause = 0;
        mPaused = true;
    }

    public void resume() {
        mPaused = false;
    }
}