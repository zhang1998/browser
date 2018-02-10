package com.uc.quark.filedownloader.message;

import android.os.Parcel;

/* compiled from: ProGuard */
public class LargeMessageSnapshot extends MessageSnapshot {

    /* compiled from: ProGuard */
    public class CompletedSnapshot extends LargeMessageSnapshot {
        private final boolean g;
        private final long h;

        CompletedSnapshot(int i, byte b, boolean z, long j, boolean z2) {
            super(i, b, z2);
            this.g = z;
            this.h = j;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.h);
        }

        CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readByte() != (byte) 0;
            this.h = parcel.readLong();
        }

        public final long a() {
            return this.h;
        }

        public final boolean c() {
            return this.g;
        }
    }

    /* compiled from: ProGuard */
    public class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements i {
        CompletedFlowDirectlySnapshot(int i, long j, boolean z) {
            super(i, (byte) -3, true, j, z);
        }
    }

    /* compiled from: ProGuard */
    public class ConnectedMessageSnapshot extends LargeMessageSnapshot {
        private final boolean g;
        private final long h;
        private final String i;
        private final String j;

        ConnectedMessageSnapshot(int i, byte b, boolean z, long j, String str, String str2, boolean z2) {
            super(i, b, z2);
            this.g = z;
            this.h = j;
            this.i = str;
            this.j = str2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
        }

        ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readByte() != (byte) 0;
            this.h = parcel.readLong();
            this.i = parcel.readString();
            this.j = parcel.readString();
        }

        public final String m() {
            return this.j;
        }

        public final boolean k() {
            return this.g;
        }

        public final long a() {
            return this.h;
        }

        public final String l() {
            return this.i;
        }
    }

    /* compiled from: ProGuard */
    public class ErrorMessageSnapshot extends LargeMessageSnapshot {
        private final long g;
        private final long h;
        private final Throwable i;

        ErrorMessageSnapshot(int i, byte b, long j, long j2, Throwable th, boolean z) {
            super(i, b, z);
            this.g = j;
            this.h = j2;
            this.i = th;
        }

        public final long b() {
            return this.g;
        }

        public final long a() {
            return this.h;
        }

        public final Throwable f() {
            return this.i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.g);
            parcel.writeLong(this.h);
            parcel.writeSerializable(this.i);
        }

        ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readLong();
            this.h = parcel.readLong();
            this.i = (Throwable) parcel.readSerializable();
        }
    }

    /* compiled from: ProGuard */
    public class PendingMessageSnapshot extends LargeMessageSnapshot {
        private final long g;
        private final long h;

        PendingMessageSnapshot(int i, byte b, long j, long j2, boolean z) {
            super(i, b, z);
            this.g = j;
            this.h = j2;
        }

        public final long b() {
            return this.g;
        }

        public final long a() {
            return this.h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.g);
            parcel.writeLong(this.h);
        }

        PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readLong();
            this.h = parcel.readLong();
        }
    }

    /* compiled from: ProGuard */
    public class NetworkSwitchMessageSnapshot extends PendingMessageSnapshot {
        NetworkSwitchMessageSnapshot(int i, byte b, long j, long j2, boolean z) {
            super(i, b, j, j2, z);
        }

        NetworkSwitchMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    /* compiled from: ProGuard */
    public class PausedSnapshot extends PendingMessageSnapshot {
        PausedSnapshot(int i, byte b, long j, long j2, boolean z) {
            super(i, b, j, j2, z);
        }
    }

    /* compiled from: ProGuard */
    public class PreCreateMessageSnapshot extends LargeMessageSnapshot {
        private final int g;

        PreCreateMessageSnapshot(int i, byte b, int i2, boolean z) {
            super(i, b, z);
            this.g = i2;
        }

        PreCreateMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.g);
        }

        public final int g() {
            return this.g;
        }
    }

    /* compiled from: ProGuard */
    public class ProgressMessageSnapshot extends LargeMessageSnapshot {
        private final long g;
        private final long h;

        ProgressMessageSnapshot(int i, byte b, long j, long j2, boolean z, long j3) {
            super(i, b, z);
            this.e = j3;
            this.g = j;
            this.h = j2;
        }

        public final long b() {
            return this.g;
        }

        public final long a() {
            return this.h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.g);
            parcel.writeLong(this.h);
        }

        ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readLong();
            this.h = parcel.readLong();
        }
    }

    /* compiled from: ProGuard */
    public class RetryMessageSnapshot extends ErrorMessageSnapshot {
        private final int g;

        RetryMessageSnapshot(int i, byte b, long j, long j2, Throwable th, int i2, boolean z) {
            super(i, b, j, j2, th, z);
            this.g = i2;
        }

        public final int h() {
            return this.g;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.g);
        }

        RetryMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readInt();
        }
    }

    /* compiled from: ProGuard */
    public class WarnMessageSnapshot extends PendingMessageSnapshot implements k {
        WarnMessageSnapshot(int i, long j, long j2, boolean z) {
            super(i, (byte) -4, j, j2, z);
        }

        WarnMessageSnapshot(Parcel parcel) {
            super(parcel);
        }

        public final void p() {
            this.b = (byte) 1;
        }
    }

    /* compiled from: ProGuard */
    public class WarnFlowDirectlySnapshot extends WarnMessageSnapshot implements i {
        WarnFlowDirectlySnapshot(int i, long j, long j2, boolean z) {
            super(i, j, j2, z);
        }
    }

    public LargeMessageSnapshot(int i, byte b, boolean z) {
        super(i, b, z);
        this.c = true;
    }

    LargeMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public final int d() {
        if (b() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) b();
    }

    public final int e() {
        if (a() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) a();
    }
}
