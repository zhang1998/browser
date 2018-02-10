package com.ucpro.feature.g.d.b;

import com.uc.apollo.android.GuideDialog;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class b extends c {
    public byte[] a;
    public byte[] b;
    public int c;
    public byte[] d;
    public byte[] e;
    public byte[] f;
    public int g;
    public long h;
    public byte[] i;

    protected final m a() {
        m mVar = new m("BOOKMARK", 50);
        mVar.a(1, "url", 1, 13);
        mVar.a(2, "full_dir", 1, 13);
        mVar.a(3, "is_directory", 1, 1);
        mVar.a(4, "device_type", 1, 13);
        mVar.a(5, "device_platform", 1, 13);
        mVar.a(6, GuideDialog.TITLE, 1, 13);
        mVar.a(7, "index", 1, 1);
        mVar.a(8, "create_time", 1, 6);
        mVar.a(9, "icon", 1, 13);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        if (this.b != null) {
            mVar.a(2, this.b);
        }
        mVar.a(3, this.c);
        if (this.d != null) {
            mVar.a(4, this.d);
        }
        if (this.e != null) {
            mVar.a(5, this.e);
        }
        if (this.f != null) {
            mVar.a(6, this.f);
        }
        mVar.a(7, this.g);
        mVar.a(8, this.h);
        if (this.i != null) {
            mVar.a(9, this.i);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.f(1);
        this.b = mVar.f(2);
        this.c = mVar.c(3);
        this.d = mVar.f(4);
        this.e = mVar.f(5);
        this.f = mVar.f(6);
        this.g = mVar.c(7);
        this.h = mVar.d(8);
        this.i = mVar.f(9);
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
