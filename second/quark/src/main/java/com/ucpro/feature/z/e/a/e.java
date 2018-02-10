package com.ucpro.feature.z.e.a;

import com.uc.quark.s;
import com.ucweb.common.util.k.a;
import com.ucweb.common.util.l.d;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ f b;

    e(f fVar, s sVar) {
        this.b = fVar;
        this.a = sVar;
    }

    public final void run() {
        if (this.b.b != null && !this.b.b.isEmpty() && this.b.b.get(0) != null) {
            String h = this.a.h();
            try {
                if (a.h(this.b.a() + "data")) {
                    a.c(this.b.a());
                }
                com.ucweb.common.util.f.a.a(h, this.b.a());
                h = ((b) this.b.b.get(0)).a;
                this.b.b(h, d.a(h, ""));
            } catch (Throwable th) {
            }
        }
    }
}
