package com.ucpro.feature.video.c.e.a;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a extends c {
    public com.uc.base.b.c.c a;
    public com.uc.base.b.c.c b;
    public byte[] c;
    public ArrayList<b> d = new ArrayList();
    public ArrayList<b> e = new ArrayList();
    private com.uc.base.b.c.c f;

    protected final m a() {
        m mVar = new m(i.w ? "PageInfo" : "", 50);
        mVar.a(1, i.w ? "errog_msg" : "", 1, 12);
        mVar.a(2, i.w ? "id" : "", 2, 12);
        mVar.a(3, i.w ? "url" : "", 2, 12);
        mVar.a(4, i.w ? "content" : "", 1, 13);
        mVar.a(5, i.w ? "cookies" : "", 3, new b());
        mVar.a(6, i.w ? "headers" : "", 3, new b());
        return mVar;
    }

    protected final boolean a(m mVar) {
        Iterator it;
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        if (this.f != null) {
            mVar.a(2, this.f);
        }
        if (this.b != null) {
            mVar.a(3, this.b);
        }
        if (this.c != null) {
            mVar.a(4, this.c);
        }
        if (this.d != null) {
            it = this.d.iterator();
            while (it.hasNext()) {
                mVar.a(5, (b) it.next());
            }
        }
        if (this.e != null) {
            it = this.e.iterator();
            while (it.hasNext()) {
                mVar.a(6, (b) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        int i;
        int i2 = 0;
        this.a = mVar.a(1);
        this.f = mVar.a(2);
        this.b = mVar.a(3);
        this.c = mVar.f(4);
        this.d.clear();
        int j = mVar.j(5);
        for (i = 0; i < j; i++) {
            this.d.add((b) mVar.a(5, i, new b()));
        }
        this.e.clear();
        i = mVar.j(6);
        while (i2 < i) {
            this.e.add((b) mVar.a(6, i2, new b()));
            i2++;
        }
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
