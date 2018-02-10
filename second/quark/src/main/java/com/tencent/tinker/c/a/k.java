package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class k extends ag<k> {
    public int a;
    public int b;
    public int c;
    public int d;
    public short[] e;
    public j[] f;
    public i[] g;

    public final /* synthetic */ int compareTo(Object obj) {
        k kVar = (k) obj;
        int b = c.b(this.a, kVar.a);
        if (b != 0) {
            return b;
        }
        b = c.b(this.b, kVar.b);
        if (b != 0) {
            return b;
        }
        b = c.b(this.c, kVar.c);
        if (b != 0) {
            return b;
        }
        b = c.b(this.d, kVar.d);
        if (b != 0) {
            return b;
        }
        b = c.a(this.e, kVar.e);
        if (b != 0) {
            return b;
        }
        b = c.a(this.f, kVar.f);
        if (b == 0) {
            return c.a(this.g, kVar.g);
        }
        return b;
    }

    public k(int i, int i2, int i3, int i4, int i5, short[] sArr, j[] jVarArr, i[] iVarArr) {
        super(i);
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = sArr;
        this.f = jVarArr;
        this.g = iVarArr;
    }
}
