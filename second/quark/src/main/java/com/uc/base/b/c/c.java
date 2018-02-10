package com.uc.base.b.c;

import android.util.Log;

/* compiled from: ProGuard */
public final class c {
    public static final c b = new c(new byte[0]);
    public final byte[] a;
    private volatile int c = 0;

    private c(byte[] bArr) {
        this.a = bArr;
    }

    public static c a(byte[] bArr) {
        return new c(bArr);
    }

    static c b(byte[] bArr) {
        return new c(bArr);
    }

    public static c a(String str) {
        try {
            return new c(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    private String a() {
        try {
            return new String(this.a, "UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public final String toString() {
        try {
            return a();
        } catch (Throwable e) {
            Log.e("ByteString", "utf-8 decode error !", e);
            return "";
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        int length = this.a.length;
        if (length != cVar.a.length) {
            return false;
        }
        byte[] bArr = this.a;
        byte[] bArr2 = cVar.a;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            byte[] bArr = this.a;
            int length = this.a.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }
}
