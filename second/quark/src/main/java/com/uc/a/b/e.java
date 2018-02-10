package com.uc.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class e extends c {
    public int a;
    public int b;
    public int c;
    private com.uc.base.b.c.c d;
    private com.uc.base.b.c.c e;
    private int f;
    private com.uc.base.b.c.c g;
    private byte[] h;

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

    public final byte[] d() {
        return this.h;
    }

    protected final m a() {
        m mVar = new m(i.w ? "UsItem" : "", 50);
        mVar.a(1, i.w ? "res_code" : "", 2, 12);
        mVar.a(2, i.w ? "sum_info" : "", 2, 12);
        mVar.a(3, i.w ? "recycle" : "", 2, 1);
        mVar.a(4, i.w ? "save_flag" : "", 2, 1);
        mVar.a(5, i.w ? "zip_flag" : "", 2, 1);
        mVar.a(6, i.w ? "enc_flag" : "", 2, 1);
        mVar.a(7, i.w ? "msg_type" : "", 1, 12);
        mVar.a(8, i.w ? "res_data" : "", 1, 13);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.d != null) {
            mVar.b(1, this.d);
        }
        if (this.e != null) {
            mVar.b(2, this.e);
        }
        mVar.a(3, this.f);
        mVar.a(4, this.a);
        mVar.a(5, this.b);
        mVar.a(6, this.c);
        if (this.g != null) {
            mVar.b(7, this.g);
        }
        if (this.h != null) {
            mVar.a(8, this.h);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.d = mVar.a(1);
        this.e = mVar.a(2);
        this.f = mVar.b(3, 0);
        this.a = mVar.b(4, 0);
        this.b = mVar.b(5, 0);
        this.c = mVar.b(6, 0);
        this.g = mVar.a(7);
        this.h = mVar.g(8);
        return true;
    }

    protected final i a(int i) {
        return new e();
    }
}
