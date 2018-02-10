package com.uc.base.b.c;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class j extends OutputStream {
    protected int a;
    private byte[] b;
    private boolean c;

    public j() {
        this.c = false;
        this.b = new byte[32];
    }

    public j(byte[] bArr) {
        this.c = false;
        this.b = bArr;
        this.c = true;
    }

    public final synchronized void write(int i) {
        if (!this.c) {
            a(this.a + 1);
        }
        this.b[this.a] = (byte) i;
        this.a++;
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (i >= 0) {
            if (i <= bArr.length && i2 >= 0 && (i + i2) - bArr.length <= 0) {
                if (!this.c) {
                    a(this.a + i2);
                }
                System.arraycopy(bArr, i, this.b, this.a, i2);
                this.a += i2;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public final synchronized byte[] a() {
        Object obj;
        obj = new byte[this.a];
        System.arraycopy(this.b, 0, obj, 0, this.a);
        return obj;
    }

    public final synchronized byte[] b() {
        return this.b;
    }

    public final synchronized int c() {
        return this.a;
    }

    public final synchronized String toString() {
        return new String(this.b, 0, this.a);
    }

    public final void close() throws IOException {
    }

    private void a(int i) {
        if (i - this.b.length > 0) {
            int length = this.b.length << 1;
            if (length - i < 0) {
                length = i << 1;
            }
            if (length < 0) {
                if (i < 0) {
                    throw new OutOfMemoryError();
                }
                length = Integer.MAX_VALUE;
            }
            Object obj = this.b;
            Object obj2 = new byte[length];
            System.arraycopy(obj, 0, obj2, 0, Math.min(obj.length, length));
            this.b = obj2;
        }
    }
}
