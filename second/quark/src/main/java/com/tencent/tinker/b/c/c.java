package com.tencent.tinker.b.c;

import java.nio.ByteOrder;

/* compiled from: ProGuard */
public final class c extends b {
    private final byte[] a;
    private final int b = 0;
    private final int c;
    private final ByteOrder d;
    private int e;

    private c(byte[] bArr, int i, ByteOrder byteOrder) {
        this.a = bArr;
        this.c = i;
        this.d = byteOrder;
    }

    public static b a(byte[] bArr, int i, ByteOrder byteOrder) {
        return new c(bArr, i, byteOrder);
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void a() {
        this.e += 4;
    }

    public final int b() {
        int i;
        byte[] bArr = this.a;
        int i2 = this.b + this.e;
        int i3;
        int i4;
        if (this.d == ByteOrder.BIG_ENDIAN) {
            i3 = i2 + 1;
            i4 = i3 + 1;
            i2 = ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16);
            i2 |= (bArr[i4] & 255) << 8;
            i = ((bArr[i4 + 1] & 255) << 0) | i2;
        } else {
            i3 = i2 + 1;
            i4 = i3 + 1;
            i2 = ((bArr[i2] & 255) << 0) | ((bArr[i3] & 255) << 8);
            i2 |= (bArr[i4] & 255) << 16;
            i = ((bArr[i4 + 1] & 255) << 24) | i2;
        }
        this.e += 4;
        return i;
    }

    public final short c() {
        short s;
        byte[] bArr = this.a;
        int i = this.b + this.e;
        if (this.d == ByteOrder.BIG_ENDIAN) {
            s = (short) ((bArr[i + 1] & 255) | (bArr[i] << 8));
        } else {
            s = (short) ((bArr[i] & 255) | (bArr[i + 1] << 8));
        }
        this.e += 2;
        return s;
    }
}
