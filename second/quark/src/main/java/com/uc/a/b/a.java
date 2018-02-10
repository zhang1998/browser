package com.uc.a.b;

import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class a extends c {
    public int a;
    public int b;
    private com.uc.base.b.c.c c;
    private com.uc.base.b.c.c d;
    private com.uc.base.b.c.c e;
    private com.uc.base.b.c.c f;
    private com.uc.base.b.c.c g;
    private com.uc.base.b.c.c h;

    public final void a(String str) {
        this.c = str == null ? null : com.uc.base.b.c.c.a(str);
    }

    public final void b(String str) {
        this.d = str == null ? null : com.uc.base.b.c.c.a(str);
    }

    public final void c(String str) {
        this.h = str == null ? null : com.uc.base.b.c.c.a(str);
    }

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
        if (this.c != null) {
            mVar.b(1, this.c);
        }
        if (this.d != null) {
            mVar.b(2, this.d);
        }
        mVar.a(3, this.a);
        mVar.a(4, this.b);
        if (this.e != null) {
            mVar.b(5, this.e);
        }
        if (this.f != null) {
            mVar.b(6, this.f);
        }
        if (this.g != null) {
            mVar.b(7, this.g);
        }
        if (this.h != null) {
            mVar.b(8, this.h);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.c = mVar.a(1);
        this.d = mVar.a(2);
        this.a = mVar.b(3, 0);
        this.b = mVar.b(4, 0);
        this.e = mVar.a(5);
        this.f = mVar.a(6);
        this.g = mVar.a(7);
        this.h = mVar.a(8);
        return true;
    }

    protected final i a(int i) {
        return new a();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("imei=").append(this.c).append(" ua=").append(this.d).append(" width=").append(this.a).append(" height=").append(this.b).append(" imsi=").append(this.e).append(" sms_no=").append(this.f).append(" rms_size=").append(this.g).append(" mac=").append(this.h);
        return stringBuilder.toString();
    }
}
