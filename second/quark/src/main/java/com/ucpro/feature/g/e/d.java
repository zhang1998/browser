package com.ucpro.feature.g.e;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class d extends c {
    int a;
    int b;
    int c;
    int d;

    protected final m a() {
        m mVar = new m("BOOKMARK_PARALIST", 50);
        mVar.a(1, "flag_title", 1, 1);
        mVar.a(2, "flag_device_platform", 1, 1);
        mVar.a(3, "flag_index", 1, 1);
        mVar.a(4, "flag_create_time", 1, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, this.a);
        mVar.a(2, this.b);
        mVar.a(3, this.c);
        mVar.a(4, this.d);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.c(1);
        this.b = mVar.c(2);
        this.c = mVar.c(3);
        this.d = mVar.c(4);
        return true;
    }

    protected final i a(int i) {
        return new d();
    }
}
