package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.c;
import com.tencent.tinker.b.a.c.e;
import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;
import com.tencent.tinker.c.a.x;
import com.tencent.tinker.c.a.z;
import java.io.ByteArrayOutputStream;

/* compiled from: ProGuard */
public final class m extends i<x> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        x xVar = (x) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(xVar.a.length);
        new e(fVar, new c(fVar, byteArrayOutputStream)).b(new z(xVar, 28));
        return new x(xVar.i, byteArrayOutputStream.toByteArray());
    }

    public m(a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.q;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            iVar.k.a(i2, i4);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.q;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i2 >= 0) {
            iVar.y.a(i2);
        }
    }

    protected final /* synthetic */ Comparable a(b bVar) {
        return bVar.o();
    }
}
