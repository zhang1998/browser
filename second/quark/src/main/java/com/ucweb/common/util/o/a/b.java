package com.ucweb.common.util.o.a;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class b extends OutputStream {
    private static final byte[] a = new byte[0];
    private final List<byte[]> b;
    private int c;
    private int d;
    private byte[] e;
    private int f;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.b = new ArrayList();
        synchronized (this) {
            a(1024);
        }
    }

    private void a(int i) {
        if (this.c < this.b.size() - 1) {
            this.d += this.e.length;
            this.c++;
            this.e = (byte[]) this.b.get(this.c);
            return;
        }
        if (this.e == null) {
            this.d = 0;
        } else {
            i = Math.max(this.e.length << 1, i - this.d);
            this.d += this.e.length;
        }
        this.c++;
        this.e = new byte[i];
        this.b.add(this.e);
    }

    public final void write(byte[] bArr, int i, int i2) {
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 > bArr.length || i + i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            synchronized (this) {
                int i3 = this.f + i2;
                int i4 = this.f - this.d;
                int i5 = i2;
                while (i5 > 0) {
                    int min = Math.min(i5, this.e.length - i4);
                    System.arraycopy(bArr, (i + i2) - i5, this.e, i4, min);
                    i5 -= min;
                    if (i5 > 0) {
                        a(i3);
                        i4 = 0;
                    }
                }
                this.f = i3;
            }
        }
    }

    public final synchronized void write(int i) {
        int i2 = this.f - this.d;
        if (i2 == this.e.length) {
            a(this.f + 1);
            i2 = 0;
        }
        this.e[i2] = (byte) i;
        this.f++;
    }

    public final void close() throws IOException {
    }

    public final synchronized byte[] a() {
        byte[] bArr;
        int i = this.f;
        if (i == 0) {
            bArr = a;
        } else {
            Object obj = new byte[i];
            int i2 = i;
            i = 0;
            for (byte[] bArr2 : this.b) {
                int min = Math.min(bArr2.length, i2);
                System.arraycopy(bArr2, 0, obj, i, min);
                int i3 = i + min;
                i = i2 - min;
                if (i == 0) {
                    break;
                }
                i2 = i;
                i = i3;
            }
            Object obj2 = obj;
        }
        return bArr2;
    }

    public final String toString() {
        return new String(a());
    }
}
