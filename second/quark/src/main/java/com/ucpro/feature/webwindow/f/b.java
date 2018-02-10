package com.ucpro.feature.webwindow.f;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class b extends c {
    com.uc.base.b.c.c a;
    com.uc.base.b.c.c b;
    int c;
    ArrayList<a> d = new ArrayList();

    protected final m a() {
        m mVar = new m(i.w ? "JsInjectItem" : "", 50);
        mVar.a(1, i.w ? "src" : "", 2, 12);
        mVar.a(2, i.w ? "time" : "", 2, 12);
        mVar.a(3, i.w ? "pri" : "", 2, 1);
        mVar.a(4, i.w ? "hosts" : "", 3, new a());
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        if (this.b != null) {
            mVar.a(2, this.b);
        }
        mVar.a(3, this.c);
        if (this.d != null) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                mVar.a(4, (a) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.a(2);
        this.c = mVar.c(3);
        this.d.clear();
        int j = mVar.j(4);
        for (int i = 0; i < j; i++) {
            this.d.add((a) mVar.a(4, i, new a()));
        }
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
