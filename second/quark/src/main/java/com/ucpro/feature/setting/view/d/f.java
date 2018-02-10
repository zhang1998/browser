package com.ucpro.feature.setting.view.d;

import com.ucpro.c.d;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ r a;

    f(r rVar) {
        this.a = rVar;
    }

    public final void run() {
        r.a(this.a, d.b() ? "agreement/en-us/lp_agreement" : "agreement/zh-cn/lp_agreement", new v(this));
    }
}
