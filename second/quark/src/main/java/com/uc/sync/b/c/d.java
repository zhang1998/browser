package com.uc.sync.b.c;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.uc.sync.b.a.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class d extends c {
    public int a;
    public int b;
    public ArrayList<b> c = new ArrayList();
    private int d;

    protected final m a() {
        m mVar = new m("CommandRes", 50);
        mVar.a(1, "cmd_res_id", 2, 1);
        mVar.a(2, "cmd_ref", 2, 1);
        mVar.a(3, "ret_code", 2, 1);
        mVar.a(4, "data_item_list", 3, new b());
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, this.d);
        mVar.a(2, this.a);
        mVar.a(3, this.b);
        if (this.c != null) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                mVar.a(4, (b) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.d = mVar.b(1, 0);
        this.a = mVar.b(2, 0);
        this.b = mVar.b(3, 0);
        this.c.clear();
        int j = mVar.j(4);
        for (int i = 0; i < j; i++) {
            this.c.add((b) mVar.a(4, i, new b()));
        }
        return true;
    }

    protected final i a(int i) {
        return new d();
    }
}
