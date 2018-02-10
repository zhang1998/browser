package com.uc.quark.filedownloader.message;

import android.os.Parcel;

/* compiled from: ProGuard */
public class SmallMessageSnapshot extends MessageSnapshot {

    /* compiled from: ProGuard */
    public class CompletedSnapshot extends SmallMessageSnapshot {
        private final boolean g;
        private final int h;

        CompletedSnapshot(int i, byte b, boolean z, int i2, boolean z2) {
            super(i, b, z2);
            this.g = z;
            this.h = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.h);
        }

        CompletedSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readByte() != (byte) 0;
            this.h = parcel.readInt();
        }

        public final int e() {
            return this.h;
        }

        public final boolean c() {
            return this.g;
        }
    }

    /* compiled from: ProGuard */
    public class CompletedFlowDirectlySnapshot extends CompletedSnapshot implements i {
        CompletedFlowDirectlySnapshot(int i, int i2, boolean z) {
            super(i, (byte) -3, true, i2, z);
        }
    }

    /* compiled from: ProGuard */
    public class ConnectedMessageSnapshot extends SmallMessageSnapshot {
        private final boolean g;
        private final int h;
        private final String i;
        private final String j;

        ConnectedMessageSnapshot(int i, byte b, boolean z, int i2, String str, String str2, boolean z2) {
            super(i, b, z2);
            this.g = z;
            this.h = i2;
            this.i = str;
            this.j = str2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.h);
            parcel.writeString(this.i);
            parcel.writeString(this.j);
        }

        ConnectedMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readByte() != (byte) 0;
            this.h = parcel.readInt();
            this.i = parcel.readString();
            this.j = parcel.readString();
        }

        public final String m() {
            return this.j;
        }

        public final boolean k() {
            return this.g;
        }

        public final int e() {
            return this.h;
        }

        public final String l() {
            return this.i;
        }
    }

    /* compiled from: ProGuard */
    public class ErrorMessageSnapshot extends SmallMessageSnapshot {
        private final int g;
        private final int h;
        private final Throwable i;

        ErrorMessageSnapshot(int i, byte b, int i2, int i3, Throwable th, boolean z) {
            super(i, b, z);
            this.g = i2;
            this.h = i3;
            this.i = th;
        }

        public final int d() {
            return this.g;
        }

        public final int e() {
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
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
            parcel.writeSerializable(this.i);
        }

        ErrorMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readInt();
            this.h = parcel.readInt();
            this.i = (Throwable) parcel.readSerializable();
        }
    }

    /* compiled from: ProGuard */
    public class PendingMessageSnapshot extends SmallMessageSnapshot {
        private final int g;
        private final int h;

        PendingMessageSnapshot(int i, byte b, int i2, int i3, boolean z) {
            super(i, b, z);
            this.g = i2;
            this.h = i3;
        }

        PendingMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readInt();
            this.h = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
        }

        public final int d() {
            return this.g;
        }

        public final int e() {
            return this.h;
        }
    }

    /* compiled from: ProGuard */
    public class NetworkSwitchMessageSnapshot extends PendingMessageSnapshot {
        NetworkSwitchMessageSnapshot(int i, byte b, int i2, int i3, boolean z) {
            super(i, b, i2, i3, z);
        }

        NetworkSwitchMessageSnapshot(Parcel parcel) {
            super(parcel);
        }
    }

    /* compiled from: ProGuard */
    public class PausedSnapshot extends PendingMessageSnapshot {
        PausedSnapshot(int i, byte b, int i2, int i3, boolean z) {
            super(i, b, i2, i3, z);
        }
    }

    /* compiled from: ProGuard */
    public class PreCreateMessageSnapshot extends SmallMessageSnapshot {
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
    public class ProgressMessageSnapshot extends SmallMessageSnapshot {
        private final int g;
        private final int h;

        ProgressMessageSnapshot(int i, byte b, int i2, int i3, boolean z, long j) {
            super(i, b, z);
            this.e = j;
            this.g = i2;
            this.h = i3;
        }

        public final int d() {
            return this.g;
        }

        public final int e() {
            return this.h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.g);
            parcel.writeInt(this.h);
        }

        ProgressMessageSnapshot(Parcel parcel) {
            super(parcel);
            this.g = parcel.readInt();
            this.h = parcel.readInt();
        }
    }

    /* compiled from: ProGuard */
    public class RetryMessageSnapshot extends ErrorMessageSnapshot {
        private final int g;

        RetryMessageSnapshot(int i, byte b, int i2, int i3, Throwable th, int i4, boolean z) {
            super(i, b, i2, i3, th, z);
            this.g = i4;
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
        WarnMessageSnapshot(int i, int i2, int i3, boolean z) {
            super(i, (byte) -4, i2, i3, z);
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
        WarnFlowDirectlySnapshot(int i, int i2, int i3, boolean z) {
            super(i, i2, i3, z);
        }
    }

    SmallMessageSnapshot(int i, byte b, boolean z) {
        super(i, b, z);
        this.c = false;
    }

    SmallMessageSnapshot(Parcel parcel) {
        super(parcel);
    }

    public final long a() {
        return (long) e();
    }

    public final long b() {
        return (long) d();
    }
}
