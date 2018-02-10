package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.af;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;

/* compiled from: ProGuard */
public final class n extends i<af> {
    private ah c = null;
    private ah d = null;
    private q e = null;
    private q f = null;

    protected final /* synthetic */ int a(Comparable comparable) {
        int a = this.e.a((af) comparable);
        this.f.d(a);
        ah ahVar = this.c;
        ahVar.c++;
        ahVar = this.d;
        ahVar.c++;
        return a;
    }

    public n(a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.n;
            this.d = uVar2.b.b;
            this.e = uVar2.a(this.c);
            this.f = uVar2.a(this.d);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            iVar.a.a(i, i3);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.n;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i >= 0) {
            iVar.o.a(i);
        }
    }

    protected final /* synthetic */ Comparable a(b bVar) {
        return bVar.b();
    }
}
