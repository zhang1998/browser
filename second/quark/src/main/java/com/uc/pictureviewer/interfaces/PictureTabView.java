package com.uc.pictureviewer.interfaces;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public abstract class PictureTabView extends FrameLayout {
    public OnScaleChangedListener mOnScaleChangedListener;
    public OnTabClickListener mOnTabClickListener;

    @Api
    /* compiled from: ProGuard */
    public interface OnScaleChangedListener {
        void onScaleChanged(float f, float f2, float f3, float f4, float f5);
    }

    @Api
    /* compiled from: ProGuard */
    public interface OnTabClickListener {
        void onClick(PictureTabView pictureTabView, PictureInfo pictureInfo);
    }

    public abstract void releaseResources();

    public abstract void setPictureInfo(PictureInfo pictureInfo);

    public PictureTabView(Context context) {
        super(context);
    }

    public void onPause(boolean z, boolean z2) {
    }

    public void onResume() {
    }

    public void enableSensor(boolean z) {
    }

    public void enableAutoPlay(boolean z) {
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }

    public void setOnScaleChangedListener(OnScaleChangedListener onScaleChangedListener) {
        this.mOnScaleChangedListener = onScaleChangedListener;
    }

    public boolean isReachLeftEdge() {
        return true;
    }

    public boolean isReachTopEdge() {
        return true;
    }

    public boolean determineTouchEventPriority(MotionEvent motionEvent) {
        return true;
    }
}
