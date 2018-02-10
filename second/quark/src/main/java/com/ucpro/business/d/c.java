package com.ucpro.business.d;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class c extends com.uc.base.b.c.b.c {
    private int a;
    private com.uc.base.b.c.c b;

    public final String c() {
        if (this.b == null) {
            return null;
        }
        return this.b.toString();
    }

    protected final m a() {
        m mVar = new m(i.w ? "HostItem" : "", 50);
        mVar.a(1, i.w ? "oper" : "", 2, 1);
        mVar.a(2, i.w ? "host" : "", 2, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, this.a);
        if (this.b != null) {
            mVar.a(2, this.b);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.c(1);
        this.b = mVar.a(2);
        return true;
    }

    protected final i a(int i) {
        return new c();
    }
}
