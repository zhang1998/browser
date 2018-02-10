package com.ucpro.feature.setting.view.d;

import com.ucpro.c.d;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ t a;

    c(t tVar) {
        this.a = tVar;
    }

    public final void run() {
        t.a(this.a, d.b() ? "agreement/en-us/lp_privacy_policy" : "agreement/zh-cn/lp_privacy_policy", new g(this));
    }
}
