package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.g;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;

/* compiled from: ProGuard */
public final class e extends i<g> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        g gVar = (g) comparable;
        return new g(gVar.i, fVar.a(gVar.a), fVar.a(gVar.b), fVar.a(gVar.c), fVar.a(gVar.d));
    }

    public e(a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.l;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            iVar.l.a(i2, i4);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.l;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i2 >= 0) {
            iVar.z.a(i2);
        }
    }

    protected final /* synthetic */ Comparable a(b bVar) {
        return bVar.j();
    }
}
