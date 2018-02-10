package com.uc.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class h extends c {
    public ArrayList<e> a = new ArrayList();
    public com.uc.base.b.c.c b;
    public com.uc.base.b.c.c c;
    public com.uc.base.b.c.c d;
    public com.uc.base.b.c.c e;
    public com.uc.base.b.c.c f;
    public int g;
    public f h;
    public ArrayList<g> i = new ArrayList();

    protected final m a() {
        m mVar = new m(i.w ? "UsData" : "", 50);
        mVar.a(1, i.w ? "items" : "", 3, new e());
        mVar.a(2, i.w ? "us_url_next" : "", 1, 12);
        mVar.a(3, i.w ? "sn" : "", 1, 12);
        mVar.a(4, i.w ? "dn" : "", 1, 12);
        mVar.a(5, i.w ? "ext_param" : "", 1, 12);
        mVar.a(6, i.w ? "cp_param" : "", 1, 12);
        mVar.a(7, i.w ? "st_flag" : "", 1, 1);
        mVar.a(8, i.w ? "url_cmd" : "", 1, new f());
        mVar.a(9, i.w ? "key_value" : "", 3, new g());
        return mVar;
    }

    protected final boolean a(m mVar) {
        Iterator it;
        if (this.a != null) {
            it = this.a.iterator();
            while (it.hasNext()) {
                mVar.a(1, (e) it.next());
            }
        }
        if (this.b != null) {
            mVar.b(2, this.b);
        }
        if (this.c != null) {
            mVar.b(3, this.c);
        }
        if (this.d != null) {
            mVar.b(4, this.d);
        }
        if (this.e != null) {
            mVar.b(5, this.e);
        }
        if (this.f != null) {
            mVar.b(6, this.f);
        }
        mVar.a(7, this.g);
        if (this.h != null) {
            mVar.a(8, i.w ? "url_cmd" : "", this.h);
        }
        if (this.i != null) {
            it = this.i.iterator();
            while (it.hasNext()) {
                mVar.a(9, (g) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        int i;
        int i2 = 0;
        this.a.clear();
        int j = mVar.j(1);
        for (i = 0; i < j; i++) {
            this.a.add((e) mVar.a(1, i, new e()));
        }
        this.b = mVar.a(2);
        this.c = mVar.a(3);
        this.d = mVar.a(4);
        this.e = mVar.a(5);
        this.f = mVar.a(6);
        this.g = mVar.b(7, 0);
        this.h = (f) new f().a(mVar, 8);
        this.i.clear();
        i = mVar.j(9);
        while (i2 < i) {
            this.i.add((g) mVar.a(9, i2, new g()));
            i2++;
        }
        return true;
    }

    protected final i a(int i) {
        return new h();
    }
}
