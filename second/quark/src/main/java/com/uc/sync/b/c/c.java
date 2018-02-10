package com.uc.sync.b.c;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class c extends com.uc.base.b.c.b.c {
    public e a;
    public ArrayList<f> b = new ArrayList();

    protected final m a() {
        m mVar = new m("SyncRes", 50);
        mVar.a(1, "sync_res_head", 2, new e());
        mVar.a(2, "res_content_list", 3, new f());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, "sync_res_head", this.a);
        }
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                mVar.a(2, (f) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = (e) new e().a(mVar, 1);
        this.b.clear();
        int j = mVar.j(2);
        for (int i = 0; i < j; i++) {
            this.b.add((f) mVar.a(2, i, new f()));
        }
        return true;
    }

    protected final i a(int i) {
        return new c();
    }
}
