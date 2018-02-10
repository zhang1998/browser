package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.aj;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;

/* compiled from: ProGuard */
public final class p extends i<aj> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        aj ajVar = (aj) comparable;
        if (ajVar == aj.a) {
            return ajVar;
        }
        short[] sArr = new short[ajVar.b.length];
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) fVar.b(ajVar.b[i]);
        }
        return new aj(ajVar.i, sArr);
    }

    public p(a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.i;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            iVar.f.a(i2, i4);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.i;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i2 >= 0) {
            iVar.t.a(i2);
        }
    }

    protected final /* synthetic */ Comparable a(b bVar) {
        return bVar.c();
    }
}
