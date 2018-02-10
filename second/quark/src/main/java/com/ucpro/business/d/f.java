package com.ucpro.business.d;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class f extends c {
    private com.uc.base.b.c.c a;
    private com.uc.base.b.c.c b;
    private com.uc.base.b.c.c c;
    private com.uc.base.b.c.c d;
    private com.uc.base.b.c.c e;

    protected final m a() {
        m mVar = new m(i.w ? "PageConfig" : "", 50);
        mVar.a(1, i.w ? "conf_name" : "", 2, 12);
        mVar.a(2, i.w ? "conf_value" : "", 2, 12);
        mVar.a(3, i.w ? "stime" : "", 1, 12);
        mVar.a(4, i.w ? "etime" : "", 1, 12);
        mVar.a(5, i.w ? "tmp_value" : "", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        if (this.b != null) {
            mVar.a(2, this.b);
        }
        if (this.c != null) {
            mVar.a(3, this.c);
        }
        if (this.d != null) {
            mVar.a(4, this.d);
        }
        if (this.e != null) {
            mVar.a(5, this.e);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.a(2);
        this.c = mVar.a(3);
        this.d = mVar.a(4);
        this.e = mVar.a(5);
        return true;
    }

    protected final i a(int i) {
        return new f();
    }
}
