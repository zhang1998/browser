package com.ucpro.feature.bookmarkhis.bookmark.a;

import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.ucpro.feature.g.a;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class f {
    public s a;
    volatile boolean b = false;

    public f(s sVar) {
        this.a = sVar;
    }

    public final synchronized void a(af afVar) {
        if (!this.b) {
            this.b = true;
            a.a(new n(this, afVar));
        }
    }

    public static m a(String str) {
        return (m) z.a(new b[0]).a(m.class).a(y.w.a((Object) str)).d();
    }

    public static void a() {
        FlowManager.c(e.class).a().a();
    }

    public static void b() {
        com.raizlabs.android.dbflow.structure.database.b a = FlowManager.c(e.class).a();
        a.b();
        a.c();
    }

    public static int c() {
        return d.a().getSharedPreferences("__anchor", 0).getInt("bk_anchor", -1);
    }

    public static void a(int i) {
        d.a().getSharedPreferences("__anchor", 0).edit().putInt("bk_anchor", i).apply();
    }
}
