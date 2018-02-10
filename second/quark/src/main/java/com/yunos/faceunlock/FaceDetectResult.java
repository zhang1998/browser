package com.yunos.faceunlock;

/* compiled from: ProGuard */
public class FaceDetectResult {
    private boolean mHasFace;
    private boolean mIsLive;

    public void setHasFace(boolean z) {
        this.mHasFace = z;
    }

    public boolean hasFace() {
        return this.mHasFace;
    }

    public void setIsLive(boolean z) {
        this.mIsLive = z;
    }

    public boolean isLive() {
        return this.mIsLive;
    }
}
