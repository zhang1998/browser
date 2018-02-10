package com.airbnb.lottie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
abstract class bm<V, O> implements ag<O> {
    final List<p<V>> a;
    final V b;

    bm(V v) {
        this(Collections.emptyList(), v);
    }

    bm(List<p<V>> list, V v) {
        this.a = list;
        this.b = v;
    }

    O a(V v) {
        return v;
    }

    public final boolean c() {
        return !this.a.isEmpty();
    }

    public O d() {
        return a(this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parseInitialValue=").append(this.b);
        if (!this.a.isEmpty()) {
            stringBuilder.append(", values=").append(Arrays.toString(this.a.toArray()));
        }
        return stringBuilder.toString();
    }
}
