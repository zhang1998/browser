package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class h implements Creator<DimensionSet> {
    h() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DimensionSet[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return DimensionSet.a(parcel);
    }
}
