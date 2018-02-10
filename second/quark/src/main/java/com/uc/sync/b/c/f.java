package com.uc.sync.b.c;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class f extends c {
    public a a;
    public b b;

    protected final m a() {
        m mVar = new m("ResContent", 50);
        mVar.a(1, "res_content_head", 2, new a());
        mVar.a(2, "res_content_body", 1, new b());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, "res_content_head", this.a);
        }
        if (this.b != null) {
            mVar.a(2, "res_content_body", this.b);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = (a) new a().a(mVar, 1);
        this.b = (b) new b().a(mVar, 2);
        return true;
    }

    protected final i a(int i) {
        return new f();
    }
}
