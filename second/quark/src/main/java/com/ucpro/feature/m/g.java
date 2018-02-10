package com.ucpro.feature.m;

import com.ucpro.business.stat.m;
import com.ucpro.ui.a;

/* compiled from: ProGuard */
final class g implements a {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        this.a.a();
        m.a("crash_recovery", "accept_crash_recovery", new String[0]);
    }

    public final void b() {
        m.a("crash_recovery", "refuse_crash_recovery", new String[0]);
    }
}
