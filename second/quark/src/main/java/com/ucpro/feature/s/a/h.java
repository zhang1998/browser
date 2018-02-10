package com.ucpro.feature.s.a;

import com.uc.quark.s;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.k.a;
import com.ucweb.common.util.l.d;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ g b;

    h(g gVar, s sVar) {
        this.b = gVar;
        this.a = sVar;
    }

    public final void run() {
        if (this.b.b != null && !this.b.b.isEmpty() && this.b.b.get(0) != null) {
            String h = this.a.h();
            try {
                if (a.h(this.b.a() + "navi.json")) {
                    a.c(this.b.a());
                }
                com.ucweb.common.util.f.a.a(h, this.b.a());
                h = ((a) this.b.b.get(0)).a;
                this.b.b(h, d.a(h, ""));
                m.a(2, new c(this, this.b.g()));
            } catch (Throwable th) {
            }
        }
    }
}
