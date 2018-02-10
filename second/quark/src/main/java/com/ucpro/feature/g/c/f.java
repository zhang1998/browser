package com.ucpro.feature.g.c;

import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.g.c.b.b;
import com.ucweb.b.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class f implements a {
    final /* synthetic */ b a;
    final /* synthetic */ i b;

    f(i iVar, b bVar) {
        this.b = iVar;
        this.a = bVar;
    }

    public final void a(String str, String str2, String str3, String str4) {
        Object arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(str3);
        arrayList.add(str4);
        e.b(this.a);
        g.a().a(e.bZ, arrayList);
    }

    public final void a(int i, String str, String str2) {
        new StringBuilder("\nerrorCode : ").append(String.valueOf(i)).append("\nmessage : ").append(str).append("\ndeital : ").append(str2);
        e.a(this.a, "error_exception", str);
    }

    public final void a() {
        e.a(this.a, "error_cancel", null);
    }
}
