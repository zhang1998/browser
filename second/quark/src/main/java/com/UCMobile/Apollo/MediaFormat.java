package com.UCMobile.Apollo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.UCMobile.Apollo.util.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
public final class MediaFormat implements Parcelable {
    public static final Creator<MediaFormat> CREATOR = new Creator<MediaFormat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaFormat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MediaFormat(parcel);
        }
    };
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final long e;
    public final List<byte[]> f = new ArrayList();
    public final boolean g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final String s;
    public final long t;
    private int u;

    MediaFormat(Parcel parcel) {
        boolean z = true;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        this.s = parcel.readString();
        this.t = parcel.readLong();
        parcel.readList(this.f, null);
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.g = z;
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = parcel.readInt();
    }

    public final String toString() {
        return "MediaFormat(" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.h + ", " + this.i + ", " + this.l + ", " + this.m + ", " + this.n + ", " + this.o + ", " + this.s + ", " + this.e + ", " + this.g + ", " + this.j + ", " + this.k + ", " + this.p + ", " + this.q + ", " + this.r + ")";
    }

    public final int hashCode() {
        int i = 0;
        if (this.u == 0) {
            int hashCode = (((this.s == null ? 0 : this.s.hashCode()) + (((((((((((((((((this.g ? 1231 : 1237) + (((((((((((((((((this.b == null ? 0 : this.b.hashCode()) + (((this.a == null ? 0 : this.a.hashCode()) + 527) * 31)) * 31) + this.c) * 31) + this.d) * 31) + this.h) * 31) + this.i) * 31) + this.l) * 31) + Float.floatToRawIntBits(this.m)) * 31) + ((int) this.e)) * 31)) * 31) + this.j) * 31) + this.k) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31)) * 31) + ((int) this.t);
            while (i < this.f.size()) {
                hashCode = Arrays.hashCode((byte[]) this.f.get(i)) + (hashCode * 31);
                i++;
            }
            this.u = hashCode;
        }
        return this.u;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaFormat mediaFormat = (MediaFormat) obj;
        if (this.g != mediaFormat.g || this.c != mediaFormat.c || this.d != mediaFormat.d || this.e != mediaFormat.e || this.h != mediaFormat.h || this.i != mediaFormat.i || this.l != mediaFormat.l || this.m != mediaFormat.m || this.j != mediaFormat.j || this.k != mediaFormat.k || this.n != mediaFormat.n || this.o != mediaFormat.o || this.p != mediaFormat.p || this.q != mediaFormat.q || this.r != mediaFormat.r || this.t != mediaFormat.t || !e.a(this.a, mediaFormat.a) || !e.a(this.s, mediaFormat.s) || !e.a(this.b, mediaFormat.b) || this.f.size() != mediaFormat.f.size()) {
            return false;
        }
        for (int i = 0; i < this.f.size(); i++) {
            if (!Arrays.equals((byte[]) this.f.get(i), (byte[]) mediaFormat.f.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.l);
        parcel.writeFloat(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeString(this.s);
        parcel.writeLong(this.t);
        parcel.writeList(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        parcel.writeInt(this.r);
    }
}
