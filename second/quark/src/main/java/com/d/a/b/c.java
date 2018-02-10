package com.d.a.b;

import com.d.a.a.a;
import com.d.a.a.b;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class c extends com.uc.base.b.c.b.c {
    public b a;
    public a b;
    public int c;
    public ArrayList<f> d = new ArrayList();
    public com.uc.base.b.c.c e;
    public ArrayList<e> f = new ArrayList();
    private int g;

    protected final m a() {
        m mVar = new m(i.w ? "UpgParam" : "", 50);
        mVar.a(1, i.w ? "pack_info" : "", 2, new b());
        mVar.a(2, i.w ? "mobile_info" : "", 2, new a());
        mVar.a(3, i.w ? "upd_type" : "", 2, 1);
        mVar.a(4, i.w ? "target_prod" : "", 2, 1);
        mVar.a(5, i.w ? "key_val" : "", 3, new f());
        mVar.a(6, i.w ? "target_product" : "", 2, 12);
        mVar.a(7, i.w ? "components" : "", 3, new e());
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
        mVar.a(3, this.c);
        mVar.a(4, this.g);
        if (this.d != null) {
            it = this.d.iterator();
            while (it.hasNext()) {
                mVar.a(5, (f) it.next());
            }
        }
        if (this.e != null) {
            mVar.b(6, this.e);
        }
        if (this.f != null) {
            it = this.f.iterator();
            while (it.hasNext()) {
                mVar.a(7, (e) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        int i;
        int i2 = 0;
        this.a = (b) new b().a(mVar, 1);
        this.b = (a) new a().a(mVar, 2);
        this.c = mVar.b(3, 0);
        this.g = mVar.b(4, 0);
        this.d.clear();
        int j = mVar.j(5);
        for (i = 0; i < j; i++) {
            this.d.add((f) mVar.a(5, i, new f()));
        }
        this.e = mVar.a(6);
        this.f.clear();
        i = mVar.j(7);
        while (i2 < i) {
            this.f.add((e) mVar.a(7, i2, new e()));
            i2++;
        }
        return true;
    }

    protected final i a(int i) {
        return new c();
    }
}
