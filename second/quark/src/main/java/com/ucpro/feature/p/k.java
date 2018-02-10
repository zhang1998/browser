package com.ucpro.feature.p;

import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.ui.g.c;
import java.util.List;

/* compiled from: ProGuard */
final class k implements c {
    final /* synthetic */ n a;

    k(n nVar) {
        this.a = nVar;
    }

    public final void a(int i) {
        List a = com.ucpro.a.a.c.a();
        if (i >= 0 && i < a.size()) {
            f.a().a(j.m, com.ucpro.a.a.c.a((String) a.get(i)));
            if (this.a.b() != null && !this.a.b().G()) {
                this.a.b().u();
            }
        }
    }
}
