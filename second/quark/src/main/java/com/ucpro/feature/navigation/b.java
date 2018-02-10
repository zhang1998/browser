package com.ucpro.feature.navigation;

import com.ucpro.feature.navigation.b.j;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ j a;
    final /* synthetic */ o b;

    b(o oVar, j jVar) {
        this.b = oVar;
        this.a = jVar;
    }

    public final void run() {
        com.uc.browser.b.a("navigation", "data", this.a);
    }
}
