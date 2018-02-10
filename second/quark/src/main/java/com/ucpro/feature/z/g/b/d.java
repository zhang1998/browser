package com.ucpro.feature.z.g.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class d extends c {
    public int a;
    public com.uc.base.b.c.c b;
    private com.uc.base.b.c.c c;

    protected final m a() {
        m mVar = new m("UCLinkName", 50);
        mVar.a(1, "linkname", 1, 12);
        mVar.a(2, "linkflag", 1, 1);
        mVar.a(3, "linkid", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.c != null) {
            mVar.a(1, this.c);
        }
        mVar.a(2, this.a);
        if (this.b != null) {
            mVar.a(3, this.b);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.c = mVar.a(1);
        this.a = mVar.c(2);
        this.b = mVar.a(3);
        return true;
    }

    protected final i a(int i) {
        return new d();
    }
}
