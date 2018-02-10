package com.yunos.faceunlock;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class a implements Creator<FaceSetupParams> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FaceSetupParams[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FaceSetupParams(parcel);
    }
}
