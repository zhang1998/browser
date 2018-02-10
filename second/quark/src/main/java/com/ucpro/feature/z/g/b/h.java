package com.ucpro.feature.z.g.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class h extends c {
    public com.uc.base.b.c.c a;
    public byte[] b;
    private com.uc.base.b.c.c c;
    private com.uc.base.b.c.c d;
    private com.uc.base.b.c.c e;

    public final String c() {
        if (this.c == null) {
            return null;
        }
        return this.c.toString();
    }

    public final String e() {
        if (this.d == null) {
            return null;
        }
        return this.d.toString();
    }

    protected final m a() {
        m mVar = new m("UCLinkItem", 50);
        mVar.a(1, "linkname", 1, 12);
        mVar.a(2, "linkurl", 1, 12);
        mVar.a(3, "linkdata", 1, 13);
        mVar.a(4, "linkid", 1, 12);
        mVar.a(5, "linkurl2", 1, 12);
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
        if (this.d != null) {
            mVar.a(4, this.d);
        }
        if (this.e != null) {
            mVar.a(5, this.e);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.c = mVar.a(1);
        this.a = mVar.a(2);
        this.b = mVar.f(3);
        this.d = mVar.a(4);
        this.e = mVar.a(5);
        return true;
    }

    protected final i a(int i) {
        return new h();
    }
}
