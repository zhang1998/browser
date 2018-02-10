package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class b implements Creator<MeasureSet> {
    b() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MeasureSet[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return MeasureSet.a(parcel);
    }
}
