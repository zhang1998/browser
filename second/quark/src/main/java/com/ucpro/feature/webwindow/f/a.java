package com.ucpro.feature.webwindow.f;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class a extends c {
    com.uc.base.b.c.c a;

    protected final m a() {
        m mVar = new m(i.w ? "JsHostItem" : "", 50);
        mVar.a(1, i.w ? "host" : "", 2, 12);
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
        return new a();
    }
}
