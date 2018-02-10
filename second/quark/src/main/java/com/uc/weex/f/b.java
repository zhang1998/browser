package com.uc.weex.f;

import com.taobao.weex.ad;
import com.taobao.weex.c;
import com.taobao.weex.d;
import com.taobao.weex.f;
import com.taobao.weex.g;
import com.taobao.weex.i;
import com.taobao.weex.q;
import com.taobao.weex.utils.WXLogUtils;
import com.uc.weex.e.e;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class b extends e implements f, g, com.uc.weex.e {
    public Boolean d;
    private ArrayList<Object> e = new ArrayList();
    private Boolean f;
    private Boolean g;

    protected final void a() {
        i.r = System.currentTimeMillis();
    }

    protected final void h_() {
        if (this.f == null) {
            ad.a().l = this;
            ad.a().q = this;
            this.f = Boolean.valueOf(false);
        }
        if (this.g == null) {
            if (this.f.booleanValue()) {
                this.g = Boolean.valueOf(true);
            } else {
                c.c.a((com.uc.weex.e) this);
                return;
            }
        }
        com.uc.weex.e.f.a(new a(this));
    }

    public final void b(boolean z) {
        this.g = Boolean.valueOf(z);
        d();
    }

    public final void a(boolean z) {
        c.c.b(z);
    }

    public final void i_() {
    }

    public final void b() {
    }

    public final void a(String str, String str2, String str3) {
        if (c.d != null) {
            c.d.a(str, str2, str3);
        }
    }

    static /* synthetic */ void b(b bVar) {
        ad.a().p = bVar.f.booleanValue();
        c cVar = new c();
        cVar.b = c.b.a;
        cVar.a = c.b.a();
        cVar.g = c.c.a(bVar.f.booleanValue());
        cVar.h = c.b.d;
        cVar.c = c.b.e;
        d dVar = new d();
        dVar.a = cVar.a;
        dVar.c = cVar.b;
        dVar.b = cVar.c;
        dVar.d = cVar.d;
        dVar.e = cVar.e;
        dVar.f = cVar.f;
        dVar.g = cVar.g;
        dVar.k = cVar.j;
        dVar.h = cVar.h;
        dVar.i = cVar.k;
        dVar.j = cVar.i;
        q.a(i.e(), dVar);
        try {
            q.a("userTrack", com.uc.weex.g.c.class);
            c.c.a();
            q.b("event", com.uc.weex.g.f.class, true);
            q.b("uc-jsBridge", com.uc.weex.g.g.class, false);
            q.b("uc-page", com.uc.weex.g.i.class, true);
            q.a("uc-div", com.uc.weex.component.a.c.class, false);
        } catch (Throwable th) {
            WXLogUtils.d("InitJsFrameworkTask", th.getMessage());
        }
    }
}
