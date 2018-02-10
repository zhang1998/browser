package com.uc.sync.b.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class a extends c {
    public d a;
    public e b;

    protected final m a() {
        m mVar = new m("ReqContent", 50);
        mVar.a(1, "req_content_head", 2, new d());
        mVar.a(2, "req_content_body", 1, new e());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, "req_content_head", this.a);
        }
        if (this.b != null) {
            mVar.a(2, "req_content_body", this.b);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = (d) new d().a(mVar, 1);
        this.b = (e) new e().a(mVar, 2);
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
