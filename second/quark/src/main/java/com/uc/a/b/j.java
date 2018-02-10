package com.uc.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class j extends c {
    public k a;
    public a b;
    public com.uc.base.b.c.c c;
    public ArrayList<g> d = new ArrayList();
    public int e;
    public ArrayList<g> f = new ArrayList();
    public i g;
    public c h;
    public int i;
    public com.uc.base.b.c.c j;

    protected final m a() {
        m mVar = new m(i.w ? "UsUcwebParam" : "", 50);
        mVar.a(1, i.w ? "pack_info" : "", 1, new k());
        mVar.a(2, i.w ? "mobile_info" : "", 1, new a());
        mVar.a(3, i.w ? "ext_param" : "", 1, 12);
        mVar.a(4, i.w ? "res_state" : "", 3, new g());
        mVar.a(5, i.w ? "pop_flag" : "", 1, 1);
        mVar.a(6, i.w ? "key_value" : "", 3, new g());
        mVar.a(7, i.w ? "lbs_info" : "", 1, new i());
        mVar.a(8, i.w ? "gps_info" : "", 1, new c());
        mVar.a(9, i.w ? "zip_capable" : "", 1, 1);
        mVar.a(10, i.w ? "cp_param" : "", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        Iterator it;
        if (this.a != null) {
            mVar.a(1, i.w ? "pack_info" : "", this.a);
        }
        if (this.b != null) {
            mVar.a(2, i.w ? "mobile_info" : "", this.b);
        }
        if (this.c != null) {
            mVar.b(3, this.c);
        }
        if (this.d != null) {
            it = this.d.iterator();
            while (it.hasNext()) {
                mVar.a(4, (g) it.next());
            }
        }
        mVar.a(5, this.e);
        if (this.f != null) {
            it = this.f.iterator();
            while (it.hasNext()) {
                mVar.a(6, (g) it.next());
            }
        }
        if (this.g != null) {
            mVar.a(7, i.w ? "lbs_info" : "", this.g);
        }
        if (this.h != null) {
            mVar.a(8, i.w ? "gps_info" : "", this.h);
        }
        mVar.a(9, this.i);
        if (this.j != null) {
            mVar.b(10, this.j);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        int i;
        this.a = (k) new k().a(mVar, 1);
        this.b = (a) new a().a(mVar, 2);
        this.c = mVar.a(3);
        this.d.clear();
        int j = mVar.j(4);
        for (i = 0; i < j; i++) {
            this.d.add((g) mVar.a(4, i, new g()));
        }
        this.e = mVar.b(5, 0);
        this.f.clear();
        j = mVar.j(6);
        for (i = 0; i < j; i++) {
            this.f.add((g) mVar.a(6, i, new g()));
        }
        this.g = (i) new i().a(mVar, 7);
        this.h = (c) new c().a(mVar, 8);
        this.i = mVar.b(9, 0);
        this.j = mVar.a(10);
        return true;
    }

    protected final i a(int i) {
        return new j();
    }
}
