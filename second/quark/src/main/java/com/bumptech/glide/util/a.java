package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
final class a extends InputStream {
    private final ByteBuffer a;
    private int b = -1;

    public a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    public final int available() throws IOException {
        return this.a.remaining();
    }

    public final int read() throws IOException {
        if (this.a.hasRemaining()) {
            return this.a.get();
        }
        return -1;
    }

    public final synchronized void mark(int i) {
        this.b = this.a.position();
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.a.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, available());
        this.a.get(bArr, i, min);
        return min;
    }

    public final synchronized void reset() throws IOException {
        if (this.b == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.a.position(this.b);
    }

    public final long skip(long j) throws IOException {
        if (!this.a.hasRemaining()) {
            return -1;
        }
        long min = Math.min(j, (long) available());
        this.a.position((int) (((long) this.a.position()) + min));
        return min;
    }
}
