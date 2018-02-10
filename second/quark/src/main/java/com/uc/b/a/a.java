package com.uc.b.a;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class a extends InputStream {
    protected String a;
    protected int b;
    protected int c = 0;
    protected int d;

    public a(String str) {
        this.a = str;
        this.d = str.length();
    }

    public final synchronized int available() {
        return this.d - this.b;
    }

    public final void close() throws IOException {
    }

    public final synchronized void mark(int i) {
        this.c = this.b;
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read() throws IOException {
        if (this.b >= this.d) {
            return -1;
        }
        String str = this.a;
        int i = this.b;
        this.b = i + 1;
        return str.charAt(i);
    }

    public final synchronized void reset() {
        this.b = this.c;
    }

    public final synchronized long skip(long j) {
        long j2 = 0;
        synchronized (this) {
            if (j > 0) {
                int i = this.b;
                this.b = ((long) (this.d - this.b)) < j ? this.d : (int) (((long) this.b) + j);
                j2 = (long) (this.b - i);
            }
        }
        return j2;
    }
}
