package com.ucpro.feature.navigation.b;

import com.uc.browser.b;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ j a;
    final /* synthetic */ r b;

    l(r rVar, j jVar) {
        this.b = rVar;
        this.a = jVar;
    }

    public final void run() {
        b.a("navigation", "data", this.a);
    }
}
