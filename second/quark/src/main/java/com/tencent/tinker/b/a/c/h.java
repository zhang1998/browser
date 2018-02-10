package com.tencent.tinker.b.a.c;

import com.tencent.tinker.c.a.v;
import com.tencent.tinker.c.b.a.a;
import com.tencent.tinker.c.b.a.c;
import com.tencent.tinker.c.b.a.d;
import com.tencent.tinker.c.b.a.e;
import com.tencent.tinker.c.b.a.f;
import com.tencent.tinker.c.b.a.g;

/* compiled from: ProGuard */
public final class h {
    final f a;

    public h(f fVar) {
        this.a = fVar;
    }

    public final short[] a(short[] sArr) throws v {
        a hVar = new com.tencent.tinker.c.b.a.h(sArr.length);
        e cVar = new c();
        e fVar = new f(hVar, cVar);
        d dVar = new d(new g(sArr));
        try {
            dVar.a(new g(this, cVar));
            dVar.a(new g(this, fVar));
            int i = hVar.b;
            if (i == hVar.c.length) {
                return hVar.c;
            }
            short[] sArr2 = new short[i];
            System.arraycopy(hVar.c, 0, sArr2, 0, i);
            return sArr2;
        } catch (Throwable e) {
            throw new v(e);
        }
    }
}
