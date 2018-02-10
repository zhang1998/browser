package com.ucpro.business.d;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class d extends c {
    public ArrayList<c> a = new ArrayList();

    protected final m a() {
        m mVar = new m(i.w ? "HostList" : "", 50);
        mVar.a(1, i.w ? "hosts" : "", 3, new c());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                mVar.a(1, (c) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a.clear();
        int j = mVar.j(1);
        for (int i = 0; i < j; i++) {
            this.a.add((c) mVar.a(1, i, new c()));
        }
        return true;
    }

    protected final i a(int i) {
        return new d();
    }
}
