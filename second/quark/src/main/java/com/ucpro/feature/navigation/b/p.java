package com.ucpro.feature.navigation.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class p extends c {
    byte[] a;
    byte[] b;
    private int c;
    private int d;
    private byte[] e;

    protected final m a() {
        m mVar = new m(i.w ? "NaviIconData" : "", 50);
        mVar.a(1, i.w ? "img_width" : "", 1, 1);
        mVar.a(2, i.w ? "img_height" : "", 1, 1);
        mVar.a(3, i.w ? "format" : "", 1, 13);
        mVar.a(4, i.w ? "url" : "", 2, 13);
        mVar.a(5, i.w ? "img_data" : "", 2, 13);
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, this.c);
        mVar.a(2, this.d);
        if (this.e != null) {
            mVar.a(3, this.e);
        }
        if (this.a != null) {
            mVar.a(4, this.a);
        }
        if (this.b != null) {
            mVar.a(5, this.b);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.c = mVar.c(1);
        this.d = mVar.c(2);
        this.e = mVar.f(3);
        this.a = mVar.f(4);
        this.b = mVar.f(5);
        return true;
    }

    protected final i a(int i) {
        return new p();
    }
}
