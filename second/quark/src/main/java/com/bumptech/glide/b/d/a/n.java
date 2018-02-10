package com.bumptech.glide.b.d.a;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
final class n implements m {
    private final InputStream a;

    n(InputStream inputStream) {
        this.a = inputStream;
    }

    public final int a() throws IOException {
        return ((this.a.read() << 8) & 65280) | (this.a.read() & 255);
    }

    public final short b() throws IOException {
        return (short) (this.a.read() & 255);
    }

    public final long a(long j) throws IOException {
        if (j < 0) {
            return 0;
        }
        long j2 = j;
        while (j2 > 0) {
            long skip = this.a.skip(j2);
            if (skip <= 0) {
                if (this.a.read() == -1) {
                    break;
                }
                j2--;
            } else {
                j2 -= skip;
            }
        }
        return j - j2;
    }

    public final int a(byte[] bArr, int i) throws IOException {
        int i2 = i;
        while (i2 > 0) {
            int read = this.a.read(bArr, i - i2, i2);
            if (read == -1) {
                break;
            }
            i2 -= read;
        }
        return i - i2;
    }

    public final int c() throws IOException {
        return this.a.read();
    }
}
