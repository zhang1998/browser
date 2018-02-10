package com.ucpro.a.e;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a extends c {
    public ArrayList<c> a = new ArrayList();
    private ArrayList<b> b = new ArrayList();

    protected final m a() {
        m mVar = new m(i.w ? "PbHiddenDomainList" : "", 50);
        mVar.a(1, i.w ? "domainList" : "", 3, new c());
        mVar.a(2, i.w ? "refererList" : "", 3, new b());
        return mVar;
    }

    protected final boolean a(m mVar) {
        Iterator it;
        if (this.a != null) {
            it = this.a.iterator();
            while (it.hasNext()) {
                mVar.a(1, (c) it.next());
            }
        }
        if (this.b != null) {
            it = this.b.iterator();
            while (it.hasNext()) {
                mVar.a(2, (b) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        int i;
        int i2 = 0;
        this.a.clear();
        int j = mVar.j(1);
        for (i = 0; i < j; i++) {
            this.a.add((c) mVar.a(1, i, new c()));
        }
        this.b.clear();
        i = mVar.j(2);
        while (i2 < i) {
            this.b.add((b) mVar.a(2, i2, new b()));
            i2++;
        }
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
