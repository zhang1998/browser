package com.d.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class e extends c {
    public com.uc.base.b.c.c a;
    public int b;
    public com.uc.base.b.c.c c;
    public int d;

    protected final m a() {
        m mVar = new m(i.w ? "UsComponent" : "", 50);
        mVar.a(1, i.w ? "name" : "", 2, 12);
        mVar.a(2, i.w ? "ver_code" : "", 2, 1);
        mVar.a(3, i.w ? "ver_name" : "", 2, 12);
        mVar.a(4, i.w ? "req_type" : "", 2, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.b(1, this.a);
        }
        mVar.a(2, this.b);
        if (this.c != null) {
            mVar.b(3, this.c);
        }
        mVar.a(4, this.d);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.b(2, 0);
        this.c = mVar.a(3);
        this.d = mVar.b(4, 0);
        return true;
    }

    protected final i a(int i) {
        return new e();
    }
}
