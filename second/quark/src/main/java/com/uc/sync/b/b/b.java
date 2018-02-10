package com.uc.sync.b.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class b extends c {
    public c a;
    public ArrayList<a> b = new ArrayList();

    protected final m a() {
        m mVar = new m("SyncReq", 50);
        mVar.a(1, "sync_req_head", 2, new c());
        mVar.a(2, "req_content_list", 3, new a());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, "sync_req_head", this.a);
        }
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                mVar.a(2, (a) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = (c) new c().a(mVar, 1);
        this.b.clear();
        int j = mVar.j(2);
        for (int i = 0; i < j; i++) {
            this.b.add((a) mVar.a(2, i, new a()));
        }
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
