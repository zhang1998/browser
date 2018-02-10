package com.ucpro.a.e;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.uc.media.interfaces.IProxyHandler;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class c extends com.uc.base.b.c.b.c {
    public com.uc.base.b.c.c a;
    public com.uc.base.b.c.c b;
    public com.uc.base.b.c.c c;
    public com.uc.base.b.c.c d;
    public com.uc.base.b.c.c e;
    public ArrayList<b> f = new ArrayList();

    protected final m a() {
        m mVar = new m(i.w ? "PbHiddenDomain" : "", 50);
        mVar.a(1, i.w ? "domain" : "", 2, 12);
        mVar.a(2, i.w ? IProxyHandler.KEY_USER_AGENT : "", 1, 12);
        mVar.a(3, i.w ? "switch1" : "", 1, 12);
        mVar.a(4, i.w ? "switch2" : "", 1, 12);
        mVar.a(5, i.w ? "switch3" : "", 1, 12);
        mVar.a(6, i.w ? "referDomainList" : "", 3, new b());
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
        if (this.f != null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                mVar.a(6, (b) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.a(2);
        this.c = mVar.a(3);
        this.d = mVar.a(4);
        this.e = mVar.a(5);
        this.f.clear();
        int j = mVar.j(6);
        for (int i = 0; i < j; i++) {
            this.f.add((b) mVar.a(6, i, new b()));
        }
        return true;
    }

    protected final i a(int i) {
        return new c();
    }
}
