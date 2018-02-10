package com.uc.sync.b.c;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.uc.sync.b.a.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class b extends c {
    public int a;
    public ArrayList<a> b = new ArrayList();
    public ArrayList<d> c = new ArrayList();
    public int d = 1;

    protected final m a() {
        m mVar = new m("ResContentBody", 50);
        mVar.a(1, "sequence_no", 2, 1);
        mVar.a(2, "cmd_list", 3, new a());
        mVar.a(3, "cmd_res_list", 3, new d());
        mVar.a(4, "lastest", 2, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        Iterator it;
        mVar.a(1, this.a);
        if (this.b != null) {
            it = this.b.iterator();
            while (it.hasNext()) {
                mVar.a(2, (a) it.next());
            }
        }
        if (this.c != null) {
            it = this.c.iterator();
            while (it.hasNext()) {
                mVar.a(3, (d) it.next());
            }
        }
        mVar.a(4, this.d);
        return true;
    }

    protected final boolean b(m mVar) {
        int i;
        int i2 = 0;
        this.a = mVar.b(1, 0);
        this.b.clear();
        int j = mVar.j(2);
        for (i = 0; i < j; i++) {
            this.b.add((a) mVar.a(2, i, new a()));
        }
        this.c.clear();
        i = mVar.j(3);
        while (i2 < i) {
            this.c.add((d) mVar.a(3, i2, new d()));
            i2++;
        }
        this.d = mVar.b(4, 1);
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
