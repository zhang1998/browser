package com.uc.apollo.media.service;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Map;

/* compiled from: ProGuard */
final class w implements Parcelable {
    public static final Creator<w> a = new x();
    private Object b;

    w(Object obj) {
        this.b = obj;
    }

    w() {
    }

    final Object a() {
        return this.b;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (this.b instanceof Map) {
            parcel.writeString("Map");
            parcel.writeMap((Map) this.b);
        } else if (this.b instanceof Bitmap) {
            parcel.writeString("Bitmap");
            ((Bitmap) this.b).writeToParcel(parcel, i);
        } else if (this.b instanceof String) {
            parcel.writeString("String");
            parcel.writeString((String) this.b);
        } else {
            parcel.writeString("null");
        }
    }
}
