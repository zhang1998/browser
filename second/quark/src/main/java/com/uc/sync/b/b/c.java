package com.uc.sync.b.b;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class c extends com.uc.base.b.c.b.c {
    public byte[] a;
    public int b;
    public f c;
    public byte[] d;

    protected final m a() {
        m mVar = new m("SyncReqHead", 50);
        mVar.a(1, "auth_data", 2, 13);
        mVar.a(2, "product_id", 2, 1);
        mVar.a(3, "device_info", 2, new f());
        mVar.a(4, "ext", 1, 13);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        mVar.a(2, this.b);
        if (this.c != null) {
            mVar.a(3, "device_info", this.c);
        }
        if (this.d != null) {
            mVar.a(4, this.d);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.g(1);
        this.b = mVar.b(2, 0);
        this.c = (f) new f().a(mVar, 3);
        this.d = mVar.g(4);
        return true;
    }

    protected final i a(int i) {
        return new c();
    }
}
