package com.ucpro.business.d;

import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class b extends c {
    private com.uc.base.b.c.c a;
    private byte[] b;
    private int c;
    private int d;

    protected final m a() {
        m mVar = new m(i.w ? "PageIcon" : "", 50);
        mVar.a(1, i.w ? "iname" : "", 2, 12);
        mVar.a(2, i.w ? "idata" : "", 2, 13);
        mVar.a(3, i.w ? Style.WIDTH : "", 1, 1);
        mVar.a(4, i.w ? Style.HEIGHT : "", 1, 1);
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
        mVar.a(4, this.d);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.f(2);
        this.c = mVar.c(3);
        this.d = mVar.c(4);
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
