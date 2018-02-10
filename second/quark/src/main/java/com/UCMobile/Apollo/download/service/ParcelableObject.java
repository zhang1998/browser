package com.UCMobile.Apollo.download.service;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class ParcelableObject implements Parcelable {
    public static final Creator<ParcelableObject> CREATOR = new Creator<ParcelableObject>() {
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
            return new ParcelableObject(hashMap);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelableObject[i];
        }
    };
    public Object a;

    public ParcelableObject(Object obj) {
        this.a = obj;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.a instanceof Map) {
            parcel.writeString("Map");
            parcel.writeMap((Map) this.a);
        } else if (this.a instanceof Bitmap) {
            parcel.writeString("Bitmap");
            ((Bitmap) this.a).writeToParcel(parcel, i);
        } else if (this.a instanceof String) {
            parcel.writeString("String");
            parcel.writeString((String) this.a);
        } else {
            parcel.writeString("null");
        }
    }
}
