package com.uc.apollo.media.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.Surface;

/* compiled from: ProGuard */
final class z implements Creator<y> {
    z() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new y[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        if (parcel.readInt() == 1) {
            return new y((Surface) Surface.CREATOR.createFromParcel(parcel));
        }
        return new y(null);
    }
}
