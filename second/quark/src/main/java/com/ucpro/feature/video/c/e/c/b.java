package com.ucpro.feature.video.c.e.c;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class b extends c {
    public com.uc.base.b.c.c a;
    public ArrayList<d> b = new ArrayList();
    private com.uc.base.b.c.c c;
    private com.uc.base.b.c.c d;
    private ArrayList<com.ucpro.feature.video.c.e.a.b> e = new ArrayList();

    protected final m a() {
        m mVar = new m(i.w ? "FLVInfo" : "", 50);
        mVar.a(1, i.w ? "resolution" : "", 1, 12);
        mVar.a(2, i.w ? "fragment" : "", 3, new d());
        mVar.a(3, i.w ? "lang_name" : "", 1, 12);
        mVar.a(4, i.w ? "format" : "", 1, 12);
        mVar.a(5, i.w ? "headers" : "", 3, new com.ucpro.feature.video.c.e.a.b());
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
                mVar.a(2, (d) it.next());
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
                mVar.a(5, (com.ucpro.feature.video.c.e.a.b) it.next());
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
            this.b.add((d) mVar.a(2, i, new d()));
        }
        this.c = mVar.a(3);
        this.d = mVar.a(4);
        this.e.clear();
        i = mVar.j(5);
        while (i2 < i) {
            this.e.add((com.ucpro.feature.video.c.e.a.b) mVar.a(5, i2, new com.ucpro.feature.video.c.e.a.b()));
            i2++;
        }
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
