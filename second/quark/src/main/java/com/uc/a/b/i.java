package com.uc.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class i extends c {
    private com.uc.base.b.c.c a;
    private com.uc.base.b.c.c b;
    private int c;
    private int d;
    private int e;
    private int f;

    protected final m a() {
        m mVar = new m(com.uc.base.b.c.i.w ? "UsLbsInfo" : "", 50);
        mVar.a(1, com.uc.base.b.c.i.w ? "mnc" : "", 2, 12);
        mVar.a(2, com.uc.base.b.c.i.w ? "mcc" : "", 2, 12);
        mVar.a(3, com.uc.base.b.c.i.w ? "lac" : "", 2, 1);
        mVar.a(4, com.uc.base.b.c.i.w ? "cid1" : "", 1, 1);
        mVar.a(5, com.uc.base.b.c.i.w ? "cid2" : "", 1, 1);
        mVar.a(6, com.uc.base.b.c.i.w ? "cid3" : "", 1, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.b(1, this.a);
        }
        if (this.b != null) {
            mVar.b(2, this.b);
        }
        mVar.a(3, this.c);
        mVar.a(4, this.d);
        mVar.a(5, this.e);
        mVar.a(6, this.f);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.a(2);
        this.c = mVar.b(3, 0);
        this.d = mVar.b(4, 0);
        this.e = mVar.b(5, 0);
        this.f = mVar.b(6, 0);
        return true;
    }

    protected final com.uc.base.b.c.i a(int i) {
        return new i();
    }
}
