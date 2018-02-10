package com.uc.quark;

import com.uc.quark.filedownloader.ai;

/* compiled from: ProGuard */
final class d extends ai {
    final /* synthetic */ x a;

    d(x xVar) {
        this.a = xVar;
    }

    public final void a() {
        if (!this.a.i) {
            this.a.i = true;
            Object obj = null;
            for (int i = 0; i < this.a.j.size(); i++) {
                r rVar = (r) this.a.j.get(i);
                if (rVar != null) {
                    if (!(rVar.b == null || rVar.b.l() || r2 != null)) {
                        obj = 1;
                        x.d(this.a);
                    }
                    if (rVar.b != null) {
                        rVar.b.c(rVar.a);
                        this.a.a(rVar.b);
                    }
                }
            }
            this.a.j.clear();
        }
    }

    public final void b() {
        x.o();
    }
}
