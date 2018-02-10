package com.tencent.tinker.c.a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: ProGuard */
final class o extends AbstractList<ac> implements RandomAccess {
    final /* synthetic */ u a;

    private o(u uVar) {
        this.a = uVar;
    }

    public final int size() {
        return this.a.b.f.c;
    }

    public final /* synthetic */ Object get(int i) {
        u.b(i, this.a.b.f.c);
        return this.a.a(this.a.b.f.d + (i * 8)).e();
    }
}
