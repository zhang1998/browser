package com.yunos.faceunlock;

import android.content.Context;
import android.preference.PreferenceManager;
import com.UCMobile.Apollo.Global;
import com.uc.annotation.Invoker;
import com.yunos.a.a.a;

/* compiled from: ProGuard */
public final class FaceLockUtil {
    @Invoker
    public static native FaceDetectResult detectFace();

    @Invoker
    private static native void finalizeJni(boolean z);

    @Invoker
    public static native float getCompareThreshold();

    @Invoker
    private static native FaceFeature getOnlineFeatureJni(byte[] bArr, boolean z);

    @Invoker
    private static native boolean initializeJni(Context context, int i, int i2, String str, String str2, boolean z);

    @Invoker
    public static native void reset();

    @Invoker
    public static native void setFace(byte[] bArr);

    @Invoker
    public static native void setFaceImage(byte[] bArr);

    @Invoker
    private static native FaceFeature setupEnrollJni(byte[] bArr);

    @Invoker
    private static native void setupSetParamsJni(FaceSetupParams faceSetupParams);

    @Invoker
    private static native FaceCompareResult unlockCompareFaceJni();

    @Invoker
    private static native void unlockSetFaceModelJni(String[] strArr, String[] strArr2, int i);

    static {
        System.loadLibrary("yunosfacelock_jni");
    }

    public static void loadLibrary() {
    }

    public static boolean isFacelockEnabled(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(context.getString(a.settings_key_facelock_switch), true);
    }

    public static void finalizeFaceLock() {
        finalizeJni(true);
    }

    public static FaceFeature getOnlineFeature(byte[] bArr, boolean z) {
        return getOnlineFeatureJni(bArr, z);
    }

    public static int getUnlockMethod(Context context) {
        return Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString(context.getString(a.settings_key_facelock_unlock_method), Global.APOLLO_SERIES));
    }

    public static boolean initialize(Context context, int i, int i2, String str, String str2) {
        initializeJni(context, i, i2, str, str2, true);
        return true;
    }

    public static FaceFeature setupEnroll(byte[] bArr) {
        return setupEnrollJni(bArr);
    }

    public static void setupSetParams(FaceSetupParams faceSetupParams) {
        setupSetParamsJni(faceSetupParams);
    }

    public static FaceCompareResult unlockCompareFace() {
        return unlockCompareFaceJni();
    }

    public static void unlockSetFaceModel(String[] strArr, String[] strArr2, int i) {
        unlockSetFaceModelJni(strArr, strArr2, i);
    }
}
