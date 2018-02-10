package com.bumptech.glide.util.a;

import android.support.v4.d.m;
import android.support.v4.d.p;
import android.support.v4.d.q;
import java.util.List;

/* compiled from: ProGuard */
public final class h {
    private static final g<Object> a = new a();

    public static <T extends f> q<T> a(d<T> dVar) {
        return a(new m(150), (d) dVar);
    }

    public static <T extends f> q<T> a(int i, d<T> dVar) {
        return a(new p(i), (d) dVar);
    }

    private static <T> q<T> a(q<T> qVar, d<T> dVar, g<T> gVar) {
        return new e(qVar, dVar, gVar);
    }

    public static <T> q<List<T>> a() {
        return a(new p(20), new b(), new c());
    }

    private static <T extends f> q<T> a(q<T> qVar, d<T> dVar) {
        return a(qVar, dVar, a);
    }
}
