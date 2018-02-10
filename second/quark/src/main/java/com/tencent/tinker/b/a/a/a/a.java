package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.c.d;
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
public final class a extends i<com.tencent.tinker.c.a.a> {
    private ah c = null;
    private q d = null;

    protected final /* synthetic */ Comparable a(f fVar, Comparable comparable) {
        com.tencent.tinker.c.a.a aVar = (com.tencent.tinker.c.a.a) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(aVar.b.a.length);
        new e(fVar, new d(fVar, byteArrayOutputStream)).a(new z(aVar.b, 29));
        return new com.tencent.tinker.c.a.a(aVar.i, aVar.a, new x(aVar.b.i, byteArrayOutputStream.toByteArray()));
    }

    public a(com.tencent.tinker.b.a.b.a aVar, u uVar, u uVar2, i iVar) {
        super(aVar, uVar, iVar);
        if (uVar2 != null) {
            this.c = uVar2.b.p;
            this.d = uVar2.a(this.c);
        }
    }

    protected final void a(i iVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            iVar.g.a(i2, i4);
        }
    }

    protected final ah a(u uVar) {
        return uVar.b.p;
    }

    protected final void a(i iVar, int i, int i2) {
        if (i2 >= 0) {
            iVar.u.a(i2);
        }
    }

    protected final /* synthetic */ Comparable a(b bVar) {
        return bVar.k();
    }
}
