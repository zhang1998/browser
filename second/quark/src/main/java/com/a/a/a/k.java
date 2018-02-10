package com.a.a.a;

/* compiled from: ProGuard */
public abstract class k {
    public abstract int a(byte[] bArr, int i, int i2) throws h;

    public abstract void b(byte[] bArr, int i, int i2) throws h;

    public final int a(byte[] bArr, int i) throws h {
        int i2 = 0;
        while (i2 < i) {
            int a = a(bArr, i2 + 0, i - i2);
            if (a <= 0) {
                throw new h("Cannot read. Remote side has closed. Tried to read " + i + " bytes, but only got " + i2 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)", (byte) 0);
            }
            i2 += a;
        }
        return i2;
    }

    public byte[] a() {
        return null;
    }

    public int b() {
        return 0;
    }

    public int c() {
        return -1;
    }

    public void a(int i) {
    }
}
