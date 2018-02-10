package com.bumptech.glide.util.a;

import android.support.v4.d.q;
import android.util.Log;

/* compiled from: ProGuard */
final class e<T> implements q<T> {
    private final d<T> a;
    private final g<T> b;
    private final q<T> c;

    e(q<T> qVar, d<T> dVar, g<T> gVar) {
        this.c = qVar;
        this.a = dVar;
        this.b = gVar;
    }

    public final T a() {
        T a = this.c.a();
        if (a == null) {
            a = this.a.a();
            if (Log.isLoggable("FactoryPools", 2)) {
                new StringBuilder("Created new ").append(a.getClass());
            }
        }
        if (a instanceof f) {
            ((f) a).m_().a(false);
        }
        return a;
    }

    public final boolean a(T t) {
        if (t instanceof f) {
            ((f) t).m_().a(true);
        }
        this.b.a(t);
        return this.c.a(t);
    }
}
