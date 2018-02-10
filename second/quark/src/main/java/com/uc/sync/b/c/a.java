package com.uc.sync.b.c;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class a extends c {
    public byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;
    public byte[] f;

    protected final m a() {
        m mVar = new m("ResContentHead", 50);
        mVar.a(1, "session", 2, 13);
        mVar.a(2, "anchor", 2, 1);
        mVar.a(3, "data_type", 2, 1);
        mVar.a(4, "sync_type", 2, 1);
        mVar.a(5, "ret_code", 2, 1);
        mVar.a(6, "ret_msg", 1, 13);
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
            mVar.a(6, this.f);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.g(1);
        this.b = mVar.b(2, 0);
        this.c = mVar.b(3, 0);
        this.d = mVar.b(4, 0);
        this.e = mVar.b(5, 0);
        this.f = mVar.g(6);
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
