package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class d implements Creator<MeasureValueSet> {
    d() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MeasureValueSet[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return MeasureValueSet.a(parcel);
    }
}
