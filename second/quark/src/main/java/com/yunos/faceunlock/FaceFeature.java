package com.yunos.faceunlock;

/* compiled from: ProGuard */
public class FaceFeature {
    private int errorFlag;
    private float[] feature;
    private float[] landmark;
    private float[] localLandmark;
    private float quality;

    public FaceFeature(float[] fArr, float[] fArr2, float[] fArr3, float f, int i) {
        this.landmark = fArr2;
        this.localLandmark = fArr;
        this.feature = fArr3;
        this.quality = f;
        this.errorFlag = i;
    }

    public float[] getLandmark() {
        return this.landmark;
    }

    public void setLandmark(float[] fArr) {
        this.landmark = fArr;
    }

    public float[] getFeature() {
        return this.feature;
    }

    public void setFeature(float[] fArr) {
        this.feature = fArr;
    }

    public int getErrorFlag() {
        return this.errorFlag;
    }

    public void setErrorFlag(int i) {
        this.errorFlag = i;
    }

    public boolean isValid() {
        return this.errorFlag == 1;
    }

    public float getQuality() {
        return this.quality;
    }

    public void setQuality(float f) {
        this.quality = f;
    }

    public float[] getLocalLandmark() {
        return this.localLandmark;
    }

    public void setLocalLandmark(float[] fArr) {
        this.localLandmark = fArr;
    }
}
