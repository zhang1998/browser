package com.ucpro.feature.z.g.b;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class c extends com.uc.base.b.c.b.c {
    public ArrayList<d> a = new ArrayList();
    public com.uc.base.b.c.c b;
    private com.uc.base.b.c.c c;

    protected final m a() {
        m mVar = new m("UCLinkType", 50);
        mVar.a(1, "typename", 1, 12);
        mVar.a(2, "linkname", 3, new d());
        mVar.a(3, "searchtag", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.c != null) {
            mVar.a(1, this.c);
        }
        if (this.a != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                mVar.a(2, (d) it.next());
            }
        }
        if (this.b != null) {
            mVar.a(3, this.b);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.c = mVar.a(1);
        this.a.clear();
        int j = mVar.j(2);
        for (int i = 0; i < j; i++) {
            this.a.add((d) mVar.a(2, i, new d()));
        }
        this.b = mVar.a(3);
        return true;
    }

    protected final i a(int i) {
        return new c();
    }
}
