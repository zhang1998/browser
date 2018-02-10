package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class d extends ag<d> {
    public int a;
    public int[][] b;
    public int[][] c;
    public int[][] d;

    public final /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        if (this.a != dVar.a) {
            return c.a(this.a, dVar.a);
        }
        int length = this.b.length;
        int length2 = this.c.length;
        int length3 = this.d.length;
        int length4 = dVar.b.length;
        int length5 = dVar.c.length;
        int length6 = dVar.d.length;
        if (length != length4) {
            return c.b(length, length4);
        }
        if (length2 != length5) {
            return c.b(length2, length5);
        }
        if (length3 != length6) {
            return c.b(length3, length6);
        }
        for (length4 = 0; length4 < length; length4++) {
            length5 = this.b[length4][0];
            length6 = this.b[length4][1];
            int i = dVar.b[length4][0];
            int i2 = dVar.b[length4][1];
            if (length5 != i) {
                return c.a(length5, i);
            }
            if (length6 != i2) {
                return c.b(length6, i2);
            }
        }
        for (length4 = 0; length4 < length2; length4++) {
            length = this.c[length4][0];
            length5 = this.c[length4][1];
            length6 = dVar.c[length4][0];
            i = dVar.c[length4][1];
            if (length != length6) {
                return c.a(length, length6);
            }
            if (length5 != i) {
                return c.b(length5, i);
            }
        }
        for (length4 = 0; length4 < length3; length4++) {
            length = this.d[length4][0];
            length2 = this.d[length4][1];
            length5 = dVar.d[length4][0];
            length6 = dVar.d[length4][1];
            if (length != length5) {
                return c.a(length, length5);
            }
            if (length2 != length6) {
                return c.b(length2, length6);
            }
        }
        return 0;
    }

    public d(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.a = i2;
        this.b = iArr;
        this.c = iArr2;
        this.d = iArr3;
    }
}
