package com.yunos.faceunlock;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class FaceSetupParams implements Parcelable {
    private static int CONTENT_DESCRIPTION = 2;
    public static final Creator<FaceSetupParams> CREATOR = new a();
    public float faceQualityThreshold;
    public float illuminationThreshold;
    public int imageCount;
    public float posXPercentage;
    public float posYPercentage;
    public float poseThreshold;
    public float sharpnessThreshold;

    public FaceSetupParams(Parcel parcel) {
        this.imageCount = parcel.readInt();
        this.faceQualityThreshold = parcel.readFloat();
        this.illuminationThreshold = parcel.readFloat();
        this.poseThreshold = parcel.readFloat();
        this.sharpnessThreshold = parcel.readFloat();
        this.posXPercentage = parcel.readFloat();
        this.posYPercentage = parcel.readFloat();
    }

    public int getImageCount() {
        return this.imageCount;
    }

    public void setImageCount(int i) {
        this.imageCount = i;
    }

    public float getFaceQualityThreshold() {
        return this.faceQualityThreshold;
    }

    public void setFaceQualityThreshold(float f) {
        this.faceQualityThreshold = f;
    }

    public float getIlluminationThreshold() {
        return this.illuminationThreshold;
    }

    public void setIlluminationThreshold(float f) {
        this.illuminationThreshold = f;
    }

    public float getPoseThreshold() {
        return this.poseThreshold;
    }

    public void setPoseThreshold(float f) {
        this.poseThreshold = f;
    }

    public float getSharpnessThreshold() {
        return this.sharpnessThreshold;
    }

    public void setSharpnessThreshold(float f) {
        this.sharpnessThreshold = f;
    }

    public float getPosXPercentage() {
        return this.posXPercentage;
    }

    public void setPosXPercentage(float f) {
        this.posXPercentage = f;
    }

    public float getPosYPercentage() {
        return this.posYPercentage;
    }

    public void setPosYPercentage(float f) {
        this.posYPercentage = f;
    }

    public int describeContents() {
        return CONTENT_DESCRIPTION;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.imageCount);
        parcel.writeFloat(this.faceQualityThreshold);
        parcel.writeFloat(this.illuminationThreshold);
        parcel.writeFloat(this.poseThreshold);
        parcel.writeFloat(this.sharpnessThreshold);
        parcel.writeFloat(this.posXPercentage);
        parcel.writeFloat(this.posYPercentage);
    }
}
