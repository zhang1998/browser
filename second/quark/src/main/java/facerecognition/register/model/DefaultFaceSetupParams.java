package facerecognition.register.model;

import com.yunos.faceunlock.FaceSetupParams;

/* compiled from: ProGuard */
public class DefaultFaceSetupParams extends FaceSetupParams {
    public DefaultFaceSetupParams() {
        this.faceQualityThreshold = 0.5f;
        this.imageCount = 5;
        this.illuminationThreshold = 0.45f;
        this.poseThreshold = 0.2f;
        this.sharpnessThreshold = 0.2f;
        this.posXPercentage = 0.85f;
        this.posYPercentage = 0.85f;
    }
}
