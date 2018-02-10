package com.ucpro.feature.g.e;

import com.uc.apollo.android.GuideDialog;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class a extends c {
    byte[] a;
    byte[] b;
    byte[] c;
    byte[] d;
    int e;
    long f;

    protected final m a() {
        m mVar = new m("NAVIMESSAGE", 50);
        mVar.a(1, "url", 1, 13);
        mVar.a(2, "device_type", 1, 13);
        mVar.a(3, "device_platform", 1, 13);
        mVar.a(4, GuideDialog.TITLE, 1, 13);
        mVar.a(5, "index", 1, 1);
        mVar.a(6, "create_time", 1, 6);
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
        mVar.a(6, this.f);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.f(1);
        this.b = mVar.f(2);
        this.c = mVar.f(3);
        this.d = mVar.f(4);
        this.e = mVar.c(5);
        this.f = mVar.d(6);
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
