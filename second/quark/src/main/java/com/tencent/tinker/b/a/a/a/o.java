package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;

/* compiled from: ProGuard */
public final class o extends i<Integer> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ int a(Comparable comparable) {
        Integer num = (Integer) comparable;
        int position = this.d.b.position();
        this.d.d(num.intValue());
        ah ahVar = this.c;
        ahVar.c++;
        return position;
    }

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        return Integer.valueOf(fVar.a(((Integer) comparable).intValue()));
    }

    public o(a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.c;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i != i3) {
            iVar.b.a(i, i3);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.c;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i >= 0) {
            iVar.p.a(i);
        }
    }

    protected final /* synthetic */ Comparable a(b bVar) {
        return Integer.valueOf(bVar.b.getInt());
    }
}
