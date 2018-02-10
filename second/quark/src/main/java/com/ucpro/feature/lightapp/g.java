package com.ucpro.feature.lightapp;

import com.ucpro.base.c.b.a;
import com.ucpro.base.c.b.m;
import com.ucpro.base.weex.c;

/* compiled from: ProGuard */
public final class g extends c {
    private a a;
    private l b;

    public g(m mVar, a aVar, c cVar, l lVar) {
        super(mVar, cVar);
        this.a = aVar;
        this.b = lVar;
    }

    protected final void a() {
        this.b.b(this.e.b());
    }

    public final void f() {
        a(true);
    }

    public final String b() {
        if (this.a.a() != null) {
            return this.a.a().getTitle();
        }
        return "";
    }

    public final String c() {
        if (this.a.a() == null || !(this.a.a() instanceof n)) {
            return "";
        }
        return ((n) this.a.a()).getUrl();
    }
}
