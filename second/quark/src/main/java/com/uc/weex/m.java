package com.uc.weex;

import android.content.Context;
import android.text.TextUtils;
import com.uc.weex.a.a;
import com.uc.weex.a.ah;
import com.uc.weex.e.b;
import com.uc.weex.e.e;
import com.uc.weex.h.k;
import com.uc.weex.h.o;
import com.uc.weex.h.p;
import com.uc.weex.h.r;

/* compiled from: ProGuard */
final class m extends e<Object> {
    o d;
    private String e;
    private k f;
    private e<o> g;
    private e<a> h;
    private e i;

    public m(Context context, String str, k kVar) {
        this.e = str;
        this.f = kVar;
        Object a = b.a();
        k kVar2 = this.f;
        if (TextUtils.isEmpty(kVar2.b)) {
            kVar2.b = str;
        }
        e bVar = new com.uc.weex.h.b(a, context, str, kVar2);
        bVar.a(new p(a));
        this.g = bVar;
        this.g.a(new l(this));
        b.b();
        this.h = ah.a(this.e, this.f);
        b.a();
        this.i = r.a(this.g, this.e, this.h);
        a(this.g, this.h, this.i);
    }

    protected final void c() {
        super.a("NOTIFY_CRATE_PAGE_AND_RENDER_TASK_END", this, this.g.c);
    }

    protected final void h_() {
        a(null);
    }
}
