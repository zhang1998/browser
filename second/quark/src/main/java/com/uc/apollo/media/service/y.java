package com.uc.apollo.media.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.Surface;

/* compiled from: ProGuard */
public final class y implements Parcelable {
    public static final Creator<y> a = new z();
    private final Surface b;

    public y(Surface surface) {
        this.b = surface;
    }

    public final Surface a() {
        return this.b;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (this.b != null) {
            parcel.writeInt(1);
            this.b.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
