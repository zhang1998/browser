package com.ucpro.services.d.b;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class c extends com.uc.base.b.c.b.c {
    public List<d> a;

    protected final m a() {
        m mVar = new m("CMSPBDataList", 50);
        mVar.a(1, "datas", 3, a.b());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            for (i a : this.a) {
                mVar.a(1, a);
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = new ArrayList();
        int j = mVar.j(1);
        for (int i = 0; i < j; i++) {
            this.a.add((d) mVar.a(1, i, a.b()));
        }
        return true;
    }

    protected final i a(int i) {
        return new c();
    }
}
