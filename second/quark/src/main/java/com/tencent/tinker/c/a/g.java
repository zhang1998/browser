package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class g extends ag<g> {
    public e[] a;
    public e[] b;
    public f[] c;
    public f[] d;

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int a = c.a(this.a, gVar.a);
        if (a != 0) {
            return a;
        }
        a = c.a(this.b, gVar.b);
        if (a != 0) {
            return a;
        }
        a = c.a(this.c, gVar.c);
        if (a == 0) {
            return c.a(this.d, gVar.d);
        }
        return a;
    }

    public g(int i, e[] eVarArr, e[] eVarArr2, f[] fVarArr, f[] fVarArr2) {
        super(i);
        this.a = eVarArr;
        this.b = eVarArr2;
        this.c = fVarArr;
        this.d = fVarArr2;
    }
}
