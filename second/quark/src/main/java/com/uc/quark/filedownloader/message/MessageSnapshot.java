package com.uc.quark.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.uc.quark.filedownloader.aa;
import com.uc.quark.filedownloader.e.b;

/* compiled from: ProGuard */
public class MessageSnapshot implements Parcelable {
    public static final Creator<MessageSnapshot> CREATOR = new h();
    public final int a;
    protected byte b;
    protected boolean c;
    protected boolean d;
    protected long e;
    public aa f;

    MessageSnapshot(int i, byte b, boolean z) {
        this.a = i;
        this.b = b;
        this.d = z;
    }

    public final byte i() {
        return this.b;
    }

    public final boolean j() {
        return this.d;
    }

    public Throwable f() {
        throw new IllegalStateException(b.a("No 'exception' in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public int h() {
        throw new IllegalStateException(b.a("No 'retrying times' in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public boolean k() {
        throw new IllegalStateException(b.a("No 'is resuming' in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public String l() {
        throw new IllegalStateException(b.a("No 'etag' in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public long b() {
        throw new IllegalStateException(b.a("No 'large sofar bytes' in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public long a() {
        throw new IllegalStateException(b.a("No 'large total bytes' in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public int d() {
        throw new IllegalStateException(b.a("No 'small sofar bytes' in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public int e() {
        throw new IllegalStateException(b.a("No 'small total bytes' in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public boolean c() {
        throw new IllegalStateException(b.a("No reused downloaded file' in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public String m() {
        throw new IllegalStateException(b.a("No filename in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public int g() {
        throw new IllegalStateException(b.a("No PreCreateProgress in this message %d %d", Integer.valueOf(this.a), Byte.valueOf(this.b)));
    }

    public final boolean n() {
        return this.c;
    }

    public final long o() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeByte((byte) (this.c ? 1 : 0));
        parcel.writeByte(this.b);
        if (!this.d) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.a);
        parcel.writeLong(this.e);
    }

    MessageSnapshot(Parcel parcel) {
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.d = z;
        this.a = parcel.readInt();
        this.e = parcel.readLong();
    }
}
