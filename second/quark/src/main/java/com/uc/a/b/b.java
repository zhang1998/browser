package com.uc.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class b extends c {
    public int a;
    public int b;
    private com.uc.base.b.c.c c;
    private com.uc.base.b.c.c d;
    private com.uc.base.b.c.c e;

    public final String b() {
        if (this.d == null) {
            return null;
        }
        return this.d.toString();
    }

    public final String c() {
        if (this.e == null) {
            return null;
        }
        return this.e.toString();
    }

    protected final m a() {
        m mVar = new m(i.w ? "UsDef" : "", 50);
        mVar.a(1, i.w ? "us_name" : "", 2, 12);
        mVar.a(2, i.w ? "us_url" : "", 2, 12);
        mVar.a(3, i.w ? "recycle" : "", 1, 1);
        mVar.a(4, i.w ? "init" : "", 1, 1);
        mVar.a(5, i.w ? "req_list" : "", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.c != null) {
            mVar.b(1, this.c);
        }
        if (this.d != null) {
            mVar.b(2, this.d);
        }
        mVar.a(3, this.a);
        mVar.a(4, this.b);
        if (this.e != null) {
            mVar.b(5, this.e);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.c = mVar.a(1);
        this.d = mVar.a(2);
        this.a = mVar.b(3, 0);
        this.b = mVar.b(4, 0);
        this.e = mVar.a(5);
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
