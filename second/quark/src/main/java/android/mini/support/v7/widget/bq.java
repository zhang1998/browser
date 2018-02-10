package android.mini.support.v7.widget;

import android.mini.support.annotation.Nullable;
import android.mini.support.v4.d.n;
import android.mini.support.v4.d.o;

/* compiled from: ProGuard */
final class bq {
    static n<bq> d = new o(20);
    int a;
    @Nullable
    ar b;
    @Nullable
    ar c;

    private bq() {
    }

    static bq a() {
        bq bqVar = (bq) d.a();
        return bqVar == null ? new bq() : bqVar;
    }

    static void a(bq bqVar) {
        bqVar.a = 0;
        bqVar.b = null;
        bqVar.c = null;
        d.a(bqVar);
    }

    static void b() {
        do {
        } while (d.a() != null);
    }
}
