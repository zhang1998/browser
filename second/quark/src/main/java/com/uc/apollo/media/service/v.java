package com.uc.apollo.media.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class v implements Creator<u> {
    v() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new u[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new u(u.a(parcel));
    }
}
