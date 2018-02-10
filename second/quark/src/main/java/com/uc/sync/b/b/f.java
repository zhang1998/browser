package com.uc.sync.b.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class f extends c {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public byte[] d;
    public int e;
    public byte[] f;
    public byte[] g;
    public byte[] h;

    protected final m a() {
        m mVar = new m("DeviceInfo", 50);
        mVar.a(1, "platform", 1, 13);
        mVar.a(2, "type", 1, 13);
        mVar.a(3, "name", 1, 13);
        mVar.a(4, "id", 1, 13);
        mVar.a(5, "last_sync_time", 1, 1);
        mVar.a(6, "sn", 1, 13);
        mVar.a(7, "imei", 1, 13);
        mVar.a(8, "pfid", 1, 13);
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
        if (this.d != null) {
            mVar.a(4, this.d);
        }
        mVar.a(5, this.e);
        if (this.f != null) {
            mVar.a(6, this.f);
        }
        if (this.g != null) {
            mVar.a(7, this.g);
        }
        if (this.h != null) {
            mVar.a(8, this.h);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.g(1);
        this.b = mVar.g(2);
        this.c = mVar.g(3);
        this.d = mVar.g(4);
        this.e = mVar.b(5, 0);
        this.f = mVar.g(6);
        this.g = mVar.g(7);
        this.h = mVar.g(8);
        return true;
    }

    protected final i a(int i) {
        return new f();
    }
}
