package com.tencent.a.b;

/* compiled from: ProGuard */
public final class l implements Cloneable {
    int a;

    public l(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private l(byte[] bArr, byte b) {
        this.a = (bArr[1] << 8) & 65280;
        this.a += bArr[0] & 255;
    }

    public l() {
        this.a = 38651;
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof l) && this.a == ((l) obj).a;
    }

    public final int hashCode() {
        return this.a;
    }
}
