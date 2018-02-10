package com.d.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class f extends c {
    public com.uc.base.b.c.c a;
    public com.uc.base.b.c.c b;

    protected final m a() {
        m mVar = new m(i.w ? "UsKeyValue" : "", 50);
        mVar.a(1, i.w ? "key" : "", 2, 12);
        mVar.a(2, i.w ? "value" : "", 2, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.b(1, this.a);
        }
        if (this.b != null) {
            mVar.b(2, this.b);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.a(2);
        return true;
    }

    protected final i a(int i) {
        return new f();
    }
}
