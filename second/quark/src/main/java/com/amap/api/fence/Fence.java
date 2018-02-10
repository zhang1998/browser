package com.amap.api.fence;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.loc.dm;

/* compiled from: ProGuard */
public class Fence implements Parcelable {
    public static final Creator<Fence> CREATOR = new Creator<Fence>() {
        public final Fence a(Parcel parcel) {
            return new Fence(parcel);
        }

        public final Fence[] a(int i) {
            return new Fence[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }
    };
    public PendingIntent a;
    public String b;
    public double c;
    public double d;
    public float e;
    public int f;
    public long g;
    private long h;
    private long i;
    private int j;

    public Fence() {
        this.a = null;
        this.b = null;
        this.c = 0.0d;
        this.d = 0.0d;
        this.e = 0.0f;
        this.h = -1;
        this.i = -1;
        this.j = 3;
        this.f = -1;
        this.g = -1;
    }

    private Fence(Parcel parcel) {
        this.a = null;
        this.b = null;
        this.c = 0.0d;
        this.d = 0.0d;
        this.e = 0.0f;
        this.h = -1;
        this.i = -1;
        this.j = 3;
        this.f = -1;
        this.g = -1;
        if (parcel != null) {
            this.b = parcel.readString();
            this.c = parcel.readDouble();
            this.d = parcel.readDouble();
            this.e = parcel.readFloat();
            this.h = parcel.readLong();
            this.i = parcel.readLong();
            this.j = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readLong();
        }
    }

    public int a() {
        return this.j;
    }

    public void a(long j) {
        if (j < 0) {
            this.h = -1;
        } else {
            this.h = dm.b() + j;
        }
    }

    public long b() {
        return this.h;
    }

    public long c() {
        return this.i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeFloat(this.e);
        parcel.writeLong(this.h);
        parcel.writeLong(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.f);
        parcel.writeLong(this.g);
    }
}
