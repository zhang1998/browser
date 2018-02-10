package com.ucpro.feature.navigation.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class k extends c {
    ArrayList<p> a = new ArrayList();

    protected final m a() {
        m mVar = new m(i.w ? "NaviIconResponse" : "", 50);
        mVar.a(1, i.w ? "icons" : "", 3, new p());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                mVar.a(1, (p) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a.clear();
        int j = mVar.j(1);
        for (int i = 0; i < j; i++) {
            this.a.add((p) mVar.a(1, i, new p()));
        }
        return true;
    }

    protected final i a(int i) {
        return new k();
    }
}
