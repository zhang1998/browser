package com.ucpro.business.d;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class e extends c {
    private com.uc.base.b.c.c a;
    private ArrayList<b> b = new ArrayList();
    private com.uc.base.b.c.c c;
    private com.uc.base.b.c.c d;
    private ArrayList<f> e = new ArrayList();
    private com.uc.base.b.c.c f;
    private ArrayList<com.uc.base.b.c.c> g = new ArrayList();

    public final String c() {
        if (this.a == null) {
            return null;
        }
        return this.a.toString();
    }

    protected final m a() {
        m mVar = new m(i.w ? "Xhtml2" : "", 50);
        mVar.a(1, i.w ? "ptext" : "", 2, 12);
        mVar.a(2, i.w ? "pimgs" : "", 3, new b());
        mVar.a(3, i.w ? "ptitle" : "", 1, 12);
        mVar.a(4, i.w ? "psubtitle" : "", 1, 12);
        mVar.a(5, i.w ? "pconfs" : "", 3, new f());
        mVar.a(6, i.w ? "purl" : "", 1, 12);
        mVar.a(7, i.w ? "ucparam" : "", 3, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        Iterator it;
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        if (this.b != null) {
            it = this.b.iterator();
            while (it.hasNext()) {
                mVar.a(2, (b) it.next());
            }
        }
        if (this.c != null) {
            mVar.a(3, this.c);
        }
        if (this.d != null) {
            mVar.a(4, this.d);
        }
        if (this.e != null) {
            it = this.e.iterator();
            while (it.hasNext()) {
                mVar.a(5, (f) it.next());
            }
        }
        if (this.f != null) {
            mVar.a(6, this.f);
        }
        if (this.g != null) {
            it = this.g.iterator();
            while (it.hasNext()) {
                mVar.b(7, (com.uc.base.b.c.c) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        int i;
        int i2 = 0;
        this.a = mVar.a(1);
        this.b.clear();
        int j = mVar.j(2);
        for (i = 0; i < j; i++) {
            this.b.add((b) mVar.a(2, i, new b()));
        }
        this.c = mVar.a(3);
        this.d = mVar.a(4);
        this.e.clear();
        j = mVar.j(5);
        for (i = 0; i < j; i++) {
            this.e.add((f) mVar.a(5, i, new f()));
        }
        this.f = mVar.a(6);
        this.g.clear();
        i = mVar.j(7);
        while (i2 < i) {
            this.g.add((com.uc.base.b.c.c) mVar.c(7, i2));
            i2++;
        }
        return true;
    }

    protected final i a(int i) {
        return new e();
    }
}
