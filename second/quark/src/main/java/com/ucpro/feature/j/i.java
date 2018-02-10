package com.ucpro.feature.j;

import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.ui.g.c;
import java.util.List;

/* compiled from: ProGuard */
public final class i implements c {
    final /* synthetic */ a a;

    public i(a aVar) {
        this.a = aVar;
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
