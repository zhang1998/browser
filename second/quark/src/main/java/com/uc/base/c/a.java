package com.uc.base.c;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class a extends InputStream {
    public static int b = 1024;
    public int a = 0;
    public byte c = (byte) 1;
    public int[] d = null;
    private byte e = (byte) 0;
    private int f = 0;
    private byte[] g = null;
    private InputStream h = null;

    public a(InputStream inputStream, int i) {
        this.a = i;
        this.h = inputStream;
        this.e = (byte) 1;
    }

    public final int read() throws IOException {
        if (this.e == (byte) 1) {
            if (this.a <= 0) {
                throw new EOFException();
            }
            this.a--;
            return this.h.read();
        } else if (this.c != (this.c | 1)) {
            if (this.d != null) {
                r0 = this.d;
                r0[0] = r0[0] + 1;
            }
            return this.h.read();
        } else {
            if (this.a <= 0) {
                this.f = 0;
                this.a = this.h.read(this.g, 0, this.g.length);
                if (this.a > 0 && this.d != null) {
                    r0 = this.d;
                    r0[0] = r0[0] + this.a;
                }
                if (this.a < 0) {
                    return -1;
                }
            }
            this.a--;
            byte[] bArr = this.g;
            int i = this.f;
            this.f = i + 1;
            return bArr[i] & 255;
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.e == (byte) 1) {
            int read = this.h.read(bArr, i, i2);
            this.a -= read;
            return read;
        }
        if (this.a > 0) {
            read = Math.min(this.a, i2);
            System.arraycopy(this.g, this.f, bArr, i, read);
            this.a -= read;
            this.f += read;
            i += read;
            i2 -= read;
        } else {
            read = 0;
        }
        while (i2 > 0) {
            int read2 = this.h.read(bArr, i, i2);
            if (read2 >= 0) {
                if (this.d != null) {
                    int[] iArr = this.d;
                    iArr[0] = iArr[0] + read2;
                }
                read += read2;
                i += read2;
                i2 -= read2;
            } else if (read == 0) {
                return -1;
            } else {
                return read;
            }
        }
        return read;
    }

    public final boolean markSupported() {
        return false;
    }

    public final void close() throws IOException {
        super.close();
        if (this.h != null) {
            this.h.close();
        }
        this.g = null;
        this.h = null;
    }
}
