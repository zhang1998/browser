package com.ucpro.feature.s.a;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.ucpro.services.d.a;

/* compiled from: ProGuard */
public final class f extends c {
    final /* synthetic */ a a;

    public f(a aVar) {
        this.a = aVar;
    }

    protected final m a() {
        m mVar = new m("DiscoveryNaviCmsData", 50);
        mVar.a(1, "file_url", 1, 13);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a.a != null) {
            mVar.a(1, a.a(this.a.a));
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a.a = a.a(mVar.f(1));
        return true;
    }

    protected final i a(int i) {
        return new f(this.a);
    }
}
