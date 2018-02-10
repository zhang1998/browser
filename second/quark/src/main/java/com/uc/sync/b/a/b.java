package com.uc.sync.b.a;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class b extends c {
    public byte[] a;
    public byte[] b;
    public byte[] c;

    protected final m a() {
        m mVar = new m("CommandDataItem", 50);
        mVar.a(1, "guid", 1, 13);
        mVar.a(2, "fp", 1, 13);
        mVar.a(3, "data", 1, 13);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        if (this.b != null) {
            mVar.a(2, this.b);
        }
        if (this.c != null) {
            mVar.a(3, this.c);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.g(1);
        this.b = mVar.g(2);
        this.c = mVar.g(3);
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
