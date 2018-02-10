package com.ucpro.feature.z.g.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class b extends c {
    public ArrayList<h> a = new ArrayList();
    public ArrayList<c> b = new ArrayList();

    protected final m a() {
        m mVar = new m("UCLinkGroup", 50);
        mVar.a(1, "items", 3, new h());
        mVar.a(2, "linktype", 3, new c());
        return mVar;
    }

    protected final boolean a(m mVar) {
        Iterator it;
        if (this.a != null) {
            it = this.a.iterator();
            while (it.hasNext()) {
                mVar.a(1, (h) it.next());
            }
        }
        if (this.b != null) {
            it = this.b.iterator();
            while (it.hasNext()) {
                mVar.a(2, (c) it.next());
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
            this.a.add((h) mVar.a(1, i, new h()));
        }
        this.b.clear();
        i = mVar.j(2);
        while (i2 < i) {
            this.b.add((c) mVar.a(2, i2, new c()));
            i2++;
        }
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
