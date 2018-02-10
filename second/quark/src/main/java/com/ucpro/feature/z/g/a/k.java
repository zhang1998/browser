package com.ucpro.feature.z.g.a;

import com.d.a.a.a;
import com.d.a.a.b;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class k extends c {
    com.uc.base.b.c.c a;
    b b;
    a c;

    protected final m a() {
        m mVar = new m("CloudAssociateRequest", 50);
        mVar.a(1, "keyword", 2, 12);
        mVar.a(2, "pack_info", 2, new b());
        mVar.a(3, "mobile_info", 2, new a());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        if (this.b != null) {
            mVar.a(2, "pack_info", this.b);
        }
        if (this.c != null) {
            mVar.a(3, "mobile_info", this.c);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = (b) new b().a(mVar, 2);
        this.c = (a) new a().a(mVar, 3);
        return true;
    }

    protected final i a(int i) {
        return new k();
    }
}
