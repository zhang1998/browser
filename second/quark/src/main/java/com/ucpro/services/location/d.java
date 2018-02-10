package com.ucpro.services.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class d implements Creator<UcLocation> {
    d() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new UcLocation[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z;
        UcLocation ucLocation = new UcLocation();
        Location location = (Location) Location.CREATOR.createFromParcel(parcel);
        ucLocation.setProvider(location.getProvider());
        ucLocation.setTime(location.getTime());
        ucLocation.setLatitude(location.getLatitude());
        ucLocation.setLongitude(location.getLongitude());
        ucLocation.setSpeed(location.getSpeed());
        ucLocation.setBearing(location.getBearing());
        ucLocation.setAccuracy(location.getAccuracy());
        ucLocation.setExtras(location.getExtras());
        ucLocation.a = parcel.readString();
        ucLocation.b = parcel.readString();
        ucLocation.c = parcel.readString();
        ucLocation.d = parcel.readString();
        ucLocation.e = parcel.readString();
        ucLocation.f = parcel.readInt();
        ucLocation.g = parcel.readString();
        ucLocation.h = parcel.readString();
        ucLocation.j = parcel.readString();
        ucLocation.i = parcel.readString();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        ucLocation.k = z;
        return ucLocation;
    }
}
