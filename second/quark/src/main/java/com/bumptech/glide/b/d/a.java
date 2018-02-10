package com.bumptech.glide.b.d;

import com.bumptech.glide.b.b.au;
import com.bumptech.glide.util.j;

/* compiled from: ProGuard */
public class a<T> implements au<T> {
    protected final T a;

    public a(T t) {
        this.a = j.a((Object) t, "Argument must not be null");
    }

    public final Class<T> a() {
        return this.a.getClass();
    }

    public final T b() {
        return this.a;
    }

    public final int c() {
        return 1;
    }

    public final void d() {
    }
}
