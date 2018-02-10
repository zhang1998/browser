package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class a implements Creator<MeasureValue> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MeasureValue[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return MeasureValue.a(parcel);
    }
}
