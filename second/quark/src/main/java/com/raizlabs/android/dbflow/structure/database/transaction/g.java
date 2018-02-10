package com.raizlabs.android.dbflow.structure.database.transaction;

import android.os.Handler;
import android.os.Looper;
import com.raizlabs.android.dbflow.config.c;

/* compiled from: ProGuard */
public final class g {
    private static Handler h;
    final b a;
    final c b;
    final a c;
    public final c d;
    final String e;
    final boolean f;
    final boolean g;

    static Handler a() {
        if (h == null) {
            h = new Handler(Looper.getMainLooper());
        }
        return h;
    }

    g(f fVar) {
        this.d = fVar.b;
        this.a = fVar.c;
        this.b = fVar.d;
        this.c = fVar.a;
        this.e = fVar.e;
        this.f = fVar.f;
        this.g = fVar.g;
    }

    public final void b() {
        this.d.e.a.a(this);
    }
}
