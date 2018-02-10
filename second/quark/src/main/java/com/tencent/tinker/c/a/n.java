package com.tencent.tinker.c.a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: ProGuard */
final class n extends AbstractList<aa> implements RandomAccess {
    final /* synthetic */ u a;

    private n(u uVar) {
        this.a = uVar;
    }

    public final int size() {
        return this.a.b.e.c;
    }

    public final /* synthetic */ Object get(int i) {
        u.b(i, this.a.b.e.c);
        return this.a.a(this.a.b.e.d + (i * 8)).d();
    }
}
