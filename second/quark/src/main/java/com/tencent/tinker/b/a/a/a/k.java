package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.ac;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;

/* compiled from: ProGuard */
public final class k extends i<ac> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        ac acVar = (ac) comparable;
        return new ac(acVar.i, fVar.b(acVar.a), fVar.c(acVar.b), fVar.a(acVar.c));
    }

    public k(a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.f;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            iVar.e.a(i, i3);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.f;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i >= 0) {
            iVar.s.a(i);
        }
    }

    protected final /* synthetic */ Comparable a(b bVar) {
        return bVar.e();
    }
}
