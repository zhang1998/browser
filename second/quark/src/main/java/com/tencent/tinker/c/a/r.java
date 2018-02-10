package com.tencent.tinker.c.a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: ProGuard */
final class r extends AbstractList<String> implements RandomAccess {
    final /* synthetic */ u a;

    private r(u uVar) {
        this.a = uVar;
    }

    public final /* synthetic */ Object get(int i) {
        return a(i);
    }

    public final String a(int i) {
        u.b(i, this.a.b.b.c);
        return this.a.a(this.a.a(this.a.b.b.d + (i * 4)).b.getInt()).b().a;
    }

    public final int size() {
        return this.a.b.b.c;
    }
}
