package com.uc.sync.b.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class d extends c {
    public byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;
    public ArrayList<byte[]> f = new ArrayList();
    public byte[] g;
    public int h;
    public int i;
    public int j;
    public int k;

    protected final m a() {
        m mVar = new m(i.w ? "ReqContentHead" : "", 50);
        mVar.a(1, i.w ? "session" : "", 2, 13);
        mVar.a(2, i.w ? "data_type" : "", 2, 1);
        mVar.a(3, i.w ? "trigger_type" : "", 2, 1);
        mVar.a(4, i.w ? "behavior" : "", 2, 1);
        mVar.a(5, i.w ? "anchor" : "", 2, 1);
        mVar.a(6, i.w ? "sync_filter" : "", 3, 13);
        mVar.a(7, i.w ? "white_flag" : "", 1, 13);
        mVar.a(8, i.w ? "sync_type" : "", 2, 1);
        mVar.a(9, i.w ? "last_res_no" : "", 2, 1);
        mVar.a(10, i.w ? "command_max" : "", 1, 1);
        mVar.a(11, i.w ? "data_version" : "", 1, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        mVar.a(2, this.b);
        mVar.a(3, this.c);
        mVar.a(4, this.d);
        mVar.a(5, this.e);
        if (this.f != null) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                mVar.a((byte[]) it.next());
            }
        }
        if (this.g != null) {
            mVar.a(7, this.g);
        }
        mVar.a(8, this.h);
        mVar.a(9, this.i);
        mVar.a(10, this.j);
        mVar.a(11, this.k);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.g(1);
        this.b = mVar.b(2, 0);
        this.c = mVar.b(3, 0);
        this.d = mVar.b(4, 0);
        this.e = mVar.b(5, 0);
        this.f.clear();
        int j = mVar.j(6);
        for (int i = 0; i < j; i++) {
            this.f.add((byte[]) mVar.c(6, i));
        }
        this.g = mVar.g(7);
        this.h = mVar.b(8, 0);
        this.i = mVar.b(9, 0);
        this.j = mVar.b(10, 0);
        this.k = mVar.b(11, 0);
        return true;
    }

    protected final i a(int i) {
        return new d();
    }
}
