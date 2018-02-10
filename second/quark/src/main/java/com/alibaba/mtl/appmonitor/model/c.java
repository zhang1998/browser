package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class c implements Creator<Measure> {
    c() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Measure[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return Measure.a(parcel);
    }
}
