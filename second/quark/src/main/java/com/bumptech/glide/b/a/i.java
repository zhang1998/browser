package com.bumptech.glide.b.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class i extends FilterInputStream {
    private static final byte[] a = new byte[]{(byte) -1, (byte) -31, (byte) 0, (byte) 28, (byte) 69, (byte) 120, (byte) 105, (byte) 102, (byte) 0, (byte) 0, (byte) 77, (byte) 77, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 8, (byte) 0, (byte) 1, (byte) 1, (byte) 18, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0};
    private static final int b = 29;
    private static final int c = 31;
    private final byte d;
    private int e;

    public i(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.d = (byte) i;
    }

    public final boolean markSupported() {
        return false;
    }

    public final void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public final int read() throws IOException {
        int read;
        if (this.e < 2 || this.e > c) {
            read = super.read();
        } else if (this.e == c) {
            read = this.d;
        } else {
            read = a[this.e - 2] & 255;
        }
        if (read != -1) {
            this.e++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        if (this.e > c) {
            read = super.read(bArr, i, i2);
        } else if (this.e == c) {
            bArr[i] = this.d;
            read = 1;
        } else if (this.e < 2) {
            read = super.read(bArr, i, 2 - this.e);
        } else {
            read = Math.min(c - this.e, i2);
            System.arraycopy(a, this.e - 2, bArr, i, read);
        }
        if (read > 0) {
            this.e += read;
        }
        return read;
    }

    public final long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.e = (int) (((long) this.e) + skip);
        }
        return skip;
    }

    public final void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
