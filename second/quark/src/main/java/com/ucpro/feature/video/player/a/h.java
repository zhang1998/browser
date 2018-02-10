package com.ucpro.feature.video.player.a;

/* compiled from: ProGuard */
public final class h<T extends e> {
    static final Object a = new Object();
    final c<T> b;
    final int c = 16;
    int d;
    T e;

    public h(c<T> cVar) {
        this.b = cVar;
    }

    public static void a(T t) {
        if (t.c() != null) {
            throw new RuntimeException(t + " is recycled");
        }
    }
}
