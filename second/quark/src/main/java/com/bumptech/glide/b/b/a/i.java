package com.bumptech.glide.b.b.a;

import android.support.annotation.Nullable;
import java.util.List;

/* compiled from: ProGuard */
final class i<K, V> {
    final K a;
    List<V> b;
    i<K, V> c;
    i<K, V> d;

    public i() {
        this(null);
    }

    public i(K k) {
        this.d = this;
        this.c = this;
        this.a = k;
    }

    @Nullable
    public final V a() {
        int b = b();
        return b > 0 ? this.b.remove(b - 1) : null;
    }

    public final int b() {
        return this.b != null ? this.b.size() : 0;
    }
}
