package com.uc.sync.b.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.uc.sync.b.a.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class e extends c {
    public int a;
    public ArrayList<a> b = new ArrayList();
    public int c;

    protected final m a() {
        m mVar = new m("ReqContentBody", 50);
        mVar.a(1, "sequence_no", 2, 1);
        mVar.a(2, "cmd_list", 3, new a());
        mVar.a(3, "lastest", 2, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, this.a);
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                mVar.a(2, (a) it.next());
            }
        }
        mVar.a(3, this.c);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.b(1, 0);
        this.b.clear();
        int j = mVar.j(2);
        for (int i = 0; i < j; i++) {
            this.b.add((a) mVar.a(2, i, new a()));
        }
        this.c = mVar.b(3, 0);
        return true;
    }

    protected final i a(int i) {
        return new e();
    }
}
