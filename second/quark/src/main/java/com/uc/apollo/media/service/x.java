package com.uc.apollo.media.service;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.HashMap;

/* compiled from: ProGuard */
final class x implements Creator<w> {
    x() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Object hashMap;
        String readString = parcel.readString();
        if (readString.equals("Map")) {
            hashMap = new HashMap();
            parcel.readMap(hashMap, null);
            if (hashMap.size() <= 0) {
                hashMap = null;
            }
        } else {
            hashMap = readString.equals("Bitmap") ? Bitmap.CREATOR.createFromParcel(parcel) : readString.equals("String") ? parcel.readString() : null;
        }
        return new w(hashMap);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new w[i];
    }
}
