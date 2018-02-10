package com.uc.quark.p2p.service.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public class MessageSnapshot implements Parcelable {
    public static final Creator<MessageSnapshot> CREATOR = new a();
    protected byte a;
    protected boolean b;
    protected boolean c;
    protected long d;
    private final int e;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeByte((byte) (this.b ? 1 : 0));
        parcel.writeByte(this.a);
        if (!this.c) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.e);
        parcel.writeLong(this.d);
    }

    MessageSnapshot(Parcel parcel) {
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.c = z;
        this.e = parcel.readInt();
        this.d = parcel.readLong();
    }
}
