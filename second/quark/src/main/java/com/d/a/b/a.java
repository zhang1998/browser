package com.d.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class a extends c {
    public com.uc.base.b.c.c a;
    public int b;
    public com.uc.base.b.c.c c;
    public com.uc.base.b.c.c d;
    public int e;
    public com.uc.base.b.c.c f;
    private com.uc.base.b.c.c g;
    private int h;
    private int i;

    public final String b() {
        if (this.g == null) {
            return null;
        }
        return this.g.toString();
    }

    protected final m a() {
        m mVar = new m(i.w ? "ComponentRet" : "", 50);
        mVar.a(1, i.w ? "name" : "", 2, 12);
        mVar.a(2, i.w ? "ver_code" : "", 2, 1);
        mVar.a(3, i.w ? "ver_name" : "", 2, 12);
        mVar.a(4, i.w ? "resp_type" : "", 2, 1);
        mVar.a(5, i.w ? "err_code" : "", 1, 1);
        mVar.a(6, i.w ? "url" : "", 2, 12);
        mVar.a(7, i.w ? "sec_url" : "", 1, 12);
        mVar.a(8, i.w ? "size" : "", 1, 1);
        mVar.a(9, i.w ? "md5" : "", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.g != null) {
            mVar.b(1, this.g);
        }
        mVar.a(2, this.h);
        if (this.a != null) {
            mVar.b(3, this.a);
        }
        mVar.a(4, this.b);
        mVar.a(5, this.i);
        if (this.c != null) {
            mVar.b(6, this.c);
        }
        if (this.d != null) {
            mVar.b(7, this.d);
        }
        mVar.a(8, this.e);
        if (this.f != null) {
            mVar.b(9, this.f);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.g = mVar.a(1);
        this.h = mVar.b(2, 0);
        this.a = mVar.a(3);
        this.b = mVar.b(4, 0);
        this.i = mVar.b(5, 0);
        this.c = mVar.a(6);
        this.d = mVar.a(7);
        this.e = mVar.b(8, 0);
        this.f = mVar.a(9);
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
