package com.ucpro.feature.navigation.b;

import com.d.a.a.b;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a extends c {
    b a;
    com.d.a.a.a b;
    int c;
    int d;
    byte[] e;
    ArrayList<byte[]> f = new ArrayList();

    protected final m a() {
        m mVar = new m(i.w ? "NaviIconRequest" : "", 50);
        mVar.a(1, i.w ? "pack_info" : "", 2, new b());
        mVar.a(2, i.w ? "mobile_info" : "", 2, new com.d.a.a.a());
        mVar.a(3, i.w ? "img_width" : "", 2, 1);
        mVar.a(4, i.w ? "img_height" : "", 2, 1);
        mVar.a(5, i.w ? "format" : "", 2, 13);
        mVar.a(6, i.w ? "url" : "", 3, 13);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, i.w ? "pack_info" : "", this.a);
        }
        if (this.b != null) {
            mVar.a(2, i.w ? "mobile_info" : "", this.b);
        }
        mVar.a(3, this.c);
        mVar.a(4, this.d);
        if (this.e != null) {
            mVar.a(5, this.e);
        }
        if (this.f != null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                mVar.a((byte[]) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = (b) new b().a(mVar, 1);
        this.b = (com.d.a.a.a) new com.d.a.a.a().a(mVar, 2);
        this.c = mVar.c(3);
        this.d = mVar.c(4);
        this.e = mVar.f(5);
        this.f.clear();
        int j = mVar.j(6);
        for (int i = 0; i < j; i++) {
            this.f.add((byte[]) mVar.c(6, i));
        }
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
