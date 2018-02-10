package com.ucpro.feature.setting.c.a;

import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucweb.common.util.n.a;
import java.util.List;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ e b;

    b(e eVar, List list) {
        this.b = eVar;
        this.a = list;
    }

    public final void run() {
        this.b.b = this.a;
        if (this.a.size() > 0) {
            long j = ((a) this.a.get(0)).t;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String str = ((a) this.a.get(0)).b;
            if (!a.a(str)) {
                List d = this.b.d();
                if (!(d != null && a.d(((a) d.get(0)).b, str) && ((a) d.get(0)).t == j) && currentTimeMillis < j) {
                    this.b.b(this.a);
                    com.ucpro.services.a.a.a.a("D151BC40C4C713DF534AD9EA65BD62BF");
                    g.a().a(e.f, Boolean.valueOf(true));
                }
            }
        }
    }
}
