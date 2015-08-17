package com.example.jay.percit.Animation;

import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;

/**
 * Created by Jay on 2015-08-15.
 */
public class ScaleAnim extends ScaleAnimation {


    private long mElapsedAtPause=0;
    private boolean mPaused=false;

    public ScaleAnim(float fromX, float toX, float fromY, float toY) {
        super(fromX, toX, fromY, toY);
    }

    public ScaleAnim(float fromX, float toX, float fromY, float toY, float pivotX, float pivotY) {
        super(fromX, toX, fromY, toY, pivotX, pivotY);
    }

    public ScaleAnim(float fromX, float toX, float fromY, float toY, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {
        super(fromX, toX, fromY, toY, pivotXType, pivotXValue, pivotYType, pivotYValue);
    }


    @Override
    public boolean getTransformation(long currentTime, Transformation outTransformation) {
        if(mPaused && mElapsedAtPause==0) {
            mElapsedAtPause=currentTime-getStartTime();
        }
        if(mPaused)
            setStartTime(currentTime-mElapsedAtPause);
        return super.getTransformation(currentTime, outTransformation);
    }

    public void pause() {
        mElapsedAtPause=0;
        mPaused=true;
    }

    public void resume() {
        mPaused=false;
    }
}
