package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.v4.d.m;
import android.support.v4.d.q;

/* compiled from: ProGuard */
final class a {
    static q<a> d = new m(20);
    int a;
    @Nullable
    m b;
    @Nullable
    m c;

    private a() {
    }

    static a a() {
        a aVar = (a) d.a();
        return aVar == null ? new a() : aVar;
    }

    static void a(a aVar) {
        aVar.a = 0;
        aVar.b = null;
        aVar.c = null;
        d.a(aVar);
    }

    static void b() {
        do {
        } while (d.a() != null);
    }
}
