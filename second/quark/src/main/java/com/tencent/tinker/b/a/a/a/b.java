package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.c;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;

/* compiled from: ProGuard */
public final class b extends i<c> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        c cVar = (c) comparable;
        int length = cVar.a.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = fVar.h(cVar.a[i]);
        }
        return new c(cVar.i, iArr);
    }

    public b(a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.j;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            iVar.i.a(i2, i4);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.j;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i2 >= 0) {
            iVar.w.a(i2);
        }
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.a.b bVar) {
        return bVar.m();
    }
}
