package com.tencent.tinker.b.c;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* compiled from: ProGuard */
public final class h extends InputStream {
    private final RandomAccessFile a;
    private long b;
    private long c;

    private h(RandomAccessFile randomAccessFile, long j, long j2) {
        this.a = randomAccessFile;
        this.c = j;
        this.b = j2;
    }

    public h(RandomAccessFile randomAccessFile, long j) throws IOException {
        this(randomAccessFile, j, randomAccessFile.length());
    }

    public final int available() throws IOException {
        return this.c < this.b ? 1 : 0;
    }

    public final int read() throws IOException {
        return e.a(this);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        synchronized (this.a) {
            long j = this.b - this.c;
            if (((long) i2) > j) {
                i2 = (int) j;
            }
            this.a.seek(this.c);
            read = this.a.read(bArr, i, i2);
            if (read > 0) {
                this.c += (long) read;
            } else {
                read = -1;
            }
        }
        return read;
    }

    public final long skip(long j) throws IOException {
        if (j > this.b - this.c) {
            j = this.b - this.c;
        }
        this.c += j;
        return j;
    }
}
