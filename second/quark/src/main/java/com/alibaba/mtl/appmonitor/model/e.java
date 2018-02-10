package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class e implements Creator<Dimension> {
    e() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Dimension[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return Dimension.a(parcel);
    }
}
