package com.tencent.tinker.c.a;

import java.util.AbstractList;
import java.util.RandomAccess;

/* compiled from: ProGuard */
final class s extends AbstractList<Integer> implements RandomAccess {
    final /* synthetic */ u a;

    private s(u uVar) {
        this.a = uVar;
    }

    public final int size() {
        return this.a.b.c.c;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(this.a.b(i));
    }
}
