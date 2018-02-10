package com.ucpro.base.e;

import java.util.AbstractList;

/* compiled from: ProGuard */
final class c extends AbstractList<Integer> {
    final /* synthetic */ int[] a;

    c(int[] iArr) {
        this.a = iArr;
    }

    public final int size() {
        return this.a.length;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(this.a[i]);
    }
}
