package com.tencent.tinker.c.a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: ProGuard */
final class m extends AbstractList<h> implements RandomAccess {
    final /* synthetic */ u a;

    private m(u uVar) {
        this.a = uVar;
    }

    public final int size() {
        return this.a.b.g.c;
    }

    public final /* synthetic */ Object get(int i) {
        u.b(i, this.a.b.g.c);
        return this.a.a(this.a.b.g.d + (i * 32)).g();
    }
}
