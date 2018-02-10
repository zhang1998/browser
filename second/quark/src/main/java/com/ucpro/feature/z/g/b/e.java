package com.ucpro.feature.z.g.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class e extends c {
    final /* synthetic */ l a;

    public e(l lVar) {
        this.a = lVar;
    }

    protected final m a() {
        m mVar = new m("SearchEngineDataPB", 50);
        mVar.a(1, "searchEngines", 3, new m());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a.a != null) {
            Iterator it = this.a.a.iterator();
            while (it.hasNext()) {
                mVar.a(1, (m) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a.a.clear();
        int j = mVar.j(1);
        for (int i = 0; i < j; i++) {
            this.a.a.add((m) mVar.a(1, i, new m()));
        }
        return true;
    }

    protected final i a(int i) {
        return new e(this.a);
    }
}
