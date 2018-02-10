package com.ucpro.business.a.b.a;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.ucpro.services.d.a;

/* compiled from: ProGuard */
public final class h extends c {
    final /* synthetic */ d a;

    public h(d dVar) {
        this.a = dVar;
    }

    protected final m a() {
        m mVar = new m("DoodleData", 50);
        mVar.a(1, "img_url", 1, 13);
        mVar.a(2, "file_url", 1, 13);
        mVar.a(3, "url", 1, 13);
        mVar.a(4, "file_path", 1, 13);
        mVar.a(5, "image_path", 1, 13);
        mVar.a(6, "image_night_path", 1, 13);
        mVar.a(7, "size_width", 1, 1);
        mVar.a(8, "size_height", 1, 1);
        mVar.a(9, "inset_bottom", 1, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a.a != null) {
            mVar.a(1, a.a(this.a.a));
        }
        if (this.a.b != null) {
            mVar.a(2, a.a(this.a.b));
        }
        if (this.a.c != null) {
            mVar.a(3, a.a(this.a.c));
        }
        if (this.a.d != null) {
            mVar.a(4, a.a(this.a.d));
        }
        if (this.a.e != null) {
            mVar.a(5, a.a(this.a.e));
        }
        if (this.a.f != null) {
            mVar.a(6, a.a(this.a.f));
        }
        mVar.a(7, this.a.g);
        mVar.a(8, this.a.h);
        mVar.a(9, this.a.i);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a.a = a.a(mVar.f(1));
        this.a.b = a.a(mVar.f(2));
        this.a.c = a.a(mVar.f(3));
        this.a.d = a.a(mVar.f(4));
        this.a.e = a.a(mVar.f(5));
        this.a.f = a.a(mVar.f(6));
        this.a.g = mVar.c(7);
        this.a.h = mVar.c(8);
        this.a.i = mVar.c(9);
        return true;
    }

    protected final i a(int i) {
        return new h(this.a);
    }
}
