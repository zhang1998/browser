package com.d.a.a;

import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class a extends c {
    public com.uc.base.b.c.c a;
    public com.uc.base.b.c.c b;
    public int c;
    public int d;
    public com.uc.base.b.c.c e;
    public com.uc.base.b.c.c f;
    public com.uc.base.b.c.c g;
    private com.uc.base.b.c.c h;

    protected final m a() {
        m mVar = new m(i.w ? "UsMobileInfo" : "", 50);
        mVar.a(1, i.w ? "imei" : "", 1, 12);
        mVar.a(2, i.w ? "ua" : "", 1, 12);
        mVar.a(3, i.w ? Style.WIDTH : "", 1, 1);
        mVar.a(4, i.w ? Style.HEIGHT : "", 1, 1);
        mVar.a(5, i.w ? "imsi" : "", 1, 12);
        mVar.a(6, i.w ? "sms_no" : "", 1, 12);
        mVar.a(7, i.w ? "rms_size" : "", 1, 12);
        mVar.a(8, i.w ? "mac" : "", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.b(1, this.a);
        }
        if (this.b != null) {
            mVar.b(2, this.b);
        }
        mVar.a(3, this.c);
        mVar.a(4, this.d);
        if (this.e != null) {
            mVar.b(5, this.e);
        }
        if (this.f != null) {
            mVar.b(6, this.f);
        }
        if (this.h != null) {
            mVar.b(7, this.h);
        }
        if (this.g != null) {
            mVar.b(8, this.g);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.a(2);
        this.c = mVar.b(3, 0);
        this.d = mVar.b(4, 0);
        this.e = mVar.a(5);
        this.f = mVar.a(6);
        this.h = mVar.a(7);
        this.g = mVar.a(8);
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
