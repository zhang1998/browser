package com.uc.a.b;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class c extends com.uc.base.b.c.b.c {
    private int a;
    private int b;

    protected final m a() {
        m mVar = new m(i.w ? "UsGpsInfo" : "", 50);
        mVar.a(1, i.w ? "lat" : "", 2, 1);
        mVar.a(2, i.w ? "lon" : "", 2, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, this.a);
        mVar.a(2, this.b);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.b(1, 0);
        this.b = mVar.b(2, 0);
        return true;
    }

    protected final i a(int i) {
        return new c();
    }
}
