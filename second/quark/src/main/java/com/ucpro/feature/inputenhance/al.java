package com.ucpro.feature.inputenhance;

import com.ucweb.common.util.h.a;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class al extends a {
    final /* synthetic */ af a;

    al(af afVar) {
        this.a = afVar;
    }

    public final void run() {
        if (this.a.j != null) {
            this.a.j.a(((Integer) this.f).intValue());
            this.a.c.c = true;
            m.a(2, new ar(this), 1000);
        }
    }
}
