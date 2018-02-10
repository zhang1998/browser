package com.ucpro.services.d.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.ucpro.services.d.a;

/* compiled from: ProGuard */
public final class d extends c {
    public final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    protected final m a() {
        m mVar = new m("CMS_PB", 50);
        mVar.a(1, "data_id", 2, 13);
        mVar.a(2, "test_id", 1, 13);
        mVar.a(3, "data_type", 1, 13);
        mVar.a(4, "start_time", 1, 6);
        mVar.a(5, "end_time", 1, 6);
        mVar.a(6, "img_pack", 1, 13);
        mVar.a(7, "check_sum", 1, 13);
        mVar.a(8, "business_data", 1, 13);
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, a.a(this.a.q));
        if (this.a.p != null) {
            mVar.a(2, a.a(this.a.p));
        }
        if (this.a.r != null) {
            mVar.a(3, a.a(this.a.r));
        }
        mVar.a(4, this.a.s);
        mVar.a(5, this.a.t);
        if (this.a.u != null) {
            mVar.a(6, a.a(this.a.u));
        }
        if (this.a.v != null) {
            mVar.a(7, a.a(this.a.v));
        }
        if (this.a.a != null) {
            mVar.a(8, this.a.a);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a.q = a.a(mVar.f(1));
        this.a.p = a.a(mVar.f(2));
        this.a.r = a.a(mVar.f(3));
        this.a.s = mVar.d(4);
        this.a.t = mVar.d(5);
        this.a.u = a.a(mVar.f(6));
        this.a.v = a.a(mVar.f(7));
        this.a.a = mVar.f(8);
        return true;
    }

    protected final i a(int i) {
        return new d(this.a);
    }
}
