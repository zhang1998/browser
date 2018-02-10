package com.uc.quark.p2p.service.message;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
final class a implements Creator<MessageSnapshot> {
    a() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = true;
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        byte readByte = parcel.readByte();
        MessageSnapshot messageSnapshot = new MessageSnapshot(parcel);
        messageSnapshot.b = z;
        messageSnapshot.a = readByte;
        return messageSnapshot;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MessageSnapshot[i];
    }
}
