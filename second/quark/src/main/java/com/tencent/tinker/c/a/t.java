package com.tencent.tinker.c.a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: ProGuard */
final class t extends AbstractList<String> implements RandomAccess {
    final /* synthetic */ u a;

    private t(u uVar) {
        this.a = uVar;
    }

    public final int size() {
        return this.a.b.c.c;
    }

    public final /* synthetic */ Object get(int i) {
        return this.a.d.a(this.a.b(i));
    }
}
