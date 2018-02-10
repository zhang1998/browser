package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ProGuard */
public final class e extends InputStream {
    private static final Queue<e> b = l.a(0);
    public IOException a;
    private InputStream c;

    public static e a(InputStream inputStream) {
        e eVar;
        synchronized (b) {
            eVar = (e) b.poll();
        }
        if (eVar == null) {
            eVar = new e();
        }
        eVar.c = inputStream;
        return eVar;
    }

    e() {
    }

    public final int available() throws IOException {
        return this.c.available();
    }

    public final void close() throws IOException {
        this.c.close();
    }

    public final void mark(int i) {
        this.c.mark(i);
    }

    public final boolean markSupported() {
        return this.c.markSupported();
    }

    public final int read(byte[] bArr) throws IOException {
        try {
            return this.c.read(bArr);
        } catch (IOException e) {
            this.a = e;
            return -1;
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.c.read(bArr, i, i2);
        } catch (IOException e) {
            this.a = e;
            return -1;
        }
    }

    public final synchronized void reset() throws IOException {
        this.c.reset();
    }

    public final long skip(long j) throws IOException {
        try {
            return this.c.skip(j);
        } catch (IOException e) {
            this.a = e;
            return 0;
        }
    }

    public final int read() throws IOException {
        try {
            return this.c.read();
        } catch (IOException e) {
            this.a = e;
            return -1;
        }
    }

    public final void a() {
        this.a = null;
        this.c = null;
        synchronized (b) {
            b.offer(this);
        }
    }
}
