package com.ucpro.feature.o.a;

import com.ucpro.base.a.g;
import com.ucpro.feature.g.c.b.b;
import com.ucpro.feature.g.c.e;
import com.ucweb.d.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class c implements a {
    final /* synthetic */ b a;
    final /* synthetic */ k b;

    c(k kVar, b bVar) {
        this.b = kVar;
        this.a = bVar;
    }

    public final void a(String str, String str2, String str3) {
        Object arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        e.b(this.a);
        g.a().a(com.ucpro.base.a.e.cb, arrayList);
    }

    public final void a(String str) {
        e.a(this.a, "error_other", str);
    }

    public final void b(String str) {
        e.a(this.a, "error_exception", str);
    }

    public final void a() {
        e.a(this.a, "error_cancel", null);
    }
}
