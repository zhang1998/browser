package com.tencent.tinker.c.b.a;

import java.io.EOFException;

/* compiled from: ProGuard */
public final class g extends a {
    final short[] c;

    public g(short[] sArr) {
        if (sArr == null) {
            throw new NullPointerException("array == null");
        }
        this.c = sArr;
    }

    public final int c() throws EOFException {
        try {
            short s = this.c[this.b];
            b();
            return s & 65535;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EOFException();
        }
    }

    public final int d() throws EOFException {
        return c() | (c() << 16);
    }

    public final long e() throws EOFException {
        return ((((long) c()) | (((long) c()) << 16)) | (((long) c()) << 32)) | (((long) c()) << 48);
    }
}
