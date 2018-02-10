package com.d.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class d extends c {
    private int A;
    public int a;
    public com.uc.base.b.c.c b;
    public int c;
    public com.uc.base.b.c.c d;
    public com.uc.base.b.c.c e;
    public com.uc.base.b.c.c f;
    public com.uc.base.b.c.c g;
    public com.uc.base.b.c.c h;
    public int i;
    public int j;
    public com.uc.base.b.c.c k;
    public com.uc.base.b.c.c l;
    public com.uc.base.b.c.c m;
    public com.uc.base.b.c.c n;
    public int o;
    public int p;
    public int q;
    public com.uc.base.b.c.c r;
    public com.uc.base.b.c.c s;
    public ArrayList<f> t = new ArrayList();
    public b u;
    public ArrayList<a> v = new ArrayList();
    private f x;
    private com.uc.base.b.c.c y;
    private com.uc.base.b.c.c z;

    protected final m a() {
        m mVar = new m(i.w ? "UpgRet" : "", 50);
        mVar.a(1, i.w ? "upd_rst" : "", 2, 1);
        mVar.a(2, i.w ? "upd_msg" : "", 2, 12);
        mVar.a(3, i.w ? "url_type" : "", 2, 1);
        mVar.a(4, i.w ? "url1" : "", 2, 12);
        mVar.a(5, i.w ? "url2" : "", 2, 12);
        mVar.a(6, i.w ? "plus" : "", 1, new f());
        mVar.a(7, i.w ? "content" : "", 1, 12);
        mVar.a(8, i.w ? "version" : "", 1, 12);
        mVar.a(9, i.w ? "description" : "", 1, 12);
        mVar.a(10, i.w ? "url3" : "", 1, 12);
        mVar.a(11, i.w ? "ull_apk_size" : "", 1, 1);
        mVar.a(12, i.w ? "add_size" : "", 1, 1);
        mVar.a(13, i.w ? "reject_log" : "", 1, 12);
        mVar.a(14, i.w ? "accept_log" : "", 1, 12);
        mVar.a(15, i.w ? "confirm_btn" : "", 1, 12);
        mVar.a(16, i.w ? "cancel_btn" : "", 1, 12);
        mVar.a(17, i.w ? "match_pkname" : "", 1, 12);
        mVar.a(18, i.w ? "silent_install" : "", 1, 1);
        mVar.a(19, i.w ? "match_type" : "", 1, 1);
        mVar.a(20, i.w ? "display_type" : "", 1, 1);
        mVar.a(21, i.w ? "url4" : "", 1, 12);
        mVar.a(22, i.w ? "publish_type" : "", 1, 1);
        mVar.a(23, i.w ? "md5" : "", 1, 12);
        mVar.a(24, i.w ? "key_val" : "", 3, new f());
        mVar.a(25, i.w ? "popup" : "", 1, new b());
        mVar.a(27, i.w ? "comp_ret" : "", 3, new a());
        return mVar;
    }

    protected final boolean a(m mVar) {
        Iterator it;
        mVar.a(1, this.a);
        if (this.b != null) {
            mVar.b(2, this.b);
        }
        mVar.a(3, this.c);
        if (this.d != null) {
            mVar.b(4, this.d);
        }
        if (this.e != null) {
            mVar.b(5, this.e);
        }
        if (this.x != null) {
            mVar.a(6, i.w ? "plus" : "", this.x);
        }
        if (this.y != null) {
            mVar.b(7, this.y);
        }
        if (this.f != null) {
            mVar.b(8, this.f);
        }
        if (this.g != null) {
            mVar.b(9, this.g);
        }
        if (this.h != null) {
            mVar.b(10, this.h);
        }
        mVar.a(11, this.i);
        mVar.a(12, this.j);
        if (this.k != null) {
            mVar.b(13, this.k);
        }
        if (this.l != null) {
            mVar.b(14, this.l);
        }
        if (this.m != null) {
            mVar.b(15, this.m);
        }
        if (this.n != null) {
            mVar.b(16, this.n);
        }
        if (this.z != null) {
            mVar.b(17, this.z);
        }
        mVar.a(18, this.o);
        mVar.a(19, this.p);
        mVar.a(20, this.q);
        if (this.r != null) {
            mVar.b(21, this.r);
        }
        mVar.a(22, this.A);
        if (this.s != null) {
            mVar.b(23, this.s);
        }
        if (this.t != null) {
            it = this.t.iterator();
            while (it.hasNext()) {
                mVar.a(24, (f) it.next());
            }
        }
        if (this.u != null) {
            mVar.a(25, i.w ? "popup" : "", this.u);
        }
        if (this.v != null) {
            it = this.v.iterator();
            while (it.hasNext()) {
                mVar.a(27, (a) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        int i;
        int i2 = 0;
        this.a = mVar.b(1, 0);
        this.b = mVar.a(2);
        this.c = mVar.b(3, 0);
        this.d = mVar.a(4);
        this.e = mVar.a(5);
        this.x = (f) new f().a(mVar, 6);
        this.y = mVar.a(7);
        this.f = mVar.a(8);
        this.g = mVar.a(9);
        this.h = mVar.a(10);
        this.i = mVar.b(11, 0);
        this.j = mVar.b(12, 0);
        this.k = mVar.a(13);
        this.l = mVar.a(14);
        this.m = mVar.a(15);
        this.n = mVar.a(16);
        this.z = mVar.a(17);
        this.o = mVar.b(18, 0);
        this.p = mVar.b(19, 0);
        this.q = mVar.b(20, 0);
        this.r = mVar.a(21);
        this.A = mVar.b(22, 0);
        this.s = mVar.a(23);
        this.t.clear();
        int j = mVar.j(24);
        for (i = 0; i < j; i++) {
            this.t.add((f) mVar.a(24, i, new f()));
        }
        this.u = (b) new b().a(mVar, 25);
        this.v.clear();
        i = mVar.j(27);
        while (i2 < i) {
            this.v.add((a) mVar.a(27, i2, new a()));
            i2++;
        }
        return true;
    }

    protected final i a(int i) {
        return new d();
    }
}
