package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class a implements Creator<Transaction> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Transaction[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return Transaction.a(parcel);
    }
}
