package com.uc.weex.a;

import android.text.TextUtils;
import com.uc.weex.e.e;
import com.uc.weex.h.k;

/* compiled from: ProGuard */
public final class ae extends e<a> implements e {
    private y d = y.a();
    private k e;
    private String f;
    private Boolean g;
    private a h;

    public ae(String str, k kVar) {
        this.f = str;
        this.e = kVar;
    }

    protected final void a() {
        boolean z = false;
        super.a("NOTIFY_LOAD_BUNDLE_TASK_BEGIN", this, new Object[0]);
        if (!(TextUtils.isEmpty(this.f) || this.f.startsWith(b.d) || this.f.startsWith(b.e) || !this.e.g)) {
            z = true;
        }
        this.g = Boolean.valueOf(z);
    }

    protected final void h_() {
        if (this.h != null || this.g.booleanValue()) {
            a((Object) this.h);
        } else if (TextUtils.isEmpty(this.f)) {
            r0 = this.d;
            r0.a.a.post(new r(r0, this.e.b, this));
        } else if (this.f.startsWith(b.d)) {
            r0 = this.f.replace(b.d, "");
            r1 = this.d;
            r1.a.a.post(new v(r1, r0, this));
        } else if (this.f.startsWith(b.e)) {
            r0 = this.f.replace(b.e, "");
            r1 = this.d;
            r1.a.a.post(new u(r1, r0, this));
        } else {
            r0 = this.d;
            r0.a.a.post(new x(r0, this.e, this));
        }
    }

    protected final void c() {
        super.a("NOTIFY_LOAD_BUNDLE_TASK_END", this, new Object[0]);
    }

    public final void a(n nVar, String str, int i) {
        this.h = new a();
        this.h.a = nVar;
        this.h.b = str;
        this.h.c = i;
        d();
    }
}
