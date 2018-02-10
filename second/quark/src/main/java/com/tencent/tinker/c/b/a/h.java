package com.tencent.tinker.c.b.a;

/* compiled from: ProGuard */
public final class h extends a {
    public short[] c;

    public h(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("initSize < 0");
        }
        this.c = new short[i];
    }

    public final void a(short s) {
        int i = this.b;
        if (this.c.length - i <= 0) {
            Object obj = new short[(this.c.length + (this.c.length >> 1))];
            System.arraycopy(this.c, 0, obj, 0, i);
            this.c = obj;
        }
        this.c[this.b] = s;
        b();
    }

    public final void a(short s, short s2) {
        a(s);
        a(s2);
    }

    public final void a(short s, short s2, short s3) {
        a(s);
        a(s2);
        a(s3);
    }

    public final void a(int i) {
        a((short) i);
        a((short) (i >> 16));
    }
}
