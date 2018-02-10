package com.uc.quark.filedownloader.f;

import java.util.Arrays;

/* compiled from: ProGuard */
final class d extends h {
    final transient byte[][] a;
    final transient int[] b;

    d(o oVar, int i) {
        int i2 = 0;
        super(null);
        e.a(oVar.b, 0, (long) i);
        n nVar = oVar.a;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            if (nVar.c == nVar.b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += nVar.c - nVar.b;
            i3++;
            nVar = nVar.f;
        }
        this.a = new byte[i3][];
        this.b = new int[(i3 * 2)];
        n nVar2 = oVar.a;
        i4 = 0;
        while (i2 < i) {
            this.a[i4] = nVar2.a;
            int i5 = (nVar2.c - nVar2.b) + i2;
            if (i5 > i) {
                i5 = i;
            }
            this.b[i4] = i5;
            this.b[this.a.length + i4] = nVar2.b;
            nVar2.d = true;
            i4++;
            nVar2 = nVar2.f;
            i2 = i5;
        }
    }

    public final String a() {
        return e().a();
    }

    public final String b() {
        return e().b();
    }

    public final h a(int i, int i2) {
        return e().a(i, i2);
    }

    public final byte a(int i) {
        e.a((long) this.b[this.a.length - 1], (long) i, 1);
        int b = b(i);
        return this.a[b][(i - (b == 0 ? 0 : this.b[b - 1])) + this.b[this.a.length + b]];
    }

    private int b(int i) {
        int binarySearch = Arrays.binarySearch(this.b, 0, this.a.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    public final int c() {
        return this.b[this.a.length - 1];
    }

    public final byte[] d() {
        int i = 0;
        Object obj = new byte[this.b[this.a.length - 1]];
        int length = this.a.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.b[length + i];
            int i4 = this.b[i];
            System.arraycopy(this.a[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    public final boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int b = b(i);
        while (i3 > 0) {
            int i4 = b == 0 ? 0 : this.b[b - 1];
            int min = Math.min(i3, ((this.b[b] - i4) + i4) - i);
            if (!e.a(this.a[b], (i - i4) + this.b[this.a.length + b], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            b++;
        }
        return true;
    }

    private h e() {
        return new h(d());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h) || ((h) obj).c() != c()) {
            return false;
        }
        boolean z;
        h hVar = (h) obj;
        int c = c();
        if (c() - c < 0) {
            z = false;
        } else {
            int i = c;
            int i2 = 0;
            int i3 = 0;
            c = b(0);
            while (i > 0) {
                int i4 = c == 0 ? 0 : this.b[c - 1];
                int min = Math.min(i, ((this.b[c] - i4) + i4) - i3);
                if (!hVar.a(i2, this.a[c], (i3 - i4) + this.b[this.a.length + c], min)) {
                    z = false;
                    break;
                }
                i3 += min;
                i2 += min;
                i -= min;
                c++;
            }
            z = true;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f;
        if (i == 0) {
            i = 1;
            int length = this.a.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.a[i2];
                int i4 = this.b[length + i2];
                int i5 = this.b[i2];
                i3 = (i5 - i3) + i4;
                int i6 = i4;
                i4 = i;
                for (i = i6; i < i3; i++) {
                    i4 = (i4 * 31) + bArr[i];
                }
                i2++;
                i3 = i5;
                i = i4;
            }
            this.f = i;
        }
        return i;
    }

    public final String toString() {
        return e().toString();
    }
}
