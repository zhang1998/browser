package com.tencent.tinker.c.a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: ProGuard */
final class p extends AbstractList<ae> implements RandomAccess {
    final /* synthetic */ u a;

    private p(u uVar) {
        this.a = uVar;
    }

    public final int size() {
        return this.a.b.d.c;
    }

    public final /* synthetic */ Object get(int i) {
        u.b(i, this.a.b.d.c);
        return this.a.a(this.a.b.d.d + (i * 12)).f();
    }
}
