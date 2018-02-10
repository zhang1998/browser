package com.ucpro.feature.z.g.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.ucpro.services.d.a;

/* compiled from: ProGuard */
public final class m extends c {
    String a;
    String b;

    protected final com.uc.base.b.c.m a() {
        com.uc.base.b.c.m mVar = new com.uc.base.b.c.m("SearchEngineItemPB", 50);
        mVar.a(1, "id", 2, 13);
        mVar.a(2, "url", 2, 13);
        return mVar;
    }

    protected final boolean a(com.uc.base.b.c.m mVar) {
        if (this.a != null) {
            mVar.a(1, a.a(this.a));
        }
        if (this.b != null) {
            mVar.a(2, a.a(this.b));
        }
        return true;
    }

    protected final boolean b(com.uc.base.b.c.m mVar) {
        this.a = a.a(mVar.f(1));
        this.b = a.a(mVar.f(2));
        return true;
    }

    protected final i a(int i) {
        return new m();
    }
}
