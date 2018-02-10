package com.ucpro.a.e;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class b extends c {
    public com.uc.base.b.c.c a;

    protected final m a() {
        m mVar = new m(i.w ? "PbString" : "", 50);
        mVar.a(1, i.w ? "val" : "", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
