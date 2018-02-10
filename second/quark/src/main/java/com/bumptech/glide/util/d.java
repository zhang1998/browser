package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class d extends FilterInputStream {
    private final long a;
    private int b;

    public static InputStream a(InputStream inputStream, long j) {
        return new d(inputStream, j);
    }

    private d(InputStream inputStream, long j) {
        super(inputStream);
        this.a = j;
    }

    public final synchronized int available() throws IOException {
        return (int) Math.max(this.a - ((long) this.b), (long) this.in.available());
    }

    public final synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return a(super.read(bArr, i, i2));
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.b += i;
        } else if (this.a - ((long) this.b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.a + ", but read: " + this.b);
        }
        return i;
    }
}
