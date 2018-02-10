package com.ucpro.feature.s;

import android.text.TextUtils;
import android.view.View;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.webwindow.aj;
import com.ucweb.common.util.i.f;

/* compiled from: ProGuard */
public final class d implements a {
    f a;
    final m b;
    int c;

    public d(m mVar, f fVar) {
        this.b = mVar;
        this.a = fVar;
    }

    public final void b() {
        g();
        e.a(5);
    }

    public final void c() {
        g();
        e.a(4);
    }

    public final void d() {
        e.a();
    }

    public final void e() {
        g();
        e.a(2);
    }

    public final void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            g();
            Object ajVar = new aj();
            if (str3.contains("douban.com")) {
                ajVar.o = f.k(str3);
            } else {
                ajVar.o = "ext:a:" + f.k(str3);
            }
            if (this.c == 1) {
                g.a().a(e.cS, ajVar.o);
            } else {
                g.a().a(e.k, ajVar, 300);
            }
            e.a(str, str2, str3);
            e.a(3);
        }
    }

    public final void a(String str) {
        e.a(str);
    }

    public final void f() {
        e.a(1);
    }

    private void g() {
        this.a.g();
    }

    public final void a() {
        this.b.b((View) this.a);
        this.a = null;
    }
}
