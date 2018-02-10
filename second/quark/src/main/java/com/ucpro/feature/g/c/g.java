package com.ucpro.feature.g.c;

import com.ucpro.base.a.e;
import com.ucpro.feature.g.c.b.b;
import com.ucweb.d.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class g implements a {
    final /* synthetic */ b a;
    final /* synthetic */ i b;

    g(i iVar, b bVar) {
        this.b = iVar;
        this.a = bVar;
    }

    public final void a(String str, String str2, String str3) {
        Object arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        e.b(this.a);
        com.ucpro.base.a.g.a().a(e.cb, arrayList);
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
