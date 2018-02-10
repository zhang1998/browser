package com.ucpro.business.a.b.a;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class a extends c {
    final /* synthetic */ f a;

    public a(f fVar) {
        this.a = fVar;
    }

    protected final m a() {
        m mVar = new m("AnimDoodleData", 50);
        mVar.a(1, "file_url", 1, 13);
        mVar.a(2, "url", 1, 13);
        mVar.a(3, "file_path", 1, 13);
        mVar.a(4, "image_path", 1, 13);
        mVar.a(5, "image_night_path", 1, 13);
        mVar.a(6, "anim_data_path", 1, 13);
        mVar.a(7, "use_hardware", 1, 11);
        mVar.a(8, "in_density", 1, 1);
        mVar.a(9, "data_info", 1, 13);
        mVar.a(10, "play_times", 1, 1);
        mVar.a(11, "loop_times", 1, 1);
        mVar.a(12, "triggr_type", 1, 1);
        mVar.a(13, "size_width", 1, 1);
        mVar.a(14, "size_height", 1, 1);
        mVar.a(15, "inset_bottom", 1, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a.a != null) {
            mVar.a(1, com.ucpro.services.d.a.a(this.a.a));
        }
        if (this.a.b != null) {
            mVar.a(2, com.ucpro.services.d.a.a(this.a.b));
        }
        if (this.a.c != null) {
            mVar.a(3, com.ucpro.services.d.a.a(this.a.c));
        }
        if (this.a.d != null) {
            mVar.a(4, com.ucpro.services.d.a.a(this.a.d));
        }
        if (this.a.e != null) {
            mVar.a(5, com.ucpro.services.d.a.a(this.a.e));
        }
        if (this.a.f != null) {
            mVar.a(6, com.ucpro.services.d.a.a(this.a.f));
        }
        mVar.a(7, this.a.g);
        mVar.a(8, this.a.h);
        if (this.a.i != null) {
            mVar.a(9, com.ucpro.services.d.a.a(this.a.i));
        }
        mVar.a(10, this.a.j);
        mVar.a(11, this.a.k);
        mVar.a(12, this.a.l);
        mVar.a(13, this.a.m);
        mVar.a(14, this.a.n);
        mVar.a(15, this.a.o);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a.a = com.ucpro.services.d.a.a(mVar.f(1));
        this.a.b = com.ucpro.services.d.a.a(mVar.f(2));
        this.a.c = com.ucpro.services.d.a.a(mVar.f(3));
        this.a.d = com.ucpro.services.d.a.a(mVar.f(4));
        this.a.e = com.ucpro.services.d.a.a(mVar.f(5));
        this.a.f = com.ucpro.services.d.a.a(mVar.f(6));
        this.a.g = mVar.e(7);
        this.a.h = mVar.c(8);
        this.a.i = com.ucpro.services.d.a.a(mVar.f(9));
        this.a.j = mVar.c(10);
        this.a.k = mVar.c(11);
        this.a.l = mVar.c(12);
        this.a.m = mVar.c(13);
        this.a.n = mVar.c(14);
        this.a.o = mVar.c(15);
        return true;
    }

    protected final i a(int i) {
        return new a(this.a);
    }
}
