package com.uc.quark.filedownloader.f;

/* compiled from: ProGuard */
public final class o implements j, l, Cloneable {
    private static final byte[] c = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    n a;
    long b;
    private Object d;
    private long e;

    public final o a() {
        return this;
    }

    public final void a(Object obj) {
        this.d = obj;
    }

    public final Object c() {
        return this.d;
    }

    public final void a(long j) {
        this.e = j;
    }

    public final long d() {
        return this.e;
    }

    public final l b() {
        return this;
    }

    public final void a(o oVar, long j) {
        if (oVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (oVar == this) {
            throw new IllegalArgumentException("source == this");
        } else {
            e.a(oVar.b, 0, j);
            while (j > 0) {
                n nVar;
                n nVar2;
                if (j < ((long) (oVar.a.c - oVar.a.b))) {
                    nVar = this.a != null ? this.a.g : null;
                    if (nVar != null && nVar.e) {
                        if ((((long) nVar.c) + j) - ((long) (nVar.d ? 0 : nVar.b)) <= 2097152) {
                            oVar.a.a(nVar, (int) j);
                            oVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    nVar = oVar.a;
                    int i = (int) j;
                    if (i <= 0 || i > nVar.c - nVar.b) {
                        throw new IllegalArgumentException();
                    }
                    if (i >= 1024) {
                        nVar2 = new n(nVar);
                    } else {
                        nVar2 = k.a();
                        System.arraycopy(nVar.a, nVar.b, nVar2.a, 0, i);
                    }
                    nVar2.c = nVar2.b + i;
                    nVar.b = i + nVar.b;
                    nVar.g.a(nVar2);
                    oVar.a = nVar2;
                }
                nVar2 = oVar.a;
                long j2 = (long) (nVar2.c - nVar2.b);
                oVar.a = nVar2.a();
                if (this.a == null) {
                    this.a = nVar2;
                    nVar2 = this.a;
                    nVar = this.a;
                    n nVar3 = this.a;
                    nVar.g = nVar3;
                    nVar2.f = nVar3;
                } else {
                    nVar = this.a.g.a(nVar2);
                    if (nVar.g == nVar) {
                        throw new IllegalStateException();
                    } else if (nVar.g.e) {
                        int i2 = nVar.c - nVar.b;
                        if (i2 <= (nVar.g.d ? 0 : nVar.g.b) + (2097152 - nVar.g.c)) {
                            nVar.a(nVar.g, i2);
                            nVar.a();
                            k.a(nVar);
                        }
                    }
                }
                oVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
        }
    }

    public final long b(o oVar, long j) {
        if (oVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.b == 0) {
            return -1;
        } else {
            if (j > this.b) {
                j = this.b;
            }
            oVar.a(this, j);
            return j;
        }
    }

    public final void flush() {
    }

    public final void close() {
    }

    public final boolean equals(Object obj) {
        long j = 0;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.b != oVar.b) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        n nVar = this.a;
        n nVar2 = oVar.a;
        int i = nVar.b;
        int i2 = nVar2.b;
        while (j < this.b) {
            long min = (long) Math.min(nVar.c - i, nVar2.c - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                byte b = nVar.a[i];
                i = i2 + 1;
                if (b != nVar2.a[i2]) {
                    return false;
                }
                i3++;
                i2 = i;
                i = i4;
            }
            if (i == nVar.c) {
                nVar = nVar.f;
                i = nVar.b;
            }
            if (i2 == nVar2.c) {
                nVar2 = nVar2.f;
                i2 = nVar2.b;
            }
            j += min;
        }
        return true;
    }

    public final int hashCode() {
        n nVar = this.a;
        if (nVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = nVar.b;
            while (i2 < nVar.c) {
                int i3 = nVar.a[i2] + (i * 31);
                i2++;
                i = i3;
            }
            nVar = nVar.f;
        } while (nVar != this.a);
        return i;
    }

    public final String toString() {
        if (this.b > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
        }
        h hVar;
        int i = (int) this.b;
        if (i == 0) {
            hVar = h.d;
        } else {
            hVar = new d(this, i);
        }
        return hVar.toString();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        o oVar = new o();
        if (this.b == 0) {
            return oVar;
        }
        oVar.a = new n(this.a);
        n nVar = oVar.a;
        n nVar2 = oVar.a;
        n nVar3 = oVar.a;
        nVar2.g = nVar3;
        nVar.f = nVar3;
        for (nVar = this.a.f; nVar != this.a; nVar = nVar.f) {
            oVar.a.g.a(new n(nVar));
        }
        oVar.b = this.b;
        return oVar;
    }
}
