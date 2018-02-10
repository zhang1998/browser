package com.ucpro.e;

import android.app.Activity;
import com.ucpro.base.a;
import com.ucpro.base.c.b;
import com.ucpro.business.e.d.g;
import com.ucpro.business.stat.m;
import com.ucpro.c.c;
import com.ucpro.feature.i.f;
import com.ucpro.feature.i.k;
import com.ucweb.common.util.d;
import java.io.File;

/* compiled from: ProGuard */
public final class h implements a {
    private Activity a;
    private b b;
    private int c = -1;

    public h(Activity activity, b bVar) {
        this.a = activity;
        this.b = bVar;
    }

    public final void c() {
        long a = com.ucweb.common.util.k.a.a(new File(d.a().getApplicationInfo().dataDir), 10) / 1048576;
        m.a("destory", "private_cache", "mode", String.valueOf(d()), "size", String.valueOf(a));
        if (c.b() != null && c.b().exists()) {
            a = com.ucweb.common.util.k.a.a(c.b(), 10) / 1048576;
            m.a("destory", "ucm_http_cache", "mode", String.valueOf(d()), "size", String.valueOf(a));
        }
        a = com.ucweb.common.util.k.a.a(c.b(), 10);
        long a2 = g.a().a("destory_clean_httpcache_size", 104857600);
        if (a2 != 0 && a > a2) {
            m.a("destory", "clean_http_cache", "mode", String.valueOf(d()));
            com.ucweb.common.util.h.m.a(0, new q(this));
        }
    }

    private int d() {
        if (-1 == this.c) {
            int i = com.ucpro.b.d.a.b() ? 0 : com.ucpro.b.d.a.c() ? 1 : 2;
            this.c = i;
        }
        return this.c;
    }

    public final void a() {
        k a = f.a;
        Activity activity = this.a;
        if (a.b()) {
            a.c.a(activity);
        }
    }

    public final void b() {
        k a = f.a;
        a.c.b(this.a);
    }
}
