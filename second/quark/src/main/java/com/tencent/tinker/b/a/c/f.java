package com.tencent.tinker.b.a.c;

import com.tencent.tinker.c.a.e;

/* compiled from: ProGuard */
public abstract class f {
    public abstract int a(int i);

    public abstract int b(int i);

    public abstract int c(int i);

    public abstract int d(int i);

    public abstract int e(int i);

    public abstract int f(int i);

    public abstract int g(int i);

    public abstract int h(int i);

    public abstract int i(int i);

    public abstract int j(int i);

    public abstract int k(int i);

    public abstract int l(int i);

    public abstract int m(int i);

    public abstract int n(int i);

    public final e[] a(e[] eVarArr) {
        e[] eVarArr2 = new e[eVarArr.length];
        for (int i = 0; i < eVarArr.length; i++) {
            e eVar = eVarArr[i];
            eVarArr2[i] = new e(d(eVar.a), eVar.b);
        }
        return eVarArr2;
    }

    public final com.tencent.tinker.c.a.f[] a(com.tencent.tinker.c.a.f[] fVarArr) {
        com.tencent.tinker.c.a.f[] fVarArr2 = new com.tencent.tinker.c.a.f[fVarArr.length];
        for (int i = 0; i < fVarArr.length; i++) {
            com.tencent.tinker.c.a.f fVar = fVarArr[i];
            fVarArr2[i] = new com.tencent.tinker.c.a.f(e(fVar.a), fVar.b, n(fVar.c));
        }
        return fVarArr2;
    }
}
