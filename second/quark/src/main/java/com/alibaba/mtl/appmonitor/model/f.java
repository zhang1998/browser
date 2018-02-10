package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class f implements Creator<DimensionValueSet> {
    f() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new DimensionValueSet[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return DimensionValueSet.a(parcel);
    }
}
