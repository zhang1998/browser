package com.ucpro.business.d;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class g extends c {
    public com.uc.base.b.c.c a;
    public com.uc.base.b.c.c b;
    private com.uc.base.b.c.c c;

    protected final m a() {
        m mVar = new m(i.w ? "UsUcParamItem" : "", 50);
        mVar.a(1, i.w ? "type" : "", 1, 12);
        mVar.a(2, i.w ? "name" : "", 2, 12);
        mVar.a(3, i.w ? "value" : "", 2, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.c != null) {
            mVar.a(1, this.c);
        }
        if (this.a != null) {
            mVar.a(2, this.a);
        }
        if (this.b != null) {
            mVar.a(3, this.b);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.c = mVar.a(1);
        this.a = mVar.a(2);
        this.b = mVar.a(3);
        return true;
    }

    protected final i a(int i) {
        return new g();
    }
}
