package com.uc.quark.filedownloader.f;

/* compiled from: ProGuard */
final class n {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    n f;
    n g;

    n() {
        this.a = new byte[2097152];
        this.e = true;
        this.d = false;
    }

    n(n nVar) {
        this(nVar.a, nVar.b, nVar.c);
        nVar.d = true;
    }

    private n(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.e = false;
        this.d = true;
    }

    public final n a() {
        n nVar = this.f != this ? this.f : null;
        this.g.f = this.f;
        this.f.g = this.g;
        this.f = null;
        this.g = null;
        return nVar;
    }

    public final n a(n nVar) {
        nVar.g = this;
        nVar.f = this.f;
        this.f.g = nVar;
        this.f = nVar;
        return nVar;
    }

    public final void a(n nVar, int i) {
        if (nVar.e) {
            if (nVar.c + i > 2097152) {
                if (nVar.d) {
                    throw new IllegalArgumentException();
                } else if ((nVar.c + i) - nVar.b > 2097152) {
                    throw new IllegalArgumentException();
                } else {
                    System.arraycopy(nVar.a, nVar.b, nVar.a, 0, nVar.c - nVar.b);
                    nVar.c -= nVar.b;
                    nVar.b = 0;
                }
            }
            System.arraycopy(this.a, this.b, nVar.a, nVar.c, i);
            nVar.c += i;
            this.b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
